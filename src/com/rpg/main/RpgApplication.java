package com.rpg.main;

import java.util.Scanner;

import com.rpg.constants.RpGameConstants;
import com.rpg.game.menu.GameMenu;
import com.rpg.game.menu.GameMenuFactory;
import com.rpg.util.MenuUtils;

public class RpgApplication {

	private static Scanner in = new Scanner(System.in);

	public static void main(String[] args) {

		mainMenu: while (true) {

			MenuUtils.printMainMenu();

			int option = in.nextInt();
			if (option == RpGameConstants.EXIT_GAME) {
				break mainMenu;
			}
			GameMenu gm = GameMenuFactory.getMenuOperation(option);
			if (gm == null) {
				MenuUtils.printInvalidOption();
				continue;
			} else {
				gm.excuteOperationChoosen();
			}

		}

	}

}
