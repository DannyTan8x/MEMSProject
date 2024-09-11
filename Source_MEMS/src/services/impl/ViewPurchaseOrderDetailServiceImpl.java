package services.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.view.ViewPurchaseOrderDetailDaoImpl;
import model.view.PurchaseOrderDetail;
import services.ViewPurchaseOrderDetailService;
import systemData.SystemData;

public class ViewPurchaseOrderDetailServiceImpl implements ViewPurchaseOrderDetailService{
	ViewPurchaseOrderDetailDaoImpl vpoddi = new ViewPurchaseOrderDetailDaoImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PurchaseOrderDetail> selectCurrentPurchaseOrderDetail() {
		List<PurchaseOrderDetail>  currentPOlist = new ArrayList();
//		System.out.println("PurchaseOrderDetailServiceImpl: "+ SystemData.currentPO.getPurchaseOrderId());
		currentPOlist = vpoddi.selectByPurchaseOrderId(SystemData.currentPO.getPurchaseOrderId());
		return currentPOlist;
	}

}
