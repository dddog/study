package com.jacademy.lesson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMain {

	public static void main(String[] args) {
		String configLocation = "com/jacademy/lesson/config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		Client client = context.getBean("client", Client.class);
		
//		System.out.println(client);
//		System.out.println(client.getConstructor());
//		System.out.println("----------------------------");
//		
//		System.out.println("name: " + client.getName());
//		System.out.println("age: " + client.getAge());
	}
}
