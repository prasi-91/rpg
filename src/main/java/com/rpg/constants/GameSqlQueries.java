/*
 * Author M S Prasita Nair
 * 
 * The Class contains all the SQL Queries made to the Table GAMES_PLAYED
 * 
 */

package com.rpg.constants;

public class GameSqlQueries {

	public static final String SELECT_ALL_GAMES_QUERY = "SELECT ID, NAME, CHARACTER_ID FROM GAMES_PLAYED ";
	public static final String SELECT_GAME_QUERY_BY_NAME = "SELECT ID, NAME, CHARACTER_ID FROM GAMES_PLAYED WHERE NAME = ? COLLATE NOCASE";
	public static final String SELECT_GAME_QUERY_BY_ID = "SELECT ID, NAME, CHARACTER_ID FROM GAMES_PLAYED WHERE ID = ?";
	public static final String INSERT_GAME_QUERY = "INSERT INTO GAMES_PLAYED (NAME,CHARACTER_ID) VALUES (?,?)";
	public static final String UPDATE_GAME_QUERY = " UPDATE GAMES_PLAYED SET NAME = ? WHERE ID = ? ";

	private GameSqlQueries() {

	}

}
