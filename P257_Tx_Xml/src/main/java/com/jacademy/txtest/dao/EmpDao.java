package com.jacademy.txtest.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jacademy.txtest.model.Emp;

@Repository
public class EmpDao {

	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Emp> empRowMapper = new RowMapper<Emp>(){
		private Emp emp = null;
		@Override
		public Emp mapRow(ResultSet rs, int idx) throws SQLException {
			emp = new Emp();
			emp.setDeptno(rs.getInt("deptno"));
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			return emp;
		}
	};
	
	@Autowired
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Emp> getEmpByDeptno(int deptno){
		String sql = "select empno, ename, deptno from emp0610 where deptno=?";
		return jdbcTemplate.query(sql, new Object[]{deptno}, empRowMapper);
	}
	
	public void insertEmps() throws Exception{
		String sql = "insert into emp0610(empno, ename, deptno) values(?, ?, ?)";
		
		int ret = jdbcTemplate.update(sql, new Object[]{101, "name1", 90});
		System.out.println("입력결과 행 수: " + ret);
		
		ret = jdbcTemplate.update(sql, new Object[]{102, "name2", 90});
		System.out.println("입력결과 행 수: " + ret);
		
		ret = jdbcTemplate.update(sql, new Object[]{103, "name3", 90});
		System.out.println("입력결과 행 수: " + ret);
		
		//DuplicateKeyException
//		ret = jdbcTemplate.update(sql, new Object[]{101, "name4", 90});
//		System.out.println("입력결과 행 수: " + ret);
		
		//강제 예외 발생
		throw new Exception();
	}
	
	public int count(){
		String sql = "select count(*) from emp0610";
		return jdbcTemplate.queryForInt(sql);
	}
	
	public void delete(){
		String sql = "delete emp0610 where 1=1";
		jdbcTemplate.update(sql);
	}
}
