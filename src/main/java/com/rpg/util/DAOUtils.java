package com.rpg.util;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOUtils {

	public static void closeAll(ResultSet rs) throws SQLException {
		if (rs != null) {
			rs.close();
		}
	}

}
