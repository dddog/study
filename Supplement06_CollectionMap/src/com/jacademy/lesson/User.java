package com.jacademy.lesson;

import java.util.Map;

public class User {

	private String name;
	private Map<String, Pet> pets;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, Map<String, Pet> pets) {
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

	public Map<String, Pet> getPets() {
		return pets;
	}

	public void setPets(Map<String, Pet> pets) {
		this.pets = pets;
	}

}
