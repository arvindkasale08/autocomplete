package com.autocomplete.model;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import org.springframework.stereotype.Component;

import com.autocomplete.constants.Constants;

/**
 * Created by arvindkasale on 2/20/17.
 */
@Component
public class Trie {

	private TrieNode root;
	private int nodeCount = 0;
	private int wordCount = 0;

	public Trie() {
		root = new TrieNode();
	}

	public TrieNode getRoot() {
		return root;
	}

	public int getNodeCount() {
		return nodeCount;
	}

	public int getWordCount() { return wordCount;}

	public TrieNode insert(String str) {
		if(null == str) {
			System.out.println(Constants.NULL_ERROR);
		}
		TrieNode currentNode = this.root;
		for(char ch : str.toCharArray()) {
			TrieNode subNode = currentNode.subNode(ch);
			if (null == subNode) {
				TrieNode newNode = new TrieNode(ch);
				currentNode.getChildren().add(newNode);
				currentNode = newNode;
				this.nodeCount++;
			}
			else {
				currentNode = subNode;
			}
		}
		currentNode.setTerminal(true);
		this.wordCount++;
		currentNode.setTerminalValue(str);
		return this.root;
	}

	public List<String> search(String str) {
		if (null == this.getRoot() || "".equals(str) || "~".equals(str)) {
			return new ArrayList<>();
		}
		TrieNode currentNode = this.root;
		for (char ch : str.toCharArray()) {
			TrieNode subNode = currentNode.subNode(ch);
			if (null == subNode)
				return new ArrayList<>();
			else {
				currentNode = subNode;
			}
		}
		return getStringsFromNode(str, currentNode);
	}

	private List<String> getStringsFromNode(String str, TrieNode node) {
		List<String> words = new ArrayList<String>();
		Deque<TrieNode> DQ = new ArrayDeque<>();
		DQ.addLast(node);
		while (!DQ.isEmpty()) {
			TrieNode first = DQ.removeFirst();
			if(first.isTerminal()){
				words.add(first.getTerminalValue());
			}
			for(TrieNode n : first.getChildren()){
				if(n != null){
					DQ.add(n);
				}
			}
		}
		return words;
	}

	private String getStringFromNodeInner(String str, TrieNode node) {
		if(!node.isTerminal()) {
			for (TrieNode currentNode : node.getChildren()) {
				String newStr = str + currentNode.getValue();
				getStringFromNodeInner(newStr, currentNode);
			}
		}
		else
			return str+ ",";

		return null;
	}
}
