package control;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.jgoodies.forms.layout.FormLayout;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import control.UIComponents.JFoodterBar;
import dao.impl.DbConnection;
import model.db.DbInfo;
import services.impl.DbSetupServiceImpl;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.JPasswordField;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.FlowLayout;
import com.jgoodies.forms.layout.Sizes;

public class DbConnectionSetupUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField txtHost;
	private JTextField txtUserName;
	private JPasswordField txtPassword;
	private JTextField txtConnectionStatus;
	private JTextField txtDbType;
	private JTextField txtPort;
	

	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					DbConnectionSetupUI frame = new DbConnectionSetupUI();
//					frame.pack();
//					frame.setLocationRelativeTo(null);
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
	public DbConnectionSetupUI() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("71dlu"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("39dlu:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("80dlu:grow"),
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,},
			new RowSpec[] {
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,
				FormSpecs.RELATED_GAP_ROWSPEC,
				FormSpecs.DEFAULT_ROWSPEC,}));

		JLabel lblNewLabel_3 = new JLabel("DataBase connection setup");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		panel.add(lblNewLabel_3, "2, 2, 9, 1, center, default");

		JLabel lblNewLabel_5 = new JLabel("Database Type");
		panel.add(lblNewLabel_5, "4, 6, right, default");

		txtDbType = new JTextField();
		lblNewLabel_5.setLabelFor(txtDbType);
		txtDbType.setText("mysql");
		panel.add(txtDbType, "6, 6, 3, 1, fill, default");
		txtDbType.setColumns(10);

		JLabel lblNewLabel = new JLabel("Host :");
		panel.add(lblNewLabel, "4, 8, right, default");

		txtHost = new JTextField();
		lblNewLabel.setLabelFor(txtHost);
		txtHost.setText("localhost");
		panel.add(txtHost, "6, 8, 3, 1, fill, default");
		txtHost.setColumns(10);

		JLabel lblNewLabel_6 = new JLabel("Port :");
		panel.add(lblNewLabel_6, "4, 10, right, default");

		txtPort = new JTextField();
		lblNewLabel_6.setLabelFor(txtPort);
		txtPort.setText("3306");
		panel.add(txtPort, "6, 10, 3, 1, fill, default");
		txtPort.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("User Name :");
		panel.add(lblNewLabel_1, "4, 14, right, default");

		txtUserName = new JTextField();
		lblNewLabel_1.setLabelFor(txtUserName);
		txtUserName.setText("root");
		txtUserName.setColumns(10);
		panel.add(txtUserName, "6, 14, 3, 1, fill, default");

		JLabel lblNewLabel_2 = new JLabel("Password :");
		panel.add(lblNewLabel_2, "4, 16, right, default");

		txtPassword = new JPasswordField();
		lblNewLabel_2.setLabelFor(txtPassword);
		txtPassword.setText("1234");
		txtPassword.setColumns(10);
		panel.add(txtPassword, "6, 16, 3, 1");

		JButton btnTestConn = new JButton("Test connection");
		btnTestConn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				DbInfo dbinfo = new DbInfo();
				dbinfo.setDbType(txtDbType.getText().trim());
				dbinfo.setHostName(txtHost.getText().trim());
				dbinfo.setPort(txtPort.getText().trim());
				dbinfo.setUserName(txtUserName.getText().trim());
				dbinfo.setPassword(new String(txtPassword.getPassword()));

				MainUI.dssi.testConnection(dbinfo);
				txtConnectionStatus.setText(DbConnection.statusString);
			}
		});
		panel.add(btnTestConn, "8, 18, fill, default");

		JLabel lblNewLabel_4 = new JLabel("Connection status:");
		panel.add(lblNewLabel_4, "4, 22, center, default");

		txtConnectionStatus = new JTextField();
		lblNewLabel_4.setLabelFor(txtConnectionStatus);
		txtConnectionStatus.setEditable(false);
		panel.add(txtConnectionStatus, "6, 22, 3, 1, fill, default");
		txtConnectionStatus.setColumns(10);

		JButton btnNext = new JButton("Next ->");
		btnNext.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JFrame parreentFrame = (JFrame) SwingUtilities.getWindowAncestor(btnNext);
		        parreentFrame.setAlwaysOnTop(false);
		        //結束往前
				DbInfo dbinfo = new DbInfo();
				dbinfo.setDbType(txtDbType.getText().trim());
				dbinfo.setHostName(txtHost.getText().trim());
				dbinfo.setPort(txtPort.getText().trim());
				dbinfo.setUserName(txtUserName.getText().trim());
				dbinfo.setPassword(new String(txtPassword.getPassword()));

				MainUI.dssi.setupSchema(dbinfo);
				MainUI.dssi.initializeSQLTable();
				
				DbConnection.getDb();
				parreentFrame.dispose();
//				MainUI frame;
//				try {
//					frame = new MainUI();
//					frame.setLocationRelativeTo(null);
//					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
//					frame.setVisible(true);
//				} catch (FileNotFoundException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
			}
		});
		panel.add(btnNext, "8, 24, fill, default");
		
//		JFoodterBar jFoodterBar = new JFoodterBar();
		
//		contentPane.add(jFoodterBar, BorderLayout.SOUTH);
		FormLayout fl = new FormLayout();
	}

}
