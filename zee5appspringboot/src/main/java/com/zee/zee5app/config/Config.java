package com.zee.zee5app.config;

import java.beans.Beans;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;
import org.springframework.core.env.Environment;
//it is used to mark on config classes
//it is responsible to read the property file

import com.zee.zee5app.utils.PasswordUtils;
@Configuration
//@ComponentScan("com.zee.zee5app")
//@PropertySource("classpath:application.properties")
public class Config {
//db related ,reading properties file,password encoder
	@Autowired //will bring the already created objectsbased on ref name /type
	Environment environment;//this impl object is prepared by string 
//	@Bean(name="ds") //providing only one object whenever the method is called
//	//if we dont specify the bean name //it takes methodName
//	//@Scope("prototype") //it is used to get multiple objects.
//	@Scope("singleton")  //gives one one object
//	public DataSource datasource()
//	{
//		BasicDataSource basicDataSource=new BasicDataSource();
//		basicDataSource.setUsername(environment.getProperty("jdbc.username"));
//		basicDataSource.setPassword(environment.getProperty("jdbc.password"));
//		basicDataSource.setUrl(environment.getProperty("jdbc.url"));
////		basicDataSource.setInitialSize(5);
//basicDataSource.setDefaultAutoCommit(false);
//		return basicDataSource;
//		
//	}
	@Bean
	//if bean is declared here,it would be useful if cutomizations are required.
	public PasswordUtils passwordutils()
	{
		return new PasswordUtils();
	}
}
