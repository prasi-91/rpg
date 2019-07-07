/*
 * Author M S Prasita Nair
 * 
 * The Character Pojo Modeled as Entity for GAME Table
 * 
 */
package com.rpg.entities;

public class Game {

	private Integer gameId;
	private Integer characterId;
	private String gameName;

	public String getGameName() {
		return gameName;
	}

	public void setGameName(String gameName) {
		this.gameName = gameName;
	}

	public Integer getGameId() {
		return gameId;
	}

	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}

	public Integer getCharacterId() {
		return characterId;
	}

	public void setCharacterId(Integer characterId) {
		this.characterId = characterId;
	}

}
