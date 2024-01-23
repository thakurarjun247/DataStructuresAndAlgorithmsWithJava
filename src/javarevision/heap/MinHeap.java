package javarevision.heap;
//Find the sum of largest three numbers in an array

import java.util.*;

public class MinHeap {

    public static void main(String[] args) {
        System.out.println(sumOfThreeLargestNum(new int[]{200, 8,5,4,7,3,100}));
    }
    public static int sumOfThreeLargestNum(int[] a){
        int ans=0;
        if(a==null ) return 0;
        //create s min heap
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for(Integer item: a){

            minHeap.add(item);
            if(minHeap.size()==4)
                minHeap.poll();
        }
        while(!minHeap.isEmpty())
            ans+=minHeap.poll();
        return ans;
    }
}
