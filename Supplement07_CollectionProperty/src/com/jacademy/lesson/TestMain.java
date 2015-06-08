package com.jacademy.lesson;

import java.util.Arrays;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"com/jacademy/lesson/lessonContext.xml");
		User user = context.getBean("user", User.class);
		
		Properties config = user.getConfig();
		Set<Object> keys = config.keySet();
		String[] keyAry = keys.toArray(new String[keys.size()]);
		
		Arrays.sort(keyAry);
		
		for (String key : keyAry) {
			System.out.println(config.get(key));
		}
		System.out.println("----------------------");
		
		for (String key : user.getConfig().keySet().toArray(new String[0])) {
			System.out.println(config.get(key));
		}
		System.out.println("----------------------");
		
		for (Object obj : keys) {
			System.out.println(config.get((String)obj));
		}
	}
}
