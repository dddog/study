package edu.biz.ioc.p33;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("daewoo")
public class DaewooMaker implements CarMaker{

	@Autowired(required=false)
	private Car car;
	
	public DaewooMaker() {}
	
	@Override
	public Car sell(Money money) {
		System.out.println("I sold a Tosca.");
		car.setName("Tosca");
		return car;
	}
}
