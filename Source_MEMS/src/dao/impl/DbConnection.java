package dao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStreamWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//import java.util.Properties;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import control.DbConnectionSetupUI;
import model.db.DbInfo;

public class DbConnection {
	public static String statusString;

	public static void main(String[] args) {
//		DbConnection dbConnection = new DbConnection();
//		DbConnection.getDb();

//		DbConnection.testConnection(DbConnection.readDbInfoFile());
//		DbConnection.recordSQLFile(InitializeSQL.SystemData.mySQLTablesQuery, "initializeDataTable");
//		DbConnection.recordSQLFile(InitializeSQL.SystemData.mySQLDataQuery, "InitializeSQLquery");
	}

	/*
	 * public static Connection getDb() { Connection conn = null; String URI =
	 * "jdbc:mysql://localhost:3306"; String username = "root"; String password =
	 * "1234";
	 * 
	 * try { Class.forName("com.mysql.cj.jdbc.Driver"); conn =
	 * DriverManager.getConnection(URI, username, password);
	 * System.out.println("Connected!"); } catch (ClassNotFoundException e) {
	 * System.out.println("No Driver"); e.printStackTrace(); } catch (SQLException
	 * e) { // TODO Auto-generated catch block System.out.println("No connection");
	 * e.printStackTrace(); } return conn; }
	 */
	public static DbInfo readDbInfoFile() throws Exception {
		DbInfo dbInfo = null;
		ObjectInputStream ois = null;
		FileInputStream fis;
		
			fis = new FileInputStream("System/.properties");
			ois = new ObjectInputStream(fis);
		

		while (true) {
			try {
				dbInfo = ((DbInfo) ois.readObject());
			} catch (Exception e) {
				// TODO Auto-generated catch block
				System.out.println("Connecting...");
//				e.printStackTrace();
				break;
			}
		}

		return dbInfo;
	}

	public static Connection getDb() {
		Connection conn = null;

		String URI = null;
		String username = null;
		String password = null;
		DbInfo dbInfo;
		

		
		
			try {
				dbInfo = readDbInfoFile();
				String schema = (dbInfo.getSchema() == null) ? "" : "/" + dbInfo.getSchema();
				URI = "jdbc:" + dbInfo.getDbType() + ":" + "//" + dbInfo.getHostName() + ":" + dbInfo.getPort() + schema;
				username = dbInfo.getUserName();
				password = (dbInfo.getPassword() != null) ? dbInfo.getPassword() : "";
				try {	 
					Class.forName("com.mysql.cj.jdbc.Driver");
					conn = DriverManager.getConnection(URI, username, password);

					System.out.println("Connected!" + URI);
				} catch (ClassNotFoundException e) {
					System.out.println("No Driver");
					e.printStackTrace();

				} catch (SQLException e) {
					// TODO Auto-generated catch block
					System.out.println("No connection");
					JOptionPane.showMessageDialog(null, "No connection: " + e.getMessage(), "Warning",
							JOptionPane.WARNING_MESSAGE);
					e.printStackTrace();
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		

		return conn;
	}

	public static Boolean testConnection(DbInfo dbinfo) {
		Connection conn = null;
		boolean connected = false;
		String schema = (dbinfo.getSchema() == null) ? "" : "/" + dbinfo.getSchema();
		String URI = "jdbc:" + dbinfo.getDbType() + ":" + "//" + dbinfo.getHostName() + ":" + dbinfo.getPort() + schema;
		String username = dbinfo.getUserName();
		String password = dbinfo.getPassword();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(URI, username, password);
			statusString = "Connected!";
			connected = true;

//			System.out.println("Connected!");
		} catch (ClassNotFoundException e) {
			statusString = "No Driver";
//			System.out.println("No Driver");
			JOptionPane.showMessageDialog(null, "No Driver: " + e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			statusString = "No connection";
			JOptionPane.showMessageDialog(null, "No connection: " + e.getMessage(), "Warning",
					JOptionPane.WARNING_MESSAGE);

//			System.out.println("No connection");
			e.printStackTrace();
		}
//		System.out.println(connected);
		return connected;
	}

	public static void recordDbInfo(DbInfo dbinfo) {
		FileOutputStream fos;
		try {
			File f = new File("System");
			if (!f.exists()) {
				System.out.println("mkdir!");
				f.mkdir();
			}

			fos = new FileOutputStream("System/.properties");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(dbinfo);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
