package com.zee.zee5app.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Erole;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.RecordExists;
import com.zee.zee5app.repository.LoginRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.Subscription_Service1;
import com.zee.zee5app.service.UserService;
@Service
public class UserServiceimpl implements UserService {
	
	//private static UserService service;
	@Autowired
	LoginService service;
	@Autowired
	UserRepository repository;
	@Autowired
	LoginRepository loginRepository;
	@Autowired
	Subscription_Service1 service1;
	
	@Override
	@Transactional(rollbackFor = RecordExists.class)
	public User addUser(User register) throws RecordExists {
		if(repository.existsByEmail(register.getEmail()) | repository.existsByContactNo(register.getContactNo()))
			throw new RecordExists("record exists");
		User register2=repository.save(register);
		System.out.println(register2);
		if(register2!=null)
		{
			
			if(loginRepository.existsByUserName(register.getEmail()))
				throw new RecordExists("Email Exists");
			Login login=new Login(register.getEmail(),register.getPassword(),register2);
			String result=service.addCredentials(login);
			if(result.equals("Success"))
			{
			System.out.println("Login updated");
//			Subscriptions subscriptions=new Subscriptions("ss00001",java.sql.Date.valueOf("2021-04-05"),java.sql.Date.valueOf("2022-04-05"),500,"DEBIT CARD","ACTIVE","YEARLY","true","India",register2);
//			service1.addSubscription(subscriptions);
			return register2;
			}
			else {
				return null;
			}
		}
		else {
			return null;
		}
//			return register2;
//		}
//			else {
//				return null;
//			}
		
		
	}
	@Override
	public String updateUser(Long id, User register) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public User getUserById(Long id)
			throws IdNotFoundException {
		// TODO Auto-generated method stub
		Optional<User> result=repository.findById(id);
		if(result.isEmpty())
			throw new IdNotFoundException("id not found");
			else {
				return result.get();
			}
	}
	@Override
	public User[] getAllUsers() throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		
		List<User> list=repository.findAll();
		User[] r=new User[list.size()];
		return list.toArray(r);
	}
	@Override
	public String deleteUserById(Long id) throws IdNotFoundException {
		// TODO Auto-generated method stub
		User optional;
		try {
			optional = this.getUserById(id);
			if(optional== null)
				throw new IdNotFoundException("Id not found");
			else
			{
				repository.deleteById(id);
				return "Success";
			}
		} catch (IdNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new IdNotFoundException(e.getMessage());		
			}
		
		
		
	}
	@Override
	public Optional<List<User>> getAllUsers1()
			throws InvalidIdLengthException, InvalidNameException, InvalidPasswordException {
		// TODO Auto-generated method stub
		return Optional.ofNullable(repository.findAll());
	}

	

}
