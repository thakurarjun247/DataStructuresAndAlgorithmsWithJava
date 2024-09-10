package algorithms.sorting.new2024;

//https://www.youtube.com/watch?v=9oWd4VJOwr0
//select the min element by scanning the datastructures.array
//swap the min with the leftmost.


import util.ArrayUtil;

public class SelectionSort {
    public static void main(String[] args) {
        Integer[] a = {9, 8, -1, 0, 7, 6, 5};
        ArrayUtil.printArray(selectionSort(a));
    }

    public static Integer[] selectionSort(Integer[] a) {
        if (a.length < 2)
            return a;
        for (int i = 0; i < a.length - 1; i++) {
            int minIndex = getMinIndex(a, i, a.length - 1);
            ArrayUtil.swap(a, minIndex, i);
        }
        return a;
    }

    private static int getMinIndex(Integer[] a, int low, int high) {
        int minIndex = low;
        if (low == high)
            return minIndex;
        int minValue = a[low];
        for (int i = low + 1; i <= high; i++) {
            if (a[i] < minValue) {
                minValue = a[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
}
