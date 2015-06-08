package edu.biz.ioc.p25;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("orderManager")
public class OrderManager {

	private String name;
	
	@Autowired
	@Qualifier("daewoo")
	private CarMaker maker;
	
	@Autowired
	private Money money;
	
	public OrderManager() {
//		this.maker = new DaewooMaker();
	}
	
	public void order() {
		money.setAmount(1000);
		Car car = this.maker.sell(money);
	}

	/**
	 * @return the maker
	 */
	public CarMaker getMaker() {
		return maker;
	}

	/**
	 * @param maker the maker to set
	 */
	public void setMaker(CarMaker maker) {
		this.maker = maker;
	}
}
