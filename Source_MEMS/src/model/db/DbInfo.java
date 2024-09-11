package model.db;

import java.io.Serializable; //需要這個個class 才能寫入 ObjectinputStream;

public class DbInfo implements Serializable {

	String dbType;
	String hostName;
	String port;
	String schema;
	String userName;
	String password;

	public DbInfo() {
		super();

	}

	public DbInfo(String dbType, String hostName, String port, String userName, String password) {
		super();
		this.dbType = dbType;
		this.hostName = hostName;
		this.port = port;
		this.userName = userName;
		this.password = password;
	}

	public String getDbType() {
		return dbType;
	}

	public void setDbType(String dbType) {
		this.dbType = dbType;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getPort() {
		return port;
	}

	public void setPort(String port) {
		this.port = port;
	}

	public String getSchema() {
		return schema;
	}

	public void setSchema(String schema) {
		this.schema = schema;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}
