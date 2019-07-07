package com.rpg.game.menu;

import java.util.List;
import java.util.Map;
import java.util.Scanner;

import com.rpg.constants.GameConstants;
import com.rpg.util.MenuValidationUtil;
import com.rpg.util.MessageUtils;
import com.rpg.util.ScannerUtil;

public class GameControl {

	private static final Map<String, String> goBackMenuMap = MenuValidationUtil.goBackMenuMap();
	private static final List<String> printableMenuList = MenuValidationUtil.nonActionMenuList();
	private static final ScannerUtil in = new ScannerUtil();

	public void startGame() {
		MessageUtils.selectPrintableMenus("0");
		String previousOption = "0";
		gameloop: while (true) {
			String option = in.getInput();
			if (!MenuValidationUtil.validateInputForOption(previousOption, option)) {
				MessageUtils.printInvalidOption();
			} else if (GameConstants.EXIT_GAME.equals(option)) {
				MessageUtils.printExitMessage();
				break gameloop;
			} else if (GameConstants.GO_BACK.equals(option)) {
				if (goBackMenuMap.get(previousOption) != null) {
					MessageUtils.selectPrintableMenus(goBackMenuMap.get(previousOption));
					previousOption = goBackMenuMap.get(previousOption);
				}
			} else if (printableMenuList.contains(option)) {
				MessageUtils.selectPrintableMenus(option);
				previousOption = option;
			} else {
				Command cm = CommandFactory.getCommandInstance(option);
				if (cm == null) {
					MessageUtils.selectPrintableMenus(previousOption);
					continue;
				}
				boolean isSuccessFull = cm.excuteOperationChoosen();
				if (isSuccessFull) {
					previousOption = cm.previousMenu();
				}
				MessageUtils.selectPrintableMenus(previousOption);
			}

		}
	}

}
