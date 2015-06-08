package com.jacademy.lesson;

public class Client {

	private IConstructor constructor;
	private String name;
	private int age;

	public Client() {
		// TODO Auto-generated constructor stub
	}

	public Client(IConstructor constructor) {
		System.out.println("Client(IConstructor constructor) called!");
		this.constructor = constructor;
	}

	public Client(IConstructor constructor, String name, int age) {
		System.out.println("Client(IConstructor constructor, String name, int age) called!");
		this.constructor = constructor;
		this.name = name;
		this.age = age;
	}
	
	public Client(IConstructor constructor, int age, String name) {
		System.out.println("Client(IConstructor constructor, int age, String name) called!");
		this.constructor = constructor;
		this.name = name;
		this.age = age;
	}

	public IConstructor getConstructor() {
		return constructor;
	}

	public void setConstructor(IConstructor constructor) {
		System.out.println("setConstructor(IConstructor constructor)");
		this.constructor = constructor;
	}

	public void build() {
		System.out.println("고객이 건설을 요청합니다.");
		constructor.build();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("setName(String name)");
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		System.out.println("setAge(int age)");
		this.age = age;
	}
}
