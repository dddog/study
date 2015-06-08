package edu.biz.ioc.p20;

public class OrderManager {

//	private HyundaiMaker maker;
	private CarMaker maker;
	
	public OrderManager() {
		this.maker = new HyundaiMaker();
	}
	
	public void order() {
		Money money = new Money(1000);
		System.out.println(money.getAmount()+"원을 지불합니다.");
		
		Car car = this.maker.sell(money);
		System.out.println(car.getName()+"를 받았습니다.");
	}
}
