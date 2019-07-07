/*
 * Author M S Prasita Nair
 * 
 * Class to execute the explore level operation
 * 
 */
package com.rpg.game.menu;

import com.rpg.service.impl.GameActionServiceImpl;
import com.rpg.util.MessageUtils;
import com.rpg.util.ScannerUtil;

public class ExploreLevelsCommand implements Command {

	private static GameActionServiceImpl gameActionService = new GameActionServiceImpl();
	private static ScannerUtil in = new ScannerUtil();

	@Override
	public boolean excuteOperationChoosen() {
		MessageUtils.printExploreLevelMenu();
		String levelName = in.getInput();
		System.out.println(gameActionService.exploreLevel(levelName));
		return true;
	}

	@Override
	public String previousMenu() {
		return "2";
	}

}
