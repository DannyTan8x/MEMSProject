package services;

import java.util.List;

import model.table.Employee;

public interface EmployeeService {

	void newEmployee(String firstName, String lastName, String positoin, Integer dept_id);

	String getEmployeeName(Integer eId);

	List<Employee> getEmployeeList();

	Employee selectEmployeeById(Integer emId);
	
	Employee selectEmployeeByUserId(Integer userId);
	
	void updateEmployee(Employee e);

	void deleteEmployee(Integer emId);

}
