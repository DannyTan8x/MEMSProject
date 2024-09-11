package dao;

import java.util.List;

import model.table.Department;

public interface DepartmentDao {
	// create
	void add(String dpName);

	// read
	List<Department> selectAll();

	List<Department> selectById(Integer id);

	List<Department> selectByName(String cName);

	// update
	void update(Department d);

	// delete
	void delete(Integer id);
}
