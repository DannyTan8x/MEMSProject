package services.impl;

import java.util.List;

import dao.impl.table.SalesOrderItemDaoImpl;
import model.table.SalesOrderItem;
import services.SalesOrderItemService;
import systemData.SystemData;

public class SalesOrderItemServiceImpl implements SalesOrderItemService {
	SalesOrderItemDaoImpl soidi = new SalesOrderItemDaoImpl();

	@Override
	public void addToCurrentSO(String productId, Integer Qty) {
		SalesOrderItem soi = new SalesOrderItem(SystemData.currentSO.getOrderId(), productId, Qty);
		soidi.add(soi);
	}

	@Override
	public SalesOrderItem selectedSOItem(Integer soiId) {
		List<SalesOrderItem> soil;
		soil = soidi.selectById(soiId);
		return soil.get(0);
	}

	@Override
	public void update(SalesOrderItem soItem) {
		soidi.update(soItem);

	}

	@Override
	public void delete(Integer soiId) {
		soidi.delete(soiId);

	}

}
