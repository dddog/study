package com.jacademy.reflection;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import java.lang.reflect.Proxy;

import org.junit.Test;

public class HelloTest {

	@Test
	public void accessTarget(){
		Hello hello = new HelloTarget();
		assertThat(hello.sayHello("Superman"), is("Hello Superman"));
		assertThat(hello.sayHi("Superman"), is("Hi Superman"));
		assertThat(hello.sayThankYou("Superman"), is("Thank You Superman"));
	}
	
	@Test
	public void accessProxy(){
		Hello hello = new HelloUppercase(new HelloTarget());
		assertThat(hello.sayHello("Superman"), is("HELLO SUPERMAN"));
		assertThat(hello.sayHi("Superman"), is("HI SUPERMAN"));
		assertThat(hello.sayThankYou("Superman"), is("THANK YOU SUPERMAN"));
	}
	
	@Test
	public void dynamicProxy(){
		Hello proxiedHello = (Hello)Proxy.newProxyInstance(
				getClass().getClassLoader(), //다이내믹프록시가 정의되는 클래스 로더
				new Class[]{Hello.class}, //인터페이스
				new UppercaseHandler(new HelloTarget())); //InvocationHandler 구현 객체
		/**
		 * 인터페이스를 주면서 프록시팩토리에게 다이내믹 프록시를 만들어 달라고 요청하면
		 * 인터페이스의 모든 메소드를 구현한 오브젝트를 만들어 준다.
		 * 
		 * InvocationHandler 인터페이스를 구현한 오브젝트를 제공해주면 다이내믹 프록시가
		 * 받는 모든 요청을 invoke() 메소드로 보내준다.
		 */
		
		assertThat(proxiedHello.sayHello("Superman"), is("HELLO SUPERMAN"));
		assertThat(proxiedHello.sayHi("Superman"), is("HI SUPERMAN"));
		assertThat(proxiedHello.sayThankYou("Superman"), is("THANK YOU SUPERMAN"));
	}
}
