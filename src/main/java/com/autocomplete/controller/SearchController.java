package com.autocomplete.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.autocomplete.model.Trie;
import com.autocomplete.services.SearchService;
import com.autocomplete.services.WordService;
import com.autocomplete.utils.Loader;

/**
 * Created by arvindkasale on 2/21/17.
 */
@RestController
@RequestMapping(value = "/search")
public class SearchController {

	@Autowired
	private SearchService service;

	@Autowired
	private WordService wordService;

	@Autowired
	private Loader loader;

	@RequestMapping(value = "")
	public List<String> search(@RequestParam("name") String search) {
		Trie trie = service.getInstance();
		return trie.search(search);
	}

	@RequestMapping(value = "/db")
	public List<String> searchFromDb(@RequestParam("name") String search) {
		if("".equals(search))
			return new ArrayList<>();
		return wordService.search(search);
	}

	@RequestMapping(value = "/add")
	public List<String> add(@RequestParam("name") String name) {
		service.getInstance().insert(name);
		return null;
	}

	@RequestMapping(value = "/load")
	public String load(@RequestParam("path") String path) {
		loader.loadDbFromFile(path);
		return "done";
	}

}
