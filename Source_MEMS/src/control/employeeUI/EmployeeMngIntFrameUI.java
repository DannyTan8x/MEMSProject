package control.employeeUI;

import java.awt.EventQueue;

import javax.swing.JDesktopPane;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import java.awt.GridLayout;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JLabel;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.FormSpecs;
import com.jgoodies.forms.layout.RowSpec;

import Utilities.EmployeeTableModel;
import control.FrameControl;
import model.table.Employee;
import model.view.EmployeeInfo;
import services.impl.DepartmentServiceImpl;
import services.impl.EmployeeServiceImple;
import services.impl.ViewEmployeeInfoServiceImpl;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.awt.FlowLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class EmployeeMngIntFrameUI extends JInternalFrame {

	private static final long serialVersionUID = 1L;
	private JTable emInfoTable;
	private static JTextField txtKeyword;
	private JTextField txtEmFirstName;
	private JTextField txtEmLastName;
	private JTextField txtPosition;
	static EmployeeTableModel emTableModel;
	private static DefaultListModel<String> listModel; // Model to hold employee names
	private EmployeeInfo selectedEm;
	private static JList listDept;
	static ViewEmployeeInfoServiceImpl veisi = new ViewEmployeeInfoServiceImpl();
	EmployeeServiceImple esi = new EmployeeServiceImple();
	DepartmentServiceImpl dsi = new DepartmentServiceImpl();

	/**
	 * Create the frame.
	 */
	public EmployeeMngIntFrameUI(JDesktopPane desktopPane) {
		
		setTitle("人員管理");
		setIconifiable(true);
		setBounds(100, 100, 450, 300);
		int top = 20; // margin on the top
		int left = 20; // margin on the left
		int bottom = 20; // margin on the bottom
		int right = 20; // margin on the right
//        contentPanel.setBorder(new EmptyBorder(top, left, bottom, right));
		JPanel searchBarpanel = new JPanel();
		searchBarpanel.setBorder(new EmptyBorder(top, left, bottom, right));
		getContentPane().add(searchBarpanel, BorderLayout.NORTH);
		GridBagLayout gbl_searchBarpanel = new GridBagLayout();
		gbl_searchBarpanel.columnWidths = new int[] { 130, 117, 0, 0 };
		gbl_searchBarpanel.rowHeights = new int[] { 29, 0 };
		gbl_searchBarpanel.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_searchBarpanel.rowWeights = new double[] { 0.0, Double.MIN_VALUE };
		searchBarpanel.setLayout(gbl_searchBarpanel);

		txtKeyword = new JTextField();
		txtKeyword.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == 10) {
					refreshEmployeeTable();
				};
			}
		});
		GridBagConstraints gbc_txtKeyword = new GridBagConstraints();
		gbc_txtKeyword.fill = GridBagConstraints.HORIZONTAL;
		gbc_txtKeyword.insets = new Insets(0, 0, 0, 5);
		gbc_txtKeyword.gridx = 0;
		gbc_txtKeyword.gridy = 0;
		searchBarpanel.add(txtKeyword, gbc_txtKeyword);
		txtKeyword.setColumns(10);
		//initialize Employee table data
		List<EmployeeInfo> employees = veisi.listEmployeeTabelwidtKeyword(txtKeyword.getText());
		emTableModel = new EmployeeTableModel(employees);
		emTableModel.setEmployees(employees);
		
		
		JButton btnSearch = new JButton("篩選");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				refreshEmployeeTable();
			}
		});
		GridBagConstraints gbc_btnSearch = new GridBagConstraints();
		gbc_btnSearch.insets = new Insets(0, 0, 0, 5);
		gbc_btnSearch.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSearch.gridx = 1;
		gbc_btnSearch.gridy = 0;
		searchBarpanel.add(btnSearch, gbc_btnSearch);

		JPanel JtabelPanel = new JPanel();
		JtabelPanel.setBorder(new EmptyBorder(0, left, 0, right));
		getContentPane().add(JtabelPanel, BorderLayout.CENTER);
		JtabelPanel.setLayout(new GridLayout(0, 1, 10, 0));

		JScrollPane scrollPane = new JScrollPane();
		
		JtabelPanel.add(scrollPane);
		
		emInfoTable = new JTable(emTableModel);
		
		scrollPane.setViewportView(emInfoTable);

		JPanel btnPanel = new JPanel();
		btnPanel.setBorder(new EmptyBorder(0, left, 0, right));
		FlowLayout flowLayout = (FlowLayout) btnPanel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		getContentPane().add(btnPanel, BorderLayout.SOUTH);

		JButton btnNewButton_1 = new JButton("關閉");
		
		btnPanel.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("新增");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				FrameControl.createInternalEmployeeCreation(desktopPane);
			}
		});
		btnPanel.add(btnNewButton_2);

		JPanel EmInfoPanel = new JPanel();
		EmInfoPanel.setBorder(new EmptyBorder(0, left, 0, right));
		getContentPane().add(EmInfoPanel, BorderLayout.EAST);
		EmInfoPanel.setLayout(new FormLayout(
				new ColumnSpec[] { FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("61px"),
						FormSpecs.RELATED_GAP_COLSPEC, ColumnSpec.decode("130px:grow"), },
				new RowSpec[] { FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("26px"), FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC,
						FormSpecs.RELATED_GAP_ROWSPEC, FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC,
						FormSpecs.DEFAULT_ROWSPEC, FormSpecs.RELATED_GAP_ROWSPEC, RowSpec.decode("default:grow"), }));

		JLabel lblNewLabel = new JLabel("姓：");
		EmInfoPanel.add(lblNewLabel, "2, 2, left, center");

		txtEmFirstName = new JTextField();
	
		
		
		
		txtEmFirstName.setEnabled(false);
		EmInfoPanel.add(txtEmFirstName, "4, 2, left, fill");
		txtEmFirstName.setColumns(10);

		JLabel lblNewLabel_1 = new JLabel("名：");
		EmInfoPanel.add(lblNewLabel_1, "2, 4, left, default");

		txtEmLastName = new JTextField();
		
		
		txtEmLastName.setEnabled(false);
		EmInfoPanel.add(txtEmLastName, "4, 4, fill, fill");
		txtEmLastName.setColumns(10);

		JLabel lblNewLabel_2 = new JLabel("職稱：");
		EmInfoPanel.add(lblNewLabel_2, "2, 6, left, default");

		txtPosition = new JTextField();
		
		txtPosition.setEnabled(false);
		EmInfoPanel.add(txtPosition, "4, 6, fill, fill");
		txtPosition.setColumns(10);

		JLabel lblNewLabel_3 = new JLabel("部門：");
		EmInfoPanel.add(lblNewLabel_3, "2, 8");
		
		listModel = new DefaultListModel<>();
		
		dsi.selectAll().stream()
		.forEach((t) -> listModel.addElement(t.getDept_name()));
        
		listDept = new JList(listModel);
		
		listDept.setEnabled(false);
		listDept.setVisibleRowCount(1);
		EmInfoPanel.add(listDept, "4, 8, fill, fill");

		JButton btnUpdate = new JButton("變更");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee em = new Employee();
				String changedDept = listDept.getSelectedValue().toString();
				em.setId(selectedEm.getId());
				em.setFirst_name(txtEmFirstName.getText());
				em.setLast_name(txtEmLastName.getText());
				em.setPosition(txtPosition.getText());
				em.setUser_id(selectedEm.getUserId());
				em.setDept_id(dsi.selectByName(changedDept).getDept_id());
				esi.updateEmployee(em);
				refreshEmployeeTable();
				btnUpdate.setEnabled(false);
				
			}

			
		});
		btnUpdate.setEnabled(false);
		EmInfoPanel.add(btnUpdate, "4, 10");
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			dispose();
			}
		});
		emInfoTable.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//table_product.getValueAt(table_product.getSelectedRow(), 0)
				btnUpdate.setEnabled(false);
				selectedEm = veisi.getEmInfoById( (Integer)emInfoTable.getValueAt(emInfoTable.getSelectedRow(), 0)); 
				txtEmFirstName.setEnabled(true);
				txtEmLastName.setEnabled(true);
				txtPosition.setEnabled(true);
				listDept.setEnabled(true);
				
				txtEmFirstName.setText(selectedEm.getFirstName());
				txtEmLastName.setText(selectedEm.getLastName());
				txtPosition.setText(selectedEm.getPosition());
				selectListItemByName(selectedEm.getDeptName());
