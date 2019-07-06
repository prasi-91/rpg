package com.rpg.game.menu;

import com.rpg.entities.Character;
import com.rpg.service.impl.CharacterServiceImpl;
import com.rpg.util.ScannerUtil;

public class NewCharacterCommand implements Command {

	private static CharacterServiceImpl rpgCharacterService = new CharacterServiceImpl();

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
			Character rpgCharacter = new Character(characterName, weapon, 0);
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
