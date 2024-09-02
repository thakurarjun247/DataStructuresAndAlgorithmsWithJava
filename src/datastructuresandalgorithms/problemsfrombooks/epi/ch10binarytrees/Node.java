package datastructuresandalgorithms.problemsfrombooks.epi.ch10binarytrees;

 public class Node {
    @Override
    public String toString() {
        return "("+key+")";
    }

    public Node left, parent,  right;
    public int key;
    public int numOfDescendents;

    public Node(int key, Node left, Node right, Node parent) {
        this.left = left;
        this.parent = parent;
        this.right = right;
        this.key = key;
    }
    public Node(int key) {

        this.key = key;
    }
     public Node(int key, int numOfDescendents) {

         this.key = key;
         this.numOfDescendents=numOfDescendents;
     }
    public Node(int key, Node left, Node right) {
        this.left = left;

        this.right = right;
        this.key = key;
    }
    public Node(){}

    public static Node createBinaryTree(){
        Node f = new Node(2);
        Node g = new Node(6);
        Node e = new Node(4);
        Node b = new Node(0);
        Node c = new Node(1);
        Node d = new Node(3);
        Node h = new Node(7);
        Node i = new Node(8);
        Node x = new Node(5);
        f.left = x;
        b.left = c;
        b.right = f;
        c.left = d;
        c.right = e;
        f.right = g;
        g.left = h;
        g.right = i;
        return b;
    }
}
