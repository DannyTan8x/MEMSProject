package dao.impl.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductDao;
import dao.impl.DbConnection;
import model.table.Employee;
import model.table.Product;

public class ProductDaoImpl implements ProductDao {
	Connection conn = DbConnection.getDb();

	public static void main(String[] args) {
		ProductDaoImpl pdi = new ProductDaoImpl();
		/*
		 * add
		 */
		System.out.println("===== addProduct =====");
		Product p = new Product("P061", "PT10", "打雜", 110, "自我描述");
		pdi.add(p);
		/*
		 * read
		 */
		List<Product> l;
		// selectAll test
		System.out.println("===== selectAll =====");
		l = pdi.selectAll();
		l.stream()
				.forEach((t) -> System.out.println(t.getProductName() + "-" + t.getProductPrice() + "-" + t.getProductId()));
		// selectById test
		System.out.println("===== selectById =====");
		l = pdi.selectById(4);
		l.stream()
		.forEach((t) -> System.out.println(t.getProductName() + "-" + t.getProductPrice() + "-" + t.getProductId()));
		// selectByName test
		System.out.println("===== selectByName =====");
		l = pdi.selectByName("水");
		l.stream()
		.forEach((t) -> System.out.println(t.getProductName() + "-" + t.getProductPrice() + "-" + t.getProductId()));
		// update
		System.out.println("===== update =====");
		Product e1 = l.get(0);
		e1.setProductName("爛東西");
		pdi.update(e1);
		//delete
		System.out.println("===== delete =====");
		pdi.delete("P061");

	}

	@Override
	public void add(Product p) {
		String SQL = "INSERT INTO `mems`.`products` "
				+ "(`product_id`, `productType_id`, `product_name`, `product_price`, `product_description`) "
				+ "VALUES (?, ?, ?, ?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, p.getProductId());
			ps.setString(2, p.getProductTypeId());
			ps.setString(3, p.getProductName());
			ps.setInt(4, p.getProductPrice());
			ps.setString(5, p.getProductDescription());
			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		}

	}

	@Override
	public List<Product> selectAll() {
		List<Product> pl = new ArrayList();
		String SQL = "SELECT * FROM mems.products ORDER BY product_id";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setProductId(rs.getString("product_id"));
				p.setProductTypeId(rs.getString("productType_id"));
				p.setProductName(rs.getString("product_name"));
				p.setProductPrice(rs.getInt("product_price"));
				p.setProductDescription(rs.getString("product_description"));

				pl.add(p);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return pl;
	}

	@Override
	public List<Product> selectById(Integer id) {
		List<Product> pl = new ArrayList();
		String SQL = "SELECT * FROM mems.products where id=?";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, id);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setProductId(rs.getString("product_id"));
				p.setProductTypeId(rs.getString("productType_id"));
				p.setProductName(rs.getString("product_name"));
				p.setProductPrice(rs.getInt("product_price"));
				p.setProductDescription(rs.getString("product_description"));

				pl.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pl;
	}

	@Override
	public List<Product> selectByName(String pName) {
		List<Product> pl = new ArrayList();
		String SQL = "SELECT * FROM mems.products where concat(product_name,product_description) like ?";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + pName + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setProductId(rs.getString("product_id"));
				p.setProductTypeId(rs.getString("productType_id"));
				p.setProductName(rs.getString("product_name"));
				p.setProductPrice(rs.getInt("product_price"));
				p.setProductDescription(rs.getString("product_description"));

				pl.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pl;
	}

	@Override
	public void update(Product p) {

		String SQL = "UPDATE `mems`.`products` SET `productType_id` = ?, "
				+ "`product_name` = ?, `product_price` = ? WHERE (`product_id` = ?)";
		PreparedStatement ps;
		try {

			ps = conn.prepareStatement(SQL);
			
			ps.setString(1, p.getProductTypeId());
			ps.setString(2, p.getProductName());
			ps.setInt(3, p.getProductPrice());
			ps.setString(4, p.getProductDescription());
			ps.executeUpdate();

		} catch (SQLException e1) {
			e1.printStackTrace();
		}

	}

	@Override
	public void delete(String pId) {
		//;
		String SQL = "DELETE FROM `mems`.`products` WHERE (`product_id` = ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, pId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<Product> selectByProId(String pid) {
		List<Product> pl = new ArrayList();
		String SQL = "SELECT * FROM mems.products where product_id=?";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, pid);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				Product p = new Product();
				p.setId(rs.getInt("id"));
				p.setProductId(rs.getString("product_id"));
				p.setProductTypeId(rs.getString("productType_id"));
				p.setProductName(rs.getString("product_name"));
				p.setProductPrice(rs.getInt("product_price"));
				p.setProductDescription(rs.getString("product_description"));

				pl.add(p);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pl;
	}

}
