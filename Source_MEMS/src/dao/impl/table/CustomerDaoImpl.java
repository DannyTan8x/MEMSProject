package dao.impl.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.CustomerDao;
import dao.impl.DbConnection;
import model.table.Customer;

public class CustomerDaoImpl implements CustomerDao {
	Connection conn = DbConnection.getDb();

	public static void main(String[] args) {
		CustomerDaoImpl cdi = new CustomerDaoImpl();
		/*
		 * add
		 */
		System.out.println("===== addCustomer =====");
		Customer c = new Customer("C012", "java客戶", "伺服器");
		cdi.add(c);
		/*
		 * read
		 */
		List<Customer> l;
		// selectAll test
		System.out.println("===== selectAll =====");
		l = cdi.selectAll();
		l.stream().forEach((t) -> System.out.println(t.getCustomerName() + "-"));
		// selectById test
		System.out.println("===== selectById =====");
		l = cdi.selectById(11);
		l.stream().forEach((t) -> System.out.println(t.getCustomerName() + "-"));
		// selectByName test
		System.out.println("===== selectByName =====");
		l = cdi.selectByName("java客戶");
		l.stream().forEach((t) -> System.out.println(t.getCustomerName() + "-"));
		/*
		 * update
		 */
		System.out.println("===== updateCustomer =====");
		Customer c1 = new Customer("C012", "java客戶1", "伺服器1");
		cdi.update(c1);
		/*
		 * delete
		 */
		System.out.println("===== deleteCustomer =====");
		cdi.delete("C012");
	}

	@Override
	public void add(Customer c) {
		String SQL = "INSERT INTO `mems`.`customers` (`customer_id`, `customer_name`, `address`) " + "VALUES (?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, c.getCustomerId());
			ps.setString(2, c.getCustomerName());
			ps.setString(3, c.getAddress());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Customer> selectAll() {
		List<Customer> cl = new ArrayList();
		String SQL = "SELECT * FROM mems.customers";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("id"));
				c.setCustomerId(rs.getString("customer_id"));
				c.setCustomerName(rs.getString("customer_name"));
				c.setAddress(rs.getString("address"));
				cl.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cl;
	}

	@Override
	public List<Customer> selectById(Integer id) {
		List<Customer> cl = new ArrayList();
		String SQL = "SELECT * FROM mems.customers where id = ?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("id"));
				c.setCustomerId(rs.getString("customer_id"));
				c.setCustomerName(rs.getString("customer_name"));
				c.setAddress(rs.getString("address"));
				cl.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cl;
	}

	@Override
	public List<Customer> selectByName(String cName) {
		List<Customer> cl = new ArrayList();
		String SQL = "SELECT * FROM mems.customers where customer_name =?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, cName);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Customer c = new Customer();
				c.setId(rs.getInt("id"));
				c.setCustomerId(rs.getString("customer_id"));
				c.setCustomerName(rs.getString("customer_name"));
				c.setAddress(rs.getString("address"));
				cl.add(c);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return cl;
	}

	@Override
	public void update(Customer c) {
		String SQL = "UPDATE `mems`.`customers` "
				+ "SET `customer_name` = ?, `address` = ? "
				+ "WHERE (`customer_id` = ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, c.getCustomerName());
			ps.setString(2, c.getAddress());
			ps.setString(3,c.getCustomerId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void delete(String Cid) {
		String SQL = "DELETE FROM `mems`.`customers` "
				+ "WHERE (`customer_id` = ?);";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, Cid);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
