package com.rpg.util;

import java.util.ArrayList;

import com.rpg.constants.RpGameConstants;

public class MenuUtils {

	public static void printMainMenu() {
		System.out.println(" ");
		System.out.println("Select the operation that you would like to perform");
		System.out.println("1 Create a Character");
		System.out.println("2 Explore");
		System.out.println("3 Start Game");
		System.out.println("8 Exit Game");
		System.out.println(" ");
	}

	public static void printInvalidOption() {
		System.out.println(" ");
		System.out.println("Please Select a valid option");
		System.out.println(" ");
	}

	public static void printMainExploreMenu() {
		System.out.println(" ");
		System.out.println("Select the number which you want to explore");
		System.out.println("1 Explore Characters");
		System.out.println("2 Explore levels");
		System.out.println("3 Go Back");
		System.out.println("8 Exit Game");
		System.out.println(" ");
	}

	public static void printExploreLevelMenu() {
		System.out.println(" ");
		System.out.println("Select the level number you would like explore:");
		System.out.println("1 Level 1");
		System.out.println("2 Level 2");
		System.out.println("3 Level 3");
		System.out.println(" ");
	}

	public static void printGameActionMainMenu() {
		System.out.println(" ");
		System.out.println("Select an option");
		System.out.println("1 Start a new Game with a character");
		System.out.println("2 Resume a game");
		System.out.println("3 Go Back");
		System.out.println("8 Exit Game");
		System.out.println(" ");
	}

	public static void printGameActionSubMenu() {
		System.out.println(" ");
		System.out.println("Select the option number you would like to do");
		System.out.println("1 Fight");
		System.out.println("2 Save game");
		System.out.println("3 Go Back");
		System.out.println("8 Exit Game");
		System.out.println(" ");
	}

	public static void printWelcomeMessage() {
		System.out.println("WELCOME TO TRIWIZARD GAME");
		System.out.println(" ");
	}

	public static boolean isValidOptionForMainMenu(String option) {
		if (RpGameConstants.NEW_CHARACTER.equals(option) || RpGameConstants.EXPLORE_MAIN_MENU.equals(option)
				|| RpGameConstants.START_GAME_MAIN_MENU.equals(option) || RpGameConstants.EXIT_GAME.equals(option)) {
			return true;
		}
		return false;
	}

	/*
	 * public static boolean isValidOptionForExploreMenu(int option) { if (option ==
	 * RpGameConstants.EXPLORE_CHARACTERS || option ==
	 * RpGameConstants.EXPLORE_LEVELS) { return true; } return false; }
	 * 
	 * public static boolean isValidOptionForGameMenu(int option) { if (option ==
	 * RpGameConstants.RESUME_GAME || option == RpGameConstants.NEW_GAME) { return
	 * true; } return false; }
	 * 
	 * public static boolean isValidOptionForGameActionMenu(int option) { if (option
	 * == RpGameConstants.FIGHT || option == RpGameConstants.SAVE_GAME) { return
	 * true; } return false; }
	 */
	public static boolean isBlank(String option) {
		if (option == null || option.trim().isEmpty()) {
			return false;
		}
		return true;
	}

}
