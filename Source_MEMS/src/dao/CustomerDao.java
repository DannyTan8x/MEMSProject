package dao;

import java.util.List;

import model.table.Customer;

public interface CustomerDao {
	// create
	void add(Customer c);

	// read
	List<Customer> selectAll();

	List<Customer> selectById(Integer id);

	List<Customer> selectByName(String cName);

	// update
	void update(Customer c);

	// delete
	void delete(String Cid);
}
