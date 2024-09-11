package dao.impl.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ViewPurchaseOrderDetailDao;
import dao.impl.DbConnection;
import model.view.PurchaseOrderDetail;

public class ViewPurchaseOrderDetailDaoImpl implements ViewPurchaseOrderDetailDao {
	Connection conn = DbConnection.getDb();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<PurchaseOrderDetail> selectAll() {
		List<PurchaseOrderDetail> podl = new ArrayList();;
		String SQL ="SELECT * FROM mems.purchaseOrderDetail ORDER BY purchaseOrder_id";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				PurchaseOrderDetail pod = new PurchaseOrderDetail();
				pod.setPurchaseOrderItem_id(rs.getInt("purchaseOrderItem_id"));
				pod.setPurchaseOrder_id(rs.getString("purchaseOrder_id"));
				pod.setProduct_id(rs.getString("product_id"));
				pod.setProduct_name(rs.getString("product_name"));
				pod.setProduct_price(rs.getInt("product_price"));
				pod.setQty(rs.getInt("Qty"));
				
				podl.add(pod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		return podl;
	}

	
	@Override
	public List<PurchaseOrderDetail> selectByPurchaseOrderId(String poId) {
		List<PurchaseOrderDetail> podl = new ArrayList();
		String SQL ="SELECT * FROM mems.purchaseOrderDetail WHERE purchaseOrder_id = ? ORDER BY purchaseOrderItem_id";
//		System.out.println("selectByPurchaseOrderId::" + poId);
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, poId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				PurchaseOrderDetail pod = new PurchaseOrderDetail();
				pod.setPurchaseOrderItem_id(rs.getInt("purchaseOrderItem_id"));
//				System.out.println(rs.getInt("purchaseOrderItem_id"));
				pod.setPurchaseOrder_id(rs.getString("purchaseOrder_id"));
				pod.setProduct_id(rs.getString("product_id"));
				pod.setProduct_name(rs.getString("product_name"));
				pod.setProduct_price(rs.getInt("purchasePrice"));
				pod.setQty(rs.getInt("Qty"));
				
				podl.add(pod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		return podl;
	}

	@Override
	public List<PurchaseOrderDetail> selectById(Integer poiid) {
		List<PurchaseOrderDetail> podl = new ArrayList();;
		String SQL ="SELECT * FROM mems.purchaseOrderDetail WHERE purchaseOrderItem_id = ? ORDER BY purchaseOrderItem_id;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, poiid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				PurchaseOrderDetail pod = new PurchaseOrderDetail();
				pod.setPurchaseOrderItem_id(rs.getInt("purchaseOrderItem_id"));
				pod.setPurchaseOrder_id(rs.getString("purchaseOrder_id"));
				pod.setProduct_id(rs.getString("product_id"));
				pod.setProduct_name(rs.getString("product_name"));
				pod.setProduct_price(rs.getInt("product_price"));
				pod.setQty(rs.getInt("Qty"));
				
				podl.add(pod);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	
		return podl;
	}

}
