package services.impl;

import java.util.List;

import javax.swing.JOptionPane;

import dao.impl.table.DepartmentDaoImpl;
import model.table.Department;
import services.DepartmentService;

public class DepartmentServiceImpl implements DepartmentService{
	DepartmentDaoImpl ddi = new DepartmentDaoImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(String dpName) {
		// TODO Auto-generated method stub
		//亂來的需要改
		if(ddi.selectByName(dpName)!=null) {
			ddi.add(dpName);
		}else {
			JOptionPane.showMessageDialog(null, "部門名稱不能重複", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
		
		
	}

	@Override
	public List<Department> selectAll() {
		List<Department> deptList= null;
		deptList = ddi.selectAll();
		return deptList;
	}

	@Override
	public void update(Department dp) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Integer dpId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Department selectByName(String dpName) {
		Department d = null;
		List<Department> l;
		l = ddi.selectByName(dpName);
		d = l.get(0);
		return d;
	}

}
