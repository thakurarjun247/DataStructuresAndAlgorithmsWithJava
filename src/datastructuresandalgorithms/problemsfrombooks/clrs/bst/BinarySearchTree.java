package datastructuresandalgorithms.problemsfrombooks.clrs.bst;

import java.util.*;

class BSTApp {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        int a[] = {0,10, 20, 30, 40, 50, 60, 70, 80, 90, 100};

        Node root = bst.createBST(a);

        System.out.println(bst.lcaInBST(root, new Node(30), new Node(50)).key);
        System.out.println(bst.lcaInBST(root, new Node(30), new Node(10)).key);
        System.out.println(bst.lcaInBST(null, new Node(30), new Node(10)));
        System.out.println(bst.lcaInBST(root, null, new Node(10)).key);
        System.out.println(bst.lcaInBST(root, new Node(10), null).key);
        System.out.println(bst.lcaInBST(null, null,null));
       /* bst.findKLargestElements(root, 5);
        bst.findKLargestElements(root, 2);
        bst.findKLargestElements(root, 10);*/
        //new BT().naturalView(root);

        // System.out.println(bst.getMin(root).key);
        Node max = bst.getMax(root);
        // System.out.println(max.key);
        //  bst.insert(root, new Node(200));
        //  bst.insert(root, new Node(35));
        // bst.inorder(root);
/*        System.out.println(bst.search(root, new Node(10)));
        System.out.println(bst.search(root, new Node(200)));
        System.out.println(bst.search(root, new Node(35)));
        System.out.println(bst.search(root, new Node(280)));
        System.out.println(bst.search(root, new Node(-30)));
        System.out.println(bst.search(root, new Node(15)));
        System.out.println(bst.isBST(root));
        System.out.println(bst.isBSTUsingInorder(root));*/
        //System.out.println("firstKeyGreaterThanGivenValue" + bst.firstKeyGreaterThanGivenValue(root, 8));
    }


}

class Node {
    Node left;
    Node right;
    int key;

    public Node() {
    }

    public Node(int key) {
        this.key = key;
    }

    @Override
    public String toString() {

        return  key + " (" + getLeft() + ", " + getRight() + ")";
    }

    Integer getLeft() {
        if (this.left != null)
            return left.key;
        else return null;
    }

    Integer getRight() {
        if (this.right != null)
            return right.key;
        else return null;
    }

    @Override
    public int hashCode() {
        Integer k = (Integer) key;
        return k.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Node node = (Node) obj;
        return node.key == this.key;
    }
}

public class BinarySearchTree {

    public boolean search(Node root, Node node) {
        if (node == null) return true;
        if (root == null) return false;
        if (root.key == node.key)
            return true;
        if (root.key > node.key)
            return search(root.left, node);
        else
            return search(root.right, node);
    }

    public Node createBST(int[] a) {
        return create(a, 0, a.length - 1);
    }

    private Node create(int[] a, int l, int h) {
        if (l > h)
            return null;

        int m = (l + h) / 2;
        Node root = new Node(a[m]);
        root.left = create(a, l, m - 1);
        root.right = create(a, m + 1, h);
        return root;
    }

    public void inorder(Node root) {
        if (root != null) {
            inorder(root.left);
            System.out.println(root);
            inorder(root.right);
        }
    }

    Node getMin(Node root) {
        if (root == null)
            return null;
        while (root.left != null)
            root = root.left;
        return root;
    }

    Node getMax(Node root) {
        if (root == null)
            return root;
        while (root.right != null)
            root = root.right;
        return root;
    }

    //todo: notice we return root here and set left and right children
    Node insert(Node root, Node node) {

        if (root == null)
            root = node;
        else {
            if (root.key > node.key) {
                root.left = insert(root.left, node);
            } else {
                root.right = insert(root.right, node);
            }

        }
        return root;

    }

    boolean isBST(Node root) {
        return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean isBST(Node root, int minValue, int maxValue) {
        if (root == null) return true;
        return
                minValue < root.key &&
                        root.key < maxValue &&
                        isBST(root.left, minValue, root.key) &&
                        isBST(root.right, root.key, maxValue);

    }

    public boolean isBSTUsingInorder(Node root) {
        return isBSTUsingInorder(root, Integer.MIN_VALUE);
    }

    private boolean isBSTUsingInorder(Node root, int prev) {
        if (root == null)
            return true;
        else {
            System.out.println(prev + "<" + root.key);
            return
                    isBSTUsingInorder(root.left, prev)
                            && (root.key > prev)
                            && isBSTUsingInorder(root.right, root.key);
        }
    }

    //
    public Integer firstKeyGreaterThanGivenValue(Node root, int k) {
        Node node = firstKeyGreaterThanGivenValue(root, k, null);
        return node == null ? null : node.key;
    }

    //prev holds the value of the previous node that we found which is > k,
    //we keep track of it so that if we don't find anything > k than we can fallback on
    //prev.
    private Node firstKeyGreaterThanGivenValue(Node root, int k, Node prev) {
        //fallback on prev
        if (root == null) return prev;

        if (root.key <= k)
            return firstKeyGreaterThanGivenValue(root.right, k, prev);
        else //if root>key
            //we will keep root as prev as root has better precision than prev
            return firstKeyGreaterThanGivenValue(root.left, k, root);
    }

    public void findKLargestElements(Node root, int k) {
        System.out.println();
        Set<Integer> list = new HashSet<Integer>();
        findKLargestElements(root, k, list);
        list.forEach(System.out::print);
    }

    private void findKLargestElements(Node root, int k, Set<Integer> list) {
        //since we need largest elements we do a reverse inorder traversal (right-> root -> left)
        if (root != null && list.size() < k) {
            findKLargestElements(root.right, k, list);
            //if(list.size()<k){
            list.add(root.key);
            findKLargestElements(root.right, k, list);
            // }
        }

    }

    public Node lcaInBST(Node root, Node one, Node two) {
        if (one == null) return two;
        if (two == null) return one;

        //instructions are parsed left to right, so first null check will be done on root
        //npe if null==root not on the leftmost
        if (  null == root || one.key == root.key || two.key == root.key) return root;

        boolean oneGreaterThanRoot = one.key > root.key;
        boolean twoGreaterThanRoot = two.key > root.key;
        if (oneGreaterThanRoot && twoGreaterThanRoot)
            return lcaInBST(root.right, one, two);
        if (!oneGreaterThanRoot && !twoGreaterThanRoot)
            return lcaInBST(root.left, one, two);
        else
            return root;
    }
}
