package clrs.sorting;

import util.Util;

import java.util.Arrays;
import java.util.Random;

import static util.Util.printArray;

public class Sorting {
    public static void main(String[] s) {
        for (int i = 0; i < 5; i++) {
            int[] a = Util.generateArray(3,false, 10, true );
            System.out.println("before sort:" + Arrays.toString(a) + " ");
            insertionSort(a);
            //qsort(a);
            System.out.println("after  sort:" + Arrays.toString(a) + " ");
            System.out.println();
        }

        int[] x = {6, 3, 5, 4, 2, 0, 1};
        System.out.println("kth smallest element" + randomizedQuickSelectFindKthSmallestElement(x, 0, x.length - 1, 3));
        int[] y = x;
        // qsort(y);
        // System.out.println(Arrays.toString(y));;
        System.out.println(Arrays.toString(x));

        System.out.println();
        int[] a = {5, 4, 5, 4, 3, 4, 0, 2, 1, 200};
        int[] b = a;
        int[] c = a;
        // printArray(a);
        // qsort(a);
        System.out.println("mergesort");


        System.out.println(Arrays.toString(a));
        mergesort(a);
        System.out.println(Arrays.toString(a));

        int k = 5;
        int[] input = new int[20];

        Random random = new Random();
        for (int i = 0; i < input.length; i++) {
            input[i] = random.nextInt(k);
        }


        System.out.println(Arrays.toString(input));
        int[] output = countingSort(input, k);
        System.out.println(Arrays.toString(output));
    }

    public static void qsort(int[] a) {
        qsort(a, 0, a.length - 1);
    }

    static void qsort(int[] a, int l, int h) {
        //if just one element we go home
        if (l >= h) return;


        //the pivotIndex, it should be called pivot pivotIndex
        //all items on left of pivotIndex < item at pivotIndex < all items on right of pivotIndex.
        int pivotIndex = swapAroundPivotOrPartition(a, l, h);
        //repeat on both halves
        qsort(a, l, pivotIndex - 1);
        qsort(a, pivotIndex, h);
    }

    static int swapAroundPivotOrPartition(int[] a, int l, int h) {
        //pivot is the middle element, not the middle index.
        //or just choose it randomly,
        //much better if you choose it to be median
        //during the interviews it is easier to demo if you choose it random
        //and almost the mid element
        //int pivot = a[(l + h) / 2];
        //pivot element and partitionIndex are different
        //pivot element is what we choose at randomm better if you choose it to be median
        //pivot index is the final position of l, that's what we return.

        int pivot = a[(l + h) / 2];
        while (l <= h) {
            //we can even cross the pivot, pivot can be 1st element as well.
            //continue to progress from both the ends until l and h meet

            //pivot is the middle element, not the middle index.
            while (a[l] < pivot) {
                l++;
            }
            while (a[h] > pivot) {
                h--;
            }
            if (l <= h) {
                swap(a, l, h);
                l++;
                h--;
            }

        }
        return l;
    }

    private static void swap(int[] arr, int left, int right) {
        int temp = arr[left];
        arr[left] = arr[right];
        arr[right] = temp;

    }

    public static void mergesort(int[] a) {
        if (a.length < 2) return;
       //new int[a.length];
        int[] helper =  Arrays.copyOf(a, a.length);
        mergesort(a, helper, 0, a.length - 1);
    }

    private static void mergesort(int[] a, int[] helper, int l, int h) {
        if (l < h) {
            int m = (l + h) / 2;
            mergesort(a, helper, l, m);
            mergesort(a, helper, m + 1, h);
            mergeHalves(a, helper, l, m, h);
        }
    }

    private static void mergeHalves(int[] a, int[] helper, int l, int m, int h) {
        int helperLeft = l;
        int helperRight = m + 1;
        int current = l;
        while (helperLeft <= m && helperRight <= h) {
            if (helper[helperLeft] > helper[helperRight]) {
                a[current] = helper[helperLeft];
                helperLeft++;
            } else {
                a[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        int remaining = m - helperLeft;
        for (int i = 0; i <= remaining; i++) {
            a[current + i] = helper[helperLeft + i];
        }
  /*      while (current <= m) {
            helper[current] = a[current];
            current++;
        }*/
    }

    public static int[] countingSort(int[] arr, int k) {
        int output[] = new int[arr.length];
        int[] count = new int[k + 1];
        Arrays.fill(count, 0);
        for (int i = 0; i < arr.length; i++) {
            count[arr[i]]++;
        }

        for (int i = 1; i < k; i++) {
            count[i] = count[i] + count[i - 1];
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            output[--count[arr[j]]] = arr[j];

        }

        return output;
        //TODO improvement: rewrite last two for loops as below,  it will be more intuitive e.g.
        /*
        int[] index=new int[count.length];
             for (int i = 1; i < k; i++) {
                index[i] = count[i] + index[i - 1];
            }
              for (int i = arr.length - 1; i >= 0; i--) {
            output[--index[arr[i]]] = arr[i];
            //count[arr[j]] -= 1;
        }

         */

    }

    public static int randomizedQuickSelectFindKthSmallestElement(int[] arr, int low, int high, int k) {
        if (low == high) return arr[low];
        int partitionIndex = swapAroundPivotOrPartition(arr, low, high);
        if (k == partitionIndex) return arr[partitionIndex];
        if (k < partitionIndex) return randomizedQuickSelectFindKthSmallestElement(arr, low, partitionIndex - 1, k);
        else return randomizedQuickSelectFindKthSmallestElement(arr, partitionIndex + 1, high, k);
    }

    public static void insertionSort(int[] a) {
        for (int j = 1; j < a.length; j++) {
            int i = j - 1;
            int key = a[j];
            //todo: careful of the order of the conditions below.
            while (i >= 0 && a[i] > key ) {
                a[i+1]=a[i];
                i--;
            }
            a[i+1]=key;
        }
    }
}
