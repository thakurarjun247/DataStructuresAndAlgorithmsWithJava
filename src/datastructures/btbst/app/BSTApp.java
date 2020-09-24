package datastructures.btbst.app;

import datastructures.btbst.TreeNode;
import datastructures.btbst.fun.BST;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BSTApp {
    public static void main(String[] args) throws Exception {
        TreeNode root = null;
        Scanner scanner = new Scanner(System.in);
        BST ops = new BST();
        for (int i = 0; i < 100; i++) {

            ops.displayChoice();
            int choice = scanner.nextInt();
            switch (choice) {
                case -1:
                    System.exit(0);
                    break;
                case 0:
                    System.out.println("enter the number of nodes to be inserted");
                    int number = scanner.nextInt();
                    for (int j = 0; j < number; j++) {
                        root = ops.insert();
                    }
                    break;

                case 1:
                    int size = ops.inOrder(root);
                    System.out.println("tree size is " + size);
                    break;
                case 2:
                    ops.preOrder(root);
                    break;
                case 3:
                    ops.postOrder(root);
                    break;
                case 4:
                    //System.out.println("tree size is " + ops.getSize(root));
                    break;
                case 5:

                    //ops.checkIfTwoTreesIdentical();
                    break;
                case 6:
                    //ops.identical(root, root);
                case 7:
                    System.out.println("is bst " + ops.isBST(root, Integer.MIN_VALUE));
                    break;
                case 8:
                    Map<Integer, Integer> map = new HashMap<>();
                    map = ops.bottomView(root, map);
                    System.out.println(map);
                    map.forEach((k, v) -> System.out.print(v + " "));
                    break;
                case 9:
                    TreeNode node = root;
                    System.out.println("inorder succuessor of " + node + " = " + ops.inOrderSuccessor(node));
                    break;
                default:
                    System.out.println("invalid choise, retry");

            }
        }
        scanner.close();

    }

}