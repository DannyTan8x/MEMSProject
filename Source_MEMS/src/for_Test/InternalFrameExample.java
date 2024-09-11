package for_Test;

import javax.swing.*;

import control.Account.LoginIntFrameUI;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InternalFrameExample {
    private static JDesktopPane desktopPane;
    private static JInternalFrame internalFrame;

    public static void main(String[] args) {
        // Main frame setup
        JFrame frame = new JFrame("JInternalFrame Example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Get the screen size and set the JFrame to full screen size
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        frame.setSize(screenSize.width, screenSize.height); // Set JFrame to full screen size

        // Create the desktop pane
        desktopPane = new JDesktopPane();
        frame.setContentPane(desktopPane);

        // Create menu bar and add menu items
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");
        JMenuItem mntmLoginFrame = new JMenuItem("Re-open Frame");
        menu.add(mntmLoginFrame);
        menuBar.add(menu);
        frame.setJMenuBar(menuBar);

        // Add a ComponentListener to adjust the desktop pane size when the frame is resized
        frame.addComponentListener(new java.awt.event.ComponentAdapter() {
            @Override
            public void componentResized(java.awt.event.ComponentEvent e) {
                // Ensure desktopPane fills the entire frame
                desktopPane.setSize(frame.getSize());
                centerInternalFrame(internalFrame); // Recenter the internal frame
            }
        });

        // Create and show the internal frame initially
        createInternalFrame(desktopPane);

        // Add ActionListener to the menu item to reopen the internal frame
        mntmLoginFrame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Re-open the internal frame if it's closed
                if (internalFrame == null || internalFrame.isClosed()) {
                    createInternalFrame(desktopPane);
                } else {
                    // Bring the frame to the front and make it visible
                    internalFrame.toFront();
                    internalFrame.setVisible(true);
                }
                System.out.println("Menu item clicked");
            }
        });

        frame.setVisible(true);
    }

    private static void createInternalFrame(JDesktopPane desktopPane) {
        // Initialize the JInternalFrame with its properties
//        internalFrame = new LoginIntFrameUI(desktopPane);
    	internalFrame = new JInternalFrame();
        internalFrame.setSize(400, 300); // Set the size of the internal frame
        internalFrame.setDefaultCloseOperation(JInternalFrame.DISPOSE_ON_CLOSE); // Set to dispose on close

        // Create a close button
        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Dispose the internal frame when the button is clicked
                internalFrame.dispose();
            }
        });

        // Add the button to the internal frame's content pane
        internalFrame.getContentPane().setLayout(new FlowLayout()); // Set layout
        internalFrame.getContentPane().add(closeButton); // Add the button

        // Add the internal frame to the desktop pane
        desktopPane.add(internalFrame);

        // Center the internal frame within the desktop pane
        centerInternalFrame(internalFrame);

        // Set visible to true to display the internal frame
        internalFrame.setVisible(true);
    }

    private static void centerInternalFrame(JInternalFrame frame) {
        if (frame == null) return; // Handle case when frame is null

        // Ensure the desktop pane size is correctly set
        desktopPane.setSize(desktopPane.getParent().getSize());

        // Get the size of the desktop pane and the internal frame
        int desktopWidth = desktopPane.getWidth();
        int desktopHeight = desktopPane.getHeight();
        int frameWidth = frame.getWidth();
        int frameHeight = frame.getHeight();

        // Calculate x and y coordinates to center the frame
        int x = (desktopWidth - frameWidth) / 2;
        int y = (desktopHeight - frameHeight) / 2;

        // Set the location of the internal frame to the calculated coordinates
        frame.setLocation(x, y);
    }
}
