package services;

import model.table.PurchaseOrderItem;

public interface PurchaseOrderItemService {
	//create
	void addToCurrentPO( String productID, Integer Qty, Integer purchasePrice);
	//read

	PurchaseOrderItem selectedPOItem(Integer poiId); //set to current poItem;
	
	
	//update
	void update(PurchaseOrderItem poItem);
	
	//delete
	void delete(Integer poiId);
	
}
