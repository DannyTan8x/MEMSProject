package dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.SchemaMemsDao;

public class SchemaMemsDaoImpl implements SchemaMemsDao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void createMems() {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "CREATE SCHEMA IF NOT EXISTS Mems";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void useMems() {
		// TODO Auto-generated method stub
		Connection conn = DbConnection.getDb();
		String SQL = "USE mems";

		try {
			PreparedStatement ps = conn.prepareStatement(SQL);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public boolean checkSchemaIsExist() {
		boolean exists = false;
		try {
			// Register JDBC driver
			Class.forName("com.mysql.cj.jdbc.Driver");

			// Open a connection
			Connection conn = DbConnection.getDb();

			// Get the database metadata
			ResultSet resultSet = conn.getMetaData().getCatalogs();

			// Iterate through the catalogs to check if the database exists
			while (resultSet.next()) {
				String databaseName = resultSet.getString(1);
				if (databaseName.equals("mems")) {
					exists = true;
					break;
				}
			}

			resultSet.close();
			conn.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return exists;
	}

	
}
