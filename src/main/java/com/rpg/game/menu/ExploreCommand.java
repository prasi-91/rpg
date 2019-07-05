package com.rpg.game.menu;

import java.util.List;

import com.rpg.constants.RpGameConstants;
import com.rpg.exploration.factory.Level;
import com.rpg.exploration.factory.LevelFactory;
import com.rpg.service.impl.GamingActionServiceImpl;
import com.rpg.util.MessageUtils;
import com.rpg.util.ScannerUtil;

public class ExploreCommand implements Command {

	private boolean isExitPressed;
	boolean isGoBackPressed;
	private static GamingActionServiceImpl gamingActionService = new GamingActionServiceImpl();

	@Override
	public boolean isExitPressed() {
		return isExitPressed;
	}

	@Override
	public void excuteOperationChoosen() {
		MessageUtils.printMainExploreMenu();
		String option = ScannerUtil.inputHandler.nextLine();
		switch (option) {
		case RpGameConstants.EXPLORE_CHARACTERS:
			exploreCharacters();
			break;

		case RpGameConstants.EXPLORE_LEVELS:
			exploreLevels();
			break;

		case RpGameConstants.EXIT_GAME:
			isExitPressed = true;
			break;

		case RpGameConstants.GO_BACK:
			isGoBackPressed = true;
			break;
		default:
			MessageUtils.printInvalidOption();
			break;
		}
	}

	private void exploreCharacters() {
		System.out.println(" ");
		System.out.println("The game has following amazing characters");
		System.out.println("============================================");
		try {
			List<String> characterList = gamingActionService.exploreCharacters();
			characterList.forEach(item -> {
				System.out.println(item);
			});
			System.out.println(" ");

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void exploreLevels() {
		MessageUtils.printExploreLevelMenu();
		String levelnum = ScannerUtil.inputHandler.nextLine();
		Level level = LevelFactory.getLevel(Integer.parseInt(levelnum));
		if (level != null) {
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append(level.getLevelEnvironment()).append(level.getLevelDifficulty())
					.append(level.getEligibility()));
		} else {
			MessageUtils.printInvalidOption();
		}
	}

	@Override
	public String previousMenu() {
		return "0";
	}

	@Override
	public boolean isGoBackPressed() {
		return isGoBackPressed;
	}
}
