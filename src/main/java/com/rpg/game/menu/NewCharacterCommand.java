/*
 * Author M S Prasita Nair
 * 
 * Class to execute the create new Character operation
 * 
 */

package com.rpg.game.menu;

import com.rpg.entities.Character;
import com.rpg.exception.CharacterServiceException;
import com.rpg.service.impl.CharacterServiceImpl;
import com.rpg.util.ScannerUtil;

public class NewCharacterCommand implements Command {

	private CharacterServiceImpl rpgCharacterService = new CharacterServiceImpl();
	private ScannerUtil in = new ScannerUtil();

	@Override
	public boolean excuteOperationChoosen() {
		System.out.println("Enter the name of the character you want to create");
		String characterName = in.getInput();
		while (characterName == null || characterName.trim().isEmpty()) {
			System.out.println("Please enter a Name");
			characterName = in.getInput();
		}
		System.out.println("Enter your weapon");
		String weapon = in.getInput();
		try {
			Character rpgCharacter = new Character(characterName.trim(), weapon, 0);
			rpgCharacterService.createNewCharacter(rpgCharacter);
			System.out.println("Hurray You Have Created Your Own Character");
			System.out.println(" ");
		} catch (CharacterServiceException e) {
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
