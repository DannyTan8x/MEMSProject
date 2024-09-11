package model.view;

public class ProductsInventory {
	private String productTypeId;
	private String productTypeName;

	private String productId;
	private String productName;
	private Integer productPrice;

	private Integer purchaseAmount;
	private Integer salesAmount;
	private Integer inventoryAmount;

	public Integer getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductTypeId() {
		return productTypeId;
	}

	public void setProductTypeId(String productTypeId) {
		this.productTypeId = productTypeId;
	}

	public String getProductTypeName() {
		return productTypeName;
	}

	public void setProductTypeName(String productTypeName) {
		this.productTypeName = productTypeName;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public Integer getPurchaseAmount() {
		return purchaseAmount;
	}

	public Integer getSalesAmount() {
		return salesAmount;
	}

	public Integer getInventoryAmount() {
		return inventoryAmount;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setPurchaseAmount(Integer purchaseAmount) {
		this.purchaseAmount = purchaseAmount;
	}

	public void setSalesAmount(Integer salesAmount) {
		this.salesAmount = salesAmount;
	}

	public void setInventoryAmount(Integer inventoryAmount) {
		this.inventoryAmount = inventoryAmount;
	}

}
