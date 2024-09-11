package dao;

import java.util.List;

import model.table.SalesOrderItem;

public interface SalesOrderItemDao {

	// create
	void add(SalesOrderItem soi);

	// read
	List<SalesOrderItem> selectAll();

	List<SalesOrderItem> selectById(Integer id);

	List<SalesOrderItem> selectBySOId(String SOId);

	// update
	void update(SalesOrderItem soi);

	// delete
	void delete(Integer id);
}
