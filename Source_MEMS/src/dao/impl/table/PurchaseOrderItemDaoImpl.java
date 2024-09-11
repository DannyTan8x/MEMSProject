package dao.impl.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.PurchaseOrderItemDao;
import dao.impl.DbConnection;
import model.table.PurchaseOrder;
import model.table.PurchaseOrderItem;

public class PurchaseOrderItemDaoImpl implements PurchaseOrderItemDao {
	Connection conn = DbConnection.getDb();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PurchaseOrderItemDaoImpl poidi = new PurchaseOrderItemDaoImpl();
		/*
		 * add
		 */
		System.out.println("===== PurchaseOrderItem =====");
		PurchaseOrderItem po = new PurchaseOrderItem("PO006","P055",100,100);
		poidi.add(po);
		/*
		 * read
		 */
		List<PurchaseOrderItem> l;
		// selectAll test
		System.out.println("===== selectAll =====");
		l = poidi.selectAll();
		l.stream()
				.forEach((t) -> System.out.println(t.getPurchaseOrderId() + "-" + t.getProductId() + "-" + t.getQty()));

		// selectByOrderId test
		System.out.println("===== selectByOrderId =====");
		l = poidi.selectByPOrderId("PO002");
		l.stream()
				.forEach((t) -> System.out.println(t.getPurchaseOrderId() + "-" + t.getProductId() + "-" + t.getQty()));
		// selectById test
		System.out.println("===== selectByOrderItemId =====");
		l = poidi.selectByPOrderItemId(5);
		l.stream()
				.forEach((t) -> System.out.println(t.getPurchaseOrderId() + "-" + t.getProductId() + "-" + t.getQty()));
		// update
		System.out.println("===== update =====");
		PurchaseOrderItem po2 = l.get(0);
		po2.setProductId("P056");
		poidi.update(po2);
		// delete
		System.out.println("===== delete =====");
		poidi.delete(37);
	}

	@Override
	public void add(PurchaseOrderItem poi) {

		String SQL = "INSERT INTO `mems`.`purchaseOrderItems` (`purchaseOrder_id`, `product_id`,`purchasePrice`, `Qty`) "
				+ "VALUES (?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, poi.getPurchaseOrderId());
			ps.setString(2, poi.getProductId());
			ps.setInt(3, poi.getPurchasePrice());
			ps.setInt(4, poi.getQty());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<PurchaseOrderItem> selectAll() {
		List<PurchaseOrderItem> poil = new ArrayList();
		String SQL = "SELECT * FROM mems.purchaseOrderItems";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PurchaseOrderItem poi = new PurchaseOrderItem();
				poi.setPurchaseOrderItemId(rs.getInt("purchaseOrderItem_id"));
				poi.setPurchaseOrderId(rs.getString("purchaseOrder_id"));
				poi.setProductId(rs.getString("product_id"));
				poi.setPurchasePrice(rs.getInt("purchasePrice"));
				poi.setQty(rs.getInt("Qty"));

				poil.add(poi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return poil;
	}

	@Override
	public List<PurchaseOrderItem> selectByPOrderItemId(Integer poiId) {
		List<PurchaseOrderItem> poil = new ArrayList(); 
		String SQL = "SELECT * FROM mems.purchaseOrderItems WHERE purchaseOrderItem_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, poiId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PurchaseOrderItem poi = new PurchaseOrderItem();
				poi.setPurchaseOrderItemId(rs.getInt("purchaseOrderItem_id"));
				poi.setPurchaseOrderId(rs.getString("purchaseOrder_id"));
				poi.setProductId(rs.getString("product_id"));
				poi.setPurchasePrice(rs.getInt("purchasePrice"));
				poi.setQty(rs.getInt("Qty"));

				poil.add(poi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return poil;
	}

	@Override
	public List<PurchaseOrderItem> selectByPOrderId(String poId) {
		List<PurchaseOrderItem> poil = new ArrayList();
		String SQL = "SELECT * FROM mems.purchaseOrderItems WHERE purchaseOrder_id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, poId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PurchaseOrderItem poi = new PurchaseOrderItem();
				poi.setPurchaseOrderItemId(rs.getInt("purchaseOrderItem_id"));
				poi.setPurchaseOrderId(rs.getString("purchaseOrder_id"));
				poi.setProductId(rs.getString("product_id"));
				poi.setPurchasePrice(rs.getInt("purchasePrice"));
				poi.setQty(rs.getInt("Qty"));

				poil.add(poi);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return poil;
	}

	@Override
	public void update(PurchaseOrderItem poi) {
		String SQL = "UPDATE `mems`.`purchaseOrderItems` " + "SET `purchaseOrder_id` = ?, `product_id` = ?,`purchasePrice` = ?, `Qty` = ? "
				+ "WHERE (`purchaseOrderItem_id` = ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, poi.getPurchaseOrderId());
			ps.setString(2, poi.getProductId());
			ps.setInt(3, poi.getPurchasePrice());
			ps.setInt(4, poi.getQty());
			ps.setInt(5, poi.getPurchaseOrderItemId());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(Integer id) {
		String SQL = "DELETE FROM `mems`.`purchaseOrderItems` WHERE (`purchaseOrderItem_id` = ?)";
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
