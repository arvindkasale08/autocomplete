package com.autocomplete.services;

import java.util.List;

/**
 * Created by arvindkasale on 2/22/17.
 */

public interface WordService {
	void save(List<String> list);
	List<String> search(String search);
}
