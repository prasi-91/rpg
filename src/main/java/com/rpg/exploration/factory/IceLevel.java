/*
 * Author M S Prasita Nair
 * 
 * Ice Level Concrete Implementation of Level
 * 
 */

package com.rpg.exploration.factory;

public class IceLevel implements Level {

	@Override
	public String getLevelEnvironment() {
		return "The battle ground for this Level is Ice.";

	}

	@Override
	public String getLevelDifficulty() {
		return " Difficulty Level is High";
	}

	@Override
	public String getEligibility() {
		return "You Need experience more than 150.";
	}

}
