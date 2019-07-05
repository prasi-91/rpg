package com.rpg.dao;

public class DAOFactory {

	public static <T> AbstractDAO getDaoInstane(String daoName) {
		switch (daoName) {
		case "RpgCharacter":
			return new RpgCharacterDao();
		case "RpgGames":
			return new RpgGamesDao();
		default:
			return null;
		}

	}

}
