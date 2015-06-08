package com.jacademy.lesson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class TestMain {

	public static void main(String[] args) {
		String configLocation = "com/jacademy/lesson/config.xml";
		ApplicationContext context = new ClassPathXmlApplicationContext(configLocation);
		
		Superman superman = context.getBean("superman", Superman.class);
		
		System.out.println(superman);
	}
}
