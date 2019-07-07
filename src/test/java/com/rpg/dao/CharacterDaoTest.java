package com.rpg.dao;

import static org.junit.Assert.assertTrue;
import static org.mockito.Matchers.anyString;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import org.sqlite.SQLiteDataSource;

import com.rpg.entities.Character;

@RunWith(PowerMockRunner.class)
@PrepareForTest(DBConnection.class)
public class CharacterDaoTest {

	@Mock
	DBConnection dbconnect;

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
	public void setUp() throws Exception {
		MockitoAnnotations.initMocks(this);
		Character character = new Character();
		character.setId(1);
		character.setCharacterName("test");
		character.setWeapon("test");
		character.setExperience(0);
		PowerMockito.mockStatic(DBConnection.class);
		PowerMockito.doReturn(mockConn).when(DBConnection.class, "getConnection");
		Mockito.when(mockConn.createStatement()).thenReturn(stmnt);
		Mockito.when(mockConn.prepareStatement(anyString())).thenReturn(mockPreparedStmnt);
		Mockito.when(mockPreparedStmnt.executeQuery()).thenReturn(mockResultSet);
		Mockito.when(mockPreparedStmnt.executeUpdate(anyString())).thenReturn(1);
		Mockito.when(mockPreparedStmnt.executeUpdate()).thenReturn(1);
		Mockito.when(stmnt.executeQuery(anyString())).thenReturn(mockResultSet);
		Mockito.when(mockResultSet.first()).thenReturn(true);
		Mockito.when(mockResultSet.getInt(anyString())).thenReturn(1);
		Mockito.when(mockResultSet.getString(anyString())).thenReturn(character.getCharacterName());
		Mockito.when(mockResultSet.getString(anyString())).thenReturn(character.getWeapon());
		Mockito.when(mockResultSet.getInt(anyString())).thenReturn(0);
	}

	@Test
	public void testFindAll() throws Exception {
		List<Character> testList = charDao.findAll();
	}

	@Test
	public void testFindByName() throws SQLException {
		Character character = charDao.findByName("test_unique");
	}

	@Test
	public void testFindById() throws SQLException {
		Character character = charDao.findById(1);
	}

	@Test
	public void testSaveChar() throws SQLException {
		Character character = new Character();
		character.setCharacterName("test");
		character.setWeapon("test");
		character.setExperience(0);
		boolean isSuccesFull = charDao.save(character);
		assertTrue(isSuccesFull);
	}

	@Test
	public void testUpdate() throws SQLException {
		Character character = new Character();
		character.setId(1);
		character.setCharacterName("test");
		character.setWeapon("test");
		character.setExperience(0);
	}

}
