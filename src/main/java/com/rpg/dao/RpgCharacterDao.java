package com.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rpg.constants.RpgCharacterQueries;
import com.rpg.domain.RpgCharacter;
import com.rpg.util.DAOUtils;

public class RpgCharacterDao implements AbstractDAO<RpgCharacter> {

	@Override
	public List<RpgCharacter> findAll() throws SQLException {
		String query = RpgCharacterQueries.SELECT_ALL_CHARACTERS_QUERY;
		List<RpgCharacter> rpgCharacterList = new ArrayList<>();
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				rpgCharacterList.add(extractResultSet(rs));
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			stmt.close();
			con.close();
		}

		return rpgCharacterList;
	}

	@Override
	public RpgCharacter findByName(String name) throws SQLException {
		String query = RpgCharacterQueries.SELECT_CHARACTER_QUERY_BY_NAME;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, name);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return extractResultSet(rs);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			DAOUtils.closeAll(rs, con, stmt);
		}
		return null;

	}

	@Override
	public boolean save(RpgCharacter rpgChar) throws SQLException {
		String query = RpgCharacterQueries.INSERT_CHARACTER_QUERY;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, rpgChar.getCharacterName().toUpperCase());
			stmt.setInt(2, rpgChar.getExperience());
			stmt.setString(3, rpgChar.getWeapon());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw e;
		} finally {
			DAOUtils.closeAll(null, con, stmt);
		}
	}

	@Override
	public boolean update(RpgCharacter rpgChar) throws SQLException {
		final String query = RpgCharacterQueries.UPDATE_CHARACTER_QUERY;
		Connection con = null;
		PreparedStatement stmt = null;

		try {
			con = getConnection();
			stmt = con.prepareStatement(query);
			stmt.setInt(1, rpgChar.getExperience());
			stmt.setString(2, rpgChar.getCharacterName());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw e;
		} finally {
			DAOUtils.closeAll(null, con, stmt);
		}

	}

	private RpgCharacter extractResultSet(ResultSet rs) throws SQLException {
		RpgCharacter rpgChar = new RpgCharacter();
		rpgChar.setId(rs.getLong("id"));
		rpgChar.setCharacterName(rs.getString("name"));
		rpgChar.setExperience(rs.getInt("experience"));
		rpgChar.setWeapon(rs.getString("weapon"));
		return rpgChar;

	}

	@Override
	public RpgCharacter findById(Long characterId) throws SQLException {
		final String query = RpgCharacterQueries.SELECT_CHARACTER_QUERY_BY_ID;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(query);
			stmt.setLong(1, characterId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return extractResultSet(rs);
			}
		} catch (SQLException e) {
			throw e;
		} finally {
			DAOUtils.closeAll(rs, con, stmt);
		}
		return null;
	}

	private Connection getConnection() throws SQLException {
		return ConnectionFactory.getConnection();
	}

}