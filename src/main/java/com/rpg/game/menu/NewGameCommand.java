package com.rpg.game.menu;

import com.rpg.entities.Character;
import com.rpg.entities.Game;
import com.rpg.exception.CharacterServiceException;
import com.rpg.service.impl.CharacterServiceImpl;
import com.rpg.service.impl.GameServiceImpl;
import com.rpg.util.ScannerUtil;

public class NewGameCommand implements Command {

	private static CharacterServiceImpl rpgCharacterService = new CharacterServiceImpl();
	private static GameServiceImpl rpGameService = new GameServiceImpl();

	@Override
	public boolean excuteOperationChoosen() {
		System.out.println("Select the character Name to Start new Game with");
		try {
			rpgCharacterService.fetchAllRpgCharacters().forEach(item -> System.out.println(item.getCharacterName()));
			String characterName = ScannerUtil.inputHandler.nextLine();
			Character rpgChar = verifyAndGetCharacter(characterName);
			System.out.println("Select the game Name you want to save");
			String gameName = ScannerUtil.inputHandler.nextLine();
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
			characterName = ScannerUtil.inputHandler.nextLine();
		}
		Character rpgChar = rpgCharacterService.getRpgCharacterByName(characterName);
		while (rpgChar == null) {
			rpgChar = rpgCharacterService.getRpgCharacterByName(characterName);
			System.out.println("Please enter a valid Name");
			characterName = ScannerUtil.inputHandler.nextLine();
		}
		return rpgChar;
	}
}
