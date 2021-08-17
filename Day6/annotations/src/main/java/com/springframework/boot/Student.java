package com.springframework.boot;

public class Student {

	String name;
	
	public Student(String name) {
		super();
		this.name = name;
	}

	public void studying() {
		System.out.println(this.name + "I am Studying");
	}
}