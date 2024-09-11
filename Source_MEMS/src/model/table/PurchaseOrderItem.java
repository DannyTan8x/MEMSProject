package model.table;

public class PurchaseOrderItem {
	private Integer purchaseOrderItemId;
	private String purchaseOrderId;
	private String productId;
	private Integer Qty;
	private Integer purchasePrice;
	public PurchaseOrderItem() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseOrderItem(String purchaseOrderId, String productId, Integer purchasePrice, Integer qty) {
		super();
		this.purchaseOrderId = purchaseOrderId;
		this.productId = productId;
		this.purchasePrice = purchasePrice;
		this.Qty = qty;
	}
	public Integer getPurchaseOrderItemId() {
		return purchaseOrderItemId;
	}
	public void setPurchaseOrderItemId(Integer purchaseOrderItemId) {
		this.purchaseOrderItemId = purchaseOrderItemId;
	}
	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
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
	public Integer getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(Integer purchasePrice) {
		this.purchasePrice = purchasePrice;
	}
	
	
}

