package algorithms.sorting.new2024;

import util.ArrayUtil;

import java.util.Arrays;

public class CountingSort {
    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 5, 6, 2, 3, 4, 1, 2, 3, 4, 5, 6, 7, 8, 9, 0, 5, 6, 7, 8, 9, 0,};
        ArrayUtil.printArray(a);
        countingSort(a);
        ArrayUtil.printArray(a);


    }

    static int[] countingSort(int[] a) {

        // Find the range of input values
        int max = Arrays.stream(a).max().getAsInt();
        int min = Arrays.stream(a).min().getAsInt();

        // Initialize the count array
        int[] count = new int[max - min + 1];  // Only allocate for the range
        int[] b = new int[a.length];
        for (int item : a) {
            count[item]++;
        }
        int writingStartAtIndex = 0;
        for (int i = 0; i < count.length; i++) {

            /// 5, 3, 4  count[i]
            /// 0, 1, 2  i
            if (count[i] != 0) {
                writer(b, i, writingStartAtIndex, count[i]);
                writingStartAtIndex += count[i];
            }
        }
        return b;
    }

    private static void writer(int[] b, int item, int startIndex, int count) {
        for (int i = startIndex; i < startIndex + count; i++) {
            b[i] = item;
        }
    }

}
