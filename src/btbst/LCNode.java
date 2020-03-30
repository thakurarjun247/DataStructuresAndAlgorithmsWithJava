package btbst;

public class LCNode {
    public Integer key;
    public LCNode left;
    public LCNode right;

    @Override
    public String toString() {
        if(this==null) return "null";
        else return this.key.toString();
    }

    public LCNode(Integer key) {
        this.key = key;
    }
}