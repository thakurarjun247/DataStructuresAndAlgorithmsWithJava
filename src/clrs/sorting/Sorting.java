package clrs.sorting;

import java.util.Arrays;
import java.util.Random;

import static util.Util.printArray;

public class Sorting {
    public static void main(String[] s) {
        int[] a = {5, 4, 5, 4, 3, 4, 0, 2, 1, -90, -80, 200};
        int[] b = a;
        int[] c = a;
        printArray(a);
        qsort(a);
        //mergesort(a);
        printArray(a);

        // int[] output = countingSort(a, 5);
        //System.out.println(output);
    }

    public static void qsort(int[] a) {
        qsort(a, 0, a.length - 1);
    }

    static void qsort(int[] a, int l, int h) {
        //if just one element we go home
        if (l >= h) return;


        //the index, it should be called pivot index
        //all items on left of index < item at index < all items on right of index.
        int index = swapAroundPivot(a, l, h);
        //repeat on both halves
        qsort(a, l, index - 1);
        qsort(a, index, h);
    }

    static int swapAroundPivot(int[] a, int l, int h) {
        //pivot is the middle element, not the middle index.
        //or even better choose it randomly,
        //much better if you choose it to be median
        //during the interviews it is easier to demo if you choose it random
        //and almost the mid element
        //int pivot = a[(l + h) / 2];
        ;
        int pivot =a[new Random().nextInt(h+1)];
        while (l <= h) {
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
        int[] helper = new int[a.length];
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
            count[arr[i]] += 1;
        }
        for (int i = 1; i < k; ++i) {
            count[i] = count[i] + count[i - 1];
        }
        for (int j = arr.length - 1; j >= 0; j--) {
            output[count[arr[j]] - 1] = arr[j];
            count[arr[j]] -= 1;
        }

        return output;
    }
}


