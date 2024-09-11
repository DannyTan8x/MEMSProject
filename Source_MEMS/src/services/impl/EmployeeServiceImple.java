package services.impl;

import java.util.List;

import javax.swing.JOptionPane;

import dao.impl.table.EmployeeDaoImpl;
import model.table.Employee;
import services.EmployeeService;

public class EmployeeServiceImple implements EmployeeService {
	EmployeeDaoImpl edi = new EmployeeDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void newEmployee(String firstName, String lastName, String positoin, Integer dept_id) {
		// adding user
		Employee e = new Employee(firstName, lastName, positoin, dept_id);
		edi.add(e);
		JOptionPane.showMessageDialog(null, "建立成功員工個資。", "Information", JOptionPane.INFORMATION_MESSAGE);
	}

	@Override
	public String getEmployeeName(Integer eId) {
		// TODO Auto-generated method stub
		String employeeName = null;
		Employee e = new Employee();

		List<Employee> el;
		try {
			el = edi.selectById(eId);
			e = el.get(0);
			employeeName = e.getFirst_name() + e.getLast_name();
		} catch (IndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(null, "工號不存在，請聯繫人資再確認！", "Information", JOptionPane.INFORMATION_MESSAGE);
			e1.printStackTrace();
		}

		return employeeName;
	}

	@Override
	public List<Employee> getEmployeeList() {
		// selectAll test
		List<Employee> el = edi.selectAll();
		return el;
	}

	@Override
	public void deleteEmployee(Integer eId) {
		edi.delete(eId);

	}

	@Override
	public Employee selectEmployeeById(Integer emId) {
		// selectById test
		List<Employee> el;
		el = edi.selectById(emId);
		Employee e = el.get(0);
		return e;
	}

	@Override
	public void updateEmployee(Employee e) {
		edi.update(e);
	}

	@Override
	public Employee selectEmployeeByUserId(Integer userId) {
		List<Employee> el;
		el = edi.selectByUserId(userId);
		Employee e = el.get(0);
		return e;
	}

}
