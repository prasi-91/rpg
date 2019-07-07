/*
 * Author M S Prasita Nair
 * 
 * Class to return Connection Object to the DB
 * 
 */

package com.rpg.dao;

import java.sql.Connection;
import java.sql.SQLException;

import org.sqlite.SQLiteDataSource;

import com.rpg.constants.GameConstants;

public class DBConnection {

	public static final String URL = GameConstants.URL_PREFIX + System.getProperty("user.dir") + GameConstants.URL_SUFFIX;

	public static Connection getConnection() throws SQLException {
		SQLiteDataSource ds = new SQLiteDataSource();
		ds.setUrl(URL);
		return ds.getConnection();

	}
}
