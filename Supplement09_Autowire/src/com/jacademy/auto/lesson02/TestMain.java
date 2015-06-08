package com.jacademy.auto.lesson02;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/jacademy/auto/lesson02/lessonContext.xml");
		User user = context.getBean("user", User.class);
		
		Pet pet = user.getPet();
		System.out.println(((Cat)pet).getName());
	}
}
