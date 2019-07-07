package com.rpg.util;

import com.rpg.constants.GameConstants;

public class MessageUtils {

	private static void printMainMenu() {
		System.out.println(" ");
		System.out.println(GameConstants.ANSI_BLUE + "Select the operation that you would like to perform"
				+ GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_YELLOW + "1 Create a Character" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_GREEN + "2 Explore" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_CYAN + "3 Start Game" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_RED + GameConstants.EXIT_MENU_MESSAGE + GameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printInvalidOption() {
		System.out.println(" ");
		System.out.println(GameConstants.ANSI_RED + "Please Select a valid option" + GameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	private static void printMainExploreMenu() {
		System.out.println(" ");
		System.out.println(GameConstants.ANSI_BLUE + "\n" + "Select the number which you want to explore"
				+ GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_YELLOW + "4 Explore Characters" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_GREEN + "5 Explore levels" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_CYAN + GameConstants.GO_BACK_MENU_MESSAGE + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_RED + GameConstants.EXIT_MENU_MESSAGE + GameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printExploreLevelMenu() {
		System.out.println(" ");
		System.out.println(
				GameConstants.ANSI_BLUE + "Select the level number you would like explore:" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_YELLOW + "1" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_GREEN + "2" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_CYAN + "3" + GameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	private static void printGameActionMainMenu() {
		System.out.println(" ");
		System.out.println(GameConstants.ANSI_BLUE + "\n" + "Select an option" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_YELLOW + "6 Create and save" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_GREEN + "7 Play/Resume" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_CYAN + GameConstants.GO_BACK_MENU_MESSAGE + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_RED + GameConstants.EXIT_MENU_MESSAGE + GameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printGameActionSubMenu() {
		System.out.println(GameConstants.ANSI_BLUE  + "\n" + "Select The option you want to perform" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_YELLOW + "1 Fight" + GameConstants.ANSI_RESET);
		System.out.println(GameConstants.ANSI_GREEN + "2 Save Game" +  GameConstants.ANSI_RESET);
	}

	public static void printWelcomeMessage() {
		System.out.println();
		System.out.println(
				GameConstants.ANSI_GREEN + "           ***********          *************           *********");
		System.out.println(GameConstants.ANSI_GREEN + "           **       **          **         **         **");
		System.out.println(GameConstants.ANSI_GREEN + "           **       **          **         **        **");
		System.out.println(GameConstants.ANSI_GREEN + "           ***********          *************       **");
		System.out.println(
				GameConstants.ANSI_GREEN + "           **       **          **                  **  ************");
		System.out.println(
				GameConstants.ANSI_GREEN + "           **        **         **                   **            **");
		System.out.println(
				GameConstants.ANSI_GREEN + "           **         **        **                    **          **");
		System.out.println(GameConstants.ANSI_GREEN
				+ "           **          **       **                     ***********" + GameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printExitMessage() {
		System.out.println(GameConstants.ANSI_GREEN + "Bye for now... See You Soon" + GameConstants.ANSI_RESET);
	}

	public static void selectPrintableMenus(String option) {
		if ("0".equals(option)) {
			printMainMenu();
		} else if ("2".equals(option)) {
			printMainExploreMenu();
		} else if ("3".equals(option)) {
			printGameActionMainMenu();
		}
	}
}
