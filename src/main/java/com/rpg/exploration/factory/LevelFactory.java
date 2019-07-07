/*
 * Author M S Prasita Nair
 * 
 * Class to create concrete level objects
 * 
 */
package com.rpg.exploration.factory;

public class LevelFactory {

	public static Level getLevel(String levelName) {
		if (levelName == null) {
			return null;
		}
		switch (levelName.toUpperCase()) {
		case "LEVEL 1":
			return new GroundLevel();
		case "LEVEL 2":
			return new MountainLevel();
		case "LEVEL 3":
			return new IceLevel();
		default:
			return null;
		}
	}
}
