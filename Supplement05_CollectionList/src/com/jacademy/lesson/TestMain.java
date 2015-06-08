package com.jacademy.lesson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/jacademy/lesson/lessonContext.xml");
		User user = context.getBean("user", User.class);
		
		for (Pet pet : user.getPets()) {
			System.out.println(pet.getName());
		}
	}
}
