package com.autocomplete.model;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.springframework.beans.factory.annotation.Autowired;

import static org.junit.Assert.*;

import java.io.InvalidObjectException;
import java.util.List;

import ch.qos.logback.core.net.SyslogOutputStream;

/**
 * Created by arvindkasale on 2/20/17.
 */
public class TrieTest {

	private Trie trie;
	private String[] arr;
	private int count;
	private String[] testArr;

	@Before
	public void setup() {
		trie = new Trie();
		arr = new String[] {"Arvind", "Always", "Are", "Alone"};
		testArr = new String[] {"", "A", "Ar", "Al"};
		count = 15;
	}

	@Test
	public void testTrieHasDefaultValueOfNullAndNoChildrenAndIsNonTerminal() {
		assertEquals(trie.getRoot().getValue(), new Character('~'));
		assertEquals(trie.getRoot().getChildren().size(), 0);
		assertEquals(trie.getRoot().isTerminal(), Boolean.FALSE);
	}

	@Test (expected = InvalidObjectException.class)
	public void testInsertOfNullValueInATrie() throws Exception{
		trie.insert(null);
	}

	@Test
	public void testInsertOfMultipleStrings() throws Exception{
		load();
		assertEquals(trie.getNodeCount(), count);
	}

	@Test
	public void testAutoComplete() throws Exception{
		load();
		for(String str : testArr) {
			List<String> list = trie.search(str);
			System.out.println("List for "+str+" : "+ list);
		}
	}

	private void load() throws Exception{
		for (String str : arr) {
			trie.insert(str);
		}
	}
}
