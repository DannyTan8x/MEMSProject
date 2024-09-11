package services;

import java.util.List;

import model.view.ProductsInventory;

public interface ViewProductsInventoryService {

	List<ProductsInventory> listProductInventoryForImport(String keyword, Integer number);

	List<ProductsInventory> listProductInventoryForSales(String keyword, Integer number);

	ProductsInventory getProductInventoryByProId(String proId);

}
