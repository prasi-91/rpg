package com.rpg.game.menu;

import java.util.Scanner;

import com.rpg.exploration.factory.Level;
import com.rpg.exploration.factory.LevelFactory;
import com.rpg.service.impl.RpgCharacterServiceImpl;
import com.rpg.util.MenuUtils;

public class ExploreGameMenu implements GameMenu {

	private static Scanner in = new Scanner(System.in);
	private static RpgCharacterServiceImpl rpgCharacterService = new RpgCharacterServiceImpl();

	@Override
	public void excuteOperationChoosen() {
		exploreLoop: while (true) {
			MenuUtils.printMainExploreMenu();
			int option = in.nextInt();
			switch (option) {
			case 1:
				final int[] count = { 0 };
				try {
					rpgCharacterService.fetchAllRpgCharacters().forEach(item -> {
						count[0]++;
						StringBuilder sb = new StringBuilder();
						System.out.println("The game has following amazing characters");
						sb.append(count[0]).append(" ").append(item.getCharacterName()).append(" ").append("has weapon")
								.append(" ").append(item.getWeapon()).append(" and Experience")
								.append(item.getExperience());
					});
				} catch (Exception e) {
					System.out.println(e.getMessage());
					break;
				}
				break;
			case 2:
				MenuUtils.printExploreLevelMenu();
				int levelnum = in.nextInt();
				Level level = LevelFactory.getLevel(levelnum);
				if (level == null) {
					MenuUtils.printInvalidOption();
				}
				StringBuilder sb = new StringBuilder();
				System.out.println(sb.append(level.getLevelEnvironment()).append(level.getLevelDifficulty())
						.append(level.getEligibility()));
				continue;
			case 3:
				break exploreLoop;
			case 4:
				break;
			default:
				MenuUtils.printInvalidOption();
				continue;
			}
		}
	}

}
