package heap;


import java.util.*;

class InBuiltMaxHeapJava {
    public static void main(String args[])
    {
        DescendingOrder comparator=new DescendingOrder();
        // Creating empty priority queue
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(10, new DescendingOrder());

        // Adding items to the pQueue using add()
        maxHeap.add(10);
        maxHeap.add(20);
        maxHeap.add(15);

        // Printing the top element of PriorityQueue
        System.out.println(maxHeap.poll());

        // Printing the top element and removing it
        // from the PriorityQueue container
        System.out.println(maxHeap.poll());

        // Printing the top element again
        System.out.println(maxHeap.poll());
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