package com.rpg.game.menu;

import java.util.List;
import java.util.Scanner;

import com.rpg.constants.RpGameConstants;
import com.rpg.domain.RpgCharacter;
import com.rpg.domain.RpgGames;
import com.rpg.service.impl.RpgCharacterServiceImpl;
import com.rpg.service.impl.RpgGameServiceImpl;
import com.rpg.util.MenuUtils;

public class GameCommand implements Command {

	boolean isExitPressed;
	boolean isGoBackPressed;
	private static Scanner in = new Scanner(System.in);
	private static RpgCharacterServiceImpl rpgCharacterService = new RpgCharacterServiceImpl();
	private static RpgGameServiceImpl rpgGameService = new RpgGameServiceImpl();

	@Override
	public boolean isExitPressed() {
		return isExitPressed;
	}

	@Override
	public void excuteOperationChoosen() {

		gameLoop: while (!isExitPressed) {
			MenuUtils.printGameActionMainMenu();
			String option = in.nextLine();
			if (!MenuUtils.isBlank(option)) {
				MenuUtils.printInvalidOption();
				continue;
			}
			switch (option) {

			case RpGameConstants.NEW_GAME:
				System.out.println("Select the character Name to Start new Game");
				try {
					rpgCharacterService.fetchAllRpgCharacters().forEach(item -> {
						System.out.println(item.getCharacterName());
					});
					String characterName = in.nextLine();
					System.out.println("Your Game for option selected will start with the character selected");
					GameActionCommand gm = new GameActionCommand();
					gm.setCharacter(rpgCharacterService.getRpgCharacterByName(characterName.toUpperCase()));
					gm.excuteOperationChoosen();
					isExitPressed = gm.isExitPressed();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case RpGameConstants.RESUME_GAME:

				try {
					List<RpgGames> gameList = rpgGameService.fetchAllGames();
					if (gameList != null && !gameList.isEmpty()) {
						System.out.println("Select the game name to resume");
						gameList.forEach(item -> {
							System.out.println(item.getGameName());
						});
					} else {
						System.out.println("No Game create please go back and select menu to create new game");
						break;
					}
					String gameSelected = in.nextLine();
					GameActionCommand gm = new GameActionCommand();
					gm.setRpgGames(rpgGameService.findGame(gameSelected));
					gm.setCharacter(rpgCharacterService.getRpgCharacterById(gm.getRpgGames().getCharacterId()));
					gm.excuteOperationChoosen();
					isExitPressed = gm.isExitPressed();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case RpGameConstants.EXIT_GAME:
				isExitPressed = true;
				break;

			case RpGameConstants.GO_BACK:
				isGoBackPressed = true;
				break gameLoop;

			default:
				MenuUtils.printInvalidOption();
				continue;
			}

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
