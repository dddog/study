package com.jacademy.p215;


import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class ConnectionTest {

	public DataSource connect() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		dataSource.setUrl("jdbc:oracle:thin:@192.168.0.27:1521:onj");
		dataSource.setUsername("scott");
		dataSource.setPassword("tiger");
		return dataSource;
	}
	public static void main(String[] args) {
		ConnectionTest test = new ConnectionTest();
		if( test.connect() != null ) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
		
		xmlSettingDatabaseConnectionTest();
	}
	private static void xmlSettingDatabaseConnectionTest() {
		// TODO Auto-generated method stub
		ApplicationContext context = new ClassPathXmlApplicationContext("database_connection.xml");
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		if( dataSource != null ) {
			System.out.println("success");
		} else {
			System.out.println("fail");
		}
	}
}
