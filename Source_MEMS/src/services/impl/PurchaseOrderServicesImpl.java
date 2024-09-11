package services.impl;

import java.util.List;

import Utilities.StringIDGrenerator;
import dao.impl.table.PurchaseOrderDaoImpl;
import model.table.PurchaseOrder;
import services.PurchaseOrderServices;
import systemData.SystemData;

public class PurchaseOrderServicesImpl implements PurchaseOrderServices{

	PurchaseOrderDaoImpl podi = new PurchaseOrderDaoImpl();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
 
	@Override
	public void newPurchaseOrder() {
//		System.out.println("===== PurchaseOrder =====");
		String PoID = StringIDGrenerator.purchaseOrderIDGenerator();
		PurchaseOrder po = new PurchaseOrder(PoID);
		podi.add(po);
		SystemData.currentPO = podi.selectByPOId(PoID).get(0);		
	}

	@Override
	public List<PurchaseOrder> selectAll() {
		List<PurchaseOrder>  pol = podi.selectAll();
		return pol;
	}

	@Override
	public PurchaseOrder getPurOderByID(String ID) {
		return podi.selectByPOId(ID).get(0);
	}

	@Override
	public void update(PurchaseOrder po) {
		podi.update(po);
		
	}

	@Override
	public void delete(String poId) {
		podi.delete(poId);
		
	}

}
