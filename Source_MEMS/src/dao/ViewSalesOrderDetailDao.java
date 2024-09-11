package dao;

import java.util.List;

import model.view.SalesOrderDetail;

public interface ViewSalesOrderDetailDao {
	

		
		//read
		
		List<SalesOrderDetail> selectAll();
		List<SalesOrderDetail> selectBySalesOrderId(String soId);
		List<SalesOrderDetail> selectById(Integer soiid);
		
		
		Integer getSumOfOrder(String soId);
		
	
}
