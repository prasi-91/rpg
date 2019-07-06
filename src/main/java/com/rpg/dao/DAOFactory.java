package com.rpg.dao;

public class DAOFactory {

	public static <T> AbstractDAO getDaoInstane(String daoName) {
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
