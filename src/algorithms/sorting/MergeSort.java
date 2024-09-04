package algorithms.sorting;

//https://www.youtube.com/watch?v=9oWd4VJOwr0
//select the min element by scanning the datastructures.array
//swap the min with the leftmost.

import util.ArrayUtil;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        Integer[] a = {5, 4, 3, 2};
        mergeSort(a);
    }

    public static void mergeSort(Integer[] a) {
        if (a.length < 2)
            return;
        Integer[] helper = Arrays.copyOf(a, a.length);
        devide(a, helper, 0, a.length - 1);
        ArrayUtil.printArray(helper);
    }

    private static void devide(Integer[] a, Integer[] helper, int low, int high) {
        if (high <= low)
            return;
        int mid = (low + high) / 2;
        devide(a, helper, low, mid);
        devide(a, helper, mid + 1, high);
        merge(a, new Integer[a.length], low, mid, high);

    }

    private static Integer[] merge(Integer[] a, Integer[] helper, int low, int mid, int high) {

        helper = Arrays.copyOf(a, a.length);
        int left = low;
        int right = mid + 1;
        int helperIndex = 0;
        while (left <= mid && right <= high) {
            if (a[left] < a[right]) {

                helper[helperIndex] = a[left];

                left++;
            } else {
                helper[helperIndex] = a[right];

                right++;
            }
            helperIndex++;
        }
        ArrayUtil.printArray(helper);
        if (left > mid) {
            //copy from right to high
            for (int i = right; i <= high; i++) {
                helper[helperIndex] = a[i];
            }
        } else {
            //copy from left to mid
            for (int i = left; i <= mid; i++) {
                helper[helperIndex] = a[i];
            }
        }
        return helper;


    }
}

