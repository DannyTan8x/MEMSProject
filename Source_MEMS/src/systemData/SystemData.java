package systemData;

import model.table.Employee;
import model.table.Product;
import model.table.PurchaseOrder;
import model.table.PurchaseOrderItem;
import model.table.SalesOrder;
import model.table.SalesOrderItem;
import model.table.User;

public class SystemData {
	public static User currentUser = new User();
	public static Product currentProduct = new Product();
	public static PurchaseOrder currentPO = new PurchaseOrder();
	public static PurchaseOrderItem currentPOI = new PurchaseOrderItem();
	
	public static SalesOrder currentSO = new SalesOrder();
	public static SalesOrderItem currentSOI = new SalesOrderItem();
	public static Employee currentEmployee = new Employee();
}
