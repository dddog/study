package edu.biz.ioc.p25;

public class DaewooMaker implements CarMaker{

	public DaewooMaker() {}
	
	public Car sell(Money money) {
		System.out.println("I sold a car.");
		Car car = new Car("Tosca");
		return car;
	}
}
