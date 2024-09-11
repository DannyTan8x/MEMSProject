package services;

import model.table.SalesOrderItem;

public interface SalesOrderItemService {
	
	//create
	void addToCurrentSO(String productId, Integer Qty);
	
	//read
	SalesOrderItem selectedSOItem(Integer soiId);
	
	//update
	void update(SalesOrderItem soItem);
	
	//delete
	void delete(Integer soiId);

}
