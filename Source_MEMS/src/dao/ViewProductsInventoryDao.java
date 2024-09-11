package dao;

import java.util.List;

import model.view.ProductsInventory;

public interface ViewProductsInventoryDao {
	//read
	List<ProductsInventory> selectAll();
	List<ProductsInventory> selectByInventoryAmountGreaterThanGivenNumber(Integer number);
	List<ProductsInventory> selectByproductName(String productName);
	List<ProductsInventory> selectByproductId(String productId);
	List<ProductsInventory> selectBykeywordAndInventry(String keyword, Integer number);
	List<ProductsInventory> selectBykeywordAndInventryForSales(String keyword, Integer number);
}
