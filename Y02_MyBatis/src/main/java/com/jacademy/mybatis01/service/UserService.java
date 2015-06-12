package com.jacademy.mybatis01.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import com.jacademy.mybatis01.dao.UserDao;
import com.jacademy.mybatis01.model.User;
import com.jacademy.mybatis01.util.MyBatisUtil;

public class UserService {
	public void insertUser(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			UserDao dao = sqlSession.getMapper(UserDao.class);
			dao.insertUser(user);
			sqlSession.commit();
		} catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			sqlSession.close();
		}
	}

	public User getUserById(Integer userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			UserDao dao = sqlSession.getMapper(UserDao.class);
			return dao.getUserById(userId);
		} finally {
			sqlSession.close();
		}
	}

	public List<User> getAllUsers() {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			UserDao dao = sqlSession.getMapper(UserDao.class);
			return dao.getAllUsers();
		} finally {
			sqlSession.close();
		}
	}

	public void updateUser(User user) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			UserDao dao = sqlSession.getMapper(UserDao.class);
			dao.updateUser(user);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}

	public void deleteUser(Integer userId) {
		SqlSession sqlSession = MyBatisUtil.getSqlSessionFactory()
				.openSession();
		try {
			UserDao dao = sqlSession.getMapper(UserDao.class);
			dao.deleteUser(userId);
			sqlSession.commit();
		} finally {
			sqlSession.close();
		}

	}
}
