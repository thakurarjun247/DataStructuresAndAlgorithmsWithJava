package datastructures.heap;


import java.util.*;
//java max datastructures.heap demo
class InBuiltMaxHeapJava {
    public static void main(String args[])
    {
        DescendingOrder comparator=new DescendingOrder();
        // Creating empty priority queue
        //by default a PQ is min datastructures.heap, pass a comparator to make it maxHeap
        PriorityQueue<Integer> minHeap= new PriorityQueue<>();

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new DescendingOrder());
        PriorityQueue<Integer> maxHeap2= new PriorityQueue<>(10, (a, b)-> b-a);
        // Adding items to the pQueue using add()
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(15);

        maxHeap2.add(10);
        maxHeap2.add(20);
        maxHeap2.add(15);

        minHeap.add(10);
        minHeap.add(20);
        minHeap.add(15);

        // Printing the top element of PriorityQueue
        System.out.println(maxHeap.poll());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(maxHeap.poll());

        // Printing the top element again
        System.out.println(maxHeap.poll());
        System.out.println("printing maxHeap2...");
        System.out.println(maxHeap2.poll());
        System.out.println(maxHeap2.poll());
        System.out.println(maxHeap2.poll());

        System.out.println("printing minHeap...");

        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());
        System.out.println(minHeap.poll());

    }

  static class DescendingOrder implements Comparator<Integer>
    {
        // Used for sorting in descending order of
       public int compare(Integer a, Integer b)
        {
            return b-a;
        }
    }
}