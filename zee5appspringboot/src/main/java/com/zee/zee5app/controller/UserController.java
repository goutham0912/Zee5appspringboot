package com.zee.zee5app.controller;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.web.HateoasSortHandlerMethodArgumentResolver;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zee.zee5app.dto.Erole;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.RecordExists;
import com.zee.zee5app.payload.request.LoginRequest;
import com.zee.zee5app.payload.request.SignUpRequest;
import com.zee.zee5app.payload.response.JwtResponse;
import com.zee.zee5app.payload.response.MessageResponse;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.security.jwt.JwtUtils;
import com.zee.zee5app.security.services.UserDetailsImpl;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.UserService;

@RestController    //combination of @ResponseBody and @Controller
//rest api-response whereever we have to share the response that method must be marked with @ResponseBody
//1000 methods ->1000@Response body, to avoid this rest controller is introduced. 
@RequestMapping("/api/auth")
public class UserController {
	
	@Autowired 
	UserService service;
	@Autowired 
	LoginService loginService;
	
	@Autowired
	UserRepository userRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Autowired
	JwtUtils jwtUtils;
	@Autowired
	AuthenticationManager authenticationManager;
	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest)
	{
		Authentication authentication = authenticationManager.authenticate
				(new UsernamePasswordAuthenticationToken(loginRequest.getUsername(), loginRequest.getPassword()));
		
		SecurityContextHolder.getContext().setAuthentication(authentication);
		String jwt = jwtUtils.generateToken(authentication);
		UserDetailsImpl userDetailsImpl = (UserDetailsImpl) authentication.getPrincipal();
		
		List<String> roles = userDetailsImpl.getAuthorities()
											.stream()
											.map(i->i.getAuthority())
											.collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt, 
												 userDetailsImpl.getId(), 
											   	 userDetailsImpl.getUsername(), 
												 userDetailsImpl.getEmail(), 
												 roles));
		
	}
	@PostMapping("/signUp")
	public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest)
	{
		if(userRepository.existsByUsername(signUpRequest.getUsername()))
		{
			return ResponseEntity.badRequest().body(new MessageResponse("Error:Username already taken"));
		}
		if(userRepository.existsByEmail(signUpRequest.getEmail()))
		{
			return ResponseEntity.badRequest().body(new MessageResponse("Error:Email is already in use"));
		}
		User user=new User(signUpRequest.getUsername(),signUpRequest.getEmail() ,
				passwordEncoder.encode(signUpRequest.getPassword()), signUpRequest.getFirstName(), 
				signUpRequest.getLastName());
		Set<String> roles=signUpRequest.getRole();
		System.out.println(roles);
		Set<Role> roles1=new HashSet<>();
		if(roles==null)
		{
			Role userRole=roleRepository.findByRoleName(Erole.ROLE_USER).orElseThrow(()->new RuntimeException("Error:role not found"));
			roles1.add(userRole);
		}
		
		else {
			
			roles.forEach(e->{
				switch(e) {
				case "admin":
					System.out.println(e+"---");
					Role roleAdmin=roleRepository.findByRoleName(Erole.ROLE_ADMIN).orElseThrow(()->new RuntimeException("Error:role not found"));
					roles1.add(roleAdmin);
					break;
				case "mod":
					System.out.println(e+"---");
					Role roleModerator=roleRepository.findByRoleName(Erole.ROLE_MODERATOR).orElseThrow(()->new RuntimeException("Error:role not found"));
					roles1.add(roleModerator);
					break;
				default:
					System.out.println(e+"---");
					Role roleUser=roleRepository.findByRoleName(Erole.ROLE_USER).orElseThrow(()->new RuntimeException("Error:role not found"));
					roles1.add(roleUser);
					break;
				}
			});
		}
		user.setRoles(roles1);
		System.out.println(user);
		userRepository.save(user);
		return ResponseEntity.status(201).body(new MessageResponse("user created successfully"));
		
	}
	
//	{
//	    "username":"goutham12",
//	    "firstName":"goutham",
//	    "lastName":"S",
//	    "email": "goutham12@gmail.com",
//	    "password":"goutham12",
//	    "role":["admin"]
//	}
	
	//"eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnb3V0aGFtMTEiLCJpYXQiOjE2NDQ2MDM5NjMsImV4cCI6MTY0NDY5MDM2M30.SmeJ6KUjMNp4qZWIQYfZqIYCJHEYOILNVDaHY2UA7bnAgXcmqjq3eOBALZhoJ4O0pNFezsHDBdzuvfEmFrY7GA"
//	admin-eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJnb3V0aGFtMTIiLCJpYXQiOjE2NDQ2MDY1MjMsImV4cCI6MTY0NDY5MjkyM30.YItxG6Dy819WFJomp0tWygo4OY0VQwM9F8DoRJO6j6DNn8XAhJrUQVk8VB1Ukw5hleMceQ1ilFQLOKrm1aAOhw
	//adding user to the table
	//info will be shared by client in terms of json object
	//we need to read the json object ,it is available in request body
	//read request body content and 
//	convert json object to java object->@Requestbody  //jackson api
	//to inform when the method should be called ,we should specify end point
	//end point ->url where resource can be found
	
	
//	@PostMapping("/addUser")    //end point 
//	//Post mapping because protocol used is post
//	//@Valid->to valid data before adding to the database 
//	public ResponseEntity<?> addUser(@Valid @RequestBody User register) throws RecordExists
//	{
//		System.out.println(register);
//	
//		User result=service.addUser(register);															
//		System.out.println(result);
//		return ResponseEntity.status(201).body(result); //201-created
//	}
//	
//	@GetMapping("/{id}")
//	public ResponseEntity<?> getUserById(@PathVariable("id") String id) throws IdNotFoundException
//	{
//		User register=service.getUserById(id);
//		return ResponseEntity.status(200).body(register);
//	}
//	@GetMapping("/all")
//	public ResponseEntity<?> getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException
//	{
//		Optional<List<User>> optional=service.getAllUsers1();
//		if(optional.isEmpty())
//		{
////			Map<String,String> map=new HashMap<String, String>();
////			map.put("message", "no record found ");
//			return ResponseEntity.status(HttpStatus.NO_CONTENT).body(new MessageResponse("No record found"));
//			
//		}
//		else
//			return ResponseEntity.ok(optional.get());
//		
//	}
//	
}
