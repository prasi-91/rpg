package com.rpg.entities;

public class Character {

	private Integer id;
	private String characterName;
	private String weapon;
	private int experience;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCharacterName() {
		return characterName;
	}

	public void setCharacterName(String characterName) {
		this.characterName = characterName;
	}

	public String getWeapon() {
		return weapon;
	}

	public void setWeapon(String weapon) {
		this.weapon = weapon;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public Character(String characterName, String weapon, int experience) {
		this.characterName = characterName;
		this.weapon = weapon;
		this.experience = experience;
	}

	public Character() {

	}

}
