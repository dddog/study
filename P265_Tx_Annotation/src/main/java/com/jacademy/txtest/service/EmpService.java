package com.jacademy.txtest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jacademy.txtest.dao.EmpDao;
import com.jacademy.txtest.model.Emp;

@Service
public class EmpService {

	@Autowired
	private EmpDao dao;
	
	public List<Emp> getEmpByDeptno(int deptno){
		return dao.getEmpByDeptno(deptno);
	}
	
	public void insertEmps() throws Exception{
		dao.insertEmps();
	}
}
