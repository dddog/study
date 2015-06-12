package com.jacademy.y03mybatis.service;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.jacademy.y03mybatis.domain.User;

/*
 * 마이바티스+스프링으로 일체형으로 사용하는 환경에서 마이바티스 정상작동을
 * 테스하기 위해서 스프링이 제공하는 테스트 클래스를 사용할 수 있다.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/root-context.xml" })
public class UserServiceTest {
	
	@Autowired
	private UserService service;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSaveUser() {
		//service.deleteAll();
		assertThat(service.deleteAll(), is(true));
		
		User user = new User();
		user.setAge("99");
		user.setId("dddog");
		user.setName("개");
		user.setSex("F");
		user.setStandard("aaa");
		
		service.saveUser(user);
		
		assertThat(service.count(), is(1));
	}

	@Test
	public void testUpdateUser() {
		User user = new User();
		user.setId("dddog");
		user.setName("강아지");
		user.setAge("100");
		user.setSex("M");
		user.setStandard("bbb");
		service.updateUser(user);
		
		User createdUser = service.getUserById(user.getId());
		Assert.assertEquals(user.getName(), createdUser.getName());
		Assert.assertEquals(user.getAge(), createdUser.getAge());
		Assert.assertEquals(user.getSex(), createdUser.getSex());
		Assert.assertEquals(user.getStandard(), createdUser.getStandard());
		System.out.println(createdUser.toString());
	}

	@Test
	public void testDeleteUser() {
		assertThat(service.count(), is(2));
		service.deleteUser("id01");
		assertThat(service.count(), is(1));
	}

	@Test
	public void testGetAllUser() {
		List<User> list = service.getAllUser();
		assertThat(list.size(), is(2));
	}

}
