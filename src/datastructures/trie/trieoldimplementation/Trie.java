package datastructures.trie.trieoldimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// A simple Java program to introduce a linked list

public class Trie {
    Scanner scanner = new Scanner(System.in);

    public void displayChoice() {
        System.out.println();
        System.out.println("====================Trie Operations==================");
        System.out.println("-1: exit");
        System.out.println(" 0: create/insert ");
        System.out.println(" 1: containsPrefix");
        System.out.println(" 2: printAll");

        System.out.println("=====================================================");
        System.out.println();
    }

    TrieNode root;

    public Trie() {

    }

    public Trie(List<String> list) {
        this();
        root = new TrieNode();
        list.forEach(word -> root.addWord(word));
    }

    public void insert() {
        List<String> list = new ArrayList<>();
        while (true) {
            System.out.println("input a word or type 'exit' to return");
            String input = scanner.next();
            if (input.equalsIgnoreCase("exit"))
                break;
            else
                list.add(input);
        }
        if (root == null) {
            root = new TrieNode();
        }
        for (String word : list) {
            root.addWord(word);
        }
    }

    public boolean containsPrefix(String prefix) {
        TrieNode lastNode = root;
        if (root == null)
            return false;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            lastNode = lastNode.getChild(c);
            if (lastNode == null) {
                return false;
            }
        }
        return lastNode.terminates();
    }

}
