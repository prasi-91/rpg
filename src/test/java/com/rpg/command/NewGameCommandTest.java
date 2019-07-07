package com.rpg.command;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rpg.entities.Character;
import com.rpg.entities.Game;
import com.rpg.exception.CharacterServiceException;
import com.rpg.exception.GameServiceException;
import com.rpg.game.menu.NewGameCommand;
import com.rpg.service.impl.CharacterServiceImpl;
import com.rpg.service.impl.GameServiceImpl;
import com.rpg.util.ScannerUtil;

public class NewGameCommandTest {

	@Mock
	ScannerUtil scUtil;

	@InjectMocks
	NewGameCommand newGameCommand;

	@Mock
	GameServiceImpl gameService;

	@Mock
	CharacterServiceImpl charService;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNewGame() throws CharacterServiceException, GameServiceException {
		Mockito.when(scUtil.getInput()).thenReturn("test");
		List<Character> rpgCharList = new ArrayList<>();
		Character rpgChar = new Character();
		rpgChar.setId(1);
		Game rpGame = new Game();
		Mockito.when(scUtil.getInput()).thenReturn("test");
		Mockito.when(charService.fetchAllRpgCharacters()).thenReturn(rpgCharList);
		Mockito.when(charService.getRpgCharacterByName("test")).thenReturn(rpgChar);
		Mockito.doNothing().when(gameService).createNewGame(rpGame);
		boolean isSuccessFull = newGameCommand.excuteOperationChoosen();
		assertTrue(isSuccessFull);
	}

}
