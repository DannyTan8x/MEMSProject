package control.employeeUI;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;

import services.impl.DepartmentServiceImpl;
import services.impl.EmployeeServiceImple;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;

import model.table.Employee;

import com.jgoodies.forms.layout.FormSpecs;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;

public class EmployeeCreationIntFrameUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	EmployeeServiceImple esi = new EmployeeServiceImple();
	DepartmentServiceImpl dsi = new DepartmentServiceImpl();
	private JTextField txtEmFirstName;
	private JTextField txtEmLastName;
	private JTextField txtPosition;
	private static DefaultListModel<String> listModel; 
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					EmployeeCreationIntFrameUI frame = new EmployeeCreationIntFrameUI();
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
	public EmployeeCreationIntFrameUI(JDesktopPane desktopPane) {
		setTitle("新增員工");
		setBounds(100, 100, 450, 300);
		int top = 20; // margin on the top
		int left = 20; // margin on the left
		int bottom = 20; // margin on the bottom
		int right = 20; // margin on the right
		JPanel panel = new JPanel();
		panel.setBorder(new EmptyBorder(top, left, bottom, right));
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
				RowSpec.decode("default:grow"),}));

		JLabel lblNewLabel = new JLabel("姓氏：");
		lblNewLabel.setToolTipText("");
		panel.add(lblNewLabel, "4, 4, right, default");

		txtEmFirstName = new JTextField();
		panel.add(txtEmFirstName, "6, 4, fill, default");
		txtEmFirstName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("名字：");
		panel.add(lblNewLabel_1, "4, 6, right, default");

		txtEmLastName = new JTextField();
		txtEmLastName.setColumns(10);
		panel.add(txtEmLastName, "6, 6, fill, default");

		JLabel lblNewLabel_2 = new JLabel("職稱：");
		panel.add(lblNewLabel_2, "4, 8, right, default");

		txtPosition = new JTextField();
		txtPosition.setColumns(10);
		panel.add(txtPosition, "6, 8, fill, default");

		JLabel lblNewLabel_3 = new JLabel("部門：");
		panel.add(lblNewLabel_3, "4, 10, right, top");
		listModel = new DefaultListModel<>();

		dsi.selectAll().stream().forEach((t) -> listModel.addElement(t.getDept_name()));
		
		JScrollPane scrollPane = new JScrollPane();
		panel.add(scrollPane, "6, 10, fill, fill");
		JList listDept = new JList(listModel);
		scrollPane.setViewportView(listDept);
		listDept.setVisibleRowCount(1);

		JPanel tbnPanel = new JPanel();
		getContentPane().add(tbnPanel, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("取消");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		tbnPanel.add(btnNewButton);

		JButton btnAddNew = new JButton("新增");
		btnAddNew.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee em = new Employee();
				try {
					String changedDept = listDept.getSelectedValue().toString();
					esi.newEmployee(txtEmFirstName.getText(), txtEmLastName.getText(),txtPosition.getText(), dsi.selectByName(changedDept).getDept_id());
					EmployeeMngIntFrameUI.refreshEmployeeTable();
					dispose();
				}catch(NullPointerException e1) {
					JOptionPane.showMessageDialog(null, "個項目不能留空，注意部門為必選。", "Information", JOptionPane.INFORMATION_MESSAGE);
				}
				
			}
		});
		tbnPanel.add(btnAddNew);

	}

}
