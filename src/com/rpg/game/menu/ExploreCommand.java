package com.rpg.game.menu;

import java.util.List;
import java.util.Scanner;

import com.rpg.constants.RpGameConstants;
import com.rpg.exploration.factory.Level;
import com.rpg.exploration.factory.LevelFactory;
import com.rpg.service.impl.GamingActionServiceImpl;
import com.rpg.util.MenuUtils;

public class ExploreCommand implements Command {

	private boolean isExitPressed;
	boolean isGoBackPressed;
	private static GamingActionServiceImpl gamingActionService = new GamingActionServiceImpl();

	@Override
	public boolean isExitPressed() {
		return isExitPressed;
	}

	private static Scanner in = new Scanner(System.in);

	@Override
	public void excuteOperationChoosen() {
		MenuUtils.printMainExploreMenu();
		String option = in.nextLine();
		switch (option) {
		case RpGameConstants.EXPLORE_CHARACTERS:
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
				break;
			}
			break;

		case RpGameConstants.EXPLORE_LEVELS:
			MenuUtils.printExploreLevelMenu();
			String levelnum = in.nextLine();
			Level level = LevelFactory.getLevel(Integer.parseInt(levelnum));
			if (level == null) {
				MenuUtils.printInvalidOption();
			}
			StringBuilder sb = new StringBuilder();
			System.out.println(sb.append(level.getLevelEnvironment()).append(level.getLevelDifficulty())
					.append(level.getEligibility()));
			break;

		case RpGameConstants.EXIT_GAME:
			isExitPressed = true;
			break;

		case RpGameConstants.GO_BACK:
			isGoBackPressed = true;
			break;
		default:
			MenuUtils.printInvalidOption();
			break;
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
