package edu.biz.ioc;

public class HyundaiMaker {

	public HyundaiMaker() {
		
	}
	
	public Car sell(Money monye) {
		System.out.println("I sold a car.");
		Car car = new Car("Sonata");
		return car;
	}
}
