package services;

import java.util.List;

import model.view.SalesOrderDetail;

public interface ViewSalesOrderDetailService {
	List<SalesOrderDetail> selectCurrentSalesOrderDetail();
	Integer getCurrentSalesOrderSum();
}
