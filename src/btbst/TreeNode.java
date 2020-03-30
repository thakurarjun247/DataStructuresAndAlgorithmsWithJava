package btbst;


public class TreeNode {
    public int key;
    public TreeNode left;
    public TreeNode right;
    public int hd;
    public int level;
    //this field is used only in a few methods e.g. finding inorder successor
    public TreeNode parent;

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public TreeNode getLeft() {
        return left;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public TreeNode getRight() {
        return right;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode() {
        super();
        // TODO Auto-generated constructor stub
    }

    public TreeNode(int key) {
        super();
        this.key = key;
    }

    public TreeNode(int key, TreeNode left, TreeNode right) {
        super();
        this.key = key;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int key, TreeNode left) {
        super();
        this.key = key;
        this.left = left;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        Integer i = new Integer(this.key);
        return i.toString();
    }
}
