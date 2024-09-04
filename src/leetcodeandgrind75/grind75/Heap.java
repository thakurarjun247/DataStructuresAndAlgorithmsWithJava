package leetcodeandgrind75.grind75;

import java.util.PriorityQueue;

public class Heap {
    public static void main(String[] args) {
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> a - b);
        q.add(4);
        q.add(2);
        q.add(6);
        System.out.println(q);
        PriorityQueue<String> pq = new PriorityQueue<>((a, b) -> a.compareTo(b));
        pq.add("b");
        pq.add("a");
        pq.add("c");
        System.out.println(pq);
    }
}
