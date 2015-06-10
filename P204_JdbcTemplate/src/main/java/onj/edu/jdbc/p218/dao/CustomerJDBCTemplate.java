package onj.edu.jdbc.p218.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import onj.edu.jdbc.p218.model.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class CustomerJDBCTemplate implements CustomerDao {

	private JdbcTemplate jt;

	@Autowired
	@Override
	public void setDataSource(DataSource ds) {
		this.jt = new JdbcTemplate(ds);
	}

	//org.springframework.jdbc.core.RowMapper<Customer>
	private RowMapper<Customer> rowMapper = new RowMapper<Customer>() {
		@Override
		public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
			Customer c = new Customer();
			c.setId(rs.getInt("id"));
			c.setName(rs.getString("name"));
			c.setAge(rs.getInt("age"));

			return c;
		}
	};

	@Override
	public void create(Integer id, String name, Integer age) {
		String sql = "insert into customer2(id, name, age) values(?, ?, ?)";
		jt.update(sql, id, name, age);
	}

	@Override
	public Customer getCustomer(Integer id) {
		return jt.queryForObject("select * from customer2 where id=?", new Object[]{id}, rowMapper);
	}

	@Override
	public List<Customer> listCustomer() {
		return jt.query("select * from customer2 order by id asc", rowMapper);
	}

	@Override
	public void delete(Integer id) {
		jt.update("delete from customer2 where id=?", id);
	}

	@Override
	public void deleteAll() {
		jt.update("delete from customer2");
	}

	@Override
	public void update(Integer id, Integer age) {
		jt.update("update customer2 set age=? where id=?", age, id);
	}

}
