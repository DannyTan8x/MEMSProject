package control.Account;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import Utilities.CheckRegex;
import control.FrameControl;
import services.impl.EmployeeServiceImple;
import services.impl.UserServiceImpl;
import systemData.SystemData;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class RegisterIntFrameUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private static JTextField txtEmployeeNo;
	private JTextField txtUserAcc;
	private JPasswordField txtPassword;
	UserServiceImpl usi = new UserServiceImpl();
	EmployeeServiceImple esi = new EmployeeServiceImple();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					RegisterIntFrameUI frame = new RegisterIntFrameUI();
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
	public RegisterIntFrameUI(JDesktopPane desktopPane) {
		setTitle("註冊");
		setBounds(100, 100, 450, 300);

		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC,
						FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, FormSpecs.RELATED_GAP_COLSPEC,
						ColumnSpec.decode("default:grow"), FormSpecs.RELATED_GAP_COLSPEC, FormSpecs.DEFAULT_COLSPEC, },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, }));

		JLabel lblNewLabel = new JLabel("工號：");
		panel.add(lblNewLabel, "4, 4, right, default");

		txtEmployeeNo = new JTextField();
		
		panel.add(txtEmployeeNo, "6, 4, fill, fill");
		txtEmployeeNo.setColumns(10);

		JButton btnSearch = new JButton("查找");

		panel.add(btnSearch, "8, 4");

		JLabel lblNewLabel_4 = new JLabel("員工姓名：");
		panel.add(lblNewLabel_4, "4, 6, default, fill");

		JLabel lblshowName = new JLabel(" ");
		panel.add(lblshowName, "6, 6, default, fill");

		JLabel lblNewLabel_1 = new JLabel("帳號：");
		panel.add(lblNewLabel_1, "4, 10, right, default");

		txtUserAcc = new JTextField();
		txtUserAcc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) txtPassword.requestFocus();
			}
		});
		panel.add(txtUserAcc, "6, 10, fill, fill");
		txtUserAcc.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("密碼：");
		panel.add(lblNewLabel_2, "4, 12, right, default");

		txtPassword = new JPasswordField();
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) userRegistry(desktopPane);
			}
		});
		panel.add(txtPassword, "6, 12, fill, fill");

		JPanel btnPanel = new JPanel();
		getContentPane().add(btnPanel, BorderLayout.SOUTH);

		JButton btnCancel = new JButton("取消");

		btnPanel.add(btnCancel);

		JButton btnConfirm = new JButton("註冊");

		btnPanel.add(btnConfirm);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				searchEmployee(lblshowName);
			}

			
		});
		btnCancel.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				FrameControl.createInternalLoginFrame(desktopPane);
				dispose();
			}
		});
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				userRegistry(desktopPane);

			}
		});
		txtEmployeeNo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					searchEmployee(lblshowName);
					txtUserAcc.requestFocus();
					}
			}
		});
		
	}
	public void userRegistry(JDesktopPane desktopPane) {
		String username = txtUserAcc.getText();
		String userPassword = new String(txtPassword.getPassword());
		Integer employeeno = CheckRegex.EmployeeNoCheckRegix(txtEmployeeNo);


		try {
			usi.registUser(username, userPassword, employeeno);
			FrameControl.createInternalLoginFrame(desktopPane);
			dispose();
		} catch (NullPointerException e1) {
			e1.printStackTrace();
		}
	}
	
	public void searchEmployee(JLabel lblshowName) {
		String EmployeeName = null;
		CheckRegex.EmployeeNoCheckRegix(txtEmployeeNo);
		
		Integer employeeno = CheckRegex.EmployeeNoCheckRegix(txtEmployeeNo);
		EmployeeName = esi.getEmployeeName(employeeno);
		lblshowName.setText(EmployeeName);
	}

}
