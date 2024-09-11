package services;

import java.util.List;

import model.table.SalesOrder;

public interface SalesOrderServices {
	
	//create
	void newSalesOrder();
	//read
	List<SalesOrder> selectAll();
	SalesOrder getSalesOrderByID(String soId);
	
	//update
	void update(SalesOrder so);
	//delete
	
	void delete(String poId);
	

}
