package com.jacademy.lesson;

import java.util.Properties;

public class User {

	private String name;
	private Properties config;

	public User() {
		// TODO Auto-generated constructor stub
	}

	public User(String name, Properties config) {
		super();
		this.name = name;
		this.config = config;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Properties getConfig() {
		return config;
	}

	public void setConfig(Properties config) {
		this.config = config;
	}

}
