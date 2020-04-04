package clrs.bst;


class BSTApp {
    public static void main(String[] args) {

        BinarySearchTree bst = new BinarySearchTree();

        int a[] = {10, 20, 30};

        Node root = bst.create(a, 0, a.length - 1);

       // System.out.println(bst.getMin(root).key);
        Node max=bst.getMax(root);
      // System.out.println(max.key);
       bst.insert(root, new Node(200));
        bst.insert(root, new Node(35));
       // bst.inorder(root);
        System.out.println(bst.search(root,new Node(10)));
        System.out.println(bst.search(root, new Node(200)));
        System.out.println(bst.search(root, new Node(35)));
        System.out.println(bst.search(root, new Node(280)));
        System.out.println(bst.search(root, new Node(-30)));
        System.out.println(bst.search(root, new Node(15)));
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
    public String toString(){

        return "\n\t"+key+ " \n("+getLeft()+", "+getRight()+")";
    }
    Integer getLeft(){
        if(this.left!=null)
            return left.key;
        else return null;
    }
    Integer getRight(){
        if(this.right!=null)
            return right.key;
        else return null;
    }
}

public class BinarySearchTree {

   public boolean search(Node root, Node node){
        if(node==null) return true;
        if(root==null) return false;
        if(root.key==node.key)
            return true;
        if(root.key>node.key)
            return search(root.left, node);
        else
            return search(root.right, node);
    }

    public Node create(int[] a, int l, int h) {
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
       while(root.left!=null)
           root=root.left;
       return root;
    }
    Node getMax(Node root) {
        if(root==null)
            return root;
        while(root.right!=null)
            root=root.right;
        return root;
    }
//todo: notice we return root here and set left and right children
    Node insert(Node root, Node node){

        if(root==null)
            root=node;
        else{
            if(root.key > node.key){
                root.left=insert(root.left, node);
            }
            else{
                root.right=insert(root.right,node);
            }

        }
        return root;

    }
}
