package control.UIComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingUtilities;

import control.FrameControl;
import control.Account.LoginIntFrameUI;
import control.MainUI;
import services.impl.DbSetupServiceImpl;
import services.impl.UserServiceImpl;
import systemData.SystemData;

public class JMyMenuBar extends JMenuBar {
	DbSetupServiceImpl dssi = new DbSetupServiceImpl();
	static UserServiceImpl usi = new UserServiceImpl();
	static JMenu mnSystem = new JMenu("系統");
	static JMenuItem mntmInitializeData = new JMenuItem("載入模擬資料");// done
	static JMenuItem mntmUserPassChange = new JMenuItem("變更密碼");// 更改密碼/ worked. 有時間再加入密碼不一致的exception
	static JMenuItem mntmLoginFrame = new JMenuItem("登入");// done
	static JMenuItem mntmLogout = new JMenuItem("登出");// done
	static JMenuItem mntmClose = new JMenuItem("關閉");// done
	static JMenu mnHr = new JMenu("人資作業");
	static JMenuItem mntmEmployeeMng = new JMenuItem("人員管理");// 添加/更改employee資訊
	static JMenu mnPur = new JMenu("倉儲作業");
	static JMenuItem mntmImportProduct = new JMenuItem("繳庫庫");// 產品入庫
	static JMenuItem mntmProductInfoMgm = new JMenuItem("產品資訊");//調整產品名稱，分類
	static JMenu mnSales = new JMenu("銷售作業");
	static JMenuItem mntmSalesOrder = new JMenuItem("銷售訂單");
	static JMenu mnReport = new JMenu("統計報告");
	static JMenuItem mntmProductInventory = new JMenuItem("庫存表");
	static JMenuItem mntmSalesOrderReport = new JMenuItem("銷售總覽");
	static JMenuItem mntmSalesOrderDetail = new JMenuItem("銷售明細");
	static JMenuItem mntmSalesOrderPerEmployee = new JMenuItem("員工銷售業績");
	
	public JMyMenuBar(LoginIntFrameUI internalFrame, JDesktopPane desktopPane) {
		super();

		// showing in MenuBar
		// 系統清單
		this.add(mnSystem);
		this.add(mnHr);
		this.add(mnPur);
		this.add(mnSales);
		this.add(mnReport);
		updateMenuList();

//		mntmClose.setEnabled(false);

		// Listner 監聽
		mntmInitializeData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dssi.initializeSQLTable();
				dssi.initializeSQLData();
			}
		});

		mntmLoginFrame.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				MainUI.createInternalLoginFrame(desktopPane);
				FrameControl.createInternalLoginFrame(desktopPane);
				updateMenuList();

			}
		});
	
		mntmUserPassChange.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameControl.createInternalUserPassChange(desktopPane);
				updateMenuList();

			}
		});

		mntmLogout.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				SystemData.currentUser = null;
				JFoodterBar.LoginAcc.setText("");
				FrameControl.closeFrames();
				FrameControl.createInternalLoginFrame(desktopPane);
				updateMenuList();

			}
		});

		mntmClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				JFrame parreentFrame = (JFrame) SwingUtilities.getWindowAncestor(mnSystem);
//		        parreentFrame.setAlwaysOnTop(false);
//		        parreentFrame.dispose();
				System.exit(ABORT);
			}
		});
		
		//人資功能
		mntmEmployeeMng.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameControl.createinternalEmployeeMng(desktopPane);
			}
		});
		
		//繳庫單
		mntmImportProduct.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameControl.createInternalWarehouseMng(desktopPane);
				updateMenuList();

			}
		});
		
		//銷售單
		mntmSalesOrder.addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						FrameControl.createInternalSalesOrder(desktopPane);
						updateMenuList();

					}
				});
		
		//庫存表
		mntmProductInventory.addActionListener(new ActionListener() {
							@Override
							public void actionPerformed(ActionEvent e) {
								FrameControl.createWareHoseInventoryIntFrameUI(desktopPane);
								updateMenuList();

							}
						});
		//權限 toggle
		checkPermision();
		this.updateUI();
		

	}

	public static void updateMenuList() {
		mnSystem.add(mntmInitializeData);
		// Login | Logic toggle
		checkPermision();
		try {
			Integer currentUserDeptId = usi.getCurrenUserDeptId();
			if (currentUserDeptId != 0) {
				mnSystem.add(mntmLogout);
				mnSystem.remove(mntmLoginFrame);
				mnSystem.add(mntmUserPassChange);
			} else {
				mnSystem.add(mntmLoginFrame);
				mnSystem.remove(mntmLogout);
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		// Menu Item adding
		
		mnSystem.add(mntmClose);
		
		mnHr.add(mntmEmployeeMng);

		mnPur.add(mntmImportProduct);
//		mnPur.add(mntmProductInfoMgm);

		mnSales.add(mntmSalesOrder);
		
		mnReport.add(mntmProductInventory);
//		mnReport.add(mntmSalesOrderReport);
//		mnReport.add(mntmSalesOrderDetail);
//		mnReport.add(mntmSalesOrderPerEmployee);
		
		
		

		
	}

	public static void checkPermision() {
		try {
			Integer currentUserDeptId = usi.getCurrenUserDeptId();
			switch (currentUserDeptId) {
			case 0:
				mntmInitializeData.setEnabled(false);
				mntmLoginFrame.setEnabled(true);
				mntmLogout.setEnabled(false);
				mntmClose.setEnabled(true);
				mnHr.setEnabled(false);
				mnPur.setEnabled(false);
				mnSales.setEnabled(false);
				mnReport.setEnabled(false);
				break;
			case 1:// ('行政管理部'), admin
				mntmInitializeData.setEnabled(true);
				mntmLoginFrame.setEnabled(true);
				mntmLogout.setEnabled(true);
				mntmClose.setEnabled(true);
				mnHr.setEnabled(true);
				mnPur.setEnabled(true);
				mnSales.setEnabled(true);
				mnReport.setEnabled(true);
				break;
			case 2: // ('人事部'),
				mntmInitializeData.setEnabled(false);
				mntmLoginFrame.setEnabled(true);
				mntmLogout.setEnabled(true);
				mntmClose.setEnabled(true);
				mnHr.setEnabled(true);
				mnPur.setEnabled(false);
				mnSales.setEnabled(false);
				mnReport.setEnabled(false);
				break;
			case 3:// ('採購部'),
				mntmInitializeData.setEnabled(false);
				mntmLoginFrame.setEnabled(true);
				mntmLogout.setEnabled(true);
				mntmClose.setEnabled(true);
				mnHr.setEnabled(false);
				mnPur.setEnabled(true);
				mnSales.setEnabled(false);
				mnReport.setEnabled(false);
				break;
			case 4: // ('銷售部'),
				mntmInitializeData.setEnabled(false);
				mntmLoginFrame.setEnabled(true);
				mntmLogout.setEnabled(true);
				mntmClose.setEnabled(true);
				mnHr.setEnabled(false);
				mnPur.setEnabled(false);
				mnSales.setEnabled(true);
				mnReport.setEnabled(false);
				break;
			}
		} catch (NullPointerException e) {
			e.printStackTrace();
		}

	}

}
