package com.jacademy.empboard.service.impl;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacademy.empboard.dao.EmpDao;
import com.jacademy.empboard.model.Emp;
import com.jacademy.empboard.service.EmpService;

@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	EmpDao dao;


	@Override
	public ArrayList<Emp> select() {
		// TODO Auto-generated method stub
		return dao.select();
	}

	@Override
	public int count() {
		// TODO Auto-generated method stub
		return dao.count();
	}

	@Override
	public ArrayList<Emp> selectByLimit(int start, int end) {
		// TODO Auto-generated method stub
		return dao.selectByLimit(start, end);
	}
	
	
}
