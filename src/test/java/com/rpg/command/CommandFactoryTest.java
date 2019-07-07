package com.rpg.command;

import org.junit.Test;

import com.rpg.game.menu.CommandFactory;

public class CommandFactoryTest {

	@Test
	public void testCommandFactory() {
		String option = "1";
		CommandFactory.getCommandInstance(option);
		option = "4";
		CommandFactory.getCommandInstance(option);
		option = "5";
		CommandFactory.getCommandInstance(option);
		option = "6";
		CommandFactory.getCommandInstance(option);
		option = "7";
		CommandFactory.getCommandInstance(option);
	}
	
}
