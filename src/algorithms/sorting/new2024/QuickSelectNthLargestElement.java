package algorithms.sorting.new2024;


import util.ArrayUtil;

public class QuickSelectNthLargestElement {
    public static void main(String[] args) {
        int[] d = {2,4,3,5,6,8,7,9,22,55,1,0,-34,};
        kthsmallestItem(d, 1);

        int[] a = {15, 12, 11, 10, 9, 8, 7, 6, 5, 4};
        kthsmallestItem(a, 3);
        int[] b = {15, 4, 12, 9, 21, 3};
        kthsmallestItem(b, 5);
        int[] c = {10, 1, 23, 7, 18, 2};
        kthsmallestItem(c, 0);

    }


    static int kthsmallestItem(int[] a, int k){
        int ans= kthsmallestItem(a,k,  0,a.length-1);
        ArrayUtil.printArray(a);
        System.out.println(k+"th smallest is "+ans);
        return ans;
    }
    static int kthsmallestItem(int[] a, int k, int low, int high){
        int pivotIndex=NewQuickSort.partition(a, low,high);
        if(pivotIndex==k)
            return a[k];
        if(k<pivotIndex)
            return kthsmallestItem(a, k, low,pivotIndex-1 );
        else
            return kthsmallestItem(a,k,pivotIndex+1,high);
    }




}
