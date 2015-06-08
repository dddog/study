package com.jacademy.lesson;

import java.util.Set;

public class User {

	private String name;
	private Set<Pet> pets;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, Set<Pet> pets) {
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

	public Set<Pet> getPets() {
		return pets;
	}

	public void setPets(Set<Pet> pets) {
		this.pets = pets;
	}

}
