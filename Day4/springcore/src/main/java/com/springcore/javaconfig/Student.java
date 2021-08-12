package com.springcore.javaconfig;

import org.springframework.stereotype.Component;

//@Component("firstStudent")

public class Student {
	public Samosa samosa;
	public void  study() {
		this.samosa.display();
		System.out.println("Shhhhhh!!!! Student is studying");
	}
	
	

	public Student(Samosa samosa) {
		super();
		this.samosa = samosa;
	}

	public Samosa getSamosa() {
		return samosa;
	}

	public void setSamosa(Samosa samosa) {
		this.samosa = samosa;
	}

	
}
