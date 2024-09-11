package services.impl;

import java.util.List;

import Utilities.StringIDGrenerator;
import dao.impl.table.SalesOrderDaoImpl;
import model.table.SalesOrder;
import services.SalesOrderServices;
import systemData.SystemData;

public class SalesOrderServicesImpl implements SalesOrderServices{
	SalesOrderDaoImpl sodi = new SalesOrderDaoImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void newSalesOrder() {
		String SoId = StringIDGrenerator.salesOrderIDGenerator();
		SalesOrder so = new SalesOrder(SoId, SystemData.currentEmployee.getId());
		sodi.add(so);
		SystemData.currentSO = sodi.selectBySOId(SoId).get(0);
	}

	@Override
	public List<SalesOrder> selectAll() {
		List<SalesOrder> sol = sodi.selectAll();
		return sol;
	}

	@Override
	public SalesOrder getSalesOrderByID(String soId) {
		
		return sodi.selectBySOId(soId).get(0);
	}

	@Override
	public void update(SalesOrder so) {
		sodi.update(so);
		
	}

	@Override
	public void delete(String poId) {
		sodi.delete(poId);
	}

}
