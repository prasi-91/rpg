package com.rpg.service.impl;

import com.rpg.domain.RpgCharacter;
import com.rpg.exploration.factory.Level;
import com.rpg.exploration.factory.LevelFactory;

public class GamingActionServiceImpl {

	public String exploreLevel(int levelNum) {
		Level level = LevelFactory.getLevel(levelNum);
		StringBuilder strBuil = new StringBuilder();
		strBuil.append(level.getLevelEnvironment());
		strBuil.append(" and ");
		strBuil.append(level.getLevelDifficulty());
		return strBuil.toString();
	}

	public RpgCharacter fight(RpgCharacter rpgChar) {
		Integer earnedExperience = (int) (Math.random() * 10 + 1);
		rpgChar.setExperience(earnedExperience);
		return rpgChar;
	}


}
