package model.table;

public class ProductType {
	private Integer id;
	private String productTypeId;
	private String productTypeName;
	public ProductType() {
		super();
	}
	public ProductType(String productTypeId, String productTypeName) {
		super();
		this.productTypeId = productTypeId;
		this.productTypeName = productTypeName;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
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
}
	

