package dao;

import java.util.List;

import model.table.Product;

public interface ProductDao {
	// create
	void add(Product p);

	// read
	List<Product> selectAll();

	List<Product> selectById(Integer id);
	List<Product> selectByProId(String pid);
	List<Product> selectByName(String pName);

	// update
	void update(Product p);

	// delete
	void delete(String pId);
}