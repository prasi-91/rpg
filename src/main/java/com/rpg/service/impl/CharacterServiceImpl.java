/*
 * Author M S Prasita Nair
 * 
 * Class to carry out Service operations for character
 * 
 */
package com.rpg.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rpg.constants.ExceptionMessages;
import com.rpg.constants.GameConstants;
import com.rpg.dao.AbstractDAO;
import com.rpg.dao.DAOFactory;
import com.rpg.entities.Character;
import com.rpg.exception.CharacterServiceException;

public class CharacterServiceImpl {

	private AbstractDAO<Character> rpgCharacterDao = DAOFactory.getDaoInstane(GameConstants.CHARACTER_DAO);

	public Character getRpgCharacterByName(String name) throws CharacterServiceException {
		try {
			return rpgCharacterDao.findByName(name);
		} catch (SQLException e) {
			throw new CharacterServiceException(ExceptionMessages.ERROR_FETCHING_CHARACTER);
		}
	}

	public Character getRpgCharacterById(Integer id) throws CharacterServiceException {
		try {
			return rpgCharacterDao.findById(id);
		} catch (SQLException e) {
			throw new CharacterServiceException(ExceptionMessages.ERROR_FETCHING_CHARACTER);
		}
	}

	public void createNewCharacter(Character rpgChar) throws CharacterServiceException {
		try {
			if (rpgCharacterDao.findByName(rpgChar.getCharacterName()) != null) {
				throw new CharacterServiceException(ExceptionMessages.UNIQUE_NAME_ERROR);
			}
			rpgCharacterDao.save(rpgChar);
		} catch (SQLException e) {
			throw new CharacterServiceException(ExceptionMessages.ERROR_SAVING_CHARACTER);
		}
	}

	public void updateCharacter(Character rpgCharacter) throws CharacterServiceException {
		try {
			rpgCharacterDao.update(rpgCharacter);
		} catch (SQLException e) {
			throw new CharacterServiceException(ExceptionMessages.ERROR_UPDATING_CHRACTER);
		}
	}

	public List<Character> fetchAllRpgCharacters() throws CharacterServiceException {
		try {
			return rpgCharacterDao.findAll();
		} catch (SQLException e) {
			throw new CharacterServiceException(ExceptionMessages.ERROR_FETCHING_CHARACTER);
		}
	}
}
