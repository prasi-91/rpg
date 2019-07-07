package com.rpg.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.sqlite.SQLiteDataSource;

import com.rpg.entities.Character;

public class CharacterDaoTest {

	@Mock
	private DBConnection dbConnect;

	@Mock
	private Connection mockConn;

	@Mock
	PreparedStatement mockPreparedStmnt;

	@Mock
	Statement stmnt;

	@Mock
	SQLiteDataSource sqlLiteDs;

	@Mock
	ResultSet mockResultSet;

	@InjectMocks
	CharacterDao charDao;

	@Before
	public void setUp() throws SQLException {
		MockitoAnnotations.initMocks(this);
		Character character = new Character();
		character.setId(1);
		character.setCharacterName("test");
		character.setWeapon("test");
		character.setExperience(0);
		Mockito.when(sqlLiteDs.getConnection()).thenReturn(mockConn);
		Mockito.when(mockConn.createStatement()).thenReturn(stmnt);
		Mockito.when(mockConn.prepareStatement("test")).thenReturn(mockPreparedStmnt);
		Mockito.when(mockPreparedStmnt.executeQuery()).thenReturn(mockResultSet);
		Mockito.when(mockPreparedStmnt.executeUpdate("test")).thenReturn(1);
		Mockito.when(mockPreparedStmnt.executeUpdate()).thenReturn(1);
		Mockito.when(stmnt.executeQuery(anyString())).thenReturn(mockResultSet);
		Mockito.when(mockResultSet.first()).thenReturn(true);
		Mockito.when(mockResultSet.next()).thenReturn(true);
		Mockito.when(mockResultSet.getInt(anyString())).thenReturn(1);
		Mockito.when(mockResultSet.getString(anyString())).thenReturn(character.getCharacterName());
		Mockito.when(mockResultSet.getString(anyString())).thenReturn(character.getWeapon());
		Mockito.when(mockResultSet.getInt(anyString())).thenReturn(0);
	}

	@Test
	public void testFindAll() throws Exception {
		List<Character> testList = charDao.findAll();
		assertNotNull(testList);
	}

	@Test
	public void testFindByName() throws SQLException {
		Character character = charDao.findByName("test");
		assertNotNull(character);
	}

	@Test
	public void testFindById() throws SQLException {
		Character character = charDao.findById(1);
		assertNotNull(character);
	}

	/*@Test
	public void testSaveChar() throws SQLException {
		Character character = new Character();
		character.setCharacterName("test");
		character.setWeapon("test");
		character.setExperience(0);
		charDao.save(character);

	}*/

	@Test
	public void testUpdate() throws SQLException {
		Character character = new Character();
		character.setId(1);
		character.setCharacterName("test");
		character.setWeapon("test");
		character.setExperience(0);
		assertNotNull(charDao.update(character));
	}
}
