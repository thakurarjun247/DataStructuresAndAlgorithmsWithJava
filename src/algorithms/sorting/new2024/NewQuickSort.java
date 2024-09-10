package algorithms.sorting.new2024;

import util.ArrayUtil;

import java.util.NoSuchElementException;

public class NewQuickSort {
    public static void main(String[] args) {
        int[] a = {15, 12, 11, 10, 9, 8, 7, 6, 5, 4};
        quicksort(a);
        int[] b = {15, 4, 12, 9, 21, 3};
        quicksort(b);
        int[] c = {10, 1, 23, 7, 18, 2};
        //partition(c, 0, c.length - 1);
        quicksort(c); // Expected output: 1 2 7 10 18 23
    }

    static void quicksort(int[] a) {
        ArrayUtil.printArray(a);
        quicksort(a, 0, a.length - 1);
        ArrayUtil.printArray(a);

    }

    static void quicksort(int[] a, int low, int high) {
        if(low >=high)
            return;
        int pivotIndex = partition(a, low, high);
        quicksort(a, low, pivotIndex - 1);
        quicksort(a, pivotIndex + 1, high);
    }

    static int partition(int[] a, int low, int high) {
        //todo: see for explantion
        //https://www.youtube.com/watch?v=7h1s2SojIRw

        int left = low;
        int right = high;
        //pick up a pivot, which is almost the median
        int pivot = a[low];
        while (left < right) {
            while (a[left] <= pivot && left < high)
                left++;
            while (a[right] > pivot && right > low)
                right--;
            if (left < right)
                ArrayUtil.swap(a, left, right);
        }
        ArrayUtil.swap(a, low, right);
        return right;

    }
}
