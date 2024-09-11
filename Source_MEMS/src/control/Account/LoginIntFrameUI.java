package control.Account;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import control.FrameControl;
import control.UIComponents.JFoodterBar;
import control.UIComponents.JMyMenuBar;
import services.impl.EmployeeServiceImple;
import services.impl.UserServiceImpl;
import systemData.SystemData;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPasswordField;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class LoginIntFrameUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTextField txtUserAcc;
	private JPasswordField txtPassword;
	UserServiceImpl usi = new UserServiceImpl();
	EmployeeServiceImple esi = new EmployeeServiceImple();

	/**
	 * Create the frame.
	 */
	public LoginIntFrameUI(JDesktopPane desktopPane) {
		setTitle("登入");
		setBounds(100, 100, 650, 600);

		// Initialize the JInternalFrame with its properties
		this.setSize(300, 300); // Set the size of the internal frame
//        this.pack();
		this.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE); // Set to dispose on close

		// elements
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("10dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("10dlu"),},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("20dlu"),
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				RowSpec.decode("default:grow"),}));

		JLabel lblUsername = new JLabel("帳號");
		panel.add(lblUsername, "4, 4");

		txtUserAcc = new JTextField();
		
		panel.add(txtUserAcc, "6, 4, fill, default");
		txtUserAcc.setColumns(10);

		JLabel lblPassword = new JLabel("密碼");
		panel.add(lblPassword, "4, 8");

		txtPassword = new JPasswordField();
		
		panel.add(txtPassword, "6, 8, fill, default");
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "4, 10, 3, 1, fill, fill");
		
		JTextArea txtrAdmin = new JTextArea();
		scrollPane.setViewportView(txtrAdmin);
		txtrAdmin.setEditable(false);
		txtrAdmin.setText("帳號-------\t密碼\t權限\nadmin        \t123\t管理者\nhr               \t123\t人資作業\nWarehouse   \t123\t倉儲作業\nsales          \t123\t銷售作業\ntianbing         \t123\t被封鎖帳號");

		JPanel btnPanel = new JPanel();
		getContentPane().add(btnPanel, BorderLayout.SOUTH);
		GridBagLayout gbl_btnPanel = new GridBagLayout();
		gbl_btnPanel.columnWidths = new int[] { 80, 80, 0 };
		gbl_btnPanel.rowHeights = new int[] { 29, 0, 0 };
		gbl_btnPanel.columnWeights = new double[] { 1.0, 1.0, Double.MIN_VALUE };
		gbl_btnPanel.rowWeights = new double[] { 0.0, 0.0, Double.MIN_VALUE };
		btnPanel.setLayout(gbl_btnPanel);
		JButton btnRegist = new JButton("註冊");
		btnRegist.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameControl.createInternalRigisterFrame( desktopPane);
				dispose();
			}
		});

		GridBagConstraints gbc_btnRegist = new GridBagConstraints();
		gbc_btnRegist.fill = GridBagConstraints.BOTH;
		gbc_btnRegist.insets = new Insets(0, 0, 5, 5);
		gbc_btnRegist.gridx = 0;
		gbc_btnRegist.gridy = 0;
		btnPanel.add(btnRegist, gbc_btnRegist);
		JButton btnConfirm = new JButton("登入");

		GridBagConstraints gbc_btnConfirm = new GridBagConstraints();
		gbc_btnConfirm.insets = new Insets(0, 0, 5, 0);
		gbc_btnConfirm.fill = GridBagConstraints.BOTH;
		gbc_btnConfirm.gridx = 1;
		gbc_btnConfirm.gridy = 0;
		btnPanel.add(btnConfirm, gbc_btnConfirm);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{txtUserAcc, txtPassword}));
		// Create a close button

		btnConfirm.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				confirmClick();

			}

			
		});
		txtUserAcc.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10)
					txtPassword.requestFocus();
			}
		});
		txtPassword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if (e.getKeyCode() == 10)
				confirmClick();
			}
		});
		
		
	}
	public void confirmClick() {
		// Dispose the internal frame when the button is clicked
		
		String userAcc = txtUserAcc.getText().trim();
		if(!userAcc.equals("")) {
			String password = new String(txtPassword.getPassword());

			SystemData.currentUser = usi.login(userAcc, password);
			SystemData.currentEmployee = esi.selectEmployeeByUserId(SystemData.currentUser.getUser_id());
			try {
				Integer currentUserDeptId = usi.getCurrenUserDeptId();
				if (currentUserDeptId != 0) {
					JFoodterBar.LoginAcc.setText("員工名稱: " + usi.getCurrentUserName());
					dispose();
				}	
			} catch (NullPointerException e1) {
				e1.printStackTrace();
			}
		}else{
			JOptionPane.showMessageDialog(null, "帳號不可空白", "Information", JOptionPane.INFORMATION_MESSAGE);
			txtUserAcc.requestFocus();
		}
		
		JMyMenuBar.updateMenuList();
		JMyMenuBar.checkPermision();
	}

}
