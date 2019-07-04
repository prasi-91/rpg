package com.rpg.dao;

public class DAOFactory {

	public static AbstractDAO getDaoInstane(String daoName) {
		switch (daoName) {
		case "RpgCharacter":
			return new RpgCharacterDao();
		case "RpgGames":
			return new RpgCharacterDao();
		default:
			return null;
		}

	}

}
