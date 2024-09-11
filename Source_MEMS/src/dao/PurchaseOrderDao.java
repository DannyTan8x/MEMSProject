package dao;

import java.util.List;

import model.table.PurchaseOrder;

public interface PurchaseOrderDao {
	// create
	void add(PurchaseOrder po);

	// read
	List<PurchaseOrder> selectAll();

	List<PurchaseOrder> selectById(Integer id);

	List<PurchaseOrder> selectByPOId(String poId);

	// update
	void update(PurchaseOrder po);

	// delete
	void delete(String poId);
}
