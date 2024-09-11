package control.Account;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import services.impl.UserServiceImpl;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UserPassChangeIntFrameUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JPasswordField txtOldPass;
	private JPasswordField txtNewPass;
	private JPasswordField txtNewPassConfirm;
	UserServiceImpl usi = new UserServiceImpl();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					UserPassChangeIntFrameUI frame = new UserPassChangeIntFrameUI();
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
	public UserPassChangeIntFrameUI(JDesktopPane desktopPane) {
		setBounds(100, 100, 450, 300);
		
		JPanel btnPanel = new JPanel();
		getContentPane().add(btnPanel, BorderLayout.SOUTH);
		
		JButton btnCancel = new JButton("取消");
		
		btnPanel.add(btnCancel);
		
		JButton btnConfirm = new JButton("確認");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String oldPass = new String(txtOldPass.getPassword());
				String newPass = new String(txtNewPass.getPassword());
				String confirmPass = new String(txtNewPassConfirm.getPassword());
				usi.changePassword(oldPass, newPass, confirmPass);
				dispose();
			}
		});
		btnPanel.add(btnConfirm);
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(new FormLayout(new ColumnSpec[] {
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				FormSpecs.DEFAULT_COLSPEC,
				FormSpecs.RELATED_GAP_COLSPEC,
				ColumnSpec.decode("default:grow"),
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
				FormSpecs.DEFAULT_ROWSPEC,}));
		
		JLabel lblNewLabel = new JLabel("目前密碼：");
		panel.add(lblNewLabel, "4, 4, right, default");
		
		txtOldPass = new JPasswordField();
		txtOldPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() ==  10) {
					txtNewPass.requestFocus();
				}
			}
		});
		panel.add(txtOldPass, "6, 4, fill, fill");
		
		JLabel lblNewLabel_1 = new JLabel("新密碼：");
		panel.add(lblNewLabel_1, "4, 8, right, default");
		
		txtNewPass = new JPasswordField();
		txtNewPass.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() ==  10) {
					txtNewPassConfirm.requestFocus();
				}
			}
		});
		panel.add(txtNewPass, "6, 8, fill, fill");
		
		JLabel lblNewLabel_2 = new JLabel("再次輸入：");
		panel.add(lblNewLabel_2, "4, 10, right, default");
		
		txtNewPassConfirm = new JPasswordField();
		txtNewPassConfirm.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() ==  10) {
					
				}
			}
		});
		panel.add(txtNewPassConfirm, "6, 10, fill, fill");
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{lblNewLabel, lblNewLabel_1, lblNewLabel_2}));

		
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
	}

}
