package javabasics.heap;
//Find the sum of largest three numbers in an array

import problemsfrombooks.clrs.stackqueue.Queue;

import java.util.*;

public class MinHeap {

    public static void main(String[] args) {
        System.out.println(sumOfThreeLargestNum(new int[]{200, 8,5,4,7,3,100}));
    }
    public static int sumOfThreeLargestNum(int[] a){
        int ans=0;
        if(a==null ) return 0;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for(Integer item: a){

            q.add(item);
            if(q.size()==4)
                q.poll();
        }
        while(!q.isEmpty())
            ans+=q.poll();
        return ans;
    }
}
