package services;

import java.util.List;

import model.table.ProductType;

public interface ProductTypeServices {
	
	//create
	void add(String ptId, String PtName);
	
	//read
	List<ProductType> selectAll();
	ProductType selectById(String ptId);
	ProductType selectByTypeName(String ptName);
	
	//update
	void update(ProductType pt);
	
	//delete
	
	void delete(String ptId);
	

}
