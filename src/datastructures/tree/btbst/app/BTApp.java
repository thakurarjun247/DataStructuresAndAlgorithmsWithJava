package datastructures.tree.btbst.app;

import datastructures.tree.LCNode;
import datastructures.tree.TreeNode;
import datastructures.tree.btbst.fun.BT;

import java.util.Scanner;

public class BTApp {
    public static void main(String[] args) throws Exception {
        TreeNode root = null;
        LCNode lcRoot=null;
        TreeNode newRoot = null;
        TreeNode root1 = null;
        TreeNode root2 = null;
        Scanner scanner = new Scanner(System.in);
        BT binaryTree = new BT();



        for (int i = 0; i < 100; i++) {

            binaryTree.displayChoice();
            int choice = scanner.nextInt();
            switch (choice) {
                case -1:
                    System.exit(0);
                    break;
                case 0:

                    System.out.println("Autocreating a BT with 15 nodes..");
                    for (int j = 0; j < 15; j++)
                        root = binaryTree.insert(root, j);
                    binaryTree.levelOrder(root);
                    //TODO: uncomment below later

              /*      System.out.println("enter the number of nodes to be inserted");
                    int number = scanner.nextInt();
                    for (int j = 0; j < number; j++) {

                        System.out.println("enter data value");
                        int data = scanner.nextInt();
                        root = binaryTree.insert(root, data);
                    }*/
                    break;
                case 1:
                    int size = binaryTree.inOrder(root);
                    System.out.println("tree size is " + size);
                    break;
                case 2:
                    binaryTree.preOrder(root);
                    break;
                case 3:
                    binaryTree.postOrder(root);
                    break;
                case 4:
                    System.out.println("tree size is " + binaryTree.getSize(root));
                    break;
                case 5:
                /*binaryTree.checkIfTwoTreesIdentical();
				break;*/
                case 6:
			/*	System.out.println("creating 2 trees to check if identical");
				System.out.println("enter the number of nodes to be inserted in tree1");
				int n1 = scanner.nextInt();
				for (int j = 0; j < n1; j++) {
					root1 = binaryTree.insert();
				}
				System.out.println(binaryTree.identical(root, root));
				
				System.out.println("enter the number of nodes to be inserted in tree2");
				int n2 = scanner.nextInt();
				for (int j = 0; j < n2; j++) {
					root2 = binaryTree.insert();
				}
				System.out.println(binaryTree.identical(root1, root2));
				break;*/
                case 7:
                    newRoot = binaryTree.newInsert();
                    break;
                case 8:
                    System.out.println("new Inorder...");
                    binaryTree.newInOrder(root);
                    break;
                case 9:
                    System.out.println("isbst ? " + binaryTree.isBST(root, null));
                    //solution at page 228 ctci
                    break;
                case 10:
                    binaryTree.levelOrder(root);
                    break;
                case 11:
                    binaryTree.bottomView(root);

                    break;
                case 12:
                    System.out.println("is balanced? " + binaryTree.isBalanced(root));
                case 13:
                    int[] a = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
                    TreeNode treeNode = binaryTree.createTreeFromArray(a, 0, a.length - 1);
                    binaryTree.inOrder(treeNode);
                    break;
                case 14:
                    for (int j = 0; j <=4; j++) {

                        //   System.out.println("enter data value");
                        // int data = scanner.nextInt();
                        root = binaryTree.insert(root, j);
                    }
                    binaryTree.levelWiseLLs(root).forEach(item-> System.out.println(item));
                    break;
                case 15:
                    System.out.println(binaryTree.lowestCommonAncestor(root, root.right, root.right.left));
                    break;

                case 16:
                    System.out.println(binaryTree.maxDiffBetweenANodeAndAncestor(root));
                    break;

                case 17:
                    System.out.println("input the sum");
                    System.out.println(printPathsWithASumAsGivenValue(root, scanner.nextInt()));
                case 18:
                    binaryTree.levelOrder1(root);
                    binaryTree.levelOrder2(root);
                case 19:
                   // System.out.println("enter the datastructures.array in format \"[0,1,2,3,4,5,6,7,8,9,10]\"");
                    String s = "[0,1,2,3,4,5,6,7,8,9,10]";
                    String[] arrString = s
                            .substring(1, s.length() - 1)
                            .split(",");
                    Integer[] arr = new Integer[arrString.length];
                    for (i = 0; i < arrString.length; i++) {
                        System.out.println(i);
                        if (arrString[i].equals("null")) {
                            System.out.println("yay");
                            arr[i] = null;
                        } else {
                            String str = arrString[i];
                            arr[i] = Integer.parseInt(str);
                        }
                        //[1,2,null,null,3,4]
                    }
                    // Integer[] arr= {1,2,3,4,5,6};
                    for (i = 0; i < arr.length; i++) {
                        lcRoot = binaryTree.insertLC(lcRoot, arr[i]);
                    }
                    binaryTree.levelOrderLC(lcRoot);
                case 20:
                   // System.out.println("enter the number of nodes to be inserted");
                    //int number = 10;
                    for (int j = 0; j < 10; j++) {

                     //   System.out.println("enter data value");
                       // int data = scanner.nextInt();
                        root = binaryTree.insert(root, j);
                    }
                    binaryTree.naturalView(root);
                    break;
                case 21:
                    binaryTree.naturalView(root);
                case 22:
                    binaryTree.zigZag(root);
                    break;
                case 23:
                    for (int j = 0; j <=4; j++) {

                        //   System.out.println("enter data value");
                        // int data = scanner.nextInt();
                        root = binaryTree.insert(root, j);
                    }
                    System.out.println(binaryTree.rightSideView(root));
                    break;


                default:
                    System.out.println("invalid choise, retry");

            }
        }
        scanner.close();

    }

    private static char[] printPathsWithASumAsGivenValue(TreeNode root,
                                                         int nextInt) {
        // TODO Auto-generated method stub
        return null;
    }

}
    /*
                                    11           //32

                     12                                    13

              3               4                     9               4

          1       5      7         6            1       5      7         6



    */