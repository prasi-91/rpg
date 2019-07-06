package com.rpg.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.rpg.domain.RpgCharacter;
import com.rpg.exception.CharacterServiceException;
import com.rpg.exploration.factory.Level;
import com.rpg.exploration.factory.LevelFactory;

public class GamingActionServiceImpl {

	private static RpgCharacterServiceImpl rpgCharacterService = new RpgCharacterServiceImpl();

	public String exploreLevel(String levelName) {
		Level level = LevelFactory.getLevel(levelName);
		if (level == null) {
			return "Invalid level choosen";
		}
		StringBuilder strBuil = new StringBuilder();
		strBuil.append(level.getLevelEnvironment());
		strBuil.append(level.getLevelDifficulty());
		strBuil.append(" and ");
		strBuil.append(level.getEligibility());
		return strBuil.toString();
	}

	public List<String> exploreCharacters() throws CharacterServiceException {
		List<String> characterList = new ArrayList<>();
		final int[] count = { 0 };

		rpgCharacterService.fetchAllRpgCharacters().forEach(item -> {
			count[0]++;
			StringBuilder sb = new StringBuilder();
			sb.append(count[0]).append(" ").append(item.getCharacterName()).append(" ");
			if (item.getWeapon() != null && !item.getWeapon().trim().isEmpty()) {
				sb.append("has weapon").append(" ").append(item.getWeapon()).append(" and ");
			} else {
				sb.append("has no weapon and ");
			}
			sb.append(" Experience ").append(item.getExperience());
			characterList.add(sb.toString());
		});

		return characterList;
	}

	public void fight(RpgCharacter rpgChar) {
		try {
			final int monsterGen = (int) (Math.random() * 10 + 1);
			if (monsterGen == 0) {
				System.out.println("You're fighting a: Wizard");
			} else if (monsterGen == 2) {
				System.out.println("You're fighting a: Dragon");
			} else {
				System.out.println("You're fighting a: Troll");
			}
			Integer earnedExperience = (int) (Math.random() * 10 + 1);
			rpgChar.setExperience(earnedExperience);
			rpgCharacterService.updateCharacter(rpgChar);
			System.out.println("Your Character has gained experience");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
