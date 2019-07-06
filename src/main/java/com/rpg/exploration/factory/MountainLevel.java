package com.rpg.exploration.factory;

public class MountainLevel implements Level {

	@Override
	public String getLevelEnvironment() {
		return "The battle ground for this Level is Moutains. ";

	}

	@Override
	public String getLevelDifficulty() {
		return "Difficulty Level is Medium";
	}

	@Override
	public String getEligibility() {
		return "You Need experience more than 50. ";
	}

}