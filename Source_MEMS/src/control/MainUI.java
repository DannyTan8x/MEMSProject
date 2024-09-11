package control;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.io.FileNotFoundException;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import control.UIComponents.JFoodterBar;
import control.UIComponents.JMyMenuBar;
import dao.impl.DbConnection;
import services.impl.DbSetupServiceImpl;
import java.awt.BorderLayout;
import javax.swing.JToolBar;
import javax.swing.JButton;
import com.jgoodies.forms.layout.FormLayout;
import com.jgoodies.forms.layout.ColumnSpec;
import com.jgoodies.forms.layout.RowSpec;
import com.jgoodies.forms.layout.FormSpecs;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;

import control.Account.LoginIntFrameUI;
import control.FrameControl;

public class MainUI extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static JDesktopPane desktopPane;
//	private static LoginIntFrameUI internalFrame;
	public static DbSetupServiceImpl dssi = new DbSetupServiceImpl();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainUI frame = new MainUI();
					frame.setLocationRelativeTo(null);
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					// Get the screen size and set the JFrame to full screen size
					Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setSize(screenSize.width, screenSize.height); // Set JFrame to full screen size

					frame.setVisible(true);
					// Add a ComponentListener to adjust the desktop pane size when the frame is resized
					frame.addComponentListener(new java.awt.event.ComponentAdapter() {
						@Override
						public void componentResized(java.awt.event.ComponentEvent e) {
							// Ensure desktopPane fills the entire frame
							desktopPane.setSize(frame.getSize());
//							centerInternalFrame(internalFrame, desktopPane); // Recenter the internal frame
							FrameControl.centerInternalFrame(FrameControl.internalLoginFrame, desktopPane);
						}
					});
					// Create and show the internal frame initially
//					MainUI.createInternalLoginFrame(desktopPane);
					FrameControl.createInternalLoginFrame(desktopPane);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws FileNotFoundException
	 */
	public MainUI() throws FileNotFoundException {
		setTitle("MEMS");
//		internalFrame = new LoginIntFrameUI();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JFoodterBar foodterBar = new JFoodterBar();
		contentPane.add(foodterBar, BorderLayout.SOUTH);
		
		 // Create the desktop pane
		desktopPane = new JDesktopPane();
		desktopPane.setBackground(Color.WHITE);
		contentPane.add(desktopPane, BorderLayout.CENTER);
		
		// Create menu bar and add menu items
		JMyMenuBar menuBar = new JMyMenuBar(FrameControl.internalLoginFrame, desktopPane);
		setJMenuBar(menuBar);
//		contentPane.add(menuBar, BorderLayout.NORTH);
		try {
			dssi.checkConnection();
			DbConnection.getDb();
		} catch (Exception e) {
			DbConnectionSetupUI frame = new DbConnectionSetupUI();
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
			dispose();
			e.printStackTrace();
		}

	}

}
