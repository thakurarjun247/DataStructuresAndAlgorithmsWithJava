package algorithms.sorting;

//https://www.youtube.com/watch?v=9oWd4VJOwr0
//select the min element by scanning the array
//swap the min with the leftmost.


public class SelectionSort {
    public static void main(String[] args) {
        int a[] = {9, 8, -1, 0,7, 6, 5};
        util.GenericUtil.printArray(selectionSort(a));
    }

    public static int[] selectionSort(int[] a) {
        if (a.length < 2)
            return a;
        for (int i = 0; i < a.length - 1; i++) {
            System.out.println(i + "->" + (a.length - 1));
            int minIndex = getMinIndex(a, i, a.length - 1);

            if (a[minIndex] < a[i]) {
                int temp = a[minIndex];
                a[minIndex] = a[i];
                a[i] = temp;
            }

        }
        return a;
    }

    private static int getMinIndex(int[] a, int low, int high) {
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
