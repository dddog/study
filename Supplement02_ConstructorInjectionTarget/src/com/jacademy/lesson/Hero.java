package com.jacademy.lesson;

public class Hero {

	private String name;
	private int age;
	private String bloodType;
	
	public Hero(String name, int age) {
		System.out.println("Hero(String name, int age)");
		this.name = name;
		this.age = age;
	}
	
	public Hero(String name, String bloodType) {
		System.out.println("Hero(String name, String bloodType)");
		this.name = name;
		this.bloodType = bloodType;
	}
	
	public void print(){
		System.out.println(name + ", " + age + ", " + bloodType);
	}
}
