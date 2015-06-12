package com.jacademy.empboard.service.impl;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jacademy.empboard.service.EmpService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class EmpServiceImplTest {

	@Autowired
	private EmpService service;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
//		fail("Not yet implemented");
	}

	@Test
	public void testSelect() {
		int count = service.count();
		assertThat(service.select().size(), is(count));
	}
}
