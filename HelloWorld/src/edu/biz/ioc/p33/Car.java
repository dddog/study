package edu.biz.ioc.p33;

import org.springframework.stereotype.Component;

@Component("car")
public class Car {
	
	private String name;

	public Car(){}
	public Car(String name) {
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	
}
