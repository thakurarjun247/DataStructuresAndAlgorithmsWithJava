package datastructuresandalgorithms.problemsfrombooks.triectci;

import java.util.HashMap;

/* One node in the datastructures.trie. Most of the logic of the datastructures.trie is implemented
 * in this class.
 */
public class TrieNode {
    /* The children of this node in the datastructures.trie.*/
    private HashMap<Character, TrieNode> children;
    private boolean terminates = false;

    // The character stored in this node as data.
    private char character;

    /* Constructs a datastructures.trie node and stores this character as the node's value.
     * Initializes the list of child nodes of this node to an empty hash map. */
    public TrieNode() {
        children = new HashMap<Character, TrieNode>();
    }

    /* Constructs a datastructures.trie node and stores in the node the char passed in
     * as the argument. Initializes the list of child nodes of this
     * node to an empty hash map.
     */
    public TrieNode(char character) {
        this();
        this.character = character;
    }

    /* Returns the character data stored in this node. */
    public char getChar() {
        return character;
    }

    /* Add this word to the datastructures.trie, and recursively create the child
     * nodes. */
    public void addWord(String word) {
        if (word == null || word.isEmpty()) {
            return;
        }

        char firstChar = word.charAt(0);
//check if the node already has the child with same val available
        TrieNode child = getChild(firstChar);
        if (child == null) {
            //if not then create one
            child = new TrieNode(firstChar);
            children.put(firstChar, child);
        }
//if there are more chars tackle them. here addWords calls itself 
        //hence it's recursive 
        if (word.length() > 1) {
            child.addWord(word.substring(1));
        }
        //terminating condition for recursion.
        else {
            child.setTerminates(true);
        }
    }

    /* Find a child node of this node that has the char argument as its
     * data. Return null if no such child node is present in the datastructures.trie.
     */
    public TrieNode getChild(char c) {
        return children.get(c);
    }

    /* Returns whether this node represents the end of a complete word. */
    public boolean terminates() {
        return terminates;
    }

    /* Set whether this node is the end of a complete word.*/
    public void setTerminates(boolean t) {
        terminates = t;
    }
}