package com.jacademy.y03mybatis.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.jacademy.y03mybatis.domain.User;

@Repository
public interface UserDao {
	public void saveUser(User user);
    public void updateUser(User user);
    public void deleteUser(String id);
    public List<User> getAllUser();
    public int count();
    public User getUserById(String id);
    public int deleteAll();
}
