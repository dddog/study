package com.jacademy.aopquiz;


import org.springframework.context.support.GenericXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
		ctx.load("aop_quiz.xml");
		ctx.refresh();
		
		MyTestBean myBean = (MyTestBean) ctx.getBean("myTestBean");
		
		System.out.println("---- MyTestBean ----");
		myBean.run();
	}
}
