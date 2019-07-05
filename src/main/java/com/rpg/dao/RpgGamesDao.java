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

		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		List<RpgGames> rpgGamesList = new ArrayList<>();
		try {
			con = getConnection();
			stmt = con.createStatement();
			rs = stmt.executeQuery(query);

			while (rs.next()) {
				rpgGamesList.add(extractResultSet(rs));
			}
			return rpgGamesList;
		} catch (SQLException e) {
			throw e;
		} finally {
			DAOUtils.closeAll(rs, con, stmt);
		}
	}

	@Override
	public RpgGames findByName(String name) throws SQLException {
		String query = RpgGameQueries.SELECT_GAME_QUERY_BY_NAME;
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
	public boolean save(RpgGames rpgGame) throws SQLException {
		String query = RpgGameQueries.INSERT_GAME_QUERY;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, rpgGame.getGameName());
			stmt.setLong(2, rpgGame.getCharacterId());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw e;
		} finally {
			DAOUtils.closeAll(null, con, stmt);
		}
	}

	@Override
	public boolean update(RpgGames rpgGame) throws SQLException {
		String query = RpgGameQueries.UPDATE_GAME_QUERY;
		Connection con = null;
		PreparedStatement stmt = null;
		try {
			con = getConnection();
			stmt = con.prepareStatement(query);
			stmt.setString(1, rpgGame.getGameName());
			stmt.setLong(2, rpgGame.getGameId());
			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			throw e;
		} finally {
			DAOUtils.closeAll(null, con, stmt);
		}
	}

	private RpgGames extractResultSet(ResultSet rs) throws SQLException {
		RpgGames rpgGame = new RpgGames();
		rpgGame.setGameId(rs.getLong("id"));
		rpgGame.setCharacterId(rs.getLong("character_id"));
		rpgGame.setGameName(rs.getString("name"));
		return rpgGame;

	}

	@Override
	public RpgGames findById(Long id) throws SQLException {
		String query = RpgGameQueries.SELECT_GAME_QUERY_BY_ID;
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			con = getConnection();
			stmt = con.prepareStatement(query);
			stmt.setLong(1, id);
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
