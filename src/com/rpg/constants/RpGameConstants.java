package com.rpg.constants;

public class RpGameConstants {

	public static final String URL = "jdbc:sqlite:SqliteJavaDB.db";
	public static final String USER = "testuser";
	public static final String PASS = "testpass";
	public static final String DRIVER = "org.sqlite.JDBC";

	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_CYAN = "\u001B[36m";

	public static final int NEW_CHARACTER = 1;
	public static final int LOAD_SAVED_GAMES = 2;
	public static final int EXIT_GAME = 8;
	public static final int EXPLORE_LEVELS = 3;
	public static final int FIGHT = 2;
	public static final int SAVE_GAME = 3;

}
