package com.rpg.game.menu;

import java.util.List;
import java.util.Map;

import com.rpg.constants.RpGameConstants;
import com.rpg.util.MessageUtils;
import com.rpg.util.ScannerUtil;

public class GameControl {

	private static final Map<String, String> goBackMenuMap = MessageUtils.goBackMenuMap();
	private static final List<String> printableMenuList = MessageUtils.nonActionMenuList();

	public void startGame() {
		MessageUtils.selectPrintableMenus("0");
		String previousOption = "0";
		gameloop: while (true) {
			String option = ScannerUtil.inputHandler.nextLine();
			if (!MessageUtils.validateInputForOption(previousOption, option)) {
				MessageUtils.printInvalidOption();
				continue;
			} else if (RpGameConstants.EXIT_GAME.equals(option)) {
				MessageUtils.printExitMessage();
				break gameloop;
			} else if (RpGameConstants.GO_BACK.equals(option)) {
				if (goBackMenuMap.get(previousOption) != null) {
					MessageUtils.selectPrintableMenus(goBackMenuMap.get(previousOption));
					previousOption = goBackMenuMap.get(previousOption);
				}
				continue;
			} else if (printableMenuList.contains(option)) {
				MessageUtils.selectPrintableMenus(option);
				previousOption = option;
				continue;
			} else {
				Command cm = getCommandInstance(option);
				boolean isSuccessFull = cm.excuteOperationChoosen();
				if (isSuccessFull) {
					previousOption = cm.previousMenu();
				}
				MessageUtils.selectPrintableMenus(previousOption);
			}

		}
	}

	private Command getCommandInstance(String option) {
		if (RpGameConstants.NEW_CHARACTER.equals(option)) {
			return new CharacterCommand();
		} else if (RpGameConstants.EXPLORE_CHARACTERS.equals(option)) {
			return new ExploreCharacterCommand();
		} else if (RpGameConstants.EXPLORE_LEVELS.equals(option)) {
			return new ExploreLevelsCommand();
		} else if (RpGameConstants.NEW_GAME.equals(option)) {
			return new NewGameCommand();
		} else if (RpGameConstants.RESUME_GAME.equals(option)) {
			return new ResumeGameCommand();
		} else {
			return null;
		}
	}

}
