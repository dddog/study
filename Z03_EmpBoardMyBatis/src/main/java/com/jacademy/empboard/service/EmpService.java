package com.jacademy.empboard.service;

import java.util.ArrayList;
import java.util.List;

import com.jacademy.empboard.model.Emp;


public interface EmpService {

	public ArrayList<Emp> select();
	public int count();
	public ArrayList<Emp> selectByLimit(int start, int end);
}
