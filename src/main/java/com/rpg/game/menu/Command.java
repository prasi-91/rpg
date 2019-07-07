/*
 * Author M S Prasita Nair
 * 
 * Class to create concrete Command objects
 * 
 */
package com.rpg.game.menu;

public interface Command {

	boolean excuteOperationChoosen();

	String previousMenu();
}
