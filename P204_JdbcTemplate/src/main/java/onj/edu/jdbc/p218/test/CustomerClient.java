package onj.edu.jdbc.p218.test;

import java.util.List;

import onj.edu.jdbc.p218.dao.CustomerJDBCTemplate;
import onj.edu.jdbc.p218.model.Customer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerClient {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"onj/edu/jdbc/p218/test/spring-jdbc1.xml");
		
		CustomerJDBCTemplate dao = ctx.getBean("customerJDBCTemplate", CustomerJDBCTemplate.class);
		
		dao.deleteAll();
		
		dao.create(1, "홍길동1", 11);
		dao.create(2, "홍길동2", 22);
		dao.create(3, "홍길동3", 33);
		
		List<Customer> customers = dao.listCustomer();
		for (Customer c : customers) {
			System.out.println(c.getId() + ", " + c.getName() + ", " + c.getAge());
		}
		System.out.println("------------------------");
		
		dao.update(1, 18);
		
		Customer customer = dao.getCustomer(1);
		System.out.println(customer.getId() + ", " + customer.getName() + ", " + customer.getAge());
		System.out.println("------------------------");
		
		dao.delete(2);
		
		List<Customer> customers2 = dao.listCustomer();
		for (Customer c : customers2) {
			System.out.println(c.getId() + ", " + c.getName() + ", " + c.getAge());
		}
	}
}
