package services;

import java.util.List;

import model.view.PurchaseOrderDetail;

public interface ViewPurchaseOrderDetailService {
	//read
	List<PurchaseOrderDetail> selectCurrentPurchaseOrderDetail();
}
