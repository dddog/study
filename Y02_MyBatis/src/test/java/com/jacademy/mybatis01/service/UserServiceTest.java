package com.jacademy.mybatis01.service;

import java.util.List;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.jacademy.mybatis01.model.User;

public class UserServiceTest {

	private static UserService userService;

	@Before
	public void setUp() throws Exception {
		userService = new UserService();
	}

	@After
	public void tearDown() throws Exception {
		userService = null;
	}

	@Test
	public void testInsertUser() {
		User user = new User();
		user.setEmailId("test_email_" + System.currentTimeMillis()
				+ "@gmail.com");
		user.setPassword("secret");
		user.setFirstName("TestFirstName");
		user.setLastName("TestLastName");

		userService.insertUser(user);
		Assert.assertTrue(user.getUserId() != 0);
		System.out.println("user.getUserId(): "+user.getUserId());
		
		User createdUser = userService.getUserById(user.getUserId());
		Assert.assertNotNull(createdUser);
		Assert.assertEquals(user.getEmailId(), createdUser.getEmailId());
		Assert.assertEquals(user.getPassword(), createdUser.getPassword());
		Assert.assertEquals(user.getFirstName(), createdUser.getFirstName());
		Assert.assertEquals(user.getLastName(), createdUser.getLastName());
	}

	@Test
	public void testGetUserById() {
		User user = userService.getUserById(2);
		Assert.assertNotNull(user);
		System.out.println(user);
	}

	@Test
	public void testGetAllUsers() {
		List<User> users = userService.getAllUsers();
		Assert.assertNotNull(users);
		for (User user : users) {
			System.out.println(user);
		}
	}

	@Test
	public void testUpdateUser() {
		long timestamp = System.currentTimeMillis();
		User user = userService.getUserById(2);
		user.setFirstName("TestFirstName" + timestamp);
		user.setLastName("TestLastName" + timestamp);
		userService.updateUser(user);
		User updatedUser = userService.getUserById(2);
		Assert.assertEquals(user.getFirstName(), updatedUser.getFirstName());
		Assert.assertEquals(user.getLastName(), updatedUser.getLastName());
	}

	@Test
	public void testDeleteUser() {
		User user = userService.getUserById(2);
		userService.deleteUser(user.getUserId());
		User deletedUser = userService.getUserById(2);
		Assert.assertNull(deletedUser);
	}

}
