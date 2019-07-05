package com.rpg.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rpg.constants.ExceptionMessages;
import com.rpg.dao.AbstractDAO;
import com.rpg.dao.DAOFactory;
import com.rpg.domain.RpgGames;
import com.rpg.exception.CharacterServiceException;
import com.rpg.exception.GameServiceException;

public class RpgGameServiceImpl {

	private AbstractDAO<RpgGames> rpgGamesDao = DAOFactory.getDaoInstane("RpgGames");

	public List<RpgGames> fetchAllGames() throws GameServiceException {
		try {
			return rpgGamesDao.findAll();
		} catch (ClassNotFoundException | SQLException e) {
			throw new GameServiceException(ExceptionMessages.ERROR_FETCHING_GAMES);
		}
	}

	public RpgGames findGame(String name) throws GameServiceException {
		try {
			return rpgGamesDao.findByName(name);
		} catch (ClassNotFoundException | SQLException e) {
			throw new GameServiceException(ExceptionMessages.ERROR_FINDING_GAME);
		}
	}

	public void createNewGame(RpgGames rpgGame) throws GameServiceException {
		try {
			rpgGamesDao.save(rpgGame);
		} catch (ClassNotFoundException | SQLException e) {
			throw new GameServiceException(ExceptionMessages.ERROR_SAVING_GAME);
		}
	}

	public void updateGame(RpgGames rpgGame) throws GameServiceException {
		try {
			rpgGamesDao.update(rpgGame);
		} catch (ClassNotFoundException | SQLException e) {
			throw new GameServiceException(ExceptionMessages.ERROR_UPDATING_CHRACTER);
		}
	}

}
