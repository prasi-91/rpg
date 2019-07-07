package com.rpg.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rpg.dao.CharacterDao;
import com.rpg.dao.GameDao;
import com.rpg.entities.Character;
import com.rpg.entities.Game;
import com.rpg.exception.CharacterServiceException;
import com.rpg.exception.GameServiceException;
import com.rpg.service.impl.CharacterServiceImpl;
import com.rpg.service.impl.GameServiceImpl;

public class GameServiceTest {

	@Mock
	private GameDao gameDao;

	@InjectMocks
	private GameServiceImpl gameServiceImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetAllSavedGames() throws SQLException, GameServiceException {
		List<Game> tempList = new ArrayList<>();
		tempList.add(new Game());
		Mockito.when(gameDao.findAll()).thenReturn(tempList);
		tempList = gameServiceImpl.fetchAllGames();
		assertFalse(tempList.isEmpty());
	}

	@Test(expected = GameServiceException.class)
	public void testGetAllSavedGamesException() throws GameServiceException, SQLException {
		Mockito.when(gameDao.findAll()).thenThrow(SQLException.class);
		gameServiceImpl.fetchAllGames();
	}

	@Test
	public void testFindByName() throws GameServiceException, SQLException {
		Game game = new Game();
		Mockito.when(gameDao.findByName("test")).thenReturn(game);
		game = gameServiceImpl.findGame("test");
		assertNotNull(game);
	}

	@Test(expected = GameServiceException.class)
	public void testFindByNameException() throws GameServiceException, SQLException {
		Mockito.when(gameDao.findByName("test")).thenThrow(SQLException.class);
		gameServiceImpl.findGame("test");
	}

	@Test
	public void testCreateGame() throws GameServiceException, SQLException {
		Game rpgGame = new Game();
		Mockito.when(gameDao.save(rpgGame)).thenReturn(true);
		gameServiceImpl.createNewGame(rpgGame);
	}

	@Test(expected = GameServiceException.class)
	public void testCreateGameExeption() throws GameServiceException, SQLException {
		SQLException ex = new SQLException("test");
		Game rpgGame = new Game();
		Mockito.when(gameDao.save(rpgGame)).thenThrow(ex);
		gameServiceImpl.createNewGame(rpgGame);
	}

	@Test(expected = GameServiceException.class)
	public void testCreateCharExceptionUnique() throws GameServiceException, SQLException {
		SQLException ex = new SQLException("column NAME is not unique");
		Game rpgGame = new Game();
		Mockito.when(gameDao.save(rpgGame)).thenThrow(ex);
		gameServiceImpl.createNewGame(rpgGame);
	}

	@Test
	public void testUpdateCharacter() throws GameServiceException, SQLException {
		Game rpgGame = new Game();
		Mockito.when(gameDao.update(rpgGame)).thenReturn(true);
		gameServiceImpl.updateGame(rpgGame);
	}

	@Test(expected = GameServiceException.class)
	public void testUpdateCharException() throws GameServiceException, SQLException {
		Game rpgGame = new Game();
		Mockito.when(gameDao.update(rpgGame)).thenThrow(SQLException.class);
		gameServiceImpl.updateGame(rpgGame);
	}
}
