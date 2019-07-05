package com.rpg.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

import com.rpg.constants.RpGameConstants;

public class ConnectionFactory {

	public static final String URL = RpGameConstants.URL_PREFIX + System.getProperty("user.dir") + RpGameConstants.URL_SUFFIX;

	public static Connection getConnection() throws SQLException {
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl(URL);
		return ds.getConnection();

	}
}
