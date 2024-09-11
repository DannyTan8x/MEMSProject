package services.impl;

import java.util.List;

import javax.swing.JOptionPane;

import dao.impl.table.ProductDaoImpl;
import model.table.Product;
import model.table.ProductType;
import services.ProductService;

public class ProductServiceImpl implements ProductService{
	ProductDaoImpl pdi = new ProductDaoImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(String pId, String ptId, String pName, Integer price, String description ) {
		Product p = new Product(pId,ptId,pName,price,description);
		if(pdi.selectByName(pName)!=null) {
			pdi.add(p);
		}else {
			JOptionPane.showMessageDialog(null, "產品名稱不能重複", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public List<Product> selectAll() {
		List<Product> proList;
		proList = pdi.selectAll();
		return proList;
	}

	@Override
	public void update(Product p) {
		// TODO Auto-generated method stub
		pdi.update(p);
	}

	@Override
	public void delete(String pId) {
		// TODO Auto-generated method stub
		pdi.delete(pId);
	}

	@Override
	public Product selectById(String pId) {
		Product p = pdi.selectByProId(pId).get(0);
		return p;
	}

}
