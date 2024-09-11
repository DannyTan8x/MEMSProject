package model.table;

public class Customer {
	private Integer id;
	private String customerId;
	private String customerName;
	private String address;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Customer(String customerId, String customerName, String address) {
		super();
		this.customerId = customerId;
		this.customerName = customerName;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCustomerId() {
		return customerId;
	}

	public void setCustomerId(String customerId) {
		this.customerId = customerId;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
}
