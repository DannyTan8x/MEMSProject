package for_Test;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.UIComponents.JFoodterBar;

import java.awt.GridLayout;
import java.beans.PropertyVetoException;

import javax.swing.JInternalFrame;
import javax.swing.JLayeredPane;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JToolBar;
import javax.swing.UIManager;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class testUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					testUI frame = new testUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws PropertyVetoException 
	 */
	public testUI() throws PropertyVetoException {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 704, 557);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnNewMenu = new JMenu("New menu");
		menuBar.add(mnNewMenu);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("New menu item");
	
		mnNewMenu.add(mntmNewMenuItem);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JLayeredPane layeredPane = new JLayeredPane();
		contentPane.add(layeredPane);
		layeredPane.setLayout(new GridLayout(0, 1, 0, 0));
		
		JDesktopPane desktopPane = new JDesktopPane();
		layeredPane.add(desktopPane);
		
		JInternalFrame internalFrame = new JInternalFrame("New JInternalFrame");
		internalFrame.setMaximum(true);
		internalFrame.setMaximizable(true);
		internalFrame.setIconifiable(true);
		internalFrame.setClosable(true);
		
		internalFrame.setBounds(0, 0, 221, 205);
		desktopPane.add(internalFrame);
		internalFrame.setVisible(true);
		
		JPanel menu_Panel = new JPanel();
		menu_Panel.setBorder(UIManager.getBorder("MenuBar.border"));
		contentPane.add(menu_Panel, BorderLayout.WEST);
		GridBagLayout gbl_menu_Panel = new GridBagLayout();
		gbl_menu_Panel.columnWidths = new int[]{108, 0};
		gbl_menu_Panel.rowHeights = new int[] {0, 0};
		gbl_menu_Panel.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_menu_Panel.rowWeights = new double[]{0.0, Double.MIN_VALUE};
		menu_Panel.setLayout(gbl_menu_Panel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.anchor = GridBagConstraints.NORTH;
		gbc_lblNewLabel_1.fill = GridBagConstraints.HORIZONTAL;
		gbc_lblNewLabel_1.gridx = 0;
		gbc_lblNewLabel_1.gridy = 0;
		menu_Panel.add(lblNewLabel_1, gbc_lblNewLabel_1);
		
		JToolBar toolBar_1 = new JToolBar();
		contentPane.add(toolBar_1, BorderLayout.NORTH);
		
		mntmNewMenuItem.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				desktopPane.add(internalFrame);
				internalFrame.setVisible(true);
				System.out.print("clicked");
			
			}
		});
	}
}
