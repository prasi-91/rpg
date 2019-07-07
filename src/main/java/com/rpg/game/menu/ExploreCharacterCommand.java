/*
 * Author M S Prasita Nair
 * 
 * Class to execute the explore Character operation
 * 
 */
package com.rpg.game.menu;

import java.util.List;
import com.rpg.service.impl.GameActionServiceImpl;

public class ExploreCharacterCommand implements Command {

	private GameActionServiceImpl gamingActionService = new GameActionServiceImpl();

	@Override
	public boolean excuteOperationChoosen() {

		try {
			List<String> characterList = gamingActionService.exploreCharacters();
			if (characterList != null && !characterList.isEmpty()) {
				System.out.println(" ");
				System.out.println("The game has following amazing characters");
				System.out.println("============================================");
				characterList.forEach(System.out::println);
				System.out.println(" ");
			} else {
				System.out.println("There are no characters created till now, please create one from the main men");
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}
		return true;
	}

	@Override
	public String previousMenu() {
		return "2";
	}

}
