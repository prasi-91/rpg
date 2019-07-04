package com.rpg.domain;

public class RpgCharacter {

	private Long id;
	private String characterName;
	private String weapon;
	private int experience;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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

	public RpgCharacter(String characterName, String weapon, int experience) {
		this.characterName = characterName;
		this.weapon = weapon;
		this.experience = experience;
	}

	public RpgCharacter() {

	}

}
