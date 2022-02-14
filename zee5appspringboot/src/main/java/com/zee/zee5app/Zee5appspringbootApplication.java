package com.zee.zee5app;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import javax.sql.DataSource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Login;
import com.zee.zee5app.dto.Movies;

import com.zee.zee5app.dto.User;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.dto.Subscriptions;
import com.zee.zee5app.exception.IdNotFoundException;
import com.zee.zee5app.exception.InvalidIdLengthException;
import com.zee.zee5app.exception.InvalidNameException;
import com.zee.zee5app.exception.InvalidPasswordException;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.repository.UserRepository;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.LoginService;
import com.zee.zee5app.service.Movie_Service1;
import com.zee.zee5app.service.Series_Service1;
import com.zee.zee5app.service.Subscription_Service1;
import com.zee.zee5app.service.UserService;

@SpringBootApplication
public class Zee5appspringbootApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext applicationContext=SpringApplication.run(Zee5appspringbootApplication.class, args);
		DataSource dataSource=applicationContext.getBean(DataSource.class);
		System.out.println(dataSource!=null);
		UserService service=applicationContext.getBean(UserService.class);
		LoginService service8=applicationContext.getBean(LoginService.class);
//		UserRepository repository=applicationContext.getBean(UserRepository.class);
		User register=null;
	
//		register=new Register("goutham1","Goutham","S","goutham1@gmail.com","goutham1",new BigDecimal("7892745106"));
//			register.setContactno(new BigDecimal("7892745107"));
//			String role=ROLE.ROLE_USER.toString();
//			System.out.println(role);
//		Login login=new Login("goutham1@gmail.com","goutham1","goutham1",role);
//		
//			System.out.println(service.addUser(register));
//			System.out.println(service8.addCredentials(login)+"Login table updated");
//			register=new Register("goutham2","Goutham","S","goutham2@gmail.com","goutham1",new BigDecimal("7892745106"));
//			System.out.println(service.addUser(register));
//		try {
//			Optional<Register> result=service.getUserById("goutham1");
//			if(result.isEmpty())
//				System.out.println("id not found");
//			else {
//				System.out.println(result.get());
//			}
//			Optional<List<Register>> result1=service.getAllUsers1();
//			if(result1.isEmpty())
//				System.out.println("id not found");
//			else {
//				System.out.println("Users are");
//				result1.get().forEach(e->System.out.println(e));
//			}
//		} catch (IdNotFoundException | InvalidIdLengthException | InvalidNameException | InvalidPasswordException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			String result2=service.deleteUserById("goutham1");
//			System.out.println("deletion");
//			System.out.println(result2);
//		} catch (IdNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		register.setContactno(new BigDecimal("7892745107"));
		
		//Movies
