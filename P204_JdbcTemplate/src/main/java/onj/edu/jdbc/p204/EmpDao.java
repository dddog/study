package onj.edu.jdbc.p204;


import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

public class EmpDao {
	private JdbcTemplate jdbcTemplate;
	
	public void setDataSource(DataSource dataSource){
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	public List<Map<String, Object>> getNames(){
		String sql = "select * from emp where rownum < 5";
		return jdbcTemplate.queryForList(sql);
	}
	
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext(""
				+ "onj/edu/jdbc/p204/app-jdbc.xml");
		
		EmpDao dao = context.getBean("empDao", EmpDao.class);
		List<Map<String, Object>> list = dao.getNames();
		
		for (Map<String, Object> map : list) {
			System.out.println(map.get("ename"));
		}
	}
}
