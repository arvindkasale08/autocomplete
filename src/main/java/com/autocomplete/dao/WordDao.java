package com.autocomplete.dao;

import java.util.List;

/**
 * Created by arvindkasale on 2/22/17.
 */
public interface WordDao {
	public void save(List<String> list);
	public List<String> search(String search);
}
