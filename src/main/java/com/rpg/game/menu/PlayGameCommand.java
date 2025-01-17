/*
 * Author M S Prasita Nair
 * 
 * Class to execute the play operation
 * 
 */
package com.rpg.game.menu;

import java.util.List;

import com.rpg.entities.Character;
import com.rpg.entities.Game;
import com.rpg.exception.GameServiceException;
import com.rpg.service.impl.GameActionServiceImpl;
import com.rpg.service.impl.CharacterServiceImpl;
import com.rpg.service.impl.GameServiceImpl;
import com.rpg.util.MessageUtils;
import com.rpg.util.ScannerUtil;

public class PlayGameCommand implements Command {

	private GameServiceImpl rpgGameService = new GameServiceImpl();
	private GameActionServiceImpl gameActionService = new GameActionServiceImpl();
	private CharacterServiceImpl rpgCharacter = new CharacterServiceImpl();
	private ScannerUtil in = new ScannerUtil();

	@Override
	public boolean excuteOperationChoosen() {
		try {
			List<Game> gameList = rpgGameService.fetchAllGames();
			if (gameList != null && !gameList.isEmpty()) {
				System.out.println("Select the game name to resume");
				gameList.forEach(item -> System.out.println(item.getGameName()));

				Game rpGame = validateGameName();

				MessageUtils.printGameActionSubMenu();

				String action = validateSubActionMenu();
				if ("1".equals(action)) {
					Character rpgChar = rpgCharacter.getRpgCharacterById(rpGame.getCharacterId());
					gameActionService.fight(rpgChar);
				} else if ("2".equals(action)) {
					System.out.println("Do You want to update the name of your game before saving Yes/No?");
					String updateGameName = validUpdateGameOption();
					if ("yes".equalsIgnoreCase(updateGameName)) {
						String gameName = validateIsBlank();
						rpGame.setGameName(gameName.trim());
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
		String action = in.getInput();
		while (!"1".equals(action) && !"2".equals(action)) {
			System.out.println("Please Enter Valid Action");
			action = in.getInput();
		}
		return action;
	}

	private Game validateGameName() throws GameServiceException {
		String gameName = in.getInput();
		Game rpGame = rpgGameService.findGame(gameName);
		while (rpGame == null) {
			System.out.println("Please Enter Valid Game Name From the options displayed");
			gameName = in.getInput();
			rpGame = rpgGameService.findGame(gameName);
		}
		return rpGame;
	}

	private String validateIsBlank() {
		System.out.println("Enter the new Name");
		String gameName = in.getInput();
		while (gameName == null || gameName.trim().isEmpty()) {
			System.out.println("Enter a valid New Name");
			gameName = in.getInput();
		}

		return gameName;
	}

	private String validUpdateGameOption() {
		String action = in.getInput();
		while (!"yes".equalsIgnoreCase(action) && !"no".equalsIgnoreCase(action)) {
			System.out.println("Please Enter Valid Action");
			action = in.getInput();
		}
		return action;
	}

}
