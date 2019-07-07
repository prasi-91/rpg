package com.rpg.command;

import static org.mockito.Matchers.anyString;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import com.rpg.entities.Character;
import com.rpg.entities.Game;
import com.rpg.exception.CharacterServiceException;
import com.rpg.exception.GameServiceException;
import com.rpg.game.menu.PlayGameCommand;
import com.rpg.service.impl.CharacterServiceImpl;
import com.rpg.service.impl.GameServiceImpl;
import com.rpg.util.ScannerUtil;

public class ResumeGameCommandTest {

	@Mock
	ScannerUtil scUtil;

	@Spy
	GameServiceImpl gameService;
	
	@Mock
	CharacterServiceImpl charService;

	@InjectMocks
	PlayGameCommand resumeGameCommand;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testNewGame() throws GameServiceException, CharacterServiceException {
		Mockito.when(scUtil.getInput()).thenReturn("1");
		List<Game> rpGameList = new ArrayList<>();
		Game rpGame = new Game();
		Mockito.when(gameService.findGame(anyString())).thenReturn(rpGame);
		Mockito.when(gameService.fetchAllGames()).thenReturn(rpGameList);
		Mockito.when(charService.getRpgCharacterById(1)).thenReturn(new Character());
		resumeGameCommand.excuteOperationChoosen();	
	}

}
