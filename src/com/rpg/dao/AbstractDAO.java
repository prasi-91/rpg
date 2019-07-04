package com.rpg.dao;

import java.sql.SQLException;
import java.util.List;

public interface AbstractDAO<T> {

	List<T> findAll() throws ClassNotFoundException,  SQLException;

	T findOne(String name) throws ClassNotFoundException, SQLException;

	boolean save(T t) throws  ClassNotFoundException,  SQLException;

	boolean update(T t) throws  ClassNotFoundException,  SQLException;

}
