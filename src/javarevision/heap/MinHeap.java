package javarevision.heap;
//Find the sum of largest three numbers in an datastructures.array

import java.util.PriorityQueue;

public class MinHeap {

    public static void main(String[] args) {
        System.out.println(sumOfThreeLargestNum(new int[]{200, 8, 5, 4, 7, 3, 100}));
    }

    public static int sumOfThreeLargestNum(int[] a) {
        int ans = 0;
        if (a == null) return 0;

        PriorityQueue<Integer> myMinHeap = new PriorityQueue<>();
        PriorityQueue<Integer> myMaxHeap = new PriorityQueue<>((x, y) -> y - x);
        for (int item : a) {
            myMinHeap.add(item);
            myMaxHeap.add(item);
        }
        System.out.println("minheap");
        for (int i = 0; i < a.length; i++) {
            System.out.println(myMinHeap.poll());
        }
        System.out.println("maxheap");
        for (int i = 0; i < a.length; i++) {
            System.out.println(myMaxHeap.poll());
        }

        //create s min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (Integer item : a) {

            minHeap.add(item);
            if (minHeap.size() == 4)
                minHeap.poll();
        }
        while (!minHeap.isEmpty())
            ans += minHeap.poll();
        return ans;
    }
}
