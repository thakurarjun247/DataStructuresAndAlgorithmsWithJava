package algorithms.sorting.chapter02;

import util.ArrayUtil;

public class _2_1InsertionSort {
    public static void main(String[] a) {
        Integer[] b = {3, 4, 2, 6, 1};
        insertionSort(b);
        ArrayUtil.printArray(b);
    }

    static void insertionSort(Integer[] a) {
        if (a == null || a.length == 0)
            return;
        for (int j = 1; j < a.length; j++) {
            int key = a[j];
            int i = j - 1;
            while (i >= 0 && a[i] > key) {
                a[i + 1] = a[i];
                i--;
            }
            a[i + 1] = key;
        }
    }
}
//Time complexity
//worst: n^2
//best: n
//The best-case time complexity of insertion sort algorithm is O(n)
// time complexity. Meaning that the time taken to sort a
// list is proportional to the number of elements in the list;
// this is the case when the list is already in the correct order.