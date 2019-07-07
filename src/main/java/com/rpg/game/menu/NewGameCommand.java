package com.rpg.game.menu;

import com.rpg.entities.Character;
import com.rpg.entities.Game;
import com.rpg.exception.CharacterServiceException;
import com.rpg.service.impl.CharacterServiceImpl;
import com.rpg.service.impl.GameServiceImpl;
import com.rpg.util.ScannerUtil;

public class NewGameCommand implements Command {

	private CharacterServiceImpl rpgCharacterService = new CharacterServiceImpl();
	private GameServiceImpl rpGameService = new GameServiceImpl();
	private ScannerUtil in = new ScannerUtil();

	@Override
	public boolean excuteOperationChoosen() {
		System.out.println("Select the character Name to Start new Game with");
		try {
			rpgCharacterService.fetchAllRpgCharacters().forEach(item -> System.out.println(item.getCharacterName()));
			String characterName = in.getInput();
			Character rpgChar = verifyAndGetCharacter(characterName);
			System.out.println("Select the game Name you want to save");
			String gameName = in.getInput();
			Game rpGame = new Game();
			rpGame.setCharacterId(rpgChar.getId());
			rpGame.setGameName(gameName);
			rpGameService.createNewGame(rpGame);
			System.out.println("Your Game has been Created");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
		}

		return true;
	}

	@Override
	public String previousMenu() {
		return "3";
	}

	private Character verifyAndGetCharacter(String characterName) throws CharacterServiceException {
		while (characterName == null || characterName.trim().isEmpty()) {
			System.out.println("Please enter a valid Name");
			characterName = in.getInput();
		}
		Character rpgChar = rpgCharacterService.getRpgCharacterByName(characterName);
		while (rpgChar == null) {
			rpgChar = rpgCharacterService.getRpgCharacterByName(characterName);
			System.out.println("Please enter a valid Name");
			characterName = in.getInput();
		}
		return rpgChar;
	}
}
