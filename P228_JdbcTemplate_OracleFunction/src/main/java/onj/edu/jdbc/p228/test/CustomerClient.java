package onj.edu.jdbc.p228.test;

import java.util.List;

import onj.edu.jdbc.p228.dao.EmpDao;
import onj.edu.jdbc.p228.model.Emp;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class CustomerClient {

	public static void main(String[] args) {
		
		ApplicationContext ctx = new ClassPathXmlApplicationContext(
				"onj/edu/jdbc/p228/test/spring-jdbc1.xml");
		
		EmpDao dao = ctx.getBean("empDao", EmpDao.class);
		System.out.println(dao);
		
		List<Emp> list = dao.listEmp(10);
		System.out.println(list.size());
		
		List<Emp> list2 = dao.listEmp2(10);
		System.out.println(list2.size());
		
		List<Emp> list3 = dao.listEmp3(10);
		System.out.println(list3.size());
	}
}
