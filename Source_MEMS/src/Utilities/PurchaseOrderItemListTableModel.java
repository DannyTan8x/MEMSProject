package Utilities;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.table.PurchaseOrderItem;
import model.view.PurchaseOrderDetail;



	public class PurchaseOrderItemListTableModel   extends AbstractTableModel{

	
	private static final long serialVersionUID = 1L;
	List<PurchaseOrderDetail> purchaseOrderDetailItems;
	 private final String[] columnNames = {"ID","品名ID", "品名",  "進價", "數量", "小計"};

	public PurchaseOrderItemListTableModel(List<PurchaseOrderDetail> purchaseOrderDetailItems) {
		super();
		this.purchaseOrderDetailItems = purchaseOrderDetailItems;
	}

	@Override
	public int getRowCount() {
		return this.purchaseOrderDetailItems.size();
	}

	@Override
	public int getColumnCount() {
		return this.columnNames.length;
	}
	
	@Override
    public String getColumnName(int column) {
        return columnNames[column];
    }

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		PurchaseOrderDetail purchaseOrderItem = purchaseOrderDetailItems.get(rowIndex);
		switch(columnIndex) {
		case 0: return purchaseOrderItem.getPurchaseOrderItem_id();
		case 1: return purchaseOrderItem.getProduct_id();
		case 2: return purchaseOrderItem.getProduct_name();
		case 3: return purchaseOrderItem.getProduct_price();
		case 4: return purchaseOrderItem.getQty();
		case 5: return purchaseOrderItem.getTotal();

		
		default: return null;
		}
		
	}
	
	// Method to reload the entire list of employees and refresh the table
    public void setPurchaseOrderItemDetailList(List<PurchaseOrderDetail> purchaseOrderItems) {
        this.purchaseOrderDetailItems = purchaseOrderItems;
        fireTableDataChanged(); // Notify the table that the entire data has changed
    }

}
