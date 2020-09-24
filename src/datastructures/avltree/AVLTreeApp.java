package datastructures.avltree;

import datastructures.heap.MaxHeap;

import java.util.Scanner;

public class AVLTreeApp {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        MaxHeap heap = new MaxHeap();
        heap.displayChoice();
        String input;
        //visit http://blog.blackbam.at/2012/05/04/avl-tree-implementation-in-java/
        while (true) {
            System.out.println("currently not working visit http://blog.blackbam.at/2012/05/04/avl-tree-implementation-in-java/");
            System.out.println("make a choice or type 'exit' to quit");
            input = scanner.next();
            switch (input) {
                case "-1":
                    heap.displayChoice();
                    break;
                case "0":
                    heap.add();
                    break;
                case "1":
                    int item = heap.remove();
                    break;
                case "2":
                    heap.printItems();
                    break;
                case "exit":
                    System.exit(0);
                default:
                    break;
            }

        }

    }

}
