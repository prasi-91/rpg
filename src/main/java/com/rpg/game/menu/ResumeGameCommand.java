package com.rpg.game.menu;

import java.util.List;

import com.rpg.domain.RpgCharacter;
import com.rpg.domain.RpgGames;
import com.rpg.exception.GameServiceException;
import com.rpg.service.impl.GamingActionServiceImpl;
import com.rpg.service.impl.RpgCharacterServiceImpl;
import com.rpg.service.impl.RpgGameServiceImpl;
import com.rpg.util.ScannerUtil;

public class ResumeGameCommand implements Command {

	private static RpgGameServiceImpl rpgGameService = new RpgGameServiceImpl();
	private static GamingActionServiceImpl gameActionService = new GamingActionServiceImpl();
	private static RpgCharacterServiceImpl rpgCharacter = new RpgCharacterServiceImpl();

	@Override
	public boolean excuteOperationChoosen() {
		try {
			List<RpgGames> gameList = rpgGameService.fetchAllGames();
			if (gameList != null && !gameList.isEmpty()) {
				System.out.println("Select the game name to resume");
				gameList.forEach(item -> System.out.println(item.getGameName()));

				RpgGames rpGame = validateGameName();

				printSubMenu();

				String action = validateSubActionMenu();
				if ("1".equals(action)) {
					RpgCharacter rpgChar = rpgCharacter.getRpgCharacterById(rpGame.getCharacterId());
					gameActionService.fight(rpgChar);
				} else if ("2".equals(action)) {
					System.out.println("Do You want to update the name of your game befor saving yes/No?");
					String updateGameName = ScannerUtil.inputHandler.nextLine();
					if ("yes".equalsIgnoreCase(updateGameName)) {
						String gameName = validateIsBlank();
						rpGame.setGameName(gameName);
						rpgGameService.updateGame(rpGame);
						System.out.println("Your Game has been saved");
					}
				}
			} else {
				System.out.println("There are no saved games please go back and select menu to create new game");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public String previousMenu() {
		return "3";
	}

	private String validateSubActionMenu() {
		String action = ScannerUtil.inputHandler.nextLine();
		while (!"1".equals(action) && !"2".equals(action)) {
			System.out.println("Please Enter Valid Action");
			action = ScannerUtil.inputHandler.nextLine();
		}
		return action;
	}

	private RpgGames validateGameName() throws GameServiceException {
		String gameName = ScannerUtil.inputHandler.nextLine();
		RpgGames rpGame = rpgGameService.findGame(gameName);
		while (rpGame == null) {
			System.out.println("Please Enter Valid Game Name From the options displayed");
			gameName = ScannerUtil.inputHandler.nextLine();
			rpGame = rpgGameService.findGame(gameName);
		}
		return rpGame;
	}

	private String validateIsBlank() {
		System.out.println("Enter the new Name");
		String gameName = ScannerUtil.inputHandler.nextLine();
		while (gameName == null || gameName.trim().isEmpty()) {
			System.out.println("Enter a valid New Name");
			gameName = ScannerUtil.inputHandler.nextLine();
		}

		return gameName;
	}

	private void printSubMenu() {
		System.out.println("Select The option you want to perform");
		System.out.println("1 Fight");
		System.out.println("2 Save Game");
	}
}
