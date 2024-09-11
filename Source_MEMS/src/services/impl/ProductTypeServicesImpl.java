package services.impl;

import java.util.List;

import javax.swing.JOptionPane;

import dao.impl.table.ProductTypeDaoImpl;
import model.table.ProductType;
import services.ProductTypeServices;

public class ProductTypeServicesImpl implements ProductTypeServices{
	ProductTypeDaoImpl ptdi = new ProductTypeDaoImpl();
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void add(String ptId, String ptName) {
		ProductType pt = new ProductType(ptId,ptName);
		if(ptdi.selectByName(ptName)!=null) {
			ptdi.add(pt);
		}else {
			JOptionPane.showMessageDialog(null, "產品類別名稱不能重複", "Information", JOptionPane.INFORMATION_MESSAGE);
		}
	}

	@Override
	public List<ProductType> selectAll() {
		List<ProductType> proList;
		proList = ptdi.selectAll();
		return proList;
	}

	@Override
	public ProductType selectById(String ptId) {
		ProductType pt = null;
		try {
			pt =ptdi.selectById(ptId).get(0);
		} catch(IndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(null, "產品類別不存在！", "Information", JOptionPane.INFORMATION_MESSAGE);
			e1.printStackTrace();
		}
		return pt;
	}

	@Override
	public ProductType selectByTypeName(String ptName) {
		ProductType pt = null;
		try {
			pt =ptdi.selectByName(ptName).get(0);
		} catch(IndexOutOfBoundsException e1) {
			JOptionPane.showMessageDialog(null, "產品類別不存在！", "Information", JOptionPane.INFORMATION_MESSAGE);
			e1.printStackTrace();
		}
		return pt;
	}

	@Override
	public void update(ProductType pt) {
		ptdi.update(pt);
		
	}

	@Override
	public void delete(String ptId) {
		ptdi.delete(ptId);
		
	}

}
