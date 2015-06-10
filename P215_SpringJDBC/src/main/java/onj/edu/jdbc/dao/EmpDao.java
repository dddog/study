package onj.edu.jdbc.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import onj.edu.jdbc.model.Emp;

public class EmpDao {

	// private DataSource dataSource;
	private JdbcTemplate jdbcTemplate;
	
	private RowMapper rowMapper = new RowMapper<Emp>(){

		@Override
		public Emp mapRow(ResultSet rs, int idx) throws SQLException {
			Emp emp = new Emp();
			emp.setEmpno(rs.getInt("empno"));
			emp.setEname(rs.getString("ename"));
			emp.setJob(rs.getString("job"));
			emp.setSal(rs.getInt("sal"));
			return emp;
		}
		
	};

	@Autowired
	public void setDataSource(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	public int insert(Emp emp) {
		String sql = "insert into emp0610(empno, ename, job, sal) values(?,?,?,?)";
		return jdbcTemplate.update(sql,	new Object[] { 
				emp.getEmpno(), 
				emp.getEname(), 
				emp.getJob(),
				emp.getSal()});
	}

	/*
	 * 과제:메소드 구현
	 */
	public void delete(int empno) {

	}

	public int update(Emp emp) {
		String sql = "update emp0610 set ename=?, job=?, sal=? where empno = ?";
		return jdbcTemplate.update(sql, new Object[] { 
				emp.getEname(), 
				emp.getJob(),
				emp.getSal(), 
				emp.getEmpno() });
	}

	public List<Map<String, Object>> selectForListMap() {
		String sql = "select * from emp0610 where rownum < 5";
		return jdbcTemplate.queryForList(sql);
	}

	@SuppressWarnings("unchecked")
	public List<Emp> select() {
		String sql = "select * from emp0610 order by empno asc";
		return jdbcTemplate.query(sql, rowMapper);
	}
	
	public List<Emp> selectJdbc() {

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<Emp> results = new ArrayList<Emp>();
		try {
			// 연결
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager
					.getConnection("jdbc:oracle:thin:@192.168.0.27:1521:onj",
							"scott", "tiger");

			// 질의
			String sql = "select * from emp0610 order by empno asc";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			Emp emp = null;

			// 처리
			while (rs.next()) {
				emp = new Emp();
				emp.setEmpno(rs.getInt("empno"));
				emp.setEname(rs.getString("ename"));
				emp.setJob(rs.getString("job"));
				emp.setSal(rs.getInt("sal"));
				results.add(emp);
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (ps != null) {
					ps.close();
				}
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}

		}
		return results;

	}

	public Emp selectByNo(int empno) {
		String sql = "select * from emp0610 where empno = ?";
		return jdbcTemplate.queryForObject(sql, new Object[]{empno}, rowMapper);
	}

	/*
	 * 과제 : 메소드 구현
	 */
	public int count() {
		String sql = "select count(*) from emp0610";
		return jdbcTemplate.queryForInt(sql);
	}

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"database_connection.xml");
		DataSource dataSource = context.getBean("dataSource", DataSource.class);
		EmpDao empDao = new EmpDao();
		empDao.setDataSource(dataSource);
		
//		List<Map<String, Object>> list = empDao.selectForListMap();
//		System.out.println(list.size());
//
//		List<Emp> empList = empDao.selectJdbc();
//		for (Emp e : empList) {
//			System.out.println(e.getEmpno()+","+e.getEname()+","+e.getJob()+","+e.getSal());
//		}
		
		Emp emp = empDao.selectByNo(999);
	}
}
