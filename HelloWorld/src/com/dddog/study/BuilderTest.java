package com.dddog.study;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;




public class BuilderTest {

	public static void main(String[] args) {
		ApplicationContext factory = new ClassPathXmlApplicationContext(
				"com/dddog/study/ioc.xml");
		Constructor constructor = (Constructor) factory.getBean("constructor");
		constructor.order();
	}
}
