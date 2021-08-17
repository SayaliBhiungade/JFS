package com.springframework.boot;
import com.springframework.boot.Student;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.util.Date;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;


@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "mypack") 
public class MyConfig {
	
	@Bean("student1")
	@Lazy
	public Student getStudent() {
		System.out.println("creating 1st student");
		return new Student("student1");
	}
	
	@Bean("student2")
	@Lazy
	public Student createStudent() { 
		System.out.println("creating 2nd student");
		return new Student("student2");
	}
	
	@Bean
	public Date getDate() { 
		System.out.println("Create new date");
		return new Date();
	}
}
