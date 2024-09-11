package control.salesUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Utilities.CheckRegex;
import Utilities.ProductListTableModelForImport;
import Utilities.ProductListTableModelForSales;
import Utilities.PurchaseOrderItemListTableModel;
import Utilities.SalesOrderItemListTableModel;
import model.table.PurchaseOrder;
import model.table.SalesOrder;
import model.view.ProductsInventory;
import model.view.PurchaseOrderDetail;
import model.view.SalesOrderDetail;
import services.impl.ProductServiceImpl;
import services.impl.PurchaseOrderItemServiceImpl;
import services.impl.PurchaseOrderServicesImpl;
import services.impl.SalesOrderItemServiceImpl;
import services.impl.SalesOrderServicesImpl;
import services.impl.ViewProductsInventoryServiceImpl;
import services.impl.ViewPurchaseOrderDetailServiceImpl;
import services.impl.ViewSalesOrderDetailServiceImpl;
import systemData.SystemData;

public class SalesOrderIntFramUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtCurrentSO;
	private JTextField txtCurrentSODate;
	private JTextField txtKeyword;
	private JTextField txtInveNumber;
	private JTable productListTable;
	private JLabel lblSum;
	static ProductListTableModelForSales proListTableModel;
	static SalesOrderItemListTableModel salesOrderDetailTable;
	ViewProductsInventoryServiceImpl vpisi = new ViewProductsInventoryServiceImpl();
	SalesOrderServicesImpl sosi = new SalesOrderServicesImpl();
	SalesOrderItemServiceImpl soisi = new SalesOrderItemServiceImpl();

	ViewSalesOrderDetailServiceImpl sodsi = new ViewSalesOrderDetailServiceImpl();

	ProductServiceImpl psi = new ProductServiceImpl();
	private Integer inventeryFilterNumber = null;
	private JTable SalesOrderItemTable;
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					SalesOrderIntFramUI frame = new SalesOrderIntFramUI();
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
	public SalesOrderIntFramUI(JDesktopPane desktopPane) {
		setTitle("銷售單");
		setBounds(100, 100, 850, 500);
		int top = 20; // margin on the top
		int left = 20; // margin on the left
		int bottom = 20; // margin on the bottom
		int right = 20; // margin on the right
		txtInveNumber = new JTextField();
		txtInveNumber.setText("0");
		txtKeyword = new JTextField();
		inventeryFilterNumber = CheckRegex.QtyNoCheckRegix(txtInveNumber);
		List<ProductsInventory> productInv = vpisi.listProductInventoryForSales(txtKeyword.getText(),
				inventeryFilterNumber);
		proListTableModel = new ProductListTableModelForSales(productInv);
		proListTableModel.setProductList(productInv);
		List<SalesOrderDetail> sodetail = sodsi.selectCurrentSalesOrderDetail();
//		podetail.stream().forEach((t) -> System.out.println(t.getProduct_name()));
		salesOrderDetailTable = new SalesOrderItemListTableModel(sodetail);

		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(10, left, bottom, right));
		getContentPane().add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 275, 275, 275, 0 };
		gbl_panel.rowHeights = new int[] { 115, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 1.0, Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 0, 5);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		panel.add(panel_2, gbc_panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 275, 0 };
		gbl_panel_2.rowHeights = new int[] { 57, 57, 0 };
		gbl_panel_2.columnWeights = new double[] { 1.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 1.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.HORIZONTAL;
		gbc_panel_4.insets = new Insets(0, 0, 5, 0);
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 0;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] { 68, 75, 0, 0 };
		gbl_panel_4.rowHeights = new int[] { 0, 29, 0, 0 };
		gbl_panel_4.columnWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_4.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_4.setLayout(gbl_panel_4);

		JLabel lblNewLabel_5 = new JLabel("篩選條件：");
		GridBagConstraints gbc_lblNewLabel_5 = new GridBagConstraints();
		gbc_lblNewLabel_5.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_5.gridx = 0;
		gbc_lblNewLabel_5.gridy = 0;
		panel_4.add(lblNewLabel_5, gbc_lblNewLabel_5);

		GridBagConstraints gbc_txtKeyword = new GridBagConstraints();
		gbc_txtKeyword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKeyword.insets = new Insets(0, 0, 5, 5);
		gbc_txtKeyword.gridx = 0;
		gbc_txtKeyword.gridy = 1;
		panel_4.add(txtKeyword, gbc_txtKeyword);
		txtKeyword.setColumns(10);

		JLabel lblNewLabel = new JLabel("庫存量>=");
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel.gridx = 1;
		gbc_lblNewLabel.gridy = 1;
		panel_4.add(lblNewLabel, gbc_lblNewLabel);

		GridBagConstraints gbc_txtInveNumber = new GridBagConstraints();
		gbc_txtInveNumber.insets = new Insets(0, 0, 5, 0);
		gbc_txtInveNumber.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtInveNumber.anchor = GridBagConstraints.NORTH;
		gbc_txtInveNumber.gridx = 2;
		gbc_txtInveNumber.gridy = 1;
		panel_4.add(txtInveNumber, gbc_txtInveNumber);
		txtInveNumber.setColumns(10);

		JButton btnNewButton_2 = new JButton("篩選");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				getProductListTableData();
			}
		});
		JLabel lblNewLabel_5_1 = new JLabel("產品名單：");
		GridBagConstraints gbc_lblNewLabel_5_1 = new GridBagConstraints();
		gbc_lblNewLabel_5_1.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_5_1.gridx = 0;
		gbc_lblNewLabel_5_1.gridy = 2;
		panel_4.add(lblNewLabel_5_1, gbc_lblNewLabel_5_1);
		GridBagConstraints gbc_btnNewButton_2 = new GridBagConstraints();
		gbc_btnNewButton_2.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnNewButton_2.gridx = 2;
		gbc_btnNewButton_2.gridy = 2;
		panel_4.add(btnNewButton_2, gbc_btnNewButton_2);

		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 1;
		panel_2.add(scrollPane, gbc_scrollPane);

		productListTable = new JTable(proListTableModel);
		scrollPane.setViewportView(productListTable);

		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 0, 5);
		gbc_panel_3.gridx = 1;
		gbc_panel_3.gridy = 0;
		panel.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("37px"), ColumnSpec.decode("61px:grow"),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("130px:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("15dlu"), FormSpecs.RELATED_GAP_ROWSPEC,
						RowSpec.decode("26px"), FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), }));

		JLabel lblNewLabel_7 = new JLabel("品名：");
		panel_3.add(lblNewLabel_7, "2, 2, right, default");

		JLabel lblSelectedProductName = new JLabel(" ");
		panel_3.add(lblSelectedProductName, "4, 2");

		JLabel lblNewLabel_4 = new JLabel("數量：");
		panel_3.add(lblNewLabel_4, "2, 6, right, default");

		JSpinner spinnerQty = new JSpinner();
		spinnerQty.setModel(new SpinnerNumberModel(1, 0, null, 1));
		panel_3.add(spinnerQty, "4, 6");

		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, "4, 8, fill, fill");

		JButton btnAddPOI = new JButton("加入明細");
		btnAddPOI.setVisible(false);
		panel_5.add(btnAddPOI);

		JButton btnModify = new JButton("更改");

		btnModify.setVisible(false);
		panel_5.add(btnModify);

		JButton btnRemovePoi = new JButton("刪除");

		btnRemovePoi.setVisible(false);
		panel_5.add(btnRemovePoi);

		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 2;
		gbc_panel_1.gridy = 0;
		panel.add(panel_1, gbc_panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] { 0, 0, 0 };
		gbl_panel_1.rowHeights = new int[] { 0, 0, 0, 0, 0 };
		gbl_panel_1.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_panel_1.rowWeights = new double[] { 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_1.setLayout(gbl_panel_1);

		JLabel lblNewLabel_6 = new JLabel("銷售單明細");
		GridBagConstraints gbc_lblNewLabel_6 = new GridBagConstraints();
		gbc_lblNewLabel_6.gridwidth = 2;
		gbc_lblNewLabel_6.insets = new Insets(0, 0, 5, 0);
		gbc_lblNewLabel_6.gridx = 0;
		gbc_lblNewLabel_6.gridy = 0;
		panel_1.add(lblNewLabel_6, gbc_lblNewLabel_6);

		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.gridwidth = 2;
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel_1.add(scrollPane_1, gbc_scrollPane_1);
		SalesOrderItemTable = new JTable(salesOrderDetailTable);

		scrollPane_1.setViewportView(SalesOrderItemTable);
		
		JLabel lblNewLabel_3 = new JLabel("總金額：");
		GridBagConstraints gbc_lblNewLabel_3 = new GridBagConstraints();
		gbc_lblNewLabel_3.anchor = GridBagConstraints.EAST;
		gbc_lblNewLabel_3.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_3.gridx = 0;
		gbc_lblNewLabel_3.gridy = 2;
		panel_1.add(lblNewLabel_3, gbc_lblNewLabel_3);
		
		lblSum = new JLabel("");
		GridBagConstraints gbc_lblSum = new GridBagConstraints();
		gbc_lblSum.anchor = GridBagConstraints.EAST;
		gbc_lblSum.insets = new Insets(0, 0, 5, 0);
		gbc_lblSum.gridx = 1;
		gbc_lblSum.gridy = 2;
		panel_1.add(lblSum, gbc_lblSum);

		JButton btnOK = new JButton("儲存");

		GridBagConstraints gbc_btnOK = new GridBagConstraints();
		gbc_btnOK.gridwidth = 2;
		gbc_btnOK.anchor = GridBagConstraints.EAST;
		gbc_btnOK.gridx = 0;
		gbc_btnOK.gridy = 3;
		panel_1.add(btnOK, gbc_btnOK);

		JPanel searchBarPanel = new JPanel();
		searchBarPanel.setBorder(new EmptyBorder(top, left, bottom, right));
		getContentPane().add(searchBarPanel, BorderLayout.NORTH);

		JButton btnNewButton_1 = new JButton("新增");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sosi.newSalesOrder();
				txtCurrentSO.setText(SystemData.currentSO.getOrderId());

				LocalDateTime dateTime = SystemData.currentSO.getOrderDate();
				DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
				String formatterDateTime = dateTime.format(formatter);
				txtCurrentSODate.setText(formatterDateTime);
			}
		});

		searchBarPanel.setLayout(new FormLayout(
				new ColumnSpec[] { ColumnSpec.decode("24px"), ColumnSpec.decode("96px"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("192px"), FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("96px"),
						ColumnSpec.decode("52px:grow"), ColumnSpec.decode("39px"), FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("192px"), },
				new RowSpec[] { RowSpec.decode("29px"), FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("16px"), }));
		searchBarPanel.add(btnNewButton_1, "2, 1, fill, top");

		JLabel lblNewLabel_1 = new JLabel("單號：");
		searchBarPanel.add(lblNewLabel_1, "2, 3, right, top");

		txtCurrentSO = new JTextField();
		txtCurrentSO.setEditable(false);
		searchBarPanel.add(txtCurrentSO, "4, 3, fill, fill");
		txtCurrentSO.setColumns(10);

		JButton btnDeletePO = new JButton("刪除訂單");
		btnDeletePO.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sosi.delete(SystemData.currentSO.getOrderId());
				txtCurrentSO.setText(null);
				txtCurrentSODate.setText(null);
				SystemData.currentSO = new SalesOrder();
				refreshPoiTable();
				getProductListTableData();
			}
		});

		searchBarPanel.add(btnDeletePO, "6, 3, left, fill");

		JLabel lblNewLabel_2 = new JLabel("日期：");
		searchBarPanel.add(lblNewLabel_2, "8, 3, right, top");

		txtCurrentSODate = new JTextField();
		txtCurrentSODate.setEditable(false);
		searchBarPanel.add(txtCurrentSODate, "10, 3, fill, fill");
		txtCurrentSODate.setColumns(10);

		JPanel btnPanel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		getContentPane().add(btnPanel, BorderLayout.SOUTH);

		JButton btnFinish = new JButton("關閉");

		btnPanel.add(btnFinish);

		JButton btnNewButton = new JButton("取消");
		btnNewButton.setHorizontalAlignment(SwingConstants.RIGHT);
		btnPanel.add(btnNewButton);

		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sosi.delete(SystemData.currentSO.getOrderId());
				SystemData.currentSO = null;
				dispose();
			}
		});

		productListTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				SystemData.currentProduct = psi
						.selectById(productListTable.getValueAt(productListTable.getSelectedRow(), 2).toString());

				lblSelectedProductName.setText(SystemData.currentProduct.getProductName());
				btnAddPOI.setVisible(true);
				btnModify.setVisible(false);
				btnRemovePoi.setVisible(false);
			}
		});
		SalesOrderItemTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnAddPOI.setVisible(false);
				btnModify.setVisible(true);
				btnRemovePoi.setVisible(true);
				SystemData.currentSOI = soisi.selectedSOItem(
						(Integer) SalesOrderItemTable.getValueAt(SalesOrderItemTable.getSelectedRow(), 0));
				spinnerQty.setValue(SystemData.currentSOI.getQty());

