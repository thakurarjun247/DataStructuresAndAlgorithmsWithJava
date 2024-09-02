package classicalcompsciproblems;


import java.util.*;
public class NewLRUCacheFromScratch{
    public static void main(String[] args) {
        NewLRUCache cache= new NewLRUCache(3);
        cache.put(1, 1);
        cache.put(0, 0);
        cache.put(2, 2);
        cache.put(4, 4);
        System.out.println(cache.get(0));
        System.out.println(cache.get(-1));
        System.out.println(cache.get(1));
        System.out.println(cache.get(4));

    }
}
 class NewLRUCache {
    //search O(1) find in map. In list: when something is accessed move it to front, keep track of head
    //remove O(1): keep track of the tail, to remove last
    //insert 0(1) add to head and map
    LinkedList<Node> linkedList;
    Map<Integer, Node> map;
    Node tail;
    Node head;

    int capacity;
     NewLRUCache(int capacity){
        linkedList = new LinkedList<>();
        map= new HashMap<>();
        this.capacity =capacity;
    }


   public void put(int key, int value){
        if(map.size()==capacity)
            removeEldestEntry();
        Node node=new Node(key, value);
        map.put(key, node);
        linkedList.addFirst(node);
    }
    public int get(int key){
        if(!map.containsKey(key))
            return -1;
        Node node=map.get(key);
        moveToFront(node);
        return node.value();

    }

    private void removeEldestEntry(){
        int keyToRemove= linkedList.getLast().key();
        linkedList.removeLast();
        map.remove(keyToRemove);

    }

    private void moveToFront(Node node){
        linkedList.remove(node);
        linkedList.addFirst(node);
    }
}

record Node(int key, int value){}
