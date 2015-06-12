package com.jacademy.y03mybatis.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jacademy.y03mybatis.dao.UserDao;
import com.jacademy.y03mybatis.domain.User;

@Service
public class UserService {
	@Autowired
	private UserDao dao;

	@Transactional
	public void saveUser(User user) {
		dao.saveUser(user);
	}

	public void updateUser(User user) {
		dao.updateUser(user);
	}

	public void deleteUser(String id) {
		dao.deleteUser(id);
	}

	public List<User> getAllUser() {
		return dao.getAllUser();
	}
	
	public int count() {
		return dao.count();
	}
	
	public User getUserById(String id) {
		return dao.getUserById(id);
	}
	
	public boolean deleteAll() {
		int deleteState = dao.deleteAll();
		System.out.println("deleteState>>>"+deleteState);
		if( deleteState > 0 ) {
			return true;
		} else if(dao.count() == 0) {
			return true;
		} else {
			return false;
		}
	}
}