//				txtInprice.setText(SystemData.currentSOI.ge.toString());
			}
		});

		btnAddPOI.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String currentProductID = SystemData.currentProduct.getProductId();
//				System.out.println("selectedProductID:" + SystemData.currentProduct.getProductId());
				Integer addQty = CheckRegex.QtyJSpinnerCheckRegix(spinnerQty);
//				Integer addPrice = CheckRegex.QtyNoCheckRegix(txtInprice);
				soisi.addToCurrentSO(currentProductID, addQty);
//				System.out.println("POID" + SystemData.currentPO.getPurchaseOrderId());
				spinnerQty.setValue(1);

				btnAddPOI.setVisible(false);
				refreshPoiTable();
				getProductListTableData();
			}
		});
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
//				SystemData.currentPOI.getPurchaseOrderItemId();
				Integer addQty = CheckRegex.QtyJSpinnerCheckRegix(spinnerQty);
//				Integer addPrice = CheckRegex.QtyNoCheckRegix(txtInprice);
				SystemData.currentSOI.setQty(addQty);
//				SystemData.currentSOI.setPurchasePrice(addPrice);
				soisi.update(SystemData.currentSOI);
				btnModify.setVisible(false);
				btnRemovePoi.setVisible(false);
				spinnerQty.setValue(1);

				refreshPoiTable();
				getProductListTableData();
			}
		});
		btnRemovePoi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				soisi.delete(SystemData.currentSOI.getOrderItemId());
				btnModify.setVisible(false);
				btnRemovePoi.setVisible(false);
				spinnerQty.setValue(1);
