package com.rpg.game.menu;

import com.rpg.domain.RpgCharacter;
import com.rpg.service.impl.RpgCharacterServiceImpl;
import com.rpg.util.ScannerUtil;

public class CharacterCommand implements Command {

	private static RpgCharacterServiceImpl rpgCharacterService = new RpgCharacterServiceImpl();

	@Override
	public boolean excuteOperationChoosen() {
		System.out.println("Enter the name of the character you want to create");
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
			System.out.println("Hurray You Have Created Your Own Character");
			System.out.println(" ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public String previousMenu() {
		return "0";
	}

}
