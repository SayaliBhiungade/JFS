package com.springcore.lifecycle;

//import org.springframework.context.ApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class Test {
	
	public static void main(String[] args) {
		AbstractApplicationContext context = new ClassPathXmlApplicationContext("com/springcore/lifecycle/config.xml");
        
        
        context.registerShutdownHook();
//        Samosa sam = (Samosa)context.getBean("samosa1");
//        System.out.println(sam);
//        System.out.println("*******************************");
//        Pizza p =(Pizza)context.getBean("pizza1");
//        System.out.println(p);
        
        Example ex = (Example) context.getBean("eg");
        System.out.println(ex);
        
	}

}
