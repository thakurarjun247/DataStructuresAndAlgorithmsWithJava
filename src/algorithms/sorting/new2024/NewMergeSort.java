package algorithms.sorting.new2024;

import util.ArrayUtil;

import java.util.Arrays;

public class NewMergeSort {
    public static void main(String[] args) {
        int[] a = {7,9,2,6,5};
        mergesort(a,0,a.length-1);
        ArrayUtil.printArray(a);

        int[] b = {15, 4, 12, 9, 21, 3};
        mergesort(b, 0, b.length - 1);
        ArrayUtil.printArray(b);  // Expected output: 3 4 9 12 15 21

        int[] c = {10, 1, 23, 7, 18, 2};
        mergesort(c, 0, c.length - 1);
        ArrayUtil.printArray(c);  // Expected output: 1 2 7 10 18 23

    }

    //devide
    static void mergesort(int[] a, int low, int high) {
        System.out.println();

        if (low < high) {
            int mid = (high + low) / 2;
            mergesort(a, low,mid);
            mergesort(a,mid+1,high);
            mergeTwoSortedHalvesOfArray(a,low, mid, mid+1, high);
        }
    }

    //conquer
    static void mergeTwoSortedHalvesOfArray(int[] a, int s1, int e1, int s2, int e2) {
        int[] temp = new int[e2-s1+1];
        int originalS1=s1;
        int writerIndex = 0;
        while (s1 <= e1 && s2 <= e2) {
            if (a[s1] > a[s2]) {
                temp[writerIndex++] = a[s2++];
            } else {
                temp[writerIndex++] = a[s1++];
            }
        }
        //set the remaining items
        if (s1 <= e1) {
            while (s1 <= e1)
                temp[writerIndex++] = a[s1++];

        } else {
            while (s2 <= e2)
                temp[writerIndex++] = a[s2++];
        }
        // Copy the merged array from temp back into the original array 'a'
        for (int i = 0; i < temp.length; i++) {
            a[originalS1++] = temp[i];
        }
    }

}


