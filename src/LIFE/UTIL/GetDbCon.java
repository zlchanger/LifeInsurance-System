package LIFE.UTIL;

import java.sql.*;

public class GetDbCon {
	private Driver drv;
	private Connection con;

	public GetDbCon() {
		super();
	}

	public void ConnectionClose() {
		try {
			if (con == null) {
				con.close();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

	public void DBDriverLoad() {
		String DriverName = "oracle.jdbc.driver.OracleDriver";
		try {
			drv = (Driver)Class.forName(DriverName).newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public Connection getConnection() throws NwException {
		if (drv == null) {
			throw new NwException();
		}
		
		try {
			String dbURL = "jdbc:oracle:thin:@CZL-PC:1521:bishe";
			String userName = "system";
			String password = "passwd";
			con = DriverManager.getConnection(dbURL,userName,password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
