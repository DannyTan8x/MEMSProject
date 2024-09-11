package services.impl;

import java.util.List;

import dao.impl.table.PurchaseOrderItemDaoImpl;
import model.table.PurchaseOrderItem;
import services.PurchaseOrderItemService;
import systemData.SystemData;

public class PurchaseOrderItemServiceImpl implements PurchaseOrderItemService{
	PurchaseOrderItemDaoImpl poidi = new PurchaseOrderItemDaoImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addToCurrentPO( String productID, Integer Qty, Integer purchasePrice) {
		PurchaseOrderItem poi = new PurchaseOrderItem(SystemData.currentPO.getPurchaseOrderId(),productID,purchasePrice,Qty);
		poidi.add(poi);
		
	}

	@Override
	public PurchaseOrderItem selectedPOItem(Integer poiId) {
		List<PurchaseOrderItem> poil;
		poil = poidi.selectByPOrderItemId(poiId);
		return poil.get(0);
	}

	@Override
	public void update(PurchaseOrderItem poItem) {
		poidi.update(poItem);
		
	}

	@Override
	public void delete(Integer poiId) {
		poidi.delete(poiId);
		
	}

}
