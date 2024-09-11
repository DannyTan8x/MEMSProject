package dao.impl.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.SalesOrderItemDao;
import dao.impl.DbConnection;
import model.table.PurchaseOrderItem;
import model.table.SalesOrderItem;

public class SalesOrderItemDaoImpl implements SalesOrderItemDao {
	Connection conn = DbConnection.getDb();

	public static void main(String[] args) {
		SalesOrderItemDaoImpl soidi = new SalesOrderItemDaoImpl();
		/*
		 * create
		 */
		System.out.println("===== addSalesOrder =====");
		SalesOrderItem soi = new SalesOrderItem("SO005","P045",50);
		soidi.add(soi);
		/*
		 * read
		 */
		List<SalesOrderItem> l;
		// selectAll test
		System.out.println("===== selectAll =====");
		l = soidi.selectAll();
		l.stream().forEach((t) -> System.out.println(t.getOrderId() + "-" + t.getProductId() + "-" + t.getQty()));
		// selectAll test
		System.out.println("===== selectById =====");
		l = soidi.selectById(5);
		l.stream().forEach((t) -> System.out.println(t.getOrderId() + "-" + t.getProductId() + "-" + t.getQty()));
		// selectAll test
		System.out.println("===== selectBySOId =====");
		l = soidi.selectBySOId("SO006");
		l.stream().forEach((t) -> System.out.println(t.getOrderId() + "-" + t.getProductId() + "-" + t.getQty()));
		// update
		System.out.println("===== update =====");
		SalesOrderItem soi2 = l.get(0);
		soi2.setProductId("P015");
		soi2.setQty(50);
		soidi.update(soi2);
		//delete
		System.out.println("===== delete =====");
		soidi.delete(5);
	}

	@Override
	public void add(SalesOrderItem soi) {
		String SQL = "INSERT INTO `mems`.`salesOrderItems` (`order_id`, `product_id`, `Qty`) " + "VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, soi.getOrderId());
			ps.setString(2, soi.getProductId());
			ps.setInt(3, soi.getQty());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<SalesOrderItem> selectAll() {
		List<SalesOrderItem> soil = new ArrayList();
		String SQL = "SELECT * FROM mems.salesOrderItems";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SalesOrderItem soi = new SalesOrderItem();
				soi.setOrderItemId(rs.getInt("orderItem_id"));
				soi.setOrderId(rs.getString("order_id"));
				soi.setProductId(rs.getString("product_id"));
				soi.setQty(rs.getInt("Qty"));

				soil.add(soi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soil;
	}

	@Override
	public List<SalesOrderItem> selectById(Integer id) {
		List<SalesOrderItem> soil = new ArrayList();
		String SQL = "SELECT * FROM mems.salesOrderItems WHERE orderItem_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SalesOrderItem soi = new SalesOrderItem();
				soi.setOrderItemId(rs.getInt("orderItem_id"));
				soi.setOrderId(rs.getString("order_id"));
				soi.setProductId(rs.getString("product_id"));
				soi.setQty(rs.getInt("Qty"));

				soil.add(soi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soil;
	}

	@Override
	public List<SalesOrderItem> selectBySOId(String SOId) {
		List<SalesOrderItem> soil = new ArrayList();
		String SQL = "SELECT * FROM mems.salesOrderItems WHERE order_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, SOId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SalesOrderItem soi = new SalesOrderItem();
				soi.setOrderItemId(rs.getInt("orderItem_id"));
				soi.setOrderId(rs.getString("order_id"));
				soi.setProductId(rs.getString("product_id"));
				soi.setQty(rs.getInt("Qty"));

				soil.add(soi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return soil;
	}

	@Override
	public void update(SalesOrderItem soi) {
		String SQL = "UPDATE `mems`.`salesOrderItems` "
				+ "SET `product_id` = ?, `Qty` = ? WHERE (`orderItem_id` = ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);

			ps.setString(1, soi.getProductId());
			ps.setInt(2, soi.getQty());
			ps.setInt(3, soi.getOrderItemId());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		String SQL ="DELETE FROM `mems`.`salesOrderItems` WHERE (`orderItem_id` = ?)";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}

}
