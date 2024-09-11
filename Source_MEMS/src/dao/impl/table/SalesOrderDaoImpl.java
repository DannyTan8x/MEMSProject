package dao.impl.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import dao.SalesOrderDao;
import dao.impl.DbConnection;
import model.table.PurchaseOrder;
import model.table.SalesOrder;

public class SalesOrderDaoImpl implements SalesOrderDao {
	Connection conn = DbConnection.getDb();

	public static void main(String[] args) {
		SalesOrderDaoImpl sodi = new SalesOrderDaoImpl();
		// TODO Auto-generated method stub

		/*
		 * read
		 */
		List<SalesOrder> l;
		// selectAll test
		System.out.println("===== selectAll =====");
		l = sodi.selectAll();
		l.stream().forEach((t) -> System.out.println(t.getOrderId() + "-" + t.getOrderDate() + "-" + t.getDiscount()));
		// selectById test
		System.out.println("===== selectById =====");
		l = sodi.selectById(3);
		l.stream().forEach((t) -> System.out.println(t.getOrderId() + "-" + t.getOrderDate() + "-" + t.getDiscount()));
		// selectAll test
		System.out.println("===== selectBySOId =====");
		l = sodi.selectBySOId("SO004");
		l.stream().forEach((t) -> System.out.println(t.getOrderId() + "-" + t.getOrderDate() + "-" + t.getDiscount()));
		// update
		SalesOrder s1 = l.get(5);
		s1.setEmployeeId(5);
		s1.setOrderDate(LocalDateTime.now());
		s1.setDiscount(5.0);
		sodi.update(s1);
		
	}

	@Override
	public void add(SalesOrder so) {
		String SQL = "INSERT INTO `mems`.`salesOrders` (`order_id`, `employee_id`, `customer_id`, `discount`) "
				+ "VALUES (?, ?, ?, ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, so.getOrderId());
			ps.setInt(2, so.getEmployeeId());
			ps.setString(3, so.getCustomerId());
			ps.setDouble(4, so.getDiscount());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<SalesOrder> selectAll() {
		List<SalesOrder> sol = new ArrayList();
		String SQL = "SELECT * FROM mems.salesOrders ORDER BY order_id";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SalesOrder po = new SalesOrder();
				LocalDateTime dateTime = null;
				po.setId(rs.getInt("id"));
				po.setOrderId(rs.getString("order_id"));

				Timestamp timestamp = rs.getTimestamp("order_date");
				if (timestamp != null) {
					dateTime = timestamp.toLocalDateTime(); // Convert Timestamp to LocalDateTime
				}
				po.setOrderDate(dateTime);
				po.setEmployeeId(rs.getInt("employee_id"));
				po.setCustomerId(rs.getString("customer_id"));
				po.setDiscount(rs.getDouble("discount"));

				sol.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sol;
	}

	@Override
	public List<SalesOrder> selectById(Integer id) {
		List<SalesOrder> sol = new ArrayList();
		String SQL = "SELECT * FROM mems.salesOrders WHERE id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SalesOrder po = new SalesOrder();
				LocalDateTime dateTime = null;
				po.setId(rs.getInt("id"));
				po.setOrderId(rs.getString("order_id"));

				Timestamp timestamp = rs.getTimestamp("order_date");
				if (timestamp != null) {
					dateTime = timestamp.toLocalDateTime(); // Convert Timestamp to LocalDateTime
				}
				po.setOrderDate(dateTime);
				po.setEmployeeId(rs.getInt("employee_id"));
				po.setCustomerId(rs.getString("customer_id"));
				po.setDiscount(rs.getDouble("discount"));

				sol.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sol;
	}

	@Override
	public List<SalesOrder> selectBySOId(String SOId) {
		List<SalesOrder> sol = new ArrayList();
		String SQL = "SELECT * FROM mems.salesOrders WHERE order_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, SOId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				SalesOrder po = new SalesOrder();
				LocalDateTime dateTime = null;
				po.setId(rs.getInt("id"));
				po.setOrderId(rs.getString("order_id"));

				Timestamp timestamp = rs.getTimestamp("order_date");
				if (timestamp != null) {
					dateTime = timestamp.toLocalDateTime(); // Convert Timestamp to LocalDateTime
				}
				po.setOrderDate(dateTime);
				po.setEmployeeId(rs.getInt("employee_id"));
				po.setCustomerId(rs.getString("customer_id"));
				po.setDiscount(rs.getDouble("discount"));

				sol.add(po);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sol;
	}

	@Override
	public void update(SalesOrder so) {
		String SQL = "UPDATE `mems`.`salesOrders` SET `order_id` = ?, `employee_id` = ?, `customer_id` = ?, `discount` = ? "
				+ "WHERE (`id` = ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, so.getOrderId());
			ps.setInt(2, so.getEmployeeId());
			ps.setString(3, so.getCustomerId());
			ps.setDouble(4, so.getDiscount());
			ps.setInt(5, so.getId());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void delete(String SoId) {
		String SQL ="DELETE FROM `mems`.`salesOrders` WHERE  (`order_id` = 'SO011')";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, SoId);
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
