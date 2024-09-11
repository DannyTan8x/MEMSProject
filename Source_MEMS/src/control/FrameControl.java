package control;

import java.beans.PropertyVetoException;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import control.Account.LoginIntFrameUI;
import control.Account.RegisterIntFrameUI;
import control.Account.UserPassChangeIntFrameUI;
import control.employeeUI.EmployeeMngIntFrameUI;
import control.salesUI.SalesOrderIntFramUI;
import control.warehose.WareHoseInventoryIntFrameUI;
import control.warehose.warehoseProductImportIntFrameUI;
import control.employeeUI.EmployeeCreationIntFrameUI;

public class FrameControl {

	public static LoginIntFrameUI internalLoginFrame;
	static RegisterIntFrameUI internalRegisterFrame;
	static UserPassChangeIntFrameUI internalUserPassChange;
	static EmployeeMngIntFrameUI internalEmployeeMng;
	static EmployeeCreationIntFrameUI internalEmployeeCreation;
	static warehoseProductImportIntFrameUI internalWarehoseProductImport;
	static SalesOrderIntFramUI internalSalesOrder;
	static WareHoseInventoryIntFrameUI internalWareHoseInventory;


	public static void createWareHoseInventoryIntFrameUI(JDesktopPane desktopPane) {

		if (internalWareHoseInventory != null && !internalWareHoseInventory.isClosed()) {
			internalWareHoseInventory.dispose();
		}

		internalWareHoseInventory = new WareHoseInventoryIntFrameUI(desktopPane);
		internalWareHoseInventory.setSize(400, 300);
		internalWareHoseInventory.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		desktopPane.add(internalWareHoseInventory);

		maximumInternalFrame(internalWareHoseInventory, desktopPane);

		internalWareHoseInventory.setVisible(true);
	}

	public static void createInternalSalesOrder(JDesktopPane desktopPane) {

		if (internalSalesOrder != null && !internalSalesOrder.isClosed()) {
			internalSalesOrder.dispose();
		}

		internalSalesOrder = new SalesOrderIntFramUI(desktopPane);
		internalSalesOrder.setSize(400, 300);
		internalSalesOrder.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		desktopPane.add(internalSalesOrder);

		maximumInternalFrame(internalSalesOrder, desktopPane);

		internalSalesOrder.setVisible(true);
	}

	public static void createInternalWarehouseMng(JDesktopPane desktopPane) {

		if (internalWarehoseProductImport != null && !internalWarehoseProductImport.isClosed()) {
			internalWarehoseProductImport.dispose();
		}

		internalWarehoseProductImport = new warehoseProductImportIntFrameUI(desktopPane);
		internalWarehoseProductImport.setSize(400, 300);
		internalWarehoseProductImport.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		desktopPane.add(internalWarehoseProductImport);

		maximumInternalFrame(internalWarehoseProductImport, desktopPane);

		internalWarehoseProductImport.setVisible(true);
	}

	public static void createInternalEmployeeCreation(JDesktopPane desktopPane) {
		if (internalEmployeeCreation != null && !internalEmployeeCreation.isClosed()) {
			internalEmployeeCreation.dispose();
		}

		internalEmployeeCreation = new EmployeeCreationIntFrameUI(desktopPane);
		internalEmployeeCreation.setSize(400, 300);
		internalEmployeeCreation.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		desktopPane.add(internalEmployeeCreation);

		centerInternalFrame(internalEmployeeCreation, desktopPane);

		internalEmployeeCreation.setVisible(true);

	}

	public static void createinternalEmployeeMng(JDesktopPane desktopPane) {
		if (internalEmployeeMng != null && !internalEmployeeMng.isClosed()) {
			internalEmployeeMng.dispose();
		}

		internalEmployeeMng = new EmployeeMngIntFrameUI(desktopPane);
		internalEmployeeMng.setSize(400, 300);
		internalEmployeeMng.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		desktopPane.add(internalEmployeeMng);

		maximumInternalFrame(internalEmployeeMng, desktopPane);

		internalEmployeeMng.setVisible(true);
	}

