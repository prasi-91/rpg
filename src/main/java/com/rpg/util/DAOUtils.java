package com.rpg.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOUtils {

	public static void closeAll(ResultSet rs, Connection con, Statement stmt) throws SQLException {
		if (rs != null) {
			rs.close();
		}
		stmt.close();
		con.close();
	}

}
