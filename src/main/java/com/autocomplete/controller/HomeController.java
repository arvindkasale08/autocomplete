package com.autocomplete.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.autocomplete.model.Trie;
import com.autocomplete.services.SearchService;

/**
 * Created by arvindkasale on 2/23/17.
 */
@RestController
@RequestMapping(value = "/home")
public class HomeController {

	@Autowired
	private SearchService service;

	@ResponseBody
	@RequestMapping("")
	public Map<String, Integer> home() {
		Map<String, Integer> map = new HashMap<>();
		Trie trie = service.getInstance();
		map.put("nodeCount" , trie.getNodeCount());
		map.put("wordCount", trie.getWordCount());
		return map;
	}
}
