package dao;

import java.util.List;

import model.table.ProductType;

public interface ProductTypeDao {
	// create
	void add(ProductType pt);

	// read
	List<ProductType> selectAll();

	List<ProductType> selectById(String ptId);

	List<ProductType> selectByName(String ptName);

	// update
	void update(ProductType pt);

	// delete
	void delete(String id);
}
