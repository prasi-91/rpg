package com.rpg.util;

import com.rpg.constants.RpGameConstants;

public class MessageUtils {

	public static void printMainMenu() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_BLUE + "Select the operation that you would like to perform"
				+ RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_YELLOW + "1 Create a Character" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_GREEN + "2 Explore" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_CYAN + "3 Start Game" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_RED + "8 Exit Game" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printInvalidOption() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_RED + "Please Select a valid option" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printMainExploreMenu() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_BLUE + "\n" + "Select the number which you want to explore"
				+ RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_YELLOW + "1 Explore Characters" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_GREEN + "2 Explore levels" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_CYAN + "3 Go Back" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_RED + "8 Exit Game" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printExploreLevelMenu() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_BLUE + "Select the level number you would like explore:"
				+ RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_YELLOW + "1 Level 1" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_GREEN + "2 Level 2" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_CYAN + "3 Level 3" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printGameActionMainMenu() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_BLUE + "\n" + "Select an option" + RpGameConstants.ANSI_RESET);
		System.out.println(
				RpGameConstants.ANSI_YELLOW + "1 Start a new Game with a character" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_GREEN + "2 Resume a game" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_CYAN + "3 Go Back" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_RED + "8 Exit Game" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printGameActionSubMenu() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_BLUE + "\n" + "Select the option number you would like to do"
				+ RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_YELLOW + "1 Fight" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_GREEN + "2 Save game" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_CYAN + "3 Go Back" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_RED + "8 Exit Game" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printWelcomeMessage() {
		System.out.println();
		System.out.println(RpGameConstants.ANSI_GREEN
				+ "           ***********          *************           *********");
		System.out.println(
				RpGameConstants.ANSI_GREEN + "           **       **          **         **         **");
		System.out
				.println(RpGameConstants.ANSI_GREEN + "           **       **          **         **        **");
		System.out
				.println(RpGameConstants.ANSI_GREEN + "           ***********          *************       **");
		System.out.println(RpGameConstants.ANSI_GREEN
				+ "           **       **          **                  **  ************");
		System.out.println(RpGameConstants.ANSI_GREEN 
				+ "           **        **         **                   **            **");
		System.out.println(RpGameConstants.ANSI_GREEN
				+ "           **         **        **                    **          **");
		System.out.println(RpGameConstants.ANSI_GREEN
				+ "           **          **       **                     ***********" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static boolean isValidOptionForMainMenu(String option) {
		return (RpGameConstants.NEW_CHARACTER.equals(option) || RpGameConstants.EXPLORE_MAIN_MENU.equals(option)
				|| RpGameConstants.START_GAME_MAIN_MENU.equals(option) || RpGameConstants.EXIT_GAME.equals(option));
	}

	public static boolean isBlank(String option) {
		return (option == null || option.trim().isEmpty());
	}

	public static void printExitMessage() {
		System.out.println(RpGameConstants.ANSI_GREEN + "Bye for now... See You Soon" + RpGameConstants.ANSI_RESET);
	}
	
	
}
