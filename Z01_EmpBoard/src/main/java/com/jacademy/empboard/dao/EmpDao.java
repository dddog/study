package com.jacademy.empboard.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jacademy.empboard.model.Emp;

public interface EmpDao {

	public Connection connect() throws ClassNotFoundException, SQLException;
	public ArrayList<Emp> select();
	public int count();
	public ArrayList<Emp> selectByLimit(int start, int end);
}
