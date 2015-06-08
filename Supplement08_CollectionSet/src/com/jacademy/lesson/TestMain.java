package com.jacademy.lesson;

import java.util.Iterator;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/jacademy/lesson/lessonContext.xml");
		User user = context.getBean("user", User.class);
		
		Set<Pet> pets = user.getPets();
		Iterator<Pet> iter = pets.iterator();
		
		while (iter.hasNext()) {
			System.out.println(iter.next().getName());
		}
		System.out.println("-----------------------------");
		
		for (Pet pet : pets) {
			System.out.println(pet.getName());
		}
	}
}
