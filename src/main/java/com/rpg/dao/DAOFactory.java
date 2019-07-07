/*
 * Author M S Prasita Nair
 * 
 * The class is concrete implementation for GAMES_PLAYED DB operations
 * 
 */
package com.rpg.dao;

public class DAOFactory {

	public static AbstractDAO getDaoInstane(String daoName) {
		switch (daoName) {
		case "Character":
			return new CharacterDao();
		case "Game":
			return new GameDao();
		default:
			return null;
		}

	}

}
