package com.edu.jdbc.dao;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import java.util.List;

import javax.sql.DataSource;

import onj.edu.jdbc.dao.EmpDao;
import onj.edu.jdbc.model.Emp;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmpDaoTest {

	private EmpDao dao;
	
	@Before
	public void setUp() throws Exception {
		//테스트를 위한 초기설정, Fixture(작업대)
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"database_connection.xml");
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		dao = new EmpDao();
		dao.setDataSource(dataSource);
	}

	@After
	public void tearDown() throws Exception {
		//테스트에서 사용한 자원반납
	}

	@Test
	public void testInsert() {
		
//		dao.insert(new Emp(999, "테스트", "의사", 9999));
		assertThat(dao.insert(new Emp(999, "테스트", "의사", 9999)), is(1));
	}

	@Test
	public void testDelete() {
		fail("Not yet implemented");
	}

	@Test
	public void testUpdate() {
		assertThat(dao.update(new Emp(999, "테스트", "의사1",9999)), is(1));
	}
	
	@Test
	public void testSelect() {
		List<Emp> results = dao.select();
		for( Emp e : results ) {
			System.out.println(e.getEmpno()+","+e.getEname()+","+e.getJob()+","+e.getSal());
		}
		assertThat(results.size(), is(not(0)));
	}

}
