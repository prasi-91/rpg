package com.rpg.game.menu;

import java.util.Scanner;

import com.rpg.constants.RpGameConstants;
import com.rpg.domain.RpgCharacter;
import com.rpg.domain.RpgGames;
import com.rpg.service.impl.GamingActionServiceImpl;
import com.rpg.service.impl.RpgCharacterServiceImpl;
import com.rpg.service.impl.RpgGameServiceImpl;
import com.rpg.util.MenuUtils;

public class GameActionMenu implements GameMenu {

	private static Scanner in = new Scanner(System.in);
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
	public void excuteOperationChoosen() {
		Integer option = in.nextInt();

		gameActionLoop: while (true) {
			MenuUtils.printGameActionSubMenu();

			switch (option) {

			case RpGameConstants.FIGHT:
				gameActionService.fight(character);
				try {
					rpgCharacterService.updateCharacter(character);
					System.out.println("Your Character Has Gained Experience");
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;

			case RpGameConstants.SAVE_GAME:
				try {
					System.out.println("Do You want to update the name of your game befor saving yes/No?");
					String updateGameName = in.nextLine();
					if ("yes".equalsIgnoreCase(updateGameName)) {
						System.out.println("Enter the new Name");
						rpgGames.setGameName(in.nextLine());
						rpgGameService.updateRpgCharacterExperience(rpgGames);
					}
					System.out.println("Your Game is Saved");

				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
				break;
			case 5:
				continue;

			case RpGameConstants.EXIT_GAME:
				break;
			default:
				MenuUtils.printInvalidOption();
				break;
			}
		}

	}
}