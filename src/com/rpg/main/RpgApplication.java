package com.rpg.main;

import java.util.Scanner;

import com.rpg.constants.RpGameConstants;
import com.rpg.game.menu.GameControl;
import com.rpg.util.MenuUtils;

public class RpgApplication {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		MenuUtils.printWelcomeMessage();
		boolean isExitPressed = false;
		while (!isExitPressed) {
			MenuUtils.printMainMenu();
			String option = in.nextLine();
			if (option.trim().isEmpty() || !MenuUtils.isValidOptionForMainMenu(option)) {
				System.out.println("Please Enter a correct option");
				continue;
			}
			if (RpGameConstants.EXIT_GAME.equals(option)) {
				isExitPressed = true;
				System.out.println("Bye for now!!!!");
			} else {
				GameControl gm = new GameControl();
				gm.excuteOperationChoosen(option);
				isExitPressed = gm.isExitPressed();
			}
		}

	}

}
