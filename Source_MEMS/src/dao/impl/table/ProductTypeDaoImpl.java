package dao.impl.table;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ProductTypeDao;
import dao.impl.DbConnection;
import model.table.Product;
import model.table.ProductType;

public class ProductTypeDaoImpl implements ProductTypeDao {
	Connection conn = DbConnection.getDb();

	public static void main(String[] args) {
		ProductTypeDaoImpl ptdi = new ProductTypeDaoImpl();
		/*
		 * add
		 */
		System.out.println("===== addProduct =====");
		ProductType pt = new ProductType("PT11", "自我描述");
		ptdi.add(pt);
		/*
		 * read
		 */
		List<ProductType> l;
		// selectAll test
		System.out.println("===== selectAll =====");
		l = ptdi.selectAll();
		l.stream()
				.forEach((t) -> System.out.println(t.getProductTypeId() + "-" + t.getProductTypeName()));
		// selectById test
		System.out.println("===== selectById =====");
		l = ptdi.selectById("PT02");
		l.stream()
		.forEach((t) -> System.out.println(t.getProductTypeId() + "-" + t.getProductTypeName()));
		// selectByName test
		System.out.println("===== selectByName =====");
		l = ptdi.selectByName("具");
		l.stream()
		.forEach((t) -> System.out.println(t.getProductTypeId() + "-" + t.getProductTypeName()));
		// update
		System.out.println("===== update =====");
		ProductType pt1 = l.get(0);
		pt1.setProductTypeName("爛東西");
		ptdi.update(pt1);
		//delete
		System.out.println("===== delete =====");
		ptdi.delete("PT11");

	}

	@Override
	public void add(ProductType pt) {
		// ;
		String SQL = "INSERT INTO `mems`.`productTypes` (`productType_id`, `productType_name`) VALUES (?, ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);

			ps.setString(1, pt.getProductTypeId());
			ps.setString(2, pt.getProductTypeName());

			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		}

	}

	@Override
	public List<ProductType> selectAll() {
		List<ProductType> ptl = new ArrayList();
		String SQL = "SELECT * FROM mems.productTypes ORDER BY productType_id";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductType pt = new ProductType();
				pt.setId(rs.getInt("id"));
				pt.setProductTypeId(rs.getString("productType_id"));
				pt.setProductTypeName(rs.getString("productType_name"));

				ptl.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ptl;
	}

	@Override
	public List<ProductType> selectById(String ptId) {
		List<ProductType> ptl = new ArrayList();
		String SQL = "SELECT * FROM mems.productTypes where productType_id = ?";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, ptId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductType pt = new ProductType();
				pt.setId(rs.getInt("id"));
				pt.setProductTypeId(rs.getString("productType_id"));
				pt.setProductTypeName(rs.getString("productType_name"));

				ptl.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ptl;
	}

	@Override
	public List<ProductType> selectByName(String ptName) {
		List<ProductType> ptl = new ArrayList();
		String SQL = "SELECT * FROM mems.productTypes where productType_name like ?";

		try {

			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + ptName +"%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductType pt = new ProductType();
				pt.setId(rs.getInt("id"));
				pt.setProductTypeId(rs.getString("productType_id"));
				pt.setProductTypeName(rs.getString("productType_name"));

				ptl.add(pt);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return ptl;
	}

	@Override
	public void update(ProductType pt) {
		String SQL = "UPDATE `mems`.`productTypes` SET `productType_name` = ? WHERE (`productType_id` = ?)";
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, pt.getProductTypeName());
			ps.setString(2, pt.getProductTypeId());

			ps.executeUpdate();

		} catch (SQLException e1) {
			// TODO Auto-generated catch block

			e1.printStackTrace();
		}
	}

	@Override
	public void delete(String ptId) {
		// ;
		String SQL = "DELETE FROM `mems`.`productTypes` WHERE (`productType_id` = ?)";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, ptId);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