//				txtInprice.setText(null);
				refreshPoiTable();
				getProductListTableData();
			}
		});

		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SystemData.currentSO = new SalesOrder();
				txtCurrentSO.setText(null);
				txtCurrentSODate.setText(null);
				spinnerQty.setValue(1);
//				txtInprice.setText(null);
				btnModify.setVisible(false);
				btnRemovePoi.setVisible(false);
				btnAddPOI.setVisible(false);
				refreshPoiTable();
				getProductListTableData();
			}
		});

		btnFinish.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					SystemData.currentSO.getOrderId().equals(null);
					JOptionPane.showMessageDialog(null, "請確認銷售單是否儲存 或 取消", "Information",
							JOptionPane.INFORMATION_MESSAGE);
				} catch (NullPointerException e1) {
					dispose();
				}

			}
		});
	}

	public void getProductListTableData() {
		inventeryFilterNumber = CheckRegex.QtyNoCheckRegix(txtInveNumber);
		List<ProductsInventory> productInv = vpisi.listProductInventoryForSales(txtKeyword.getText(),
				inventeryFilterNumber);
		proListTableModel.setProductList(productInv);
	}

	public void refreshPoiTable() {
		List<SalesOrderDetail> sodetail = sodsi.selectCurrentSalesOrderDetail();
		salesOrderDetailTable.setSalesOrderItemDetailList(sodetail);
		lblSum.setText(sodsi.getCurrentSalesOrderSum().toString());
	}
	

}
