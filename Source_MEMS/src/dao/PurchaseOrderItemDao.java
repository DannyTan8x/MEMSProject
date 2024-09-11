package dao;

import java.util.List;

import model.table.PurchaseOrderItem;

public interface PurchaseOrderItemDao {
	// create
	void add(PurchaseOrderItem poi);

	// read
	List<PurchaseOrderItem> selectAll();

	List<PurchaseOrderItem> selectByPOrderItemId(Integer poiId);

	List<PurchaseOrderItem> selectByPOrderId(String poId);

	// update
	void update(PurchaseOrderItem poi);

	// delete
	void delete(Integer id);
}
