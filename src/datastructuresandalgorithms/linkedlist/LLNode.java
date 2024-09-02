package datastructuresandalgorithms.linkedlist;

public class LLNode {
    public int data;
    public LLNode next;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public LLNode getNext() {
        return next;
    }

    public void setNext(LLNode next) {
        this.next = next;
    }

    public LLNode() {
    }

    public LLNode(int data, LLNode next) {
        super();
        this.data = data;
        this.next = next;
    }

    public LLNode(int data) {
        super();
        this.data = data;
    }

    public LLNode(LLNode next) {
        super();
        this.next = next;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return Integer.toString(data);
    }

}
