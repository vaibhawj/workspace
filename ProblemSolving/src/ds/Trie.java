package ds;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Trie {

	private TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void add(String textString) {
		TrieNode node = root;
		for (Character c : textString.toCharArray()) {
			TrieNode nextNode = node.childrenMap.get(c);
			if (null == nextNode) {
				nextNode = new TrieNode();
				node.childrenMap.put(c, nextNode);
			}
			node = nextNode;
		}
		node.text = textString;
	}

	public List<String> findMatch(String searchString) {

		List<String> possibleMatchsList = new LinkedList<>();
		TrieNode node = root;
		for (Character c : searchString.toCharArray()) {
			TrieNode nextNode = node.childrenMap.get(c);
			if (null == nextNode) {
				return possibleMatchsList;
			}

			if (null != nextNode.text) {
				possibleMatchsList.add(nextNode.text);
			}
			node = nextNode;
		}

		addtPartialMatchesToResult(node, possibleMatchsList);

		return possibleMatchsList;

	}

	private void addtPartialMatchesToResult(TrieNode node, List<String> possibleMatchsList) {

		for (TrieNode n : node.childrenMap.values()) {
			if (null != n.text) {
				possibleMatchsList.add(n.text);
			}
			addtPartialMatchesToResult(n, possibleMatchsList);
		}

	}

	public static void main(String[] args) {

		Trie trie = new Trie();

		trie.add("ABC");
		trie.add("ABD");
		trie.add("XYZ");

		System.out.println(trie.findMatch("X"));

	}

	protected class TrieNode {

		private Map<Character, TrieNode> childrenMap;

		private String text;

		public TrieNode() {
			childrenMap = new HashMap<>();
		}

	}

}
