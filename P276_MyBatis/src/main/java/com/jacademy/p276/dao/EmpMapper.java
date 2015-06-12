package com.jacademy.p276.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.jacademy.p276.model.Emp;

public interface EmpMapper {
	@Select("select * from emp2 where empno = #{empno}")
	public Emp selectByEmpno(@Param("empno") int empno);
}
