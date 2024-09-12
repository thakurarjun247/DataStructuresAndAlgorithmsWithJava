package datastructures.tree.bst.bstwithnewjava;


public class BinarySearchTree {


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = binarySearchTree.create(new int[]{2, 6, 3, 8, 4, 9, 1, 0, 77});
        binarySearchTree.setParentsLink(root);
        binarySearchTree.inorderSuccessorPrinter(root.right.left.right);
        binarySearchTree.inorderTraversal(root);
       System.out.println("\n");
       System.out.println(binarySearchTree.findMinimumChild(root.right));
       System.out.println(binarySearchTree.findMaximumChild(root.left));
        binarySearchTree.inorderSuccessorPrinter(root);
    }

    void setParentsLink(Node root) {
        if (root != null) {
            if (root.left != null)
                root.left.parent = root;

            if (root.right != null)
                root.right.parent = root;

            setParentsLink(root.left);
            setParentsLink(root.right);
        }
    }

    Node create(int[] a) {
        if (a == null || a.length == 0)
            return null;
        Node root = new Node(a[0]);
        for (int i = 1; i < a.length; i++) {
            insert(new Node(a[i]), root);
        }
        return root;
    }


    Node insert(Node node, Node root) {
        if (root == null) {
            root = node;
            return root;
        }
        Node originalRoot = root;
        if (node.key < root.key)
            root.left = insert(node, root.left);
        else
            root.right = insert(node, root.right);
        return originalRoot;
    }

    void inorderTraversal(Node root) {
        if (root != null) {
            inorderTraversal(root.left);
            // System.out.print(root.key+" ");
            inorderSuccessorPrinter(root);

            inorderTraversal(root.right);
        }
    }

    void inorderSuccessorPrinter(Node root) {
        System.out.print("inorder successor of " + root + " is: ");
        Node node = inorderSuccessor(root);
        System.out.println(node);
    }



    Node inorderSuccessor(Node root) {
        //if there is a right child, find min in the right subtree.
        if (root.right != null)
            return findMinimumChild(root.right);
        //we don't need to worry about left child, we will find no predesessor there, only smaller items are in there.
        Node parent = root.parent;
        //until the parent
        //  1.  is non null and
        //``2. the root node is right child of it's parent
        // keep moving up
        while (parent != null && root == parent.right) {
            root = parent;
            parent = parent.parent;
        }

        //if the root is the left child of it's parent, the parent is the answer
        return parent;

    }

    Node findRoot(Node node) {
        if (node == null || node.parent == null)
            return node;
        return findRoot(node.parent);
    }

    Node findMinimumChild(Node root) {
        if (root == null || root.left == null)
            return root;
        else
            return findMinimumChild(root.left);
    }

    Node findMaximumChild(Node root) {
        if (root == null || root.right == null)
            return root;
        else
            return findMaximumChild(root.right);
    }


    // Visualize method to print the tree structure like textbooks


}


class Node {
    public int key;
    public Node left;
    public Node right;
    public Node parent;

    Node(int key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return String.valueOf(key);
    }
}
