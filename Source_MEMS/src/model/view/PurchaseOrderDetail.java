package model.view;

public class PurchaseOrderDetail {
	Integer purchaseOrderItem_id;
    String purchaseOrder_id;
    String product_id;
    String product_name;
    Integer product_price;
    Integer Qty;
    Integer total;
    
	public PurchaseOrderDetail() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Integer getPurchaseOrderItem_id() {
		return purchaseOrderItem_id;
	}
	public void setPurchaseOrderItem_id(Integer purchaseOrderItem_id) {
		this.purchaseOrderItem_id = purchaseOrderItem_id;
	}
	public String getPurchaseOrder_id() {
		return purchaseOrder_id;
	}
	public void setPurchaseOrder_id(String purchaseOrder_id) {
		this.purchaseOrder_id = purchaseOrder_id;
	}
	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public Integer getProduct_price() {
		return product_price;
	}
	public void setProduct_price(Integer product_price) {
		this.product_price = product_price;
	}
	public Integer getQty() {
		return Qty;
	}
	public void setQty(Integer qty) {
		Qty = qty;
	}
	public Integer getTotal() {
		this.total = this.product_price * this.Qty;
		return total;
	}
	
	
    

}
