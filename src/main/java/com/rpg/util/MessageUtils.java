package com.rpg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rpg.constants.RpGameConstants;

public class MessageUtils {

	private static void printMainMenu() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_BLUE + "Select the operation that you would like to perform"
				+ RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_YELLOW + "1 Create a Character" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_GREEN + "2 Explore" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_CYAN + "3 Start Game" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_RED + "11 Exit Game" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printInvalidOption() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_RED + "Please Select a valid option" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	private static void printMainExploreMenu() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_BLUE + "\n" + "Select the number which you want to explore"
				+ RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_YELLOW + "4 Explore Characters" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_GREEN + "5 Explore levels" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_CYAN + "10 Go Back" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_RED + "11 Exit Game" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printExploreLevelMenu() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_BLUE + "Select the level number you would like explore:"
				+ RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_YELLOW + "Level 1" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_GREEN + "Level 2" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_CYAN + "Level 3" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	private static void printGameActionMainMenu() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_BLUE + "\n" + "Select an option" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_YELLOW + "6 Create and save a new games" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_GREEN + "7 Resume saved games" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_CYAN + "10 Go Back" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_RED + "11 Exit Game" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printGameActionSubMenu() {
		System.out.println(" ");
		System.out.println(RpGameConstants.ANSI_BLUE + "\n" + "Select the option number you would like to do"
				+ RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_YELLOW + "8 Fight" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_GREEN + "9 Save game" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_CYAN + "10 Go Back" + RpGameConstants.ANSI_RESET);
		System.out.println(RpGameConstants.ANSI_RED + "11 Exit Game" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	public static void printWelcomeMessage() {
		System.out.println();
		System.out.println(
				RpGameConstants.ANSI_GREEN + "           ***********          *************           *********");
		System.out.println(RpGameConstants.ANSI_GREEN + "           **       **          **         **         **");
		System.out.println(RpGameConstants.ANSI_GREEN + "           **       **          **         **        **");
		System.out.println(RpGameConstants.ANSI_GREEN + "           ***********          *************       **");
		System.out.println(
				RpGameConstants.ANSI_GREEN + "           **       **          **                  **  ************");
		System.out.println(
				RpGameConstants.ANSI_GREEN + "           **        **         **                   **            **");
		System.out.println(
				RpGameConstants.ANSI_GREEN + "           **         **        **                    **          **");
		System.out.println(RpGameConstants.ANSI_GREEN
				+ "           **          **       **                     ***********" + RpGameConstants.ANSI_RESET);
		System.out.println(" ");
	}

	private static boolean isValidOptionForMainMenu(String option) {
		return (RpGameConstants.NEW_CHARACTER.equals(option) || RpGameConstants.EXPLORE_MAIN_MENU.equals(option)
				|| RpGameConstants.START_GAME_MAIN_MENU.equals(option) || RpGameConstants.EXIT_GAME.equals(option));
	}

	private static boolean isValidOptionForExploreMenu(String option) {
		return (RpGameConstants.EXPLORE_CHARACTERS.equals(option) || RpGameConstants.EXPLORE_LEVELS.equals(option)
				|| RpGameConstants.GO_BACK.equals(option) || RpGameConstants.EXIT_GAME.equals(option));
	}

	private static boolean isValidOptionForStartGameMenu(String option) {
		return (RpGameConstants.NEW_GAME.equals(option) || RpGameConstants.RESUME_GAME.equals(option)
				|| RpGameConstants.GO_BACK.equals(option) || RpGameConstants.EXIT_GAME.equals(option));
	}

	private static boolean isBlank(String option) {
		return (option == null || option.trim().isEmpty());
	}

	public static void printExitMessage() {
		System.out.println(RpGameConstants.ANSI_GREEN + "Bye for now... See You Soon" + RpGameConstants.ANSI_RESET);
	}

	public static List<String> nonActionMenuList() {
		List<String> nonActionMenuList = new ArrayList<>();
		nonActionMenuList.add("0"); // Main Menu
		nonActionMenuList.add("2"); // Explore Menu
		nonActionMenuList.add("3"); // Start Game Menu
		return nonActionMenuList;
	}

	public static Map<String, String> goBackMenuMap() {
		Map<String, String> goBackMenuMap = new HashMap<String, String>();
		goBackMenuMap.put("2", "0");
		goBackMenuMap.put("3", "0");
		goBackMenuMap.put("6", "0");
		goBackMenuMap.put("7", "0");
		goBackMenuMap.put("8", "3");
		goBackMenuMap.put("9", "3");
		return goBackMenuMap;
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

	public static boolean validateInputForOption(String prevOption, String currentOption) {
		if ("0".equals(prevOption)) {
			return isValidOptionForMainMenu(currentOption);
		} else if ("2".equals(prevOption)) {
			return isValidOptionForExploreMenu(currentOption);
		} else if ("3".equals(prevOption)) {
			return isValidOptionForStartGameMenu(currentOption);
		}
		return false;
	}
	
}