//		System.out.println("Movies--------");
//		java.sql.Date date=java.sql.Date.valueOf("2022-02-05");
//		Movie_Service1 service2=applicationContext.getBean(Movie_Service1.class);
//		Movies movies1=new Movies("m000001","Avengers",18,"X1,Y1","A1,B1",new BigDecimal(7200),"youtube.com/Avengers",date,"English","action");
//		Movies movies2=new Movies("m000002","AvengersEndGame",18,"X,Y","A,B",new BigDecimal(7200),"youtube.com/AvengersEndGame",java.sql.Date.valueOf("2022-04-05"),"English","action");
//		String result=service2.addMovie(movies1);
//		String result1=service2.addMovie(movies2);
//		System.out.println(result1);
//		System.out.println(result);
//		try {
//			Optional<Movies> result2=service2.getMoviedetails("m000001");
//			if(result2.isEmpty())
//				System.out.println("movie not found");
//			else {
//				System.out.println(result2.get());
//			}
//			Optional<List<Movies>> result4=service2.getallMovies();
//			if(result4.isEmpty())
//				System.out.println("Movie not found");
//			else {
//				System.out.println("Movies are");
//				result4.get().forEach(e->System.out.println(e));
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			String result5=service2.deleteMovie("m000001");
//			System.out.println("deletion");
//			System.out.println(result5);
//		} catch (NameNotFound | LocationNotFound e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Series--------");
//		
//		Series_Service1 service3=applicationContext.getBean(Series_Service1.class);
//		Series series=new Series("s000001","Friends",18, "A,B", "G,H,I","youtube.com/friends", java.sql.Date.valueOf("2022-04-05"), "English", 10);
//		Series series1=new Series("s000002","Office",18, "C,D", "G,H","youtube.com/office", java.sql.Date.valueOf("2022-02-05"), "English", 15);
//		String result6=service3.addSeries(series1);
//		String result7=service3.addSeries(series);
//		System.out.println(result6);
//		System.out.println(result7);
//		
//		try {
//			Optional<Series> result8=service3.getSeriesdetails("s000001");
//			if(result8.isEmpty())
//				System.out.println("Series not found");
//			else {
//				System.out.println(result8.get());
//			}
//			Optional<List<Series>> result9=service3.getallSeries();
//			if(result9.isEmpty())
//				System.out.println("Series not found");
//			else {
//				System.out.println("Series are");
//				result9.get().forEach(e->System.out.println(e));
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			String result5=service3.deleteSeries("s000001");
//			System.out.println("deletion");
//			System.out.println(result5);
//		} catch (NameNotFound e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		System.out.println("Episodes--------");
		
//		EpisodeService service4=applicationContext.getBean(EpisodeService.class);
//		Episodes episodes=new Episodes("e000001","XYZ",new BigDecimal(3000),"India,USA","ABC","s000001");
//		Episodes episodes1=new Episodes("e000002","XYZ1",new BigDecimal(2800),"India","XYZ","s000001");
//		String result10=service4.addepisode(episodes1);
//		String result11=service4.addepisode(episodes);
//		try {
//			Optional<Episodes> result8=service4.getEpisodesdetails("e000001");
//			if(result8.isEmpty())
//				System.out.println("Episode not found");
//			else {
//				System.out.println(result8.get());
//			}
//			Optional<List<Episodes>> result9=service4.getallEpisodeDetails();
//			if(result9.isEmpty())
//				System.out.println("No episodes found");
//			else {
//				System.out.println("Episodes are");
//				result9.get().forEach(e->System.out.println(e));
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			String result5=service4.deletepisode("e000002");
//			System.out.println("deletion");
//			System.out.println(result5);
//		} catch (NameNotFound | LocationNotFound e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		System.out.println("Subscription--------");
//		Subscription_Service1 service5=applicationContext.getBean(Subscription_Service1.class);
//		Subscriptions subscriptions=new Subscriptions("ss00001",java.sql.Date.valueOf("2021-04-05"),java.sql.Date.valueOf("2022-04-05"),500,"DEBIT CARD","ACTIVE","YEARLY","true","goutham1","India");
//		Subscriptions subscriptions1=new Subscriptions("ss00002",java.sql.Date.valueOf("2022-01-05"),java.sql.Date.valueOf("2022-02-05"),500,"CREDIT CARD","ACTIVE","MONTHLY","false","goutham2","India");
//		String result12=service5.addSubscription(subscriptions1);
//		String result13=service5.addSubscription(subscriptions);
//		try {
//			Optional<Subscriptions> result8=service5.getSubscription("ss00001");
//			if(result8.isEmpty())
//				System.out.println("Subscription id found");
//			else {
//				System.out.println(result8.get());
//			}
//			Optional<List<Subscriptions>> result9=service5.getallSubscription();
//			if(result9.isEmpty())
//				System.out.println("Subscription not found");
//			else {
//				System.out.println("Subscriptions are");
//				result9.get().forEach(e->System.out.println(e));
//			}
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			String result5=service5.deleteSubscription("ss00002");
//			System.out.println("deletion");
//			System.out.println(result5);
//		} catch (NameNotFound e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		applicationContext.close();
		
	}
	

}
