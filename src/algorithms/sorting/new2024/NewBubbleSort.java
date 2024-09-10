package algorithms.sorting.new2024;

import util.ArrayUtil;

public class NewBubbleSort {
    public static void main(String[] args) {
        int[] a = {15, 12, 11, 10, 9, 8, 7, 6, 5, 4};
        bubbleSort(a);
        int[] b = {15, 4, 12, 9, 21, 3};
        bubbleSort(b);
        int[] c = {10, 1, 23, 7, 18, 2};
        //partition(c, 0, c.length - 1);
        bubbleSort(c); // Expected output: 1 2 7 10 18 23
    }

    static void bubbleSort(int[] a) {
        ArrayUtil.printArray(a);
        for (int high = a.length-1; high > 0; high--) {
            for (int low = 0; low < high; low++) {
                if (a[low] > a[low + 1])
                    ArrayUtil.swap(a, low, low + 1);
            }
        }
        ArrayUtil.printArray(a);
    }

}
