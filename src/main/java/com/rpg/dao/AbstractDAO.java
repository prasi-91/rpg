package com.rpg.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO<T> {

	List<T> findAll() throws SQLException;

	T findByName(String name) throws SQLException;

	T findById(Long id) throws SQLException;

	boolean save(T t) throws SQLException;

	boolean update(T t) throws SQLException;

}
