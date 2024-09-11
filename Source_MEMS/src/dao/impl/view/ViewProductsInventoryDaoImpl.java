package dao.impl.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ViewProductsInventoryDao;
import dao.impl.DbConnection;
import model.view.ProductsInventory;

public class ViewProductsInventoryDaoImpl implements ViewProductsInventoryDao {
	Connection conn = DbConnection.getDb();

	public static void main(String[] args) {
		ViewProductsInventoryDaoImpl vpidi = new ViewProductsInventoryDaoImpl();

		List<ProductsInventory> pil = new ArrayList();
		// selectAll test
		System.out.println(" ====== selectAll =======");
		pil = vpidi.selectAll();
		pil.stream().forEach(
				(t) -> System.out.println(t.getProductId() + "-" + t.getProductName() + "-" + t.getInventoryAmount()));
		// selectAselectByInventoryAmountGreaterThanGivenNumberll test
		System.out.println(" ====== selectByInventoryAmountGreaterThanGivenNumber =======");
		pil = vpidi.selectByInventoryAmountGreaterThanGivenNumber(10);
		pil.stream().forEach(
				(t) -> System.out.println(t.getProductId() + "-" + t.getProductName() + "-" + t.getInventoryAmount()));
		// selectByproductName test
		System.out.println(" ====== selectByproductName =======");
		pil = vpidi.selectByproductName("電");
		pil.stream().forEach(
				(t) -> System.out.println(t.getProductId() + "-" + t.getProductName() + "-" + t.getInventoryAmount()));
		// selectBykeywordAndInventry test
		System.out.println(" ====== selectBykeywordAndInventry =======");
		pil = vpidi.selectBykeywordAndInventry("電", 10);
		pil.stream().forEach(
				(t) -> System.out.println(t.getProductId() + "-" + t.getProductName() + "-" + t.getInventoryAmount()));

	}

	@Override
	public List<ProductsInventory> selectAll() {
		List<ProductsInventory> pil = new ArrayList();
		String SQL = "SELECT * FROM mems.product_inventory";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductsInventory ei = new ProductsInventory();
				ei.setProductTypeId(rs.getString("productType_id"));
				ei.setProductTypeName(rs.getString("productType_name"));
				ei.setProductId(rs.getString("product_id"));
				ei.setProductName(rs.getString("product_name"));
				ei.setProductPrice(rs.getInt("product_price"));
				ei.setPurchaseAmount(rs.getInt("purchaseAmount"));
				ei.setSalesAmount(rs.getInt("salesAmount"));
				ei.setInventoryAmount(rs.getInt("inventoryAmount"));

				pil.add(ei);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pil;
	}

	@Override
	public List<ProductsInventory> selectByInventoryAmountGreaterThanGivenNumber(Integer number) {
		List<ProductsInventory> pil = new ArrayList();
		String SQL = "SELECT * FROM mems.product_inventory WHERE inventoryAmount >= ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, number);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductsInventory ei = new ProductsInventory();
				ei.setProductTypeId(rs.getString("productType_id"));
				ei.setProductTypeName(rs.getString("productType_name"));
				ei.setProductId(rs.getString("product_id"));
				ei.setProductName(rs.getString("product_name"));
				ei.setProductPrice(rs.getInt("product_price"));
				ei.setPurchaseAmount(rs.getInt("purchaseAmount"));
				ei.setSalesAmount(rs.getInt("salesAmount"));
				ei.setInventoryAmount(rs.getInt("inventoryAmount"));

				pil.add(ei);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pil;
	}

	@Override
	public List<ProductsInventory> selectByproductName(String productName) {
		List<ProductsInventory> pil = new ArrayList();
		String SQL = "SELECT * FROM mems.product_inventory WHERE product_name like ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + productName + "%");
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductsInventory ei = new ProductsInventory();
				ei.setProductTypeId(rs.getString("productType_id"));
				ei.setProductTypeName(rs.getString("productType_name"));
				ei.setProductId(rs.getString("product_id"));
				ei.setProductName(rs.getString("product_name"));
				ei.setProductPrice(rs.getInt("product_price"));
				ei.setPurchaseAmount(rs.getInt("purchaseAmount"));
				ei.setSalesAmount(rs.getInt("salesAmount"));
				ei.setInventoryAmount(rs.getInt("inventoryAmount"));

				pil.add(ei);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pil;
	}

	@Override
	public List<ProductsInventory> selectBykeywordAndInventry(String keyword, Integer number) {
		List<ProductsInventory> pil = new ArrayList();
		String SQL = "SELECT * FROM mems.product_inventory WHERE concat(product_name, productType_name) like ? and inventoryAmount  <= ?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + keyword + "%");
			ps.setInt(2, number);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductsInventory ei = new ProductsInventory();
				ei.setProductTypeId(rs.getString("productType_id"));
				ei.setProductTypeName(rs.getString("productType_name"));
				ei.setProductId(rs.getString("product_id"));
				ei.setProductName(rs.getString("product_name"));
				ei.setProductPrice(rs.getInt("product_price"));
				ei.setPurchaseAmount(rs.getInt("purchaseAmount"));
				ei.setSalesAmount(rs.getInt("salesAmount"));
				ei.setInventoryAmount(rs.getInt("inventoryAmount"));

				pil.add(ei);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pil;
	}

	@Override
	public List<ProductsInventory> selectByproductId(String productId) {
		List<ProductsInventory> pil = new ArrayList();
		String SQL = "SELECT * FROM mems.product_inventory WHERE product_id = ?;";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, productId);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductsInventory ei = new ProductsInventory();
				ei.setProductTypeId(rs.getString("productType_id"));
				ei.setProductTypeName(rs.getString("productType_name"));
				ei.setProductId(rs.getString("product_id"));
				ei.setProductName(rs.getString("product_name"));
				ei.setProductPrice(rs.getInt("product_price"));
				ei.setPurchaseAmount(rs.getInt("purchaseAmount"));
				ei.setSalesAmount(rs.getInt("salesAmount"));
				ei.setInventoryAmount(rs.getInt("inventoryAmount"));

				pil.add(ei);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pil;
	}

	@Override
	public List<ProductsInventory> selectBykeywordAndInventryForSales(String keyword, Integer number) {
		List<ProductsInventory> pil = new ArrayList();
		String SQL = "SELECT * FROM mems.product_inventory WHERE concat(product_name, productType_name) like ? and inventoryAmount  >= ?";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, "%" + keyword + "%");
			ps.setInt(2, number);
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				ProductsInventory ei = new ProductsInventory();
				ei.setProductTypeId(rs.getString("productType_id"));
				ei.setProductTypeName(rs.getString("productType_name"));
				ei.setProductId(rs.getString("product_id"));
				ei.setProductName(rs.getString("product_name"));
				ei.setProductPrice(rs.getInt("product_price"));
				ei.setPurchaseAmount(rs.getInt("purchaseAmount"));
				ei.setSalesAmount(rs.getInt("salesAmount"));
				ei.setInventoryAmount(rs.getInt("inventoryAmount"));

				pil.add(ei);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pil;
	}
}
