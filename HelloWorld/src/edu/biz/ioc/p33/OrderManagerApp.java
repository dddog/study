package edu.biz.ioc.p33;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class OrderManagerApp {

	private static OrderManager orderManager;

	@Autowired
	public OrderManagerApp(OrderManager orderManager) {
		this.orderManager = orderManager;
	}

	public static void main(String args[]) {
		ApplicationContext factory = new ClassPathXmlApplicationContext(
				"edu/biz/ioc/p33/ioc.xml");
		// OrderManager manager = (OrderManager)
		// factory.getBean("orderManager");
		orderManager.order();
	}
}
