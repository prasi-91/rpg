package com.rpg.command;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rpg.entities.Character;
import com.rpg.exception.CharacterServiceException;
import com.rpg.game.menu.NewCharacterCommand;
import com.rpg.service.impl.CharacterServiceImpl;
import com.rpg.util.ScannerUtil;

public class NewCharCommandTest {

	@Mock
	ScannerUtil scUtil;

	@InjectMocks
	NewCharacterCommand newCharCommand;

	@Mock
	CharacterServiceImpl charService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testCreateNewChar() throws CharacterServiceException {
		Mockito.when(scUtil.getInput()).thenReturn("test");
		Character rpgChar = new Character();
		Mockito.doNothing().when(charService).createNewCharacter(rpgChar);
		newCharCommand.excuteOperationChoosen();
	}
}
