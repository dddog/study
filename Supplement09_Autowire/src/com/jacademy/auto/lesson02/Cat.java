package com.jacademy.auto.lesson02;

public class Cat implements Pet{

	private String name;

	public Cat() {
		// TODO Auto-generated constructor stub
	}
	
	public Cat(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
