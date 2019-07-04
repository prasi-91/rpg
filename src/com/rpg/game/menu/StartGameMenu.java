package com.rpg.game.menu;

import java.util.Scanner;

import com.rpg.service.impl.RpgCharacterServiceImpl;
import com.rpg.service.impl.RpgGameServiceImpl;
import com.rpg.util.MenuUtils;

public class StartGameMenu implements GameMenu {

	private static Scanner in = new Scanner(System.in);
	private static RpgCharacterServiceImpl rpgCharacterService = new RpgCharacterServiceImpl();
	private static RpgGameServiceImpl rpgGameService = new RpgGameServiceImpl();

	@Override
	public void excuteOperationChoosen() {

		gameActionLoop: while (true) {
			MenuUtils.printGameActionMainMenu();

			Integer option = in.nextInt();

			switch (option) {
			case 1:
				System.out.println("Select the character Name to Start new Game");
				try {
					rpgCharacterService.fetchAllRpgCharacters();
					rpgCharacterService.fetchAllRpgCharacters().forEach(item -> {
						System.out.println(item.getCharacterName());
					});
					String characterName = in.nextLine();

					GameActionMenu gm = new GameActionMenu();
					gm.setCharacter(rpgCharacterService.getRpgCharacter(characterName));
					gm.excuteOperationChoosen();
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 2:
				System.out.println("Select the game name to resume");
				try {
					rpgGameService.fetchAllGames().forEach(item -> {
						System.out.println(item.getGameName());
					});
					String gameSelected = in.nextLine();
					GameActionMenu gm = new GameActionMenu();
					gm.setRpgGames(rpgGameService.findAGame(gameSelected));
					gm.excuteOperationChoosen();
					System.out.println("Your Character Has Gained Experience");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			default:
				MenuUtils.printInvalidOption();
				continue;
			}

		}

	}
}
