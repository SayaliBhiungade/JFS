package com.springcore.javaconfig.example2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages="com.springcore.javaconfig")
public class JavaConfig {
	@Bean
	public Chalk getChalk() {
		return new Chalk();
	}
	
	@Bean(name = {"faculty", "teacher", "professor"})
	public Faculty getFaculty() {
		// creating new student object
		Faculty f= new Faculty(getChalk());
		return f;
	}

}
