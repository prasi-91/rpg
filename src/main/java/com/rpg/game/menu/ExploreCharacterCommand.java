package com.rpg.game.menu;

import java.util.List;

import com.rpg.domain.RpgCharacter;
import com.rpg.service.impl.GamingActionServiceImpl;
import com.rpg.service.impl.RpgCharacterServiceImpl;
import com.rpg.util.ScannerUtil;

public class ExploreCharacterCommand implements Command {

	private static GamingActionServiceImpl gamingActionService = new GamingActionServiceImpl();

	@Override
	public boolean excuteOperationChoosen() {
		System.out.println(" ");
		System.out.println("The game has following amazing characters");
		System.out.println("============================================");
		try {
			List<String> characterList = gamingActionService.exploreCharacters();
			characterList.forEach(item -> {
				System.out.println(item);
			});
			System.out.println(" ");
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
