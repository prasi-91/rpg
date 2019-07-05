package com.rpg.game.menu;

import com.rpg.constants.RpGameConstants;
import com.rpg.domain.RpgCharacter;
import com.rpg.domain.RpgGames;
import com.rpg.service.impl.GamingActionServiceImpl;
import com.rpg.service.impl.RpgCharacterServiceImpl;
import com.rpg.service.impl.RpgGameServiceImpl;
import com.rpg.util.MessageUtils;
import com.rpg.util.ScannerUtil;

public class GameActionCommand implements Command {

	private boolean isExitPressed = false;
	boolean isGoBackPressed;
	private static RpgCharacterServiceImpl rpgCharacterService = new RpgCharacterServiceImpl();
	private static GamingActionServiceImpl gameActionService = new GamingActionServiceImpl();
	private static RpgGameServiceImpl rpgGameService = new RpgGameServiceImpl();

	private RpgCharacter character;
	private RpgGames rpgGames;

	public RpgCharacter getCharacter() {
		return character;
	}

	public void setCharacter(RpgCharacter character) {
		this.character = character;
	}

	public RpgGames getRpgGames() {
		return rpgGames;
	}

	public void setRpgGames(RpgGames rpgGames) {
		this.rpgGames = rpgGames;
	}

	@Override
	public boolean isExitPressed() {
		return isExitPressed;
	}

	@Override
	public void excuteOperationChoosen() {

		gameActionLoop: while (!isExitPressed) {
			MessageUtils.printGameActionSubMenu();
			String option = ScannerUtil.inputHandler.nextLine();
			if (MessageUtils.isBlank(option)) {
				MessageUtils.printInvalidOption();
				continue;
			}
			switch (option) {

			case RpGameConstants.FIGHT:
				fightGame();
				break;

			case RpGameConstants.SAVE_GAME:
				saveGame();
				break;

			case RpGameConstants.EXIT_GAME:
				isExitPressed = true;
				break;

			case RpGameConstants.GO_BACK:
				isGoBackPressed = true;
				break gameActionLoop;
			default:
				MessageUtils.printInvalidOption();
				continue;
			}
		}

	}

	private void fightGame() {
		gameActionService.fight(character);
		try {
			rpgCharacterService.updateCharacter(character);
			System.out.println("Your Character Has Gained Experience");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	private void saveGame() {
		try {
			System.out.println("Your Game is Saved");
			String gameName = "";
			if (rpgGames == null) {
				rpgGames = new RpgGames();
				System.out.println("Please Enter the name in which you want to save the game");
				gameName = ScannerUtil.inputHandler.nextLine();
				rpgGames.setGameName(gameName);
				rpgGames.setCharacterId(character.getId());
			} else {
				System.out.println("Do You want to update the name of your game befor saving yes/No?");
				String updateGameName = ScannerUtil.inputHandler.nextLine();
				if ("yes".equalsIgnoreCase(updateGameName)) {
					System.out.println("Enter the new Name");
					gameName = ScannerUtil.inputHandler.nextLine();
					rpgGames.setGameName(gameName);

				}
				rpgGameService.createNewGame(rpgGames);
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String previousMenu() {
		return "3";
	}

	@Override
	public boolean isGoBackPressed() {
		return isGoBackPressed;
	}
}