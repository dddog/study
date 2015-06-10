package onj.edu.jdbc.p218.dao;

import java.util.List;

import javax.sql.DataSource;

import onj.edu.jdbc.p218.model.Customer;

public interface CustomerDao {

	public void setDataSource(DataSource ds);
	public void create(Integer id, String name, Integer age);
	public Customer getCustomer(Integer id);
	public List<Customer> listCustomer();
	public void delete(Integer id);
	public void deleteAll();
	public void update(Integer id, Integer age);
}
