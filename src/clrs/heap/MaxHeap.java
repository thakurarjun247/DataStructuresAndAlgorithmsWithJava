package clrs.heap;

import java.util.*;

public class MaxHeap {
    public static void main(String[] s) {
        MaxHeapUtil heap = new MaxHeapUtil();
        //Warning Arrays.asList gives fixed size list, but we need a linked list to be able
        //to add remove elements.
        List<Integer> list = new LinkedList<>(Arrays.asList(2, 6, 3, 8, 4, 9, 1, 7));
        System.out.println(list);
        heap.buildMaxHeap(list);
        //heap.heapSort(list);
        System.out.println(list);
        heap.maxHeapInsertMyStyle(list, 10);
        System.out.println(list);
        heap.maxHeapInsertMyStyle(list, -10);
        System.out.println(list);
        heap.maxHeapInsertCLRSStyle(list, 20);
        System.out.println(list);
        heap.maxHeapInsertCLRSStyle(list, -20);
        System.out.println(list);


    }
}

class MaxHeapUtil {

    //floats down the value at index i to appropriate place
    //when we have to delete the max element, we call maxHeapyfy(a, 0)
    void maxHeapyfy(List<Integer> list, int i) {
        if (i >= list.size()) return;
        int heapSize = list.size();
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        //find the index of max among the this item, it's left and right child
        //if left child present
        if (left < heapSize)
            //compare it with parent
            if (list.get(left) > list.get(i))
                largest = left;

        if (right < heapSize)
            if (list.get(right) > list.get(largest))
                largest = right;
            //parent is not the largest
        if (largest != i) {
            Collections.swap(list, largest, i);
            maxHeapyfy(list, largest);
        }
    }

    //builds a maxheap
    void buildMaxHeap(List<Integer> list) {
        for (int i = list.size() - 1; i >= 0; i--)
            maxHeapyfy(list, i);
    }

    void heapSort(List<Integer> list) {
        buildMaxHeap(list);
        System.out.print("sorted elements: ");
        while (!list.isEmpty())
            System.out.print(heapExtractMax(list));
    }

    //remove, delete
    int heapExtractMax(List<Integer> list) {
        if (list.isEmpty())
            throw new NoSuchElementException("empty heap, can't extract max");
        Integer max = list.get(0);
        int lastIndex = list.size() - 1;
        list.set(0, list.get(lastIndex));
        list.remove(lastIndex);
        maxHeapyfy(list, 0);
        return max;

    }
    //Bubble up  / Flow up
    //i is the index where we need to update the value
    void heapIncreaseKey(List<Integer> list, int i, int newValueForIndexI){
        if(i>=list.size())
            return;
        list.set(i,newValueForIndexI);
        flowUp(list, i);
    }
    void flowUp(List<Integer> list, int i){
        if(i>=list.size() || i<1)
            return;
        else{
            int parent = i/2;
            if(parent<0) return;
            if(list.get(parent)<list.get(i))
            {
                Collections.swap(list, i, parent);
                flowUp(list, parent);
            }
        }
    }

    void maxHeapInsertCLRSStyle(List<Integer> list, int key){
        list.add(Integer.MIN_VALUE); //appended
        heapIncreaseKey(list,list.size()-1, key);

    }
    void maxHeapInsertMyStyle(List<Integer> list, int key){
        list.add(key); //appended
        flowUp(list, list.size()-1);
    }


}
