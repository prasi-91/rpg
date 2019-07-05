package com.rpg.dao;

import java.io.IOException;
import java.util.List;

public interface AbstractFileDAO<T> {

	List<T> findAll() throws IOException;

	T findByName(String name) throws IOException;

	T findById(Long id) throws IOException;

	boolean save(T t) throws IOException;

	boolean update(T t) throws IOException;

}
