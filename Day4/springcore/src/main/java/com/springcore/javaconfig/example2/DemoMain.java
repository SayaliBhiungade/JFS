package com.springcore.javaconfig.example2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		//Faculty f = (Faculty) context.getBean("firstFaculty");//using component annotation
		Faculty f = (Faculty) context.getBean("faculty");//wo using component annotation
		
		//Faculty f= (Faculty) context.getBean("firstFaculty"); also works
		System.out.println(f);
		f.teach();
//		context.close();
	}

}
