/*
 * Author M S Prasita Nair
 * 
 * The Class contains all the constant Strings used in the application
 * 
 */

package com.rpg.constants;

public class GameConstants {

	public static final String URL_PREFIX = "jdbc:sqlite:";
	public static final String URL_SUFFIX = "//RPGames.db";
	public static final String DRIVER = "org.sqlite.JDBC";

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW = "\u001B[33m";

	public static final String NEW_CHARACTER = "1";
	public static final String EXPLORE_MAIN_MENU = "2";
	public static final String START_GAME_MAIN_MENU = "3";
	public static final String EXPLORE_CHARACTERS = "4";
	public static final String EXPLORE_LEVELS = "5";
	public static final String NEW_GAME = "6";
	public static final String RESUME_GAME = "7";
	public static final String FIGHT = "8";
	public static final String RESAVE_GAME = "9";
	public static final String GO_BACK = "10";
	public static final String EXIT_GAME = "11";

	public static final String EXIT_MENU_MESSAGE = "11 Exit Game ";
	public static final String GO_BACK_MENU_MESSAGE = "10 Go Back";
	public static final String GAME_DAO = "Game";
	public static final String CHARACTER_DAO = "Character";
	

	private GameConstants() {

	}
}
