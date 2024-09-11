package model.view;

import java.time.LocalDateTime;

public class OrderForPrint {
	private String orderId;
	private LocalDateTime orderDate;
	private String emFirstName;
	private String emLastName;
	private String cusName;
	private String cusAddress;
	private String productName;
	private Integer qty;
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public LocalDateTime getOrderDate() {
		return orderDate;
	}
	public void setOrderDate(LocalDateTime orderDate) {
		this.orderDate = orderDate;
	}
	public String getEmFirstName() {
		return emFirstName;
	}
	public void setEmFirstName(String emFirstName) {
		this.emFirstName = emFirstName;
	}
	public String getEmLastName() {
		return emLastName;
	}
	public void setEmLastName(String emLastName) {
		this.emLastName = emLastName;
	}
	public String getCusName() {
		return cusName;
	}
	public void setCusName(String cusName) {
		this.cusName = cusName;
	}
	public String getCusAddress() {
		return cusAddress;
	}
	public void setCusAddress(String cusAddress) {
		this.cusAddress = cusAddress;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	
}
