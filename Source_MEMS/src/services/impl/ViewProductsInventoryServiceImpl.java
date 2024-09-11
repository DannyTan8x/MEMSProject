package services.impl;

import java.util.ArrayList;
import java.util.List;

import dao.impl.view.ViewProductsInventoryDaoImpl;
import model.view.ProductsInventory;
import services.ViewProductsInventoryService;

public class ViewProductsInventoryServiceImpl implements ViewProductsInventoryService {
	ViewProductsInventoryDaoImpl vpidi = new ViewProductsInventoryDaoImpl();

	public static void main(String[] args) {

		// TODO Auto-generated method stub

	}

	@Override
	public List<ProductsInventory> listProductInventoryForImport(String keyword, Integer number) {
		List<ProductsInventory> pil = new ArrayList();
		try {
			Integer  compaireNum =  number.equals(null) ? number = 0 : number;
			String key = keyword.equals(null) ? "" : keyword;
			pil = vpidi.selectBykeywordAndInventry(key, compaireNum);
			return pil;

		} catch (NullPointerException e) {
			return null;
		}

	}

	@Override
	public ProductsInventory getProductInventoryByProId(String proId) {
		ProductsInventory pro = null;

		List<ProductsInventory> pil = new ArrayList();

		ProductsInventory pi = vpidi.selectByproductId(proId).get(0);
		return pi;
	}

	@Override
	public List<ProductsInventory> listProductInventoryForSales(String keyword, Integer number) {
		List<ProductsInventory> pil = new ArrayList();
		try {
			Integer  compaireNum = number.equals(null) ? number = 1 : number;
			String key = keyword.equals(null) ? "" : keyword;
			pil = vpidi.selectBykeywordAndInventryForSales(key, compaireNum);
			return pil;

		} catch (NullPointerException e) {
			return null;
		}
	}

}
