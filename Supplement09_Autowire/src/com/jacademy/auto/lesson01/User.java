package com.jacademy.auto.lesson01;

public class User {

	private String name;
	private Pet pet;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(Pet pet) {
		super();
		this.pet = pet;
	}

	public User(String name, Pet pet) {
		super();
		this.name = name;
		this.pet = pet;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Pet getPet() {
		return pet;
	}

	public void setPet(Pet pet) {
		this.pet = pet;
	}

}
