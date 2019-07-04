package com.rpg.constants;

public class RpgCharacterQueries {

	public static final String SELECT_ALL_CHARACTERS = "Select id, name, experience, weapon from Character";
	public static final String SELECT_A_CHARACTER = "Select id, name, experience, weapon from Character where name = ?";
	public static final String INSERT_CHARACTER_QUERY = "Insert into Character values(NULL, ?,?,?)";
	public static final String UPDATE_CHARACTER_QUERY = " Update Character set experience = ? where name = ?";
}