//				listDept.setSelectedIndex(selectedEm.getDeptId()-1);
				
//				System.out.println(selectedEm.getFirstName() + selectedEm.getLastName()+selectedEm.getDeptName());
			}
		});
		txtEmFirstName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				btnUpdate.setEnabled(true);
			}
		});
		txtEmLastName.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				btnUpdate.setEnabled(true);
			}
		});
		txtPosition.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				btnUpdate.setEnabled(true);
			}
		});
		listDept.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				btnUpdate.setEnabled(true);
			}
		});

	}
	public static void refreshEmployeeTable() {
		List<EmployeeInfo> employees = veisi.listEmployeeTabelwidtKeyword(txtKeyword.getText());
		emTableModel.setEmployees(employees);
	}
	// Method to select an item in the JList by matching the given name
    private static void selectListItemByName(String name) {
        for (int i = 0; i < listModel.getSize(); i++) {
            String listItem = listModel.getElementAt(i);
            if (listItem.equals(name)) {
            	listDept.setSelectedIndex(i); // Select the matching item
            	listDept.ensureIndexIsVisible(i); // Ensure the selected item is visible
//            	listDept.showMessageDialog(null, "Selected: " + listItem);
                return;
            }
        }
        JOptionPane.showMessageDialog(null, "Item not found: " + name);
    }

}
