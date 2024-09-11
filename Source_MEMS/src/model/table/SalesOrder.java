package model.table;

import java.time.LocalDateTime;

public class SalesOrder {
	private Integer id;
	private String orderId;
	private LocalDateTime orderDate;
	private Integer employeeId;
	private String customerId;
	private Double discount = 0.0;
	public SalesOrder() {
		super();
		// TODO Auto-generated constructor stub
	} 
	public SalesOrder(String orderId, Integer employeeId) {
		super();
		this.orderId = orderId;
		this.employeeId = employeeId;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
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
	public String getCustomerId() {
		return customerId;
	}
	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}
	public Double getDiscount() {
		return discount;
	}
	public void setDiscount(Double discount) {
		this.discount = discount;
	}
	public Integer getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(Integer employeeId) {
		this.employeeId = employeeId;
	}
	
	
}
