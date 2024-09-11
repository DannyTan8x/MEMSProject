package services.impl;

import java.util.List;

import dao.impl.view.ViewEmployeeInfoDaoImpl;
import model.view.EmployeeInfo;
import services.ViewEmployeeInfoService;

public class ViewEmployeeInfoServiceImpl implements ViewEmployeeInfoService {
	ViewEmployeeInfoDaoImpl veidi = new ViewEmployeeInfoDaoImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<EmployeeInfo> listEmployeeTabelwidtKeyword(String keyword) {
		List<EmployeeInfo> eil = null;
		if(keyword.equals("") || keyword.equals(null)) {
			eil = veidi.selectAll();
		}else {
			eil = veidi.selectByKeyword(keyword);
		}
		return eil;
	}

	@Override
	public EmployeeInfo getEmInfoById(Integer emInfoId) {
		EmployeeInfo e = veidi.selectByEmId(emInfoId).get(0);
		return e;
	}

}
