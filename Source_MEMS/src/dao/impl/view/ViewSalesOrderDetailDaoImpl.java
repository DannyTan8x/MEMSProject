package dao.impl.view;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.ViewSalesOrderDetailDao;
import dao.impl.DbConnection;
import model.view.SalesOrderDetail;

public class ViewSalesOrderDetailDaoImpl implements ViewSalesOrderDetailDao  {
 
	
	Connection conn = DbConnection.getDb();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<SalesOrderDetail> selectAll() {
		List<SalesOrderDetail> podl = new ArrayList();;
		String SQL ="SELECT * FROM mems.salesorderdetail ORDER BY salesOrder_id";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				SalesOrderDetail pod = new SalesOrderDetail();
				pod.setSalesOrderItemId(rs.getInt("salesOrderItem_id"));
				pod.setSalesOrderId(rs.getString("salesOrder_id"));
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
	public List<SalesOrderDetail> selectBySalesOrderId(String soId) {
		List<SalesOrderDetail> podl = new ArrayList();
		String SQL ="SELECT * FROM mems.salesorderdetail WHERE salesOrder_id = ? ORDER BY salesOrderItem_id";
//		System.out.println("selectByPurchaseOrderId::" + poId);
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, soId);
			ResultSet rs = ps.executeQuery(); 
			
			while(rs.next()) {
				SalesOrderDetail pod = new SalesOrderDetail();
				pod.setSalesOrderItemId(rs.getInt("salesOrderItem_id"));
				pod.setSalesOrderId(rs.getString("salesOrder_id"));
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
	public List<SalesOrderDetail> selectById(Integer soiid) {
		List<SalesOrderDetail> podl = new ArrayList();;
		String SQL ="SELECT * FROM mems.salesorderdetail WHERE salesOrderItem_id = ? ORDER BY salesOrder_id;";
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setInt(1, soiid);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				SalesOrderDetail pod = new SalesOrderDetail();
				pod.setSalesOrderItemId(rs.getInt("salesOrderItem_id"));
				pod.setSalesOrderId(rs.getString("salesOrder_id"));
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
	public Integer getSumOfOrder(String soId) {
		String SQL = "SELECT  sum(`Qty` * `product_price`) as sum FROM mems.salesorderdetail WHERE salesorder_id = ?;";
		Integer Sum = 0;
		
		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.setString(1, soId);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Sum = rs.getInt("sum");
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return Sum;
	}


}
