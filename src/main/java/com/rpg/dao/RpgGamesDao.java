package com.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.rpg.constants.RpgGameQueries;
import com.rpg.domain.RpgGames;
import com.rpg.util.DAOUtils;

public class RpgGamesDao implements AbstractDAO<RpgGames> {

	@Override
	public List<RpgGames> findAll() throws SQLException {
		String query = RpgGameQueries.SELECT_ALL_GAMES_QUERY;
		List<RpgGames> rpgGamesList = new ArrayList<>();
		try (Connection con = getConnection();
				Statement stmt = con.createStatement();
				ResultSet rs = stmt.executeQuery(query);) {

			while (rs.next()) {
				rpgGamesList.add(extractResultSet(rs));
			}
			return rpgGamesList;
		}
	}

	@Override
	public RpgGames findByName(String name) throws SQLException {
		String query = RpgGameQueries.SELECT_GAME_QUERY_BY_NAME;
		ResultSet rs = null;
		try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, name);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return extractResultSet(rs);
			}
		} finally {
			rs.close();
		}
		return null;
	}

	@Override
	public RpgGames findById(Long id) throws SQLException {
		String query = RpgGameQueries.SELECT_GAME_QUERY_BY_ID;
		ResultSet rs = null;
		try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setLong(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				return extractResultSet(rs);
			}
		} finally {
			rs.close();
		}
		return null;
	}

	@Override
	public boolean save(RpgGames rpgGame) throws SQLException {
		String query = RpgGameQueries.INSERT_GAME_QUERY;
		ResultSet rs = null;
		try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, rpgGame.getGameName());
			stmt.setLong(2, rpgGame.getCharacterId());
			stmt.executeUpdate();
			return true;
		} finally {
			rs.close();
		}
	}

	@Override
	public boolean update(RpgGames rpgGame) throws SQLException {
		String query = RpgGameQueries.UPDATE_GAME_QUERY;
		try (Connection con = getConnection(); PreparedStatement stmt = con.prepareStatement(query);) {
			stmt.setString(1, rpgGame.getGameName());
			stmt.setLong(2, rpgGame.getGameId());
			stmt.executeUpdate();
			return true;
		}
	}

	private Connection getConnection() throws SQLException {
		return ConnectionFactory.getConnection();
	}

	private RpgGames extractResultSet(ResultSet rs) throws SQLException {
		RpgGames rpgGame = new RpgGames();
		rpgGame.setGameId(rs.getLong("id"));
		rpgGame.setCharacterId(rs.getLong("character_id"));
		rpgGame.setGameName(rs.getString("name"));
		return rpgGame;

	}

}
