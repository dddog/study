package com.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMain {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext("com/test/config.xml");
		
		/*
		We load the context and the result is... Nothing. 
		No beans are created, no beans are autowired. 
		*/
		
		/*
		<context:annotation-config /> only works on beans registered 
		within the application context. 
		Because I removed the XML configuration for the three beans 
		there is no bean created and <context:annotation-config /> 
		has no "targets" to work on.
		 */
		
		/*
		<context:component-scan> which can scan a package for "targets" 
		to work on. Let's change the content of the XML config into 
		the following entry
		 */
		
		/*
		추가: <context:component-scan base-package="com.xxx" />
		실행
		creating bean B: com.xxx.B@1be0f0a
		creating bean C: com.xxx.C@80d1ff
		*/
		
		/*
		<context:component-scan base-package="com.xxx, com.yyy" />
		creating bean B: com.xxx.B@42367c17
		creating bean C: com.xxx.C@4b9a6fa1
		creating bean A: com.yyy.A@2e13c690
		setting A.bbb with com.xxx.B@42367c17
		setting A.ccc with com.xxx.C@4b9a6fa1
		*/
	}
}
