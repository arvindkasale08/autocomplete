package com.autocomplete.services;

import com.autocomplete.model.Trie;

/**
 * Created by arvindkasale on 2/22/17.
 */
public interface SearchService {
	Trie getInstance();

	Trie getInstance(String path);
}
