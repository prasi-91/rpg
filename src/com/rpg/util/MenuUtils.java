package com.rpg.util;

public class MenuUtils {

	public static void printMainMenu() {
		System.out.println("Welcome to application");
		System.out.println("Select the operation that you would like to perform");
		System.out.println("1 Create a Character");
		System.out.println("2 Explore");
		System.out.println("3 Start Game");
		System.out.println("4 Exit");
	}

	public static void printInvalidOption() {
		System.out.println("Please Select a valid option");
	}

	public static void printMainExploreMenu() {
		System.out.println("Select the number which you want to explore");
		System.out.println("1 Explore Characters");
		System.out.println("2 Explore levels");
		System.out.println("3 Go Back");
		System.out.println("4 Exit");
	}

	public static void printExploreLevelMenu() {
		System.out.println("Select the level number you would like explore:");
		System.out.println("1 Level 1");
		System.out.println("2 Level 2");
		System.out.println("3 Level 3");
	}
	
	public static void printGameActionMainMenu() {
		System.out.println("Select an option");
		System.out.println("1) Start a new Game with a character");
		System.out.println("2) Resume a game");
		System.out.println("3) Go back");
	}
	
	public static void printGameActionSubMenu() {
		System.out.println("Select the option number you would like to do");
		System.out.println("1 Fight");
		System.out.println("2 Save game");
		System.out.println("4 Go Back");
		System.out.println("9 Exit");
	}
}
