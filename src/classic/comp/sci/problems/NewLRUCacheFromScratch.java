package classic.comp.sci.problems;


import java.util.*;
public class NewLRUCacheFromScratch{
    public static void main(String[] args) {
        NewLRUCache cache= new NewLRUCache(3);
        cache.put("1", "Maata");
        cache.put("0", "SGN");
        cache.put("2", "HHM");
        cache.put("4", "Jai Maata Di");
        System.out.println(cache.get("0"));
        System.out.println(cache.get("-1"));
        System.out.println(cache.get("1"));
        System.out.println(cache.get("4"));

    }
}
 class NewLRUCache {
    //search O(1) find in map. In list: when something is accessed move it to front, keep track of head
    //remove O(1): keep track of the tail, to remove last
    //insert 0(1) add to head and map
    LinkedList<Node> linkedList;
    Map<String, Node> map;
    Node tail;
    Node head;

    int capacity;
     NewLRUCache(int capacity){
        linkedList = new LinkedList<>();
        map= new HashMap<>();
        this.capacity =capacity;
    }


   public void put(String key, String value){
        if(map.size()==capacity)
            removeEldestEntry();
        Node node=new Node(key, value);
        map.put(key, node);
        linkedList.addFirst(node);
    }
    public String get(String key){
        if(!map.containsKey(key))
            return null;
        Node node=map.get(key);
        moveToFront(node);
        return node.value();

    }

    private void removeEldestEntry(){
        String keyToRemove= linkedList.getLast().key();
        linkedList.removeLast();
        map.remove(keyToRemove);

    }

    private void moveToFront(Node node){
        linkedList.remove(node);
        linkedList.addFirst(node);
    }
}

record Node(String key, String value){}
