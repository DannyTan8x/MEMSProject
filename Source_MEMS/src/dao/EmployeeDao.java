package dao;

import java.util.List;

import model.table.Employee;

public interface EmployeeDao {
	// create
		void add(Employee e);

		// read
		List<Employee> selectAll();

		List<Employee> selectById(Integer id);

		List<Employee> selectByName(String name);
		
		List<Employee> selectByUserId(Integer userId);

		// update
		void update(Employee e);

		// delete
		void delete(Integer id);
}
