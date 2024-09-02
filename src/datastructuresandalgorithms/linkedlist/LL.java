package datastructuresandalgorithms.linkedlist;

public class LL {
    public static void main(String[] args) {
        LLFun ll=new LLFun();
        Node node =ll.create();
        ll.visit(node);
        Node last=ll.reverse(node);
        ll.visit(last);
    }
}
class LLFun{
    Node create(){
        Node start=new Node();
        Node temp=start;
        for(int i=0;i<6;i++){
            Node newNode=new Node(i);
            temp.next=newNode;
            temp=newNode;
        }
        return start.next;
    }
    void visit(Node n){
        while(n!=null) {
            System.out.print(n.key + " ");
            n=n.next;
        }
    }

    Node reverse(Node s){
       Node next=null;
       Node pre=s;
       Node current=s;
       while (current!=null || current.next!=null ){
           next=current.next;
           current.next=pre;
           current=next;
           pre=current;
       }
       return current;
    }
}
class Node {
    int key;
    Node next;

    public Node(){}
    public Node(int key) {
        this.key = key;
      //  this.next = next;

    }
}
