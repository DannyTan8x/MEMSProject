package dao;

import java.util.List;

import model.view.EmployeeInfo;

public interface ViewEmployeeInfoDao {
	
	//read
	List<EmployeeInfo> selectAll();
	List<EmployeeInfo> selectByEmId(Integer emId);
	List<EmployeeInfo> selectByDepId(Integer dpId);
	List<EmployeeInfo> selectByKeyword(String keyword);

}
