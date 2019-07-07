package com.rpg.service;

import static org.junit.Assert.assertFalse;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import static org.mockito.Matchers.any;


import com.rpg.dao.CharacterDao;
import com.rpg.entities.Character;
import com.rpg.exception.CharacterServiceException;
import com.rpg.exploration.factory.LevelFactory;
import com.rpg.service.impl.CharacterServiceImpl;
import com.rpg.service.impl.GameActionServiceImpl;

public class GameActionServiceTest {

	@Mock
	CharacterDao charDao;

	@Mock
	private GameActionServiceImpl gameActionService;
	
	@InjectMocks
	private CharacterServiceImpl rpgCharacterService;

	@InjectMocks
	private LevelFactory levelFactory;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testExploreLevel() {
		String levelName = "LEVEL 1";
		gameActionService.exploreLevel(levelName);
		levelName = "LEVEL 2";
		gameActionService.exploreLevel(levelName);
		levelName = "LEVEL 3";
		gameActionService.exploreLevel(levelName);
		levelName = null;
		gameActionService.exploreLevel(levelName);
	}

	@Test
	public void exploreCharacters() throws CharacterServiceException {
		List<Character> tempList = new ArrayList<>();
		tempList.add(new Character());
		Mockito.when(rpgCharacterService.fetchAllRpgCharacters()).thenReturn(tempList);
		List<String> testList = gameActionService.exploreCharacters();
	}

	@Test
	public void fight() {
		Character rpgCharacter = new Character();
		rpgCharacter.setCharacterName("TEST_NEW");
		gameActionService.fight(rpgCharacter);
	}

}
