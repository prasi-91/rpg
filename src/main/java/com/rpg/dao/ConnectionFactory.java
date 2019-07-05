package com.rpg.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

import com.rpg.constants.RpGameConstants;

public class ConnectionFactory {

	public static Connection getConnection() throws SQLException {
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl(RpGameConstants.URL);
		return ds.getConnection();

	}
}