	public static void createInternalUserPassChange(JDesktopPane desktopPane) {
		if (internalUserPassChange != null && !internalUserPassChange.isClosed()) {
			internalUserPassChange.dispose(); // Dispose of the old frame if it's still present
		}

		internalUserPassChange = new UserPassChangeIntFrameUI(desktopPane);
		internalUserPassChange.setSize(400, 300);
		internalUserPassChange.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		desktopPane.add(internalUserPassChange);

		centerInternalFrame(internalUserPassChange, desktopPane);

		internalUserPassChange.setVisible(true);
	}

	public static void createInternalLoginFrame(JDesktopPane desktopPane) {
		if (internalLoginFrame != null && !internalLoginFrame.isClosed()) {
			internalLoginFrame.dispose(); // Dispose of the old frame if it's still present
		}

		// Initialize the JInternalFrame with its properties
		internalLoginFrame = new LoginIntFrameUI(desktopPane);
		internalLoginFrame.setSize(400, 300); // Set the size of the internal frame
		internalLoginFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		// Add the internal frame to the desktop pane
		desktopPane.add(internalLoginFrame);

		// Center the internal frame within the desktop pane
		centerInternalFrame(internalLoginFrame, desktopPane);

		// Set visible to true to display the internal frame
		internalLoginFrame.setVisible(true);
	}

	public static void createInternalRigisterFrame(JDesktopPane desktopPane) {
		if (internalRegisterFrame != null && !internalRegisterFrame.isClosed()) {
			internalRegisterFrame.dispose(); // Dispose of the old frame if it's still present
		}

		internalRegisterFrame = new RegisterIntFrameUI(desktopPane);
		internalRegisterFrame.setSize(400, 300); // Set the size of the internal frame
		internalRegisterFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE);

		desktopPane.add(internalRegisterFrame);

		centerInternalFrame(internalRegisterFrame, desktopPane);

		internalRegisterFrame.setVisible(true);
	}

	public static void centerInternalFrame(JInternalFrame frame, JDesktopPane desktopPane) {
		if (frame == null) {
			return; // Handle case when frame is null
		}

		// Ensure the desktop pane size is correctly set
		try {
			desktopPane.setSize(desktopPane.getParent().getSize());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Get the size of the desktop pane and the internal frame
		int desktopWidth = desktopPane.getWidth();
		int desktopHeight = desktopPane.getHeight();
		int frameWidth = frame.getWidth();
		int frameHeight = frame.getHeight();

		// Calculate x and y coordinates to center the frame
		int x = (desktopWidth - frameWidth) / 2;
		int y = (desktopHeight - frameHeight) / 2;

		// Set the location of the internal frame to the calculated coordinates
		frame.setLocation(x, y);
	}

	public static void maximumInternalFrame(JInternalFrame frame, JDesktopPane desktopPane) {
		if (frame == null) {
			return; // Handle case when frame is null
		}
		// Ensure the desktop pane size is correctly set
		try {
			desktopPane.setSize(desktopPane.getParent().getSize());
		} catch (Exception e) {
			e.printStackTrace();
		}

		// Maximum frame size
		try {
			frame.setMaximum(true);
		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

		frame.setLocation(0, 0);
	}
	
	public static void closeFrames() {
		if (internalRegisterFrame != null && !internalRegisterFrame.isClosed()) {
			internalRegisterFrame.dispose(); // Dispose of the old frame if it's still present
		}
		if (internalUserPassChange != null && !internalUserPassChange.isClosed()) {
			internalUserPassChange.dispose(); // Dispose of the old frame if it's still present
		}
		if (internalEmployeeMng != null && !internalEmployeeMng.isClosed()) {
			internalEmployeeMng.dispose();
		}
		if (internalEmployeeCreation != null && !internalEmployeeCreation.isClosed()) {
			internalEmployeeCreation.dispose();
		}
		if (internalWarehoseProductImport != null && !internalWarehoseProductImport.isClosed()) {
			internalWarehoseProductImport.dispose();
		}
		if (internalWareHoseInventory != null && !internalWareHoseInventory.isClosed()) {
			internalWareHoseInventory.dispose();
		}
	}
}
