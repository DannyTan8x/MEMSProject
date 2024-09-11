package services;

import java.util.List;

import model.table.Department;

public interface DepartmentService {

	// create
	void add(String dpName);

	// read
	List<Department> selectAll();

	Department selectByName(String dpName);

	// update
	void update(Department dp);
	// delete

	void delete(Integer dpId);

}
