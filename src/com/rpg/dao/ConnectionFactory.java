package com.rpg.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import com.rpg.constants.RpGameConstants;

public class ConnectionFactory {

	public static Connection getConnection() throws ClassNotFoundException {
		try {
			Class.forName("org.apache.derby.jdbc.ClientDriver");
			return DriverManager.getConnection(RpGameConstants.URL, RpGameConstants.USER, RpGameConstants.PASS);
		} catch (SQLException ex) {
			throw new RuntimeException("Error connecting to the database", ex);
		}
	}
}
