package dao;

import java.util.List;

import model.table.SalesOrder;

public interface SalesOrderDao {
	// create
	void add(SalesOrder so);

	// read
	List<SalesOrder> selectAll();

	List<SalesOrder> selectById(Integer id);

	List<SalesOrder> selectBySOId(String SOId);

	// update
	void update(SalesOrder so);

	// delete
	void delete(String SoId);
}
