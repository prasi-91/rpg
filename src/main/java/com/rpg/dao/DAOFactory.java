/*
 * Author M S Prasita Nair
 * 
 * The class is concrete implementation for GAMES_PLAYED DB operations
 * 
 */
package com.rpg.dao;

import com.rpg.constants.GameConstants;

public class DAOFactory {

	public static AbstractDAO getDaoInstane(String daoName) {
		switch (daoName) {
		case GameConstants.CHARACTER_DAO:
			return new CharacterDao();
		case GameConstants.GAME_DAO:
			return new GameDao();
		default:
			return null;
		}

	}

}
