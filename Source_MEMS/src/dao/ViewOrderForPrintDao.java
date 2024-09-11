package dao;

import java.util.List;

import model.view.OrderForPrint;

public interface ViewOrderForPrintDao {
	
	//read
	List<OrderForPrint> selectAll();
	List<OrderForPrint> selectByOrderId(String OId);

}
