package onj.edu.jdbc.p228.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import onj.edu.jdbc.p228.model.Emp;

import org.springframework.jdbc.core.RowMapper;

public class EmpMapper implements RowMapper<Emp>{

	@Override
	public Emp mapRow(ResultSet rs, int idx) throws SQLException {
		Emp emp = new Emp();
		emp.setEmpno(rs.getInt("empno"));
		emp.setEname(rs.getString("ename"));
		emp.setSal(rs.getInt("sal"));
		
		return emp;
	}
}
