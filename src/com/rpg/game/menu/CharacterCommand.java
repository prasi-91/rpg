package com.rpg.game.menu;

import java.util.Scanner;

import com.rpg.domain.RpgCharacter;
import com.rpg.service.impl.RpgCharacterServiceImpl;

public class CharacterCommand implements Command {

	boolean isExitPressed;
	boolean isGoBackPressed;
	private static RpgCharacterServiceImpl rpgCharacterService = new RpgCharacterServiceImpl();
	private static Scanner in = new Scanner(System.in);
	private RpgCharacter rpgCharacter;

	@Override
	public boolean isExitPressed() {
		return isExitPressed;
	}

	@Override
	public void excuteOperationChoosen() {
		System.out.println("Enter the name of the character");
		String characterName = in.nextLine();
		while (characterName == null || characterName.trim().isEmpty()) {
			System.out.println("Please enter a Name");
			characterName = in.nextLine();
		}
		System.out.println("Enter your weapon");
		String weapon = in.nextLine();
		try {
			rpgCharacter = new RpgCharacter(characterName, weapon, 0);
			rpgCharacterService.createNewCharacter(rpgCharacter);
			isGoBackPressed = true;
			System.out.println("Hurray You Have Created Your Own Character");
			System.out.println(" ");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public String previousMenu() {
		return "0";
	}

	@Override
	public boolean isGoBackPressed() {
		return isGoBackPressed;
	}

}
