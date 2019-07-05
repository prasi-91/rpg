package com.rpg.exploration.factory;

public class LevelFactory {

	public static Level getLevel(int level) {

		switch (level) {

		case 1:
			return new GroundLevel();
		case 2:
			return new MountainLevel();
		case 3:
			return new IceLevel();
		default:
			return null;
		}
	}
}
