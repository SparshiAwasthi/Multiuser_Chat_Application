package com.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import static com.utils.ConfigReader.getValue;

public interface CommonDAO {
	public static Connection createConnection() throws ClassNotFoundException, SQLException {
		Class.forName(getValue("Driver"));
		
		final String url = getValue("Connection_url");
		final String user = getValue("userId");
		final String pass = getValue("Password");
		Connection con = (Connection) DriverManager.getConnection(url, user, pass);
		
		if(con != null)
		{
			System.out.println("Connection created....");
		}
		return con;
	}
}
