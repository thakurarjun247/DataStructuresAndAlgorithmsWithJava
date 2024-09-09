package algorithms.sorting.new2024;

import util.ArrayUtil;

public class NewQuickSort {
    public static void main(String[] args) {
        int[] a = {7,9,2,6,5};
        quickSort(a,0,a.length-1);
        ArrayUtil.printArray(a);

        int[] b = {15, 4, 12, 9, 21, 3};
        quickSort(b, 0, b.length - 1);
        ArrayUtil.printArray(b);  // Expected output: 3 4 9 12 15 21

        int[] c = {10, 1, 23, 7, 18, 2};
        quickSort(c, 0, c.length - 1);
        ArrayUtil.printArray(c);  // Expected output: 1 2 7 10 18 23
    }
    static void quickSort(int[] a, int left, int right){
        //pick up a pivot, which is almost the median
        int pivot=a[left];
        while(left<right)
        {
            while(a[left]<=pivot)
                left++;
            while(a[right]>pivot)
                right--;
            ArrayUtil.swap(a, left,right);
        }



    }
}
