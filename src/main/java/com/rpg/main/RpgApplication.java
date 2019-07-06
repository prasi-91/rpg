package com.rpg.main;

import com.rpg.game.menu.GameControl;
import com.rpg.util.MessageUtils;

public class RpgApplication {

	public static void main(String[] args) {

		MessageUtils.printWelcomeMessage();
		GameControl gm = new GameControl();
		gm.startGame();

	}

}
