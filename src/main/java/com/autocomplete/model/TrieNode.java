package com.autocomplete.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by arvindkasale on 2/20/17.
 */
public class TrieNode {
	private boolean terminal;
	private char value;
	private List<TrieNode> children;
	private String terminalValue;

	public TrieNode() {
		terminal = false;
		value = '~';
		children = new ArrayList<>();
	}

	public TrieNode(char value) {
		this();
		this.value = value;
	}

	public boolean isTerminal() {
		return terminal;
	}

	public void setTerminalValue(String terminalValue) {
		this.terminalValue = terminalValue;
	}

	public void setTerminal(boolean terminal) {
		this.terminal = terminal;
	}

	public Character getValue() {
		return value;
	}

	public List<TrieNode> getChildren() {
		return children;
	}

	public String getTerminalValue() {
		return terminalValue;
	}

	public TrieNode subNode(char ch) {
		if (this.children != null) {
			for (TrieNode node : this.children) {
				if(Character.toLowerCase(ch) == Character.toLowerCase(node.getValue())) {
					return node;
				}
			}
		}
		return null;
	}

	@Override
	public String toString() {
		return "TrieNode{" +
			"terminal=" + terminal +
			", value=" + value +
			", children=" + children +
			'}';
	}
}
