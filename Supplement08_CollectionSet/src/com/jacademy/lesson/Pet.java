package com.jacademy.lesson;

public class Pet {

	private String name;

	public Pet() {
		// TODO Auto-generated constructor stub
	}
	
	public Pet(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public void init(){
		System.out.println("init() called");
	}

}
