package com.jacademy.lesson;

import java.util.Map;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/jacademy/lesson/lessonContext.xml");
		User user = context.getBean("user", User.class);
		
		Map<String, Pet> pets = user.getPets();
		Set<String> keys = pets.keySet();
		String[] keyAry = keys.toArray(new String[keys.size()]);
		
		for (String key : keyAry) {
			System.out.println(pets.get(key));
		}
	}
}
