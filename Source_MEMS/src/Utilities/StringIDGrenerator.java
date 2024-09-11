package Utilities;

import java.util.List;

import dao.impl.table.SalesOrderDaoImpl;
import model.table.Product;
import model.table.ProductType;
import model.table.PurchaseOrder;
import model.table.SalesOrder;
import services.impl.ProductServiceImpl;
import services.impl.ProductTypeServicesImpl;
import services.impl.PurchaseOrderServicesImpl;
import services.impl.SalesOrderServicesImpl;

public class StringIDGrenerator {
	static Integer numCodelenght = 4;
	static ProductTypeServicesImpl ptsi = new ProductTypeServicesImpl();
	static ProductServiceImpl psi = new ProductServiceImpl();
	static PurchaseOrderServicesImpl posi = new PurchaseOrderServicesImpl();
	static SalesOrderServicesImpl sosi = new SalesOrderServicesImpl();

	public static void main(String[] args) {
		StringIDGrenerator idg = new StringIDGrenerator();
		System.out.println(idg.productTypeIDGenerator());
		System.out.println(idg.productIDGenerator());
		System.out.println(idg.purchaseOrderIDGenerator());
	}

	public static String productTypeIDGenerator() {
		List<ProductType> ptl;
		ptl = ptsi.selectAll();
		ProductType lastestpt = ptl.get(ptl.size() - 1);
		String lastestId = lastestpt.getProductTypeId();
		return IDGenerator("PT", lastestId);
	}

	public static String productIDGenerator() {
		List<Product> pl;
		pl = psi.selectAll();
		Product lastestpt = pl.get(pl.size() - 1);
		String lastestId = lastestpt.getProductId();
		return IDGenerator("P", lastestId);
	}

	public static String purchaseOrderIDGenerator() {
		List<PurchaseOrder> pl;
		pl = posi.selectAll();
		PurchaseOrder lastestpt = pl.get(pl.size() - 1);
		String lastestId = lastestpt.getPurchaseOrderId();
		return IDGenerator("PO", lastestId);
	}

	public static String salesOrderIDGenerator() {
		List<SalesOrder> sl;
		sl = sosi.selectAll();
		SalesOrder lastestpt = sl.get(sl.size() - 1);
		String lastestId = lastestpt.getOrderId();
		return IDGenerator("SO", lastestId);
	}

	public static String IDGenerator(String prefix, String id) {
		Integer number = 0;
		String pre = prefix;
		try {
			String sub = id.substring(id.length() - numCodelenght, id.length());
			number = Integer.parseInt(sub) + 1;
		} catch (Exception e) {
			number = 1;
		}

		String newSub = "" + number + "";
		for (int i = 0; i < numCodelenght; i++) {
			if (newSub.length() < numCodelenght) {
				newSub = "0" + newSub;
			}
		}

		return pre + newSub;

	}

}
