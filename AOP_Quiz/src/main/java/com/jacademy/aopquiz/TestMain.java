package com.jacademy.aopquiz;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop_quiz.xml");
		
		MyTestBean myBean = (MyTestBean) ctx.getBean("myTestBean");
		
		System.out.println("---- MyTestBean ----");
		myBean.run();
	}
}
