package com.rpg.game.menu;

import com.rpg.service.impl.GamingActionServiceImpl;
import com.rpg.util.MessageUtils;
import com.rpg.util.ScannerUtil;

public class ExploreLevelsCommand implements Command {

	private static GamingActionServiceImpl gameActionService = new GamingActionServiceImpl();

	@Override
	public boolean excuteOperationChoosen() {
		MessageUtils.printExploreLevelMenu();
		String levelName = ScannerUtil.inputHandler.nextLine();
		System.out.println(gameActionService.exploreLevel(levelName));
		return true;
	}

	@Override
	public String previousMenu() {
		return "2";
	}

}
