package com.jacademy.lesson;

import java.util.List;

public class User {

	private String name;
	private List<Pet> pets;

	public User() {}
	
	public User(String name, List<Pet> pets) {
		super();
		this.name = name;
		this.pets = pets;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

}
