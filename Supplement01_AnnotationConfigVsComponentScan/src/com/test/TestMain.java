package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/config.xml");
		
		/*
		creating bean B: com.xxx.B@2121946d
		creating bean C: com.xxx.C@3c859513
		creating bean A: com.yyy.A@65fe316f
		setting A.bbb with com.xxx.B@2121946d
		setting A.ccc with com.xxx.C@3c859513
		*/
		
	}
}
