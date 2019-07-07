package com.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rpg.constants.CharacterSqlQueries;
import com.rpg.entities.Character;
import com.rpg.util.DAOUtils;

public class CharacterDao implements AbstractDAO<Character> {

	@Override
	public List<Character> findAll() throws SQLException {
		List<Character> rpgCharacterList = new ArrayList<>();
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(CharacterSqlQueries.SELECT_ALL_CHARACTERS_QUERY);) {

			while (rs.next()) {
				rpgCharacterList.add(extractResultSet(rs));
			}
		}
		return rpgCharacterList;
	}

	@Override
	public Character findByName(String name) throws SQLException {
		ResultSet rs = null;
		try (Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(CharacterSqlQueries.SELECT_CHARACTER_QUERY_BY_NAME);) {
			stmt.setString(1, name);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return extractResultSet(rs);
			}
		} finally {
			DAOUtils.closeAll(rs);
		}
		return null;
	}

	@Override
	public Character findById(Integer characterId) throws SQLException {
		ResultSet rs = null;
		try (Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(CharacterSqlQueries.SELECT_CHARACTER_QUERY_BY_ID);) {
			stmt.setLong(1, characterId);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return extractResultSet(rs);
			}
		} finally {
			DAOUtils.closeAll(rs);
		}
		return null;
	}

	@Override
	public boolean save(Character rpgChar) throws SQLException {
		try (Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(CharacterSqlQueries.INSERT_CHARACTER_QUERY);) {
			stmt.setString(1, rpgChar.getCharacterName().toUpperCase());
			stmt.setInt(2, rpgChar.getExperience());
			stmt.setString(3, rpgChar.getWeapon());
			stmt.executeUpdate();
			return true;
		}
	}

	@Override
	public boolean update(Character rpgChar) throws SQLException {
		try (Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(CharacterSqlQueries.UPDATE_CHARACTER_QUERY);) {
			stmt.setInt(1, rpgChar.getExperience());
			stmt.setString(2, rpgChar.getCharacterName());
			stmt.executeUpdate();
			return true;
		}

	}

	private Character extractResultSet(ResultSet rs) throws SQLException {
		Character rpgChar = new Character();
		rpgChar.setId(rs.getInt("id"));
		rpgChar.setCharacterName(rs.getString("name"));
		rpgChar.setExperience(rs.getInt("experience"));
		rpgChar.setWeapon(rs.getString("weapon"));
		return rpgChar;

	}

	private Connection getConnection() throws SQLException {
		return DBConnection.getConnection();
	}

}
