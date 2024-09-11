package dao.impl.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.PurchaseOrderDao;
import dao.impl.DbConnection;
import model.table.ProductType;
import model.table.PurchaseOrder;

public class PurchaseOrderDaoImpl implements PurchaseOrderDao {
	Connection conn = DbConnection.getDb();

	public static void main(String[] args) {
		PurchaseOrderDaoImpl podi = new PurchaseOrderDaoImpl();
		// TODO Auto-generated method stub
		/*
		 * add
		 */
		System.out.println("===== PurchaseOrder =====");
		PurchaseOrder pt = new PurchaseOrder("PO013");
		podi.add(pt);
		/*
		 * read
		 */
		List<PurchaseOrder> l;
		// selectAll test
		System.out.println("===== selectAll =====");
		l = podi.selectAll();
		l.stream().forEach((t) -> System.out.println(t.getPurchaseOrderId() + "-" + t.getPurchaseOrderDate()));
		// selectById test
		System.out.println("===== selectById =====");
		l = podi.selectById(2);
		l.stream().forEach((t) -> System.out.println(t.getPurchaseOrderId() + "-" + t.getPurchaseOrderDate()));
		// selectByPOId test
		System.out.println("===== selectByPOId =====");
		l = podi.selectByPOId("PO003");
		l.stream().forEach((t) -> System.out.println(t.getPurchaseOrderId() + "-" + t.getPurchaseOrderDate()));
		// update
		System.out.println("===== update =====");
		PurchaseOrder pt2 = l.get(0);
		pt2.setPurchaseOrderDate(LocalDateTime.now());
		podi.update(pt2);
		// delete
		System.out.println("===== delete =====");
		podi.delete("PO013");

	}

	@Override
	public void add(PurchaseOrder po) {
		String SQL = "INSERT INTO `mems`.`purchaseOrders` (`purchaseOrder_id`) VALUES (?)";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, po.getPurchaseOrderId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public List<PurchaseOrder> selectAll() {
		List<PurchaseOrder> pol = new ArrayList();
		String SQL = "SELECT * FROM mems.purchaseorders ORDER BY purchaseOrder_id";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PurchaseOrder po = new PurchaseOrder();
				LocalDateTime dateTime = null;
				po.setId(rs.getInt("id"));
				po.setPurchaseOrderId(rs.getString("purchaseOrder_id"));
				Timestamp timestamp = rs.getTimestamp("purchaseOrder_date");
				if (timestamp != null) {
					dateTime = timestamp.toLocalDateTime(); // Convert Timestamp to LocalDateTime
				}
				po.setPurchaseOrderDate(dateTime);

				pol.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pol;

	}

	@Override
	public List<PurchaseOrder> selectById(Integer id) {
		List<PurchaseOrder> pol = new ArrayList();
		String SQL = "SELECT * FROM mems.purchaseOrders where id = ? ORDER BY purchaseOrder_id";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PurchaseOrder po = new PurchaseOrder();
				LocalDateTime dateTime = null;
				po.setId(rs.getInt("id"));
				po.setPurchaseOrderId(rs.getString("purchaseOrder_id"));
				Timestamp timestamp = rs.getTimestamp("purchaseOrder_date");
				if (timestamp != null) {
					dateTime = timestamp.toLocalDateTime(); // Convert Timestamp to LocalDateTime
				}
				po.setPurchaseOrderDate(dateTime);

				pol.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pol;
	}

	@Override
	public List<PurchaseOrder> selectByPOId(String poId) {
		List<PurchaseOrder> pol = new ArrayList();
		String SQL = "SELECT * FROM mems.purchaseOrders where purchaseOrder_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, poId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				PurchaseOrder po = new PurchaseOrder();
				LocalDateTime dateTime = null;
				po.setId(rs.getInt("id"));
				po.setPurchaseOrderId(rs.getString("purchaseOrder_id"));
				Timestamp timestamp = rs.getTimestamp("purchaseOrder_date");
				if (timestamp != null) {
					dateTime = timestamp.toLocalDateTime(); // Convert Timestamp to LocalDateTime
				}
				po.setPurchaseOrderDate(dateTime);

				pol.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pol;
	}

	@Override
	public void update(PurchaseOrder po) {
		String SQL = "UPDATE `mems`.`purchaseOrders` SET `purchaseOrder_date` = ? WHERE  (`purchaseOrder_id` = ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setTimestamp(1, Timestamp.valueOf(po.getPurchaseOrderDate()));
			ps.setString(2, po.getPurchaseOrderId());
			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		}

	}

	@Override
	public void delete(String poId) {
		String SQL = "DELETE FROM `mems`.`purchaseOrders` WHERE  (`purchaseOrder_id` = ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, poId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
