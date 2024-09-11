package Utilities;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.view.ProductsInventory;

public class ProductListTableModelForImport extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	List<ProductsInventory> productInv;
//	 private final String[] columnNames = {"產品類別ID", "產品類別", "產品ID", "品名", "入庫數量", "銷售數量", "目前庫存"};
	 private final String[] columnNames = {"產品類別ID", "產品類別", "產品ID", "品名",  "目前庫存"};

	public ProductListTableModelForImport(List<ProductsInventory> productInv) {
		super();
		this.productInv = productInv;
	}

	@Override
	public int getRowCount() {
		
		return this.productInv.size();
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
		ProductsInventory product = productInv.get(rowIndex);
		switch(columnIndex) {
		case 0: return product.getProductTypeId();
		case 1: return product.getProductTypeName();
		case 2: return product.getProductId();
		case 3: return product.getProductName();
		case 4: return product.getInventoryAmount();
		
		default: return null;
		}
		
	}
	
	// Method to reload the entire list of employees and refresh the table
    public void setProductList(List<ProductsInventory> productInv) {
        this.productInv = productInv;
        fireTableDataChanged(); // Notify the table that the entire data has changed
    }

}
