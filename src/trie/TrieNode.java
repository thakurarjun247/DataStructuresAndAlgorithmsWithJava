package trie;

import java.util.LinkedList;

public class TrieNode {
    char character;
    LinkedList<TrieNode> children;
    boolean terminates;

    public TrieNode() {
        children = new LinkedList<TrieNode>();
    }

    public TrieNode(char character) {
        this.character = character;

    }

    public char getChar() {
        return character;
    }

    public boolean terminates() {
        return terminates;
    }

    public void setTerminates(boolean terminates) {
        this.terminates = terminates;
    }

    public TrieNode getChild(char c) {
        if (children == null)
            return null;
        for (TrieNode child : children) {
            if (child.getChar() == c)
                return child;
        }
        return null;
    }

    public void addWord(String word) {
        if (word == null || word.isEmpty())
            return;
        TrieNode child;
        char first = word.charAt(0);
        TrieNode t = getChild(first);
        if (t == null) {
            child = new TrieNode(first);
            // node.setTerminates(true);
            children.add(child);

        } else {
            child = t;
        }
        if (word.length() > 1) {
            child.addWord(word.substring(1));
        } else {
            child.setTerminates(true);
        }
    }
}
