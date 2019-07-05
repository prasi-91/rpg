package com.rpg.game.menu;

public interface Command {

	void excuteOperationChoosen();

	boolean isExitPressed();

	String previousMenu();
	
	boolean isGoBackPressed();
}
