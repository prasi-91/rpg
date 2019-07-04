package com.rpg.game.menu;

public class GameMenuFactory {

	public static GameMenu getMenuOperation(int option) {
		if (option == 1) {
			return new CreateCharacterMenu();
		} else if (option == 2) {
			return new StartGameMenu();
		} else if (option == 3) {
			return new ExploreGameMenu();
		} else {
			return null;
		}
	}

}
