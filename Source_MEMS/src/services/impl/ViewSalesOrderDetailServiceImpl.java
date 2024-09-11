package services.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.view.ViewSalesOrderDetailDaoImpl;

import model.view.SalesOrderDetail;
import services.ViewSalesOrderDetailService;
import systemData.SystemData;

public class ViewSalesOrderDetailServiceImpl implements ViewSalesOrderDetailService {
	ViewSalesOrderDetailDaoImpl vsoddi = new ViewSalesOrderDetailDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SalesOrderDetail> selectCurrentSalesOrderDetail() {
		List<SalesOrderDetail> currentPOlist = new ArrayList();
//		System.out.println("PurchaseOrderDetailServiceImpl: "+ SystemData.currentPO.getPurchaseOrderId());
		currentPOlist = vsoddi.selectBySalesOrderId(SystemData.currentSO.getOrderId());
		return currentPOlist;
	}

	@Override
	public Integer getCurrentSalesOrderSum() {
		return vsoddi.getSumOfOrder(SystemData.currentSO.getOrderId());
	}

}
