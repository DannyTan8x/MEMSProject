package services.impl;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import control.DbConnectionSetupUI;
import dao.impl.DbConnection;
import dao.impl.SchemaMemsDaoImpl;
import model.db.DbInfo;
import services.DbSetupSevrice;

public class DbSetupServiceImpl implements DbSetupSevrice {
	SchemaMemsDaoImpl smdi = new SchemaMemsDaoImpl();

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean checkConnection() throws Exception {
		DbInfo dbinfo = null;
		dbinfo = DbConnection.readDbInfoFile();

		return DbConnection.testConnection(dbinfo);
	}

	@Override
	public void testConnection(DbInfo dbinfo) {
		DbConnection.testConnection(dbinfo);
		DbConnection.recordDbInfo(dbinfo);
	}

	@Override
	public void setupSchema(DbInfo dbinfo) {
		// create Schema mems;
		if (!smdi.checkSchemaIsExist()) {
			smdi.createMems();

		}
		dbinfo.setSchema("mems");
		// use mems;
		smdi.useMems();
		// save config.properties;
		DbConnection.recordDbInfo(dbinfo);
	}

	@Override
	public boolean checkShemaIsExist() {
		return smdi.checkSchemaIsExist();
	}

	private static String loadSQLFromFile(String filePath) throws IOException {
		StringBuilder sqlBuilder = new StringBuilder();
		try (InputStream inputStream = DbSetupServiceImpl.class.getResourceAsStream(filePath);
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
			String line;
			while ((line = reader.readLine()) != null) {
				sqlBuilder.append(line).append("\n");
			}
		}
		return sqlBuilder.toString();
//		
	
		    
//		    // Reading the file using UTF-8 encoding
//		    try (BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(filePath), StandardCharsets.UTF_8))) {
//		        String line;
//		        while ((line = reader.readLine()) != null) {
//		            sqlBuilder.append(line).append("\n");
//		        }
//		    }
//		    
//		    return sqlBuilder.toString();
//		
		
	}

	private void executeSqlFromFile(String sqlFilePath) {
		try (Connection conn = DbConnection.getDb()) {
			conn.setAutoCommit(false); // Start transaction

			try (Statement stmt = conn.createStatement()) {
				String sqlCommands = loadSQLFromFile(sqlFilePath);
				String[] commands = sqlCommands.split("(?<=;)(?=\\s*\\r?\\n)"); // Split commands by semicolons and new
																				// lines

				for (String command : commands) {
					if (command.trim().length() > 0) {
						stmt.addBatch(command);
					}
				}

				stmt.executeBatch(); // Execute all statements in the batch

				conn.commit(); // Commit transaction
				System.out.println("SQL script executed successfully.");
				JOptionPane.showMessageDialog(null, "SQL script executed successfully.", "Information", JOptionPane.INFORMATION_MESSAGE);
			} catch (SQLException e) {
				conn.rollback(); // Rollback on error
				System.err.println("SQL error: " + e.getMessage());
				JOptionPane.showMessageDialog(null, "SQL error: " + e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
			}
		} catch (SQLException e) {
			System.err.println("Database connection error: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Database connection error: " + e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
			//disconnect reconfig
			
			DbConnectionSetupUI frame = new DbConnectionSetupUI();
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			frame.setVisible(true);
		} catch (IOException e) {
			System.err.println("Error reading SQL file: " + e.getMessage());
			JOptionPane.showMessageDialog(null, "Error reading SQL file: " + e.getMessage(), "Warning", JOptionPane.WARNING_MESSAGE);
		}
	}

	public void initializeSQLTable() {

		String sqlFilePath = "/InitializeSQL/initializeDataTable.sql";
		executeSqlFromFile(sqlFilePath);
	}

	public void initializeSQLData() {
		
		String sqlFilePath = "/InitializeSQL/initializeSQLquery.sql";
		executeSqlFromFile(sqlFilePath);
	}
}
