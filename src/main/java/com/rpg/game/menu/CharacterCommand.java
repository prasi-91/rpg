package com.rpg.game.menu;

import com.rpg.domain.RpgCharacter;
import com.rpg.service.impl.RpgCharacterServiceImpl;
import com.rpg.util.ScannerUtil;

public class CharacterCommand implements Command {

	boolean isExitPressed;
	boolean isGoBackPressed;
	private static RpgCharacterServiceImpl rpgCharacterService = new RpgCharacterServiceImpl();

	@Override
	public boolean isExitPressed() {
		return isExitPressed;
	}

	@Override
	public void excuteOperationChoosen() {
		creatNewCharacter();
	}

	@Override
	public String previousMenu() {
		return "0";
	}

	@Override
	public boolean isGoBackPressed() {
		return isGoBackPressed;
	}

	private void creatNewCharacter() {
		System.out.println("Enter the name of the character");
		String characterName = ScannerUtil.inputHandler.nextLine();
		while (characterName == null || characterName.trim().isEmpty()) {
			System.out.println("Please enter a Name");
			characterName = ScannerUtil.inputHandler.nextLine();
		}
		System.out.println("Enter your weapon");
		String weapon = ScannerUtil.inputHandler.nextLine();
		try {
			RpgCharacter rpgCharacter = new RpgCharacter(characterName, weapon, 0);
			rpgCharacterService.createNewCharacter(rpgCharacter);
			isGoBackPressed = true;
			System.out.println("Hurray You Have Created Your Own Character");
			System.out.println(" ");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			isGoBackPressed = true;
		}
	}
}
