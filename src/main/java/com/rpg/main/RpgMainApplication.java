/*
 * Author M S Prasita Nair
 * 
 * Main entry class for Game
 * 
 */
package com.rpg.main;

import com.rpg.game.menu.GameControl;
import com.rpg.util.MessageUtils;

public class RpgMainApplication {

	public static void main(String[] args) {

		MessageUtils.printWelcomeMessage();
		GameControl gm = new GameControl();
		gm.startGame();

	}

}
