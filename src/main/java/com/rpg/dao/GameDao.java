/*
 * Author M S Prasita Nair
 * 
 * The class is concrete implementation for GAMES_PLAYED Table operations
 * 
 */
package com.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rpg.constants.GameSqlQueries;
import com.rpg.entities.Game;
import com.rpg.util.DAOUtils;

public class GameDao implements AbstractDAO<Game> {

	@Override
	public List<Game> findAll() throws SQLException {
		List<Game> rpgGamesList = new ArrayList<>();
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(GameSqlQueries.SELECT_ALL_GAMES_QUERY);) {

			while (rs.next()) {
				rpgGamesList.add(extractResultSet(rs));
			}
			return rpgGamesList;
		}
	}

	@Override
	public Game findByName(String name) throws SQLException {
		ResultSet rs = null;
		try (Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(GameSqlQueries.SELECT_GAME_QUERY_BY_NAME);) {
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
	public Game findById(Integer id) throws SQLException {
		ResultSet rs = null;
		try (Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(GameSqlQueries.SELECT_GAME_QUERY_BY_ID);) {
			stmt.setInt(1, id);
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
	public boolean save(Game rpgGame) throws SQLException {
		ResultSet rs = null;
		try (Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(GameSqlQueries.INSERT_GAME_QUERY);) {
			stmt.setString(1, rpgGame.getGameName());
			stmt.setInt(2, rpgGame.getCharacterId());
			stmt.executeUpdate();
			return true;
		} finally {
			DAOUtils.closeAll(rs);
		}
	}

	@Override
	public boolean update(Game rpgGame) throws SQLException {
		try (Connection con = getConnection();
				PreparedStatement stmt = con.prepareStatement(GameSqlQueries.UPDATE_GAME_QUERY);) {
			stmt.setString(1, rpgGame.getGameName());
			stmt.setInt(2, rpgGame.getGameId());
			stmt.executeUpdate();
			return true;
		}
	}

	private Connection getConnection() throws SQLException {
		return DBConnection.getConnection();
	}

	private Game extractResultSet(ResultSet rs) throws SQLException {
		Game rpgGame = new Game();
		rpgGame.setGameId(rs.getInt("id"));
		rpgGame.setCharacterId(rs.getInt("character_id"));
		rpgGame.setGameName(rs.getString("name"));
		return rpgGame;

	}

}
