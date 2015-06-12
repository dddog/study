package com.jacademy.mybatis01.dao;

import java.util.List;

import com.jacademy.mybatis01.model.User;

public interface UserDao {
	public void insertUser(User user);

	public User getUserById(Integer userId);

	public List<User> getAllUsers();

	public void updateUser(User user);

	public void deleteUser(Integer userId);
}
