package onj.edu.jdbc.p200;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ConnectionTest2 {
	
	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"onj/edu/jdbc/p200/datasource-context2.xml");
		
		DataSource dataSource3 = context.getBean("dataSource", BasicDataSource.class);
		System.out.println(dataSource3);
	}
}
