package com.rpg.game.menu;

import java.util.Scanner;

import com.rpg.domain.RpgCharacter;
import com.rpg.service.impl.RpgCharacterServiceImpl;

public class CreateCharacterMenu implements GameMenu {

	private static RpgCharacterServiceImpl rpgCharacterService = new RpgCharacterServiceImpl();

	private static Scanner in = new Scanner(System.in);

	private RpgCharacter rpgCharacter;

	@Override
	public void excuteOperationChoosen() {
		System.out.println("Enter the name of the character");
		String characterName = in.nextLine();
		if (characterName == null || characterName.isBlank()) {
			System.out.println("Please enter a Name");
		}
		characterName = in.nextLine();
		System.out.println("Enter your weapon");
		String weapon = in.nextLine();
		try {
			rpgCharacter = new RpgCharacter(characterName, weapon, 0);
			rpgCharacterService.createNewCharacter(rpgCharacter);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
