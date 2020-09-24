package problemsfrombooks.clrs.stackqueue;

class QueueApp {
    public static void main(String[] ar) {
        Queue q = new Queue();
        System.out.println(q.isEmpty());
        q.remove();
        q.add(10);
        q.add(20);
        q.add(30);
        q.printQ(q.front);


        //q.printQ(q.front);


    }
}

public class Queue {
    Node rear;
    Node front;
    public Queue(){

        rear=null;
        front=null;

    }

//todo: see it carefully.
    public void add(int key) {

        if (rear == null)
            rear = new Node(key);
        else {
            rear.next = new Node(key);
            rear = rear.next;
        }
        if(front==null)
            front=rear;
        System.out.println();
        System.out.println(" added "+key);
       printQ(front);

    }
    void printQ(Node front){
        if(front ==null)
            System.out.println("q is empty");
        else{
            Node temp=front;
            //System.out.println();
            while(temp!=null)
            {
                System.out.print(temp.key+ " -> ");

                temp=temp.next;
            }
        }
    }
    boolean isEmpty() {
        return front == null;
    }

    Node remove() {
        if (isEmpty()) {
            System.out.println("q is empty");
            return null;
        }
        Node node=front;
        System.out.println("removed "+node.key);
        front = front.next;
        printQ(front);
        return node;

    }

}

class Node {
    int key;
    Node next;

    public Node() {
    }

    public Node(int key) {
        this.key = key;
    }

}