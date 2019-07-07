/*
 * Author M S Prasita Nair
 * 
 * The class acts as blue print for the Commands to be 
 * performed on each Selection
 * 
 */
package com.rpg.game.menu;

import com.rpg.constants.GameConstants;

public class CommandFactory {
	
	public static Command getCommandInstance(String option) {
		if (GameConstants.NEW_CHARACTER.equals(option)) {
			return new NewCharacterCommand();
		} else if (GameConstants.EXPLORE_CHARACTERS.equals(option)) {
			return new ExploreCharacterCommand();
		} else if (GameConstants.EXPLORE_LEVELS.equals(option)) {
			return new ExploreLevelsCommand();
		} else if (GameConstants.NEW_GAME.equals(option)) {
			return new NewGameCommand();
		} else if (GameConstants.RESUME_GAME.equals(option)) {
			return new PlayGameCommand();
		} else {
			return null;
		}
	}

}
