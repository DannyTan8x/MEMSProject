package services;

import java.util.List;

import model.table.Product;

public interface ProductService {
	
	//create
	void add(String pId, String ptId, String pName, Integer price, String description );
	
	//read
	List<Product> selectAll();
	Product selectById(String pId);
	
	//update
	void update(Product p);
	//delete
	
	void delete(String pId);
	

}
