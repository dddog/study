package com.jacademy.empboard.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.jacademy.empboard.model.Emp;

public class EmpDaoImpl implements EmpDao {
	
	@Override
	public Connection connect() throws ClassNotFoundException, SQLException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		String url = "jdbc:oracle:thin:@192.168.0.27:1521:onj";
		return DriverManager.getConnection(url, "scott", "tiger");
	}

	@Override
	public ArrayList<Emp> select(){
		
		ArrayList<Emp> results = new ArrayList<Emp>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = connect();
			String sql = "select * from emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				results.add(new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getDouble("sal")));
			}
			return results;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (ps != null) {ps.close();}
				if (conn != null) {conn.close();}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return null;
	}
	
	@Override
	public ArrayList<Emp> selectByLimit(int start, int end){
		
		ArrayList<Emp> results = new ArrayList<Emp>();
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = connect();
			
			String sql = "select * from ( select rownum as rnum, a.* from ( select * from emp ) a )" +
				"where rnum >=? and rnum <=?";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, start);
			ps.setInt(2, end);
			
			rs = ps.executeQuery();
			while (rs.next()) {
				results.add(new Emp(rs.getInt("empno"), rs.getString("ename"), rs.getString("job"), rs.getDouble("sal")));
			}
			return results;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (ps != null) {ps.close();}
				if (conn != null) {conn.close();}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return null;
	}
	
	@Override
	public int count() {
		
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		
		try {
			conn = connect();
			String sql = "select count(*) as cnt from emp";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			if (rs.next()) {
				return rs.getInt("cnt");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {rs.close();}
				if (ps != null) {ps.close();}
				if (conn != null) {conn.close();}
			} catch (Exception ex) {
				ex.printStackTrace();
			}
		}
		
		return 0;
	}
	
	public static void main(String[] args) {
		EmpDaoImpl dao = new EmpDaoImpl();
		
		printEmp(dao);
		
		System.out.println(dao.count());
	}

	private static void printEmp(EmpDaoImpl dao) {
		for (Emp e : dao.select()) {
			System.out.println(e.getEmpno());
		}
	}
}
