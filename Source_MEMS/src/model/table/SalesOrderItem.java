package model.table;

public class SalesOrderItem {
	private Integer orderItemId;
	private String orderId;
	private String productId;
	private Integer Qty;
	public SalesOrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SalesOrderItem(String orderId, String productId, Integer qty) {
		super();
		this.orderId = orderId;
		this.productId = productId;
		Qty = qty;
	}
	public Integer getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(Integer orderItemId) {
		this.orderItemId = orderItemId;
	}
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public Integer getQty() {
		return Qty;
	}
	public void setQty(Integer qty) {
		Qty = qty;
	}
	
}
