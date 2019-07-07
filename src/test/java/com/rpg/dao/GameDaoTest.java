package com.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.sqlite.SQLiteDataSource;

import com.rpg.entities.Game;
import com.rpg.entities.Game;

public class GameDaoTest {

	@Mock
	private DBConnection dbConnect;

	@Mock
	private Connection mockConn;

	@Mock
	PreparedStatement mockPreparedStmnt;

	@Mock
	Statement stmnt;

	@Mock
	SQLiteDataSource sqlLiteDs;

	@Mock
	ResultSet mockResultSet;

	@InjectMocks
	GameDao gameDao;

	@BeforeClass
	public static void setUpClass() throws Exception {
	}

	@AfterClass
	public static void tearDownClass() {
	}

	@Before
	public void setUp() throws SQLException {
		MockitoAnnotations.initMocks(this);
		Game game = new Game();
		game.setGameId(1);
		game.setGameName("test");
		game.setCharacterId(1);
		Mockito.when(sqlLiteDs.getConnection()).thenReturn(mockConn);
		Mockito.when(mockConn.createStatement()).thenReturn(stmnt);
		Mockito.when(mockConn.prepareStatement("test")).thenReturn(mockPreparedStmnt);
		Mockito.when(mockPreparedStmnt.executeQuery()).thenReturn(mockResultSet);
		Mockito.when(mockPreparedStmnt.executeUpdate("test")).thenReturn(1);
		Mockito.when(mockPreparedStmnt.executeUpdate()).thenReturn(1);
		Mockito.when(stmnt.executeQuery(anyString())).thenReturn(mockResultSet);
		Mockito.when(mockResultSet.first()).thenReturn(true);
		Mockito.when(mockResultSet.next()).thenReturn(true);
		Mockito.when(mockResultSet.getInt(anyString())).thenReturn(1);
		Mockito.when(mockResultSet.getString(anyString())).thenReturn(game.getGameName());
		Mockito.when(mockResultSet.getInt(anyString())).thenReturn(0);
	}

	@Test
	public void testFindAll() throws Exception {
		List<Game> testList = gameDao.findAll();
		assertNotNull(testList);
	}

	@Test
	public void testFindByName() throws SQLException {
		Game game = gameDao.findByName("test");
		assertNotNull(game);
	}

	@Test
	public void testFindById() throws SQLException {
		Game game = gameDao.findById(1);
		assertNotNull(game);
	}

	@Test
	public void testSaveChar() throws SQLException {
		Game game = new Game();
		game.setGameName("test");
		game.setCharacterId(1);
		assertTrue(gameDao.save(game));

	}

	@Test
	public void testUpdate() throws SQLException {
		Game game = new Game();
		game.setGameId(1);
		game.setGameName("test_junit");
		game.setCharacterId(1);
		assertNotNull(gameDao.update(game));
	}
}
