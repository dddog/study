package com.dddog.study;

import org.springframework.stereotype.Component;

@Component("builder")
public class Builder {

	private String name;
	public Builder(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}
