/*
 * Author M S Prasita Nair
 * 
 * The Class contains all the SQL Queries made to the Table CHARACTER
 * 
 */

package com.rpg.constants;

public class CharacterSqlQueries {

	public static final String SELECT_ALL_CHARACTERS_QUERY = "SELECT ID, NAME, EXPERIENCE, WEAPON FROM CHARACTER ";
	public static final String SELECT_CHARACTER_QUERY_BY_NAME = "SELECT ID, NAME, EXPERIENCE, WEAPON FROM CHARACTER WHERE NAME = ? COLLATE NOCASE";
	public static final String SELECT_CHARACTER_QUERY_BY_ID = "SELECT ID, NAME, EXPERIENCE, WEAPON FROM CHARACTER WHERE ID = ? ";
	public static final String INSERT_CHARACTER_QUERY = "INSERT INTO CHARACTER (NAME, EXPERIENCE, WEAPON) VALUES (?,?,?)";
	public static final String UPDATE_CHARACTER_QUERY = " UPDATE CHARACTER SET EXPERIENCE = ? WHERE NAME = ? ";
}
