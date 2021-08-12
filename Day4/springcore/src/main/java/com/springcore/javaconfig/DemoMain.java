package com.springcore.javaconfig;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoMain {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(JavaConfig.class);
		Student st = (Student) context.getBean("member",Student.class);
		
		//Student st = (Student) context.getBean("firstStudent"); also works
		System.out.println(st);
		st.study();
//		context.close();
	}

}
