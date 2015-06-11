package com.jacademy.p298.dao;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.jacademy.p298.model.Emp;

import static org.hamcrest.CoreMatchers.notNullValue;

public class EmpDaoImplTest {

	private EmpDao dao;
	
	@Before
	public void setUp() throws Exception {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"file:src/main/webapp/WEB-INF/spring/root-context.xml");
		dao = context.getBean("empDao", EmpDaoImpl.class);
	}
	
	@Test
	public void test() {
		List<Emp> results = dao.Select();
		int count = 0;
		for( Emp e : results ) {
			count++;
			System.out.println(e.getEmpno()+","+e.getEname());
		}
		assertThat(results, notNullValue());
	}
}
