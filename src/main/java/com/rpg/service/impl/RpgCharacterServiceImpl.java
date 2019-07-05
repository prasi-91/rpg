package com.rpg.service.impl;

import java.sql.SQLException;
import java.util.List;

import com.rpg.constants.ExceptionMessages;
import com.rpg.dao.AbstractDAO;
import com.rpg.dao.DAOFactory;
import com.rpg.domain.RpgCharacter;
import com.rpg.exception.CharacterServiceException;

public class RpgCharacterServiceImpl {

	private AbstractDAO<RpgCharacter> rpgCharacterDao = DAOFactory.getDaoInstane("RpgCharacter");

	public RpgCharacter getRpgCharacterByName(String name) throws CharacterServiceException {
		try {
			return rpgCharacterDao.findByName(name);
		} catch (SQLException e) {
			throw new CharacterServiceException(ExceptionMessages.ERROR_FETCHING_CHARACTER);
		}
	}

	public RpgCharacter getRpgCharacterById(Long id) throws CharacterServiceException {
		try {
			return rpgCharacterDao.findById(id);
		} catch (SQLException e) {
			throw new CharacterServiceException(ExceptionMessages.ERROR_FETCHING_CHARACTER);
		}
	}

	public void createNewCharacter(RpgCharacter rpgChar) throws CharacterServiceException {
		try {
			rpgCharacterDao.save(rpgChar);
		} catch (SQLException e) {
			if (e.getMessage().contains("column NAME is not unique")) {
				throw new CharacterServiceException(ExceptionMessages.UNIQUE_NAME_ERROR);
			} else {
				throw new CharacterServiceException(ExceptionMessages.ERROR_SAVING_CHARACTER);
			}
		}
	}

	public void updateCharacter(RpgCharacter rpgCharacter) throws CharacterServiceException {
		try {
			rpgCharacterDao.update(rpgCharacter);
		} catch (SQLException e) {
			throw new CharacterServiceException(ExceptionMessages.ERROR_UPDATING_CHRACTER);
		}
	}

	public List<RpgCharacter> fetchAllRpgCharacters() throws CharacterServiceException {
		try {
			return rpgCharacterDao.findAll();
		} catch (SQLException e) {
			throw new CharacterServiceException(ExceptionMessages.ERROR_FETCHING_CHARACTER);
		}
	}
}
