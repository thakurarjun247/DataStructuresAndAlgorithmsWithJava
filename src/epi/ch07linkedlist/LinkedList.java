package epi.ch07linkedlist;

import java.util.Random;

class LinkedListApp {
    public static void main(String[] args) {

        //8.1 mergeSortedLLs
        LinkedListUtil util = new LinkedListUtil();
        int[] a = {10, 20, 30};
        int[] b = {5, 25, 35};
       // System.out.println(util.mergeSortedLLs(util.createLLFromArray(b),util.createLLFromArray(a)));

        //8.2 reverse single sublist
        int[] l= {10, 20, 30, 40, 50, 60, 70};
        System.out.println(util.reverseSingleSublist(util.createLLFromArray(l), 3, 5));
        System.out.println();

    }
}

class LinkedListUtil {
    public Node createEvenLL() {
        Random random = new Random();
        Node head = new Node(0);
        Node prev = head;
        for (int i = 1; i <= 3; i++) {
            Node node = new Node(i * 2);
            prev.next = node;
            prev = prev.next;

        }
        return head;

    }

    public Node createOddLL() {
        Random random = new Random();
        Node head = new Node(1);
        Node prev = head;
        for (int i = 1; i <= 3; i++) {
            Node node = new Node(i * 2 + 1);
            prev.next = node;
            prev = prev.next;

        }
        return head;

    }

    public Node createLLFromArray(int[] a) {
        if (a.length == 0)
            return null;
        Node head = new Node(a[0]);
        Node prev = head;
        for (int i = 1; i < a.length; i++) {
            Node node = new Node(a[i]);
            prev.next = node;
            prev = prev.next;

        }
        return head;

    }

    public Node mergeSortedLLs(Node n1, Node n2) {
      if(n1==null) return n2;
      if(n2==null) return n1;

      Node current=new Node();
      Node dummyHead=current;

      while(n1!=null && n2!=null){
          if(n1.key>=n2.key)
          {
              current.next=n2;
              n2=n2.next;
          }
          else{
              current.next=n1;
              n1=n1.next;
          }
          current=current.next;
      }
        if(n1==null)
            current.next=n2;
        else
            current.next=n1;

        return dummyHead.next;
    }


    public Node reverseSingleSublist(Node head, int s, int f) {
        //s and f inclusive
        //index starts from 1
        //head ->
        Node start=head;
        for(int i=0;i<s-1;i++){
            start = start.next;
        }
        //start is the "sth" node
        Node current=start.next;

        Node finish=current;
        int diff=f-s+1;
        while(diff!=0){
            finish=finish.next;
            diff--;
        }
        Node prev=current;
        while(current!=finish && current!=null){

            Node next=current.next;
            current.next=prev;
            prev=current;
            current=next;

        }
        start.next.next=finish.next;
        start.next=finish;
        return head;
    }


}


class Node {
    int key;
    Node next;

    public Node(int key, Node next) {
        this.key = key;
        this.next = next;
    }

    public Node(int key) {
        this.key = key;
        this.next = null;
    }

    Node() {
    }

    @Override
    public String toString() {
        return key + " -> " + this.next;
    }

/*    @Override
    public boolean equals(Object obj) {
        Node n=(Node) obj;
        return n.key>this.key;
       // return super.equals(obj);
    }

    @Override
    public int hashCode() {
        return this.key.toInteger().hashCode();
    }*/
}
