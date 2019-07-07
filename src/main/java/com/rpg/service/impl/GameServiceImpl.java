/*
 * Author M S Prasita Nair
 * 
 * Class to carry out Service operations for Save and Create Game
 * 
 */
package com.rpg.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rpg.constants.ExceptionMessages;
import com.rpg.constants.GameConstants;
import com.rpg.dao.AbstractDAO;
import com.rpg.dao.DAOFactory;
import com.rpg.entities.Game;
import com.rpg.exception.GameServiceException;

public class GameServiceImpl {

	private AbstractDAO<Game> rpgGamesDao = DAOFactory.getDaoInstane(GameConstants.GAME_DAO);

	public List<Game> fetchAllGames() throws GameServiceException {
		try {
			return rpgGamesDao.findAll();
		} catch (SQLException e) {
			throw new GameServiceException(ExceptionMessages.ERROR_FETCHING_GAMES);
		}
	}

	public Game findGame(String name) throws GameServiceException {
		try {
			return rpgGamesDao.findByName(name);
		} catch (SQLException e) {
			throw new GameServiceException(ExceptionMessages.ERROR_SAVING_GAME);
		}
	}

	public void createNewGame(Game rpgGame) throws GameServiceException {
		try {
			if (rpgGamesDao.findByName(rpgGame.getGameName()) != null) {
				throw new GameServiceException(ExceptionMessages.UNIQUE_NAME_ERROR);
			}
			rpgGamesDao.save(rpgGame);
		} catch (SQLException e) {
			throw new GameServiceException(ExceptionMessages.ERROR_SAVING_GAME);
		}
	}

	public void updateGame(Game rpgGame) throws GameServiceException {
		try {
			if (rpgGamesDao.findByName(rpgGame.getGameName()) != null) {
				throw new GameServiceException(ExceptionMessages.UNIQUE_NAME_ERROR);
			}
			rpgGamesDao.update(rpgGame);
		} catch (SQLException e) {
			throw new GameServiceException(ExceptionMessages.ERROR_UPDATING_CHRACTER);
		}
	}

}
