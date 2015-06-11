package com.jacademy.p298.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.jacademy.p298.model.Emp;

@Repository("empDao")
public class EmpDaoImpl implements EmpDao {

	private JdbcTemplate jdbcTemplate;
	
	private RowMapper<Emp> empRowMapper = new RowMapper<Emp>() {
		
		@Override
		public Emp mapRow(ResultSet rs, int idx) throws SQLException {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			return emp;
		}
	};
	@Autowired
	public void setDataSource(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}
	@Override
	public List<Emp> Select() {
		String sql = "select * from emp0610";
		return jdbcTemplate.query(sql, empRowMapper);
	}

}
