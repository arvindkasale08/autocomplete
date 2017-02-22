package com.autocomplete.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.autocomplete.model.Trie;
import com.autocomplete.services.WordService;

/**
 * Created by arvindkasale on 2/21/17.
 */
@Component
public class Loader {

	@Autowired
	private Trie trie;

	@Autowired
	private WordService service;

	public Trie loadTrieFromFile(String fileName) {
		FileReader reader = null;
		try {
			File file = new ClassPathResource(fileName).getFile();
			reader = new FileReader(file);
			String str;
			BufferedReader bufferedReader = new BufferedReader(reader);
			while ((str = bufferedReader.readLine()) != null) {
				trie.insert(str);
			}
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		return trie;
	}

	public void loadDbFromFile(String fileName) {
		List<String> list = new ArrayList<>();
		FileReader reader = null;
		try {
			File file = new ClassPathResource(fileName).getFile();
			reader = new FileReader(file);
			String str;
			BufferedReader bufferedReader = new BufferedReader(reader);
			while ((str = bufferedReader.readLine()) != null) {
				list.add(str);
			}
		service.save(list);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
}
