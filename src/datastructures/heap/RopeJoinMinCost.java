package datastructures.heap;
/*
There are given n ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.

        For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect the ropes in following ways.
        1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
        2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
        3) Finally connect the two ropes and all ropes have connected.

        Total cost for connecting all ropes is 5 + 9 + 15 = 29.
        */

import java.util.PriorityQueue;

public class RopeJoinMinCost {
    public static void main(String[] ar) {
        int[] a = {4, 3, 2, 6};
        System.out.println(f(a));
    }

    public static int f(int[] a) {
        //by default its  min datastructures.heap
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < a.length; i++)
            q.add(a[i]);
        int cost = 0;
        while (q.size() >= 2) {
            int first = q.poll();
            int second = q.poll();
            cost += first + second;
            q.add(first + second);
        }

        return cost;

    }
}
