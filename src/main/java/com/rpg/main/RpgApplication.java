package com.rpg.main;

import java.util.Scanner;

import com.rpg.constants.RpGameConstants;
import com.rpg.game.menu.GameControl;
import com.rpg.util.MessageUtils;
import com.rpg.util.ScannerUtil;

public class RpgApplication {

	public static void main(String[] args) {

		MessageUtils.printWelcomeMessage();
		boolean isExitPressed = false;
		while (!isExitPressed) {
			MessageUtils.printMainMenu();
			String option = ScannerUtil.inputHandler.nextLine();
			if (option.trim().isEmpty() || !MessageUtils.isValidOptionForMainMenu(option)) {
				System.out.println("Please Enter a correct option");
				continue;
			}
			if (RpGameConstants.EXIT_GAME.equals(option)) {
				isExitPressed = true;
				MessageUtils.printExitMessage();
				ScannerUtil.closeInputConnection();
			} else {
				GameControl gm = new GameControl();
				gm.excuteOperationChoosen(option);
				isExitPressed = gm.isExitPressed();
			}
		}

	}

}
