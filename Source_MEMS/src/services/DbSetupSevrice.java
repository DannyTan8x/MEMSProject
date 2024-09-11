package services;

import java.io.FileNotFoundException;

import model.db.DbInfo;

public interface DbSetupSevrice {

	void testConnection(DbInfo dbinfo);

	boolean checkConnection() throws FileNotFoundException, Exception;

	boolean checkShemaIsExist();

	void setupSchema(DbInfo dbinfo);

	void initializeSQLTable();

	void initializeSQLData();
}
