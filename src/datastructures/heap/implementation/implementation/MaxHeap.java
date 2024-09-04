package datastructures.heap.implementation.implementation;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MaxHeap {
    List<Integer> heap;

    public MaxHeap() {
        heap = new ArrayList<>();

    }

    public static void main(String[] args) {
        MaxHeap maxHeap = new MaxHeap();
        maxHeap.buildHeap(new int[]{1, 14, 10, 8, 16, 7, 9, 3, 2, 4});

        maxHeap.insert(100);
        maxHeap.insert(2000);
        maxHeap.insert(0);
        maxHeap.delete();
        maxHeap.getMax();
        maxHeap.udpate(300);
        maxHeap.heapSort();

    }

    private int getGreaterChildIndex(int parentIndex) {
        //returns index of the left or right child whichever is greater

        //index of left and right child
        int lc = 2 * parentIndex + 1;
        int rc = 2 * parentIndex + 2;
        int last = heap.size() - 1;

        //check if left child exists
        if (lc > last)
            return -1;
        //check if left child exists but right does not
        if (rc > last) {
            //retrun right child
            return lc;
        }

        if (heap.get(lc) > heap.get(rc)) {
            return (lc);
        } else {
            return (rc);
        }

    }

    int delete() {
        int heapRoot = heap.getFirst();
        Collections.swap(heap, 0, heap.size() - 1);
        heap.removeLast();
        settleDown(0);
        return heapRoot;
    }

    void buildHeap(int[] a) {
        for (int item : a) {
            insert(item);
        }
    }

    //heapify
    void insert(int item) {
        heap.add(item);
        bubbleUp(heap.size() - 1);
    }

    private void bubbleUp(int childIndex) {
        int parentIndex = (childIndex - 1) / 2;
        if (childIndex >= 0 && parentIndex >= 0 && heap.get(parentIndex) < heap.get(childIndex)) {
            Collections.swap(heap, childIndex, parentIndex);
            bubbleUp(parentIndex);
        }
    }

    private void settleDown(int rootIndex) {
        int childIndex = getGreaterChildIndex(rootIndex);
        if (childIndex != -1 && heap.get(childIndex) > heap.get(rootIndex)) {
            Collections.swap(heap, rootIndex, childIndex);
            settleDown(childIndex);
        }
    }

    int getMax() {
        return heap.get(0);
    }

    void udpate(int key) {
        //add to last
        heap.add(key);
        //move it up
        bubbleUp(heap.size() - 1);

    }

    int[] heapSort() {
        int[] array = new int[heap.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = delete();
        }
        Arrays.stream(array).forEach(item -> System.out.print(item + ", "));
        return array;
    }

}
