package com.rpg.dao;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.anyString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.sqlite.SQLiteDataSource;

import com.rpg.entities.Game;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DBConnection.class)
public class GameDaoTest {

	@Mock
	DBConnection dbconnect;

	@Mock
	Connection mockConn;

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
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Game game = new Game();
		game.setGameId(1);
		game.setGameName("test");
		game.setCharacterId(1);
		PowerMockito.mockStatic(DBConnection.class);
		PowerMockito.doReturn(mockConn).when(DBConnection.class, "getConnection");
		Mockito.when(mockConn.createStatement()).thenReturn(stmnt);
		Mockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockPreparedStmnt);
		Mockito.when(mockPreparedStmnt.executeQuery()).thenReturn(mockResultSet);
		Mockito.when(mockPreparedStmnt.executeUpdate(anyString())).thenReturn(1);
		Mockito.when(mockPreparedStmnt.executeUpdate()).thenReturn(1);
		Mockito.when(stmnt.executeQuery(anyString())).thenReturn(mockResultSet);
		Mockito.when(mockResultSet.first()).thenReturn(true);
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
		gameDao.findByName("test");
	}

	@Test
	public void testFindById() throws SQLException {
		gameDao.findById(1);
	}

	@Test
	public void testSaveChar() throws SQLException {
		Game game = new Game();
		game.setGameName("test");
		game.setCharacterId(1);
		boolean isSuccessFull = gameDao.save(game);
		assertTrue(isSuccessFull);

	}

	@Test
	public void testUpdate() throws SQLException {
		Game game = new Game();
		game.setGameId(1);
		game.setGameName("test");
		game.setCharacterId(1);
		boolean isSuccessFull = gameDao.update(game);
		assertTrue(isSuccessFull);
	}
}
