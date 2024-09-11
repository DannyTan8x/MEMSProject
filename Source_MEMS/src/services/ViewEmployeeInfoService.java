package services;

import java.util.List;

import model.view.EmployeeInfo;

public interface ViewEmployeeInfoService {
	
	List<EmployeeInfo> listEmployeeTabelwidtKeyword(String keyword);
	
	EmployeeInfo getEmInfoById(Integer emInfoId);
}
