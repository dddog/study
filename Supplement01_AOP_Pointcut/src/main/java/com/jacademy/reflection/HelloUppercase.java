package com.jacademy.reflection;

public class HelloUppercase implements Hello{
	
	Hello hello;
	
	public HelloUppercase(Hello hello) {
		this.hello = hello;
	}
	
	/**
	 * 현재 프록시 사용 방법의 문제점
	 * 1. 모든 메소드를 구현해야 한다.
	 * 2. 부가기능이 모든 메소드에 중복돼서 나타난다.
	 * 
	 * TODO: 다이나믹프록시 사용
	 */

	@Override
	public String sayHello(String name) {
		return hello.sayHello(name).toUpperCase();
	}

	@Override
	public String sayHi(String name) {
		return hello.sayHi(name).toUpperCase();
	}

	@Override
	public String sayThankYou(String name) {
		return hello.sayThankYou(name).toUpperCase();
	}

}
