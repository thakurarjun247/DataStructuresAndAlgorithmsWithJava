package datastructures.tree;

public class LCNode {
    public Integer key;
    public LCNode left;
    public LCNode right;

    public LCNode(Integer key) {
        this.key = key;
    }

    @Override
    public String toString() {
        if (this == null) return "null";
        else return this.key.toString();
    }
}