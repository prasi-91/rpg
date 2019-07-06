package com.rpg.game.menu;

import com.rpg.domain.RpgCharacter;
import com.rpg.domain.RpgGames;
import com.rpg.exception.CharacterServiceException;
import com.rpg.service.impl.RpgCharacterServiceImpl;
import com.rpg.service.impl.RpgGameServiceImpl;
import com.rpg.util.ScannerUtil;

public class NewGameCommand implements Command {

	private static RpgCharacterServiceImpl rpgCharacterService = new RpgCharacterServiceImpl();
	private static RpgGameServiceImpl rpGameService = new RpgGameServiceImpl();

	@Override
	public boolean excuteOperationChoosen() {
		System.out.println("Select the character Name to Start new Game with");
		try {
			rpgCharacterService.fetchAllRpgCharacters().forEach(item -> {
				System.out.println(item.getCharacterName());
			});
			String characterName = ScannerUtil.inputHandler.nextLine();
			RpgCharacter rpgChar = verifyAndGetCharacter(characterName);
			System.out.println("Select the game Name you want to save");
			String gameName = ScannerUtil.inputHandler.nextLine();
			RpgGames rpGame = new RpgGames();
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

	private RpgCharacter verifyAndGetCharacter(String characterName) throws CharacterServiceException {
		while (characterName == null || characterName.trim().isEmpty()) {
			System.out.println("Please enter a valid Name");
			characterName = ScannerUtil.inputHandler.nextLine();
		}
		RpgCharacter rpgChar = rpgCharacterService.getRpgCharacterByName(characterName);
		while (rpgChar == null) {
			rpgChar = rpgCharacterService.getRpgCharacterByName(characterName);
			System.out.println("Please enter a valid Name");
			characterName = ScannerUtil.inputHandler.nextLine();
		}
		return rpgChar;
	}
}
