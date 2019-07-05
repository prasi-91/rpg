package com.rpg.constants;

public class RpGameConstants {

	public static final String URL = "jdbc:sqlite:C:/sqlLite/RPGame.db";
	public static final String DRIVER = "org.sqlite.JDBC";

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_YELLOW = "\u001B[33m";

	public static final String NEW_CHARACTER = "1";
	public static final String CREATE_NEW_GAME = "1";
	public static final String RESUME_GAME = "2";
	public static final String EXIT_GAME = "8";
	public static final String EXPLORE_LEVELS = "2";
	public static final String EXPLORE_CHARACTERS = "1";
	public static final String FIGHT = "1";
	public static final String SAVE_GAME = "2";
	public static final String EXPLORE_MAIN_MENU = "2";
	public static final String START_GAME_MAIN_MENU = "3";
	public static final String NEW_GAME = "1";
	public static final String RESUME = "2";
	public static final String GO_BACK = "3";
	public static final String FILE_EXT = ".ser";
	public static final String RELATIVE_FILE_PATH = "./characters/";

	private RpGameConstants() {

	}
}
