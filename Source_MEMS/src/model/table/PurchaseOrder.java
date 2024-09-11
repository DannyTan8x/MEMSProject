package model.table;

import java.time.LocalDateTime;

public class PurchaseOrder {
	private Integer id;
	private String purchaseOrderId;
	private LocalDateTime purchaseOrderDate ;
	public PurchaseOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	public PurchaseOrder(String purchaseOrderId) {
		super();
		this.purchaseOrderId = purchaseOrderId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getPurchaseOrderId() {
		return purchaseOrderId;
	}
	public void setPurchaseOrderId(String purchaseOrderId) {
		this.purchaseOrderId = purchaseOrderId;
	}
	public LocalDateTime getPurchaseOrderDate() {
		return purchaseOrderDate;
	}
	public void setPurchaseOrderDate(LocalDateTime purchaseOrderDate) {
		this.purchaseOrderDate = purchaseOrderDate;
	}
	
	
}
