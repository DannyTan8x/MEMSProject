package model.table;

public class Product {

	private Integer id;
	private String productId;
	private String productTypeId;
	private String productName;
	private Integer productPrice;
	private String productDescription;
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(String productId, String productTypeId, String productName, Integer productPrice,
			String productDescription) {
		super();
		this.productId = productId;
		this.productTypeId = productTypeId;
		this.productName = productName;
		this.productPrice = productPrice;
		this.productDescription = productDescription;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getProductTypeId() {
		return productTypeId;
	}
	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public Integer getProductPrice() {
		return productPrice;
	}
	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}
	public String getProductDescription() {
		return productDescription;
	}
	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	
}
