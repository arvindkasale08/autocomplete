package com.autocomplete.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autocomplete.model.Trie;
import com.autocomplete.utils.Loader;

/**
 * Created by arvindkasale on 2/22/17.
 */
@Service
public class SearchServiceImpl implements SearchService {

	private Trie trie;

	@Autowired
	Loader loader;

	@Override
	public Trie getInstance() {
		if(null == trie)
			trie = loader.loadTrieFromFile("high.txt");
		return trie;
	}

	@Override
	public Trie getInstance(String path) {
		this.trie = loader.loadTrieFromFile(path);
		return trie;
	}

}
