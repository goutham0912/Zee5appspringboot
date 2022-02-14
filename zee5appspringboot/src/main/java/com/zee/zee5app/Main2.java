package com.zee.zee5app;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Erole;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Erole;
import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Role;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.exception.RecordExists;
import com.zee.zee5app.repository.MovieRepository;
import com.zee.zee5app.repository.RoleRepository;
import com.zee.zee5app.repository.SeriesRepository;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.RoleService;
import com.zee.zee5app.service.Subscription_Service1;
import com.zee.zee5app.service.UserService;
@SpringBootApplication
public class Main2 {
public static void main(String[] args) {
	ConfigurableApplicationContext applicationContext=SpringApplication.run(Main2.class, args);
	UserRepository repo=applicationContext.getBean(UserRepository.class);
//	System.out.println(repo.existsByEmail("goutham2@gmail.com"));
//	System.out.println(repo.existsByContactNo(new BigDecimal("7892745106")));
//	System.out.println(repo.existsByEmailAndContactNo("goutham2@gmail.com",new BigDecimal("7892745106")));
//	
//	MovieRepository movie=applicationContext.getBean(MovieRepository.class);
//	System.out.println(movie.existsByMovieName("AvengersEndGame")+" Movie exists");
//	System.out.println(movie.findByMovieNameAndLanguage("AvengersEndGame","English"));
//	System.out.println(movie.findByMovieNameAndReleaseDate("AvengersEndGame", Date.valueOf("2022-04-05"))+"--"+"\n");
//	movie.findByCast("X,K").get().forEach(e->System.out.println(e+"--Based on cast"));
//	
//	
//	SeriesRepository srepository=applicationContext.getBean(SeriesRepository.class);
//	System.out.println(srepository.findByNameAndLanguage("Office", "English"));
	
//	UserService service=applicationContext.getBean(UserService.class);
//	Register register=null;
////	
//	Role role=new Role();
//	role.setRoleName(Erole.ROLE_ADMIN);
//	Role role1=new Role();
//	role1.setRoleName(Erole.ROLE_USER);
//	RoleService roleService = applicationContext.getBean(RoleService.class);
//	UserService userService=applicationContext.getBean(UserService.class);
//	System.out.println(roleService.addRole(role));
//	System.out.println(roleService.addRole(role1));
////	register=new Register("goutham6","Goutham","S","goutham6@gmail.com","goutham1",new BigDecimal("7892745101"));
//		RoleRepository repository=applicationContext.getBean(RoleRepository.class);
////		UserRepository repository =applicationContext.getBean(UserRepository.class);
//		Register register1=new Register("goutham4","Goutham","S","goutham4@gmail.com","goutham1",new BigDecimal("7892745103"),null,null,null);
//		Set<Role> s=new HashSet<Role>();
//		s.add(repository.findById(1).get());
//		s.add(repository.findById(2).get());
//		System.out.println(s);
//		register1.setRoles(s);
//	try {
//		System.out.println(service.addUser(register1));
//	} catch (RecordExists e1) {
//		// TODO Auto-generated catch block
//		e1.printStackTrace();
//	}
//	Subscription_Service1 service5=applicationContext.getBean(Subscription_Service1.class);
//	Subscriptions subscriptions=new Subscriptions("ss00001",java.sql.Date.valueOf("2021-04-05"),java.sql.Date.valueOf("2022-04-05"),500,"DEBIT CARD","ACTIVE","YEARLY","true","India",register1);
////	subscriptions.setRegister(userService.getUserById("goutham4").get());
////	Subscriptions subscriptions1=new Subscriptions("ss00002",java.sql.Date.valueOf("2022-01-05"),java.sql.Date.valueOf("2022-02-05"),500,"CREDIT CARD","ACTIVE","MONTHLY","false","India",null);
////	String result12=service5.addSubscription(subscriptions1);
//	String result13=service5.addSubscription(subscriptions);
//	applicationContext.close();
}
}
