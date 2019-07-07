package com.rpg.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.rpg.constants.GameConstants;

public class MenuValidationUtil {

	private static boolean isValidOptionForMainMenu(String option) {
		return (GameConstants.NEW_CHARACTER.equals(option) || GameConstants.EXPLORE_MAIN_MENU.equals(option)
				|| GameConstants.START_GAME_MAIN_MENU.equals(option) || GameConstants.EXIT_GAME.equals(option));
	}

	private static boolean isValidOptionForExploreMenu(String option) {
		return (GameConstants.EXPLORE_CHARACTERS.equals(option) || GameConstants.EXPLORE_LEVELS.equals(option)
				|| GameConstants.GO_BACK.equals(option) || GameConstants.EXIT_GAME.equals(option));
	}

	private static boolean isValidOptionForStartGameMenu(String option) {
		return (GameConstants.NEW_GAME.equals(option) || GameConstants.RESUME_GAME.equals(option)
				|| GameConstants.GO_BACK.equals(option) || GameConstants.EXIT_GAME.equals(option));
	}

	private static boolean isBlank(String option) {
		return (option == null || option.trim().isEmpty());
	}

	public static List<String> nonActionMenuList() {
		List<String> nonActionMenuList = new ArrayList<>();
		nonActionMenuList.add("0"); // Main Menu
		nonActionMenuList.add("2"); // Explore Menu
		nonActionMenuList.add("3"); // Start Game Menu
		return nonActionMenuList;
	}

	public static Map<String, String> goBackMenuMap() {
		Map<String, String> goBackMenuMap = new HashMap<>();
		goBackMenuMap.put("2", "0");
		goBackMenuMap.put("3", "0");
		goBackMenuMap.put("6", "0");
		goBackMenuMap.put("7", "0");
		goBackMenuMap.put("8", "3");
		goBackMenuMap.put("9", "3");
		return goBackMenuMap;
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
