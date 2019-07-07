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

import com.rpg.exception.CharacterServiceException;
import com.rpg.game.menu.ExploreCharacterCommand;
import com.rpg.service.impl.GameActionServiceImpl;

public class ExploreCharacterCommandTest {

	@Mock
	GameActionServiceImpl gameService;

	@InjectMocks
	ExploreCharacterCommand exploreCharCommand;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testExploreCharacters() throws CharacterServiceException {
		List<String> testList = new ArrayList<>();
		testList.add("test");
		Mockito.when(gameService.exploreCharacters()).thenReturn(testList);
		boolean isSuccessFull = exploreCharCommand.excuteOperationChoosen();
		assertTrue(isSuccessFull);
	}

	@Test
	public void testExploreCharactersEmptyList() throws CharacterServiceException {
		List<String> testList = new ArrayList<>();
		Mockito.when(gameService.exploreCharacters()).thenReturn(testList);
		boolean isSuccessFull = exploreCharCommand.excuteOperationChoosen();
		assertTrue(isSuccessFull);
	}

	@Test
	public void testExploreCharactersException() throws CharacterServiceException {
		Mockito.when(gameService.exploreCharacters()).thenThrow(CharacterServiceException.class);
		exploreCharCommand.excuteOperationChoosen();
	}
}
