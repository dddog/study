package onj.edu.jdbc.p199;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConnectionTest {
	
	public DataSource getDataSource(){
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@192.168.0.121:1521:orcl");
		dataSource.setUsername("scott");
		dataSource.setPassword("1234");
		return dataSource;
	}

	public static void main(String[] args) {
		
		ConnectionTest test = new ConnectionTest();
		DataSource dataSource = test.getDataSource();
		System.out.println(dataSource);
		System.out.println("--------------------------");
		
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"onj/edu/jdbc/p199/datasource-context.xml");
		DataSource dataSource2 = context.getBean("dataSource", DriverManagerDataSource.class);
		System.out.println(dataSource2);
	}
}
