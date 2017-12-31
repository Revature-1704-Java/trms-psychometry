package com.revature.util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class ConnectionUtil {

	public static Connection getConn() throws SQLException, IOException{
		InputStream in = new FileInputStream("connection.properties");
		Properties prop = new Properties();
		prop.load(in);
		String url = prop.getProperty("url");
		String user = prop.getProperty("user");
		String password = prop.getProperty("password");
		in.close();
		return DriverManager.getConnection(url,user,password);
	}

}
