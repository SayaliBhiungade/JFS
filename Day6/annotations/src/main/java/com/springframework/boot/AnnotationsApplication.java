package com.springframework.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

import com.springframework.boot.mypack.Manager;

@SpringBootApplication
public class AnnotationsApplication implements CommandLineRunner {
	
	@Autowired
	@Qualifier("student2")
	private Student student; 
	
	@Autowired
	private Date date; 
	
	@Autowired
	private Emp emp;
	
	@Autowired
	private Manager manager;

	public static void main(String[] args) {
		SpringApplication.run(AnnotationsApplication.class, args);
	}
	
	@Override
	public void run(String...args) throws Exception {
		this.student.studying(); 
		this.emp.whatsYourName();
		this.manager.speaking();
	}

}
