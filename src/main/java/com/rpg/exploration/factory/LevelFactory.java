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
		case "1":
			return new GroundLevel();
		case "2":
			return new MountainLevel();
		case "3":
			return new IceLevel();
		default:
			return null;
		}
	}
}
