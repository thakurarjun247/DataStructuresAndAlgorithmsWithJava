package datastructures.trie.trieoldimplementation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TrieApp {
    public static void main(String[] args) throws Exception {
        Trie ops = new Trie();
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < 100; i++) {

            ops.displayChoice();
            int choice = scanner.nextInt();
            switch (choice) {
                case -1:
                    System.exit(0);
                    break;
                case 0:
                    System.out.println("create/insert datastructures.trie");

                    List<String> list = new ArrayList<>();
                    while (true) {
                        System.out.println("input a word or type 'exit' to return");
                        String input = scanner.next();
                        if (input.equalsIgnoreCase("exit"))
                            break;
                        else
                            list.add(input);
                    }

                    break;
                case 1:
                    System.out.println("enter a prefix ");
                    System.out.println("prefix contained? " + ops.containsPrefix(scanner.next()));
                    break;
                default:
                    System.out.println("invalid choise, retry");

            }
        }
        scanner.close();

    }


}