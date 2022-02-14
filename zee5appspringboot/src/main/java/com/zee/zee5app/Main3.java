package com.zee.zee5app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Optional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.zee.zee5app.dto.Episodes;
import com.zee.zee5app.dto.Movies;
import com.zee.zee5app.dto.Series;
import com.zee.zee5app.exception.LocationNotFound;
import com.zee.zee5app.exception.NameNotFound;
import com.zee.zee5app.service.EpisodeService;
import com.zee.zee5app.service.Movie_Service1;
import com.zee.zee5app.service.Series_Service1;
import com.zee.zee5app.utils.FileUtils;

@SpringBootApplication
public class Main3 {
public static void main(String[] args) {
	ConfigurableApplicationContext applicationContext=SpringApplication.run(Main3.class, args);
//	Series_Service1 service3=applicationContext.getBean(Series_Service1.class);
//	FileInputStream fileInputStream = null;
//	Series series=new Series("s000001","Friends",18, "A,B", "G,H,I","youtube.com/friends", java.sql.Date.valueOf("2022-04-05"), "English", 10,null);
////	Series series1=new Series("s000002","Office",18, "C,D", "G,H","youtube.com/office", java.sql.Date.valueOf("2022-02-05"), "English", 15,null);
////	String result6=service3.addSeries(series1);
////	String result7=service3.addSeries(series);
////	System.out.println(result6);
////	System.out.println(result7);
////	
//	File file1 = new File("C:\\movie\\video.mp4");
//	FileUtils fileUtils=null;
//	System.out.println("---episodes-");
//	EpisodeService service4=applicationContext.getBean(EpisodeService.class);
//	Episodes episodes=new Episodes("ep000001","XYZ",new BigDecimal(3000),"India,USA","ABC",series);
//	episodes.setTrailer("C:\\movie\\movieStore"+file1.getName());
//	String result11=service4.addepisode(episodes);
//	if(result11=="Success")
//	{
//		 fileUtils=applicationContext.getBean(FileUtils.class);
//		 try {
//			byte[] data=fileUtils.readFile(file1);
//			String add=fileUtils.writeFile(data,"C:\\movie\\movieStore\\"+file1.getName() );
//			System.out.println(add);
//			System.out.println("successfully added the file");
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	System.out.println(result11);
//	
//	
////	try {
////	 fileInputStream = new FileInputStream("C:\\movie\\video.mp4");
////	 File file = new File("C:\\movie\\video.mp4");
////	 long  filesize=file.length();
////	 
////     
////
////     
////     
////	 FileOutputStream fileOutputStream=null;
////	
////	Movie_Service1 service2=applicationContext.getBean(Movie_Service1.class);
////	Movies movies1=new Movies("m000001","Avengers",18,"X1,Y1","A1,B1",new BigDecimal(7200),null,java.sql.Date.valueOf("2022-04-05"),"English","action");
////	movies1.setTrailer("C:\\movie\\movieStore"+file.getName());
////	String result=service2.addMovie(movies1);
////	
////
////	System.out.println(result);
////	if(result.equals("Success"))
////	{
////		fileOutputStream=new FileOutputStream("C:\\movie\\movieStore\\"+file.getName());
////		byte[] data=new byte[(int) filesize];
////		fileInputStream.read(data);
////		fileOutputStream.write(data);
////	}
////	} catch (FileNotFoundException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	} catch (IOException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}
////	finally {
////		try {
////			fileInputStream.close();
////		} catch (IOException e) {
////			// TODO Auto-generated catch block
////			e.printStackTrace();
////		}
////	}
////	FileOutputStream fileOutputStream=null;
////	Movie_Service1 service2=applicationContext.getBean(Movie_Service1.class);
////	try {
////		Optional<Movies> movies=service2.getMoviedetails("m000001");
////		if(movies.isEmpty())
////			System.out.println("movie not found");
////		else
////		{
////			
////			 fileOutputStream =new FileOutputStream("C:\\Users\\goutham.s\\Downloads\\video1.mp4");
////			fileOutputStream.write(movies.get().getTrailer());
////		}
////	} catch (NameNotFound | LocationNotFound e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	} catch (FileNotFoundException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	} catch (IOException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}
////	finally {
////	try {
////		fileOutputStream.close();
////	} catch (IOException e) {
////		// TODO Auto-generated catch block
////		e.printStackTrace();
////	}
////	}
	
	

}
}
