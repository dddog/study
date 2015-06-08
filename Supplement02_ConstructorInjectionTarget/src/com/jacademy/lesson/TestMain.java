package com.jacademy.lesson;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/jacademy/lesson/context.xml");
		
		Hero hero = context.getBean("hero", Hero.class);
		hero.print();
	}
}
