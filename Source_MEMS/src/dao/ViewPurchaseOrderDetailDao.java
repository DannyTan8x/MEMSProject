package dao;

import java.util.List;

import model.view.PurchaseOrderDetail;

public interface ViewPurchaseOrderDetailDao {

	
	//read
	
	List<PurchaseOrderDetail> selectAll();
	List<PurchaseOrderDetail> selectByPurchaseOrderId(String poId);
	List<PurchaseOrderDetail> selectById(Integer poiid);
	
}
