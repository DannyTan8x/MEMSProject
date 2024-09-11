package dao;

import java.sql.Connection;

import model.db.DbInfo;

public interface DbConnectionDao {
	
	Void testConnection (DbInfo dbinfo);
	Connection getDb();
//	List<dbUser> outPutDbUser

}
