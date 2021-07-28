package com.hospital.util;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.*;


public class DBConnection extends CommonUtilities{
	private static Connection connection;
	
	
	private DBConnection() {
	}
	public static Connection getDBConnection() throws SQLException, ClassNotFoundException {
		if(connection == null || connection.isClosed()) {
			Class.forName(properties.getProperty("driverName"));
			connection = DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
		}
		return connection;
	}
}
