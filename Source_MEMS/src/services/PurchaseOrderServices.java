package services;

import java.util.List;

import model.table.PurchaseOrder;

public interface PurchaseOrderServices {
	//create
	void newPurchaseOrder();
	
	//read
	List<PurchaseOrder> selectAll();
	PurchaseOrder getPurOderByID(String ID);
	
	//update
	void update(PurchaseOrder po);
	//delete
	
	void delete(String poId);
}
