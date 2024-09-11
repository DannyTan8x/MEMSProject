package Utilities;


import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.table.SalesOrderItem;
import model.view.PurchaseOrderDetail;
import model.view.SalesOrderDetail;

public class SalesOrderItemListTableModel extends AbstractTableModel {

	private static final long serialVersionUID = 1L;
	List<SalesOrderDetail> salesOrderDetailItems;
	private final String[] columnNames = { "ID", "品名ID", "品名", "售價", "數量", "小計" };

	public SalesOrderItemListTableModel(List<SalesOrderDetail> purchaseOrderDetailItems) {
			super();
			this.salesOrderDetailItems = purchaseOrderDetailItems;
		}

	@Override
	public int getRowCount() {
		return this.salesOrderDetailItems.size();
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
		SalesOrderDetail salesOrderItem = salesOrderDetailItems.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return salesOrderItem.getSalesOrderItemId();
		case 1:
			return salesOrderItem.getProduct_id();
		case 2:
			return salesOrderItem.getProduct_name();
		case 3:
			return salesOrderItem.getProduct_price();
		case 4:
			return salesOrderItem.getQty();
		case 5:
			return salesOrderItem.getTotal();

		default:
			return null;
		}

	}

	// Method to reload the entire list of employees and refresh the table
	public void setSalesOrderItemDetailList(List<SalesOrderDetail> purchaseOrderItems) {
		this.salesOrderDetailItems = purchaseOrderItems;
		fireTableDataChanged(); // Notify the table that the entire data has changed
	}

}
