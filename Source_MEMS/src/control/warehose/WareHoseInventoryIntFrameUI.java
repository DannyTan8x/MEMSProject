package control.warehose;

import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JScrollPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

import Utilities.CheckRegex;
import Utilities.ProductListTableModelForImport;
import Utilities.ProductListTableModelForInventory;
import model.view.ProductsInventory;
import model.view.PurchaseOrderDetail;
import services.impl.ViewProductsInventoryServiceImpl;
import services.impl.ViewPurchaseOrderDetailServiceImpl;

import javax.swing.JPanel;

public class WareHoseInventoryIntFrameUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable inventoryTable;
	private JTextField txtKeyword;
	private JTextField txtInveNumber;
	private Integer inventeryFilterNumber = null;
	static ProductListTableModelForInventory proListTableModel;
	ViewProductsInventoryServiceImpl vpisi = new ViewProductsInventoryServiceImpl();
	ViewPurchaseOrderDetailServiceImpl podsi = new ViewPurchaseOrderDetailServiceImpl();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					WareHoseInventoryIntFrameUI frame = new WareHoseInventoryIntFrameUI();
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the frame.
	 */
	public WareHoseInventoryIntFrameUI(JDesktopPane desktopPane) {
		setTitle("庫存表");
		setBounds(100, 100, 850, 500);
		int top = 20; // margin on the top
		int left = 20; // margin on the left
		int bottom = 20; // margin on the bottom
		int right = 20; // margin on the right
		txtInveNumber = new JTextField();
		txtInveNumber.setText("0");
		txtKeyword = new JTextField();
		inventeryFilterNumber = CheckRegex.QtyNoCheckRegix(txtInveNumber);
		JScrollPane scrollPane = new JScrollPane();
		getContentPane().add(scrollPane, BorderLayout.CENTER);
		List<ProductsInventory> productInv = vpisi.listProductInventoryForImport(txtKeyword.getText(),
				inventeryFilterNumber);
		proListTableModel = new ProductListTableModelForInventory(productInv);
		proListTableModel.setProductList(productInv);
		
		inventoryTable = new JTable(proListTableModel);
		
		scrollPane.setViewportView(inventoryTable);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.NORTH);
		
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 68, 75, 0, 0, 0, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 29, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel_4);
		JLabel lblNewLabel_5 = new JLabel("篩選條件：");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel.add(lblNewLabel_5, gbc_lblNewLabel_5);
		GridBagConstraints gbc_txtKeyword = new GridBagConstraints();
		gbc_txtKeyword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKeyword.insets = new Insets(0, 0, 5, 5);
		gbc_txtKeyword.gridx = 0;
		gbc_txtKeyword.gridy = 1;
		panel.add(txtKeyword, gbc_txtKeyword);
		
		txtKeyword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("庫存量<=");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel.add(lblNewLabel, gbc_lblNewLabel);
		GridBagConstraints gbc_txtInveNumber = new GridBagConstraints();
		gbc_txtInveNumber.insets = new Insets(0, 0, 5, 5);
		gbc_txtInveNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInveNumber.anchor = GridBagConstraints.NORTH;
		gbc_txtInveNumber.gridx = 2;
		gbc_txtInveNumber.gridy = 1;
		panel.add(txtInveNumber, gbc_txtInveNumber);
		txtInveNumber.setColumns(10);
		JButton btnNewButton_2 = new JButton("篩選");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getProductListTableData();
			}
		});
		
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.insets = new Insets(0, 0, 5, 5);
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton_2.gridx = 3;
		gbc_btnNewButton_2.gridy = 1;
		panel.add(btnNewButton_2, gbc_btnNewButton_2);
		
		JButton btnNewButton = new JButton("關閉");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.insets = new Insets(0, 0, 5, 0);
		gbc_btnNewButton.gridx = 5;
		gbc_btnNewButton.gridy = 1;
		panel.add(btnNewButton, gbc_btnNewButton);

		JLabel lblNewLabel_5_1 = new JLabel("產品名單：");
		GridBagConstraints gbc_lblNewLabel_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1.anchor = GridBagConstraints.WEST;
		gbc_lblNewLabel_5_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5_1.gridx = 0;
		gbc_lblNewLabel_5_1.gridy = 2;
		panel.add(lblNewLabel_5_1, gbc_lblNewLabel_5_1);

		
	}
	public void getProductListTableData() {
		inventeryFilterNumber = CheckRegex.QtyNoCheckRegix(txtInveNumber);
		List<ProductsInventory> productInv = vpisi.listProductInventoryForImport(txtKeyword.getText(),
				inventeryFilterNumber);
		proListTableModel.setProductList(productInv);
	}

}
