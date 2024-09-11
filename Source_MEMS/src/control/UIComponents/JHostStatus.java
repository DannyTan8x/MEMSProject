package control.UIComponents;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

import control.DbConnectionSetupUI;
import dao.impl.DbConnection;
import model.db.DbInfo;

public class JHostStatus extends JLabel {
	public JHostStatus() throws FileNotFoundException {
		super("hostname:" + "\tprot:");
//		Timer timer = new Timer(1000, new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				checkStatus();
//			}
//		});
//		timer.start();
		
		
	
			scheduleCheck();
	
		
		
		
	}

	private void checkStatus() {
		String hostStatus;
		
		try {
			DbInfo dbInfo = DbConnection.readDbInfoFile();
			
			String status = DbConnection.testConnection(dbInfo) ? "Connected" : "Disconnect!";

			hostStatus= DbConnection.testConnection(dbInfo) ? dbInfo.getHostName() + ":" + dbInfo.getPort() + "\t=== Status: Connected" : "Disconnect!";
		}catch(Exception e) {
			
			hostStatus = "Not connected!";
		}
		
		updateText(hostStatus);
	}
	
	
	private void scheduleCheck() throws FileNotFoundException {
		
		// Schedule the connection check to run periodically
        ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);

        // Define the task that checks the connection
        Runnable checkConnectionTask = () -> {
        	String hostStatus;
        	DbInfo dbInfo;
			try {
				dbInfo = DbConnection.readDbInfoFile();
				 boolean isConnected = DbConnection.testConnection(dbInfo);
		            String status = DbConnection.testConnection(dbInfo) ? "Connected" : "Disconnect!";

					hostStatus= isConnected ? dbInfo.getHostName() + ":" + dbInfo.getPort() + "\t=== Status: Connected" : "Disconnect!";
		            if (isConnected) {
		                System.out.println("Database is connected and accessible.");
		            } else {
		                System.out.println("Database is not accessible.");
		            }
		            updateText(hostStatus);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
           
        	
        };

        // Schedule the task to run every 30 seconds
        int initialDelay = 0; // Delay before the first execution
        int period = 10;      // Time period between successive executions (in seconds)
        scheduler.scheduleAtFixedRate(checkConnectionTask, initialDelay, period, TimeUnit.SECONDS);

        // This will keep running; add shutdown logic as needed
    	
	}

	protected void updateText(String text) {
		super.setText(text);
	}

}
