package com.springcore.javaconfig.example2;

import org.springframework.stereotype.Component;

//@Component("firstFaculty")

public class Faculty {
	
	public Chalk Chalk;
	public void  teach() {
		this.Chalk.display();
		System.out.println("Keep Silence!! Faculty is teaching...");
	}
	
	

	public Faculty(Chalk Chalk) {
		super();
		this.Chalk = Chalk;
	}

	public Chalk getChalk() {
		return Chalk;
	}

	public void setChalk(Chalk Chalk) {
		this.Chalk = Chalk;
	}

	
}
