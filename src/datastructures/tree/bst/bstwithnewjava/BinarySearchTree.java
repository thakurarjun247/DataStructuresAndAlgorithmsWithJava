package datastructures.tree.bst.bstwithnewjava;


public class BinarySearchTree {


    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();
        Node root = binarySearchTree.create(new int[]{2, 6, 3, 8, 4, 9, 1, 0, 77});
        binarySearchTree.setParentsLink(root);
        binarySearchTree.printTree(root);
        binarySearchTree.deleteANode(root.left.left);
        binarySearchTree.printTree(root);


    }


    public Node deleteANode(Node nodeToDelete) {
        if(nodeToDelete==null)
            return null;

        if(nodeToDelete.left==null && nodeToDelete.right==null)
        {
            if(nodeToDelete.parent.left==nodeToDelete)
                nodeToDelete.parent.left=null;
            else
                nodeToDelete.parent.right=null;
           return null;
        }
        //if  left is null, has only right child
        if(nodeToDelete.left==null){
            if(nodeToDelete.parent==null)
                nodeToDelete=nodeToDelete.right;
            if(nodeToDelete.parent.left==nodeToDelete)
                nodeToDelete.parent.left= nodeToDelete.right;
            else
                nodeToDelete.parent.right=nodeToDelete.right;
            return null;
        }

        //do the same on the right side
        if(nodeToDelete.right==null){
            //copy left to here
            nodeToDelete=nodeToDelete.left;

            return;
        }

        //if both child present
        //find the min in the right child, and copy that node here and delete that node.
        Node minOnRight=findMinimumChild(nodeToDelete.right);

        nodeToDelete=minOnRight;
        //deleteANode(minOnRight);


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

    void printInorderSuccessorForAllNodes(Node root) {
        if (root != null) {
            printInorderSuccessorForAllNodes(root.left);
            // System.out.print(root.key+" ");
            inorderSuccessorPrinter(root);

            printInorderSuccessorForAllNodes(root.right);
        }
    }

    void printTree(Node root){
        if(root!=null)
        {
            printTree(root.left);
            System.out.print(root+" ");
            printTree(root.right);
        }
    }

    void inorderSuccessorPrinter(Node root) {
        System.out.print("inorder successor of " + root + " is: ");
        Node node = findInorderSuccessor(root);
        System.out.println(node);
    }



    Node findInorderSuccessor(Node root) {
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
