package com.rpg.constants;

public class RpgGameQueries {

	public static final String SELECT_ALL_GAMES_QUERY = "Select id, name, character_id, weapon from SavedGames";
	public static final String SELECT_GAME_QUERY = "Select id, name, character_id, weapon from SavedGames where name = ?";
	public static final String INSERT_GAME_QUERY = "Insert into SavedGames values (NULL, ?,?)";
	public static final String UPDATE_GAME_QUERY = " Update SavedGames set name = ? where name = ?";

}
