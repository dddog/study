package edu.biz.ioc.p25;

public class HyundaiMaker implements CarMaker{

	public HyundaiMaker() {
		
	}
	
	public Car sell(Money monye) {
		System.out.println("I sold a car.");
		Car car = new Car("Sonata");
		return car;
	}
}
