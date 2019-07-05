package com.rpg.game.menu;

import com.rpg.constants.RpGameConstants;
import com.rpg.util.MessageUtils;

public class GameControl {

	private boolean isExitPressed;

	public boolean isExitPressed() {
		return isExitPressed;
	}

	public void excuteOperationChoosen(String option) {
		Command cm = getCommandInstance(option);
		while (!isExitPressed) {
			if (cm != null) {
				if (!MessageUtils.isBlank(option)) {
					MessageUtils.printInvalidOption();
					continue;
				}
				cm.excuteOperationChoosen();
				isExitPressed = cm.isExitPressed();
				if (cm.isGoBackPressed()) {
					cm = getCommandInstance(cm.previousMenu());
				}
			} else {
				break;
			}
		}
	}

	private Command getCommandInstance(String option) {
		if (RpGameConstants.NEW_CHARACTER.equals(option)) {
			return new CharacterCommand();
		} else if (RpGameConstants.EXPLORE_MAIN_MENU.equals(option)) {
			return new ExploreCommand();
		} else if (RpGameConstants.START_GAME_MAIN_MENU.equals(option)) {
			return new GameCommand();
		} else {
			return null;
		}
	}

}
