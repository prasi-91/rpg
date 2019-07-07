package com.rpg.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import com.rpg.dao.CharacterDao;
import com.rpg.entities.Character;
import com.rpg.exception.CharacterServiceException;
import com.rpg.service.impl.CharacterServiceImpl;

public class CharacterServiceTest {

	@Mock
	private CharacterDao charDao;

	@InjectMocks
	private CharacterServiceImpl characterServiceImpl;

	@Before
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testFindAllCharacter() throws CharacterServiceException, SQLException {
		List<Character> tempList = new ArrayList<>();
		tempList.add(new Character());
		Mockito.when(charDao.findAll()).thenReturn(tempList);
		tempList = characterServiceImpl.fetchAllRpgCharacters();
		assertFalse(tempList.isEmpty());
	}

	@Test(expected = CharacterServiceException.class)
	public void testFindAllCharacterExeption() throws CharacterServiceException, SQLException {
		Mockito.when(charDao.findAll()).thenThrow(SQLException.class);
		characterServiceImpl.fetchAllRpgCharacters();
	}

	@Test
	public void testFindByName() throws CharacterServiceException, SQLException {
		Character rpgChar = new Character();
		Mockito.when(charDao.findByName("test")).thenReturn(rpgChar);
		rpgChar = characterServiceImpl.getRpgCharacterByName("test");
		assertNotNull(rpgChar);
	}

	@Test(expected = CharacterServiceException.class)
	public void testFindByNameException() throws CharacterServiceException, SQLException {
		Mockito.when(charDao.findByName("test")).thenThrow(SQLException.class);
		characterServiceImpl.getRpgCharacterByName("test");
	}

	@Test
	public void testFindById() throws CharacterServiceException, SQLException {
		Character rpgChar = new Character();
		Mockito.when(charDao.findById(1)).thenReturn(rpgChar);
		rpgChar = characterServiceImpl.getRpgCharacterById(1);
		assertNotNull(rpgChar);
	}

	@Test(expected = CharacterServiceException.class)
	public void testFindByIdException() throws CharacterServiceException, SQLException {
		Mockito.when(charDao.findById(1)).thenThrow(SQLException.class);
		characterServiceImpl.getRpgCharacterById(1);
	}

	@Test
	public void testCreateCharacter() throws CharacterServiceException, SQLException {
		Character rpgChar = new Character();
		Mockito.when(charDao.save(rpgChar)).thenReturn(true);
		characterServiceImpl.createNewCharacter(rpgChar);
	}

	@Test(expected = CharacterServiceException.class)
	public void testCreateCharException() throws CharacterServiceException, SQLException {
		SQLException ex = new SQLException("test");
		Character rpgChar = new Character();
		Mockito.when(charDao.save(rpgChar)).thenThrow(ex);
		characterServiceImpl.createNewCharacter(rpgChar);
	}

	
	@Test(expected = CharacterServiceException.class)
	public void testCreateCharExceptionUnique() throws CharacterServiceException, SQLException {
		SQLException ex = new SQLException("column NAME is not unique");
		Character rpgChar = new Character();
		Mockito.when(charDao.save(rpgChar)).thenThrow(ex);
		characterServiceImpl.createNewCharacter(rpgChar);
	}

	@Test
	public void testUpdateCharacter() throws CharacterServiceException, SQLException {
		Character rpgChar = new Character();
		Mockito.when(charDao.update(rpgChar)).thenReturn(true);
		characterServiceImpl.updateCharacter(rpgChar);
	}

	@Test(expected = CharacterServiceException.class)
	public void testUpdateCharException() throws CharacterServiceException, SQLException {
		Character rpgChar = new Character();
		Mockito.when(charDao.update(rpgChar)).thenThrow(SQLException.class);
		characterServiceImpl.updateCharacter(rpgChar);
	}
}
