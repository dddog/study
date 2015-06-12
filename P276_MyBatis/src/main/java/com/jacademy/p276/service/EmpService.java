package com.jacademy.p276.service;

import com.jacademy.p276.dao.EmpMapper;
import com.jacademy.p276.model.Emp;

public class EmpService {
	private EmpMapper empMapper;

	public void setEmpMapper(EmpMapper empMapper) {
		this.empMapper = empMapper;
	}

	public Emp selectByEmpno(int empno) {
		return this.empMapper.selectByEmpno(empno);
	}
}
