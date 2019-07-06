package com.rpg.exploration.factory;

public class GroundLevel implements Level {

	@Override
	public String getLevelEnvironment() {
		return "The battle ground for this Level is Ground.";
	}

	@Override
	public String getLevelDifficulty() {
		return "Difficulty Level is low";
	}

	@Override
	public String getEligibility() {
		return "You donot need experience to play this level.";
	}

}