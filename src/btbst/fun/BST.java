package btbst.fun;

import btbst.TreeNode;

import java.util.LinkedList;
import java.util.Map;
import java.util.Scanner;

// A simple Java program to introduce a linked list

public class BST {
    Scanner scanner = new Scanner(System.in);
    private TreeNode root = null;

    public void displayChoice() {
        System.out.println();
        System.out
                .println("=======================BST Operations======================");
        System.out.println("-1: exit");
        System.out.println(" 0: create/insert ");
        System.out.println(" 1: inorder traversal ");
        System.out.println(" 2: preorder traversal ");
        System.out.println(" 3: postorder traversal ");
        System.out.println(" 4: get size");
        System.out
                .println(" 5: checkIfTwoTreesIdentical          //not working");
        System.out.println(" 6: SGN identical");
        System.out.println("7: check if binary tree is a bst");
        System.out.println("8: bottom view");
        System.out.println("9: inorderSuccessor");


        System.out
                .println("============================================================");
        System.out.println();

    }

    int size = 0;

    //static Integer minValue=Integer.MIN_VALUE;
    public boolean isBST(TreeNode node, Integer previous) throws Exception {
        if (node == null) {
            return true;
        }
    /*	if(previous==null)
		{
			previous=minValue;
		}*/
        if (node != null) {
            isBST(node.getLeft(), previous);
            System.out.print(node.getKey() + "  ");
            if (previous > node.key) {
                System.out.println("not a bst");
                throw new Exception("not a bst");
                //return false;
            }
            previous = node.key;
            isBST(node.getRight(), previous);
        }
        return true;

    }

    public int inOrder(TreeNode node) {
		/*if(node==null)
			return -1;*/
        if (node != null) {
            inOrder(node.getLeft());
            System.out.println("key= " + node.getKey() + " , level=" + node.level + " , parent=" + node.parent);
            size++;
            inOrder(node.getRight());
        }
        return size;
    }

    public void postOrder(TreeNode node) {
        if (node != null) {
            postOrder(node.getLeft());
            postOrder(node.getRight());
            System.out.print(node.getKey() + "  ");
        }
    }

    public TreeNode insert() {
        System.out.println("enter data value");
        root = insert(root, scanner.nextInt());
        return root;
    }

    private TreeNode insert(TreeNode root, int data) {
        // TreeNode root=root;
        if (root == null) // if tree is empty
        {
            root = new TreeNode(data);
            return root;
        } else {
            if (data < root.getKey()) {
                root.left = insert(root.left, data);
                //setting link to parent
                root.left.parent = root;
            } else {
                root.right = insert(root.right, data);
                //setting link to parent
                root.right.parent = root.right;
            }
        }
        return root;

    }

    public void preOrder(TreeNode root) {

        if (root != null) {
            System.out.print(root.getKey() + "  ");
            preOrder(root.getLeft());
            preOrder(root.getRight());
        }
    }

    public Map<Integer, Integer> bottomView(TreeNode root, Map<Integer, Integer> map) {
        LinkedList<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.removeFirst();
            if (node != null) {
                map.put(node.hd, node.key);
                if (node.left != null) {
                    node.left.hd = node.hd - 1;
                    node.left.level = node.level + 1;
                    queue.add(node.left);
                }
                if (node.right != null) {
                    node.right.hd = node.hd + 1;
                    node.right.level = node.level + 1;

                    queue.add(node.right);
                }
            }
        }
        return map;

    }

    public TreeNode inOrderSuccessor(TreeNode node) {
        if (node == null)
            return null;
        if (node.right != null) {
            // search left most node in right sub tree
            node = node.right;
            while (node.left != null) {
                node = node.left;
            }
            return node;
        } else {
            // if right sub tree null
            // move up until an element larger than this is found or
            // null encountered in case we are at the righmost node
            while (node.parent != null || node.key < node.parent.key) {
                node = node.parent;
            }
            return node;
        }
    }

}
