package algorithms.sorting;

import java.util.Arrays;

public class SalaryCap {


    public static void main(String[] args) {
        int[] a = {90, 30, 100, 40, 20};
    }

    static int f(int[] a, int target) {
        Arrays.sort(a);
        int sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += a[i];
        int diff = sum - target;
        if (diff == 0) return -1;
        for (int i = 0; i < a.length - 1 && diff > 0; i++) {

            int subtractThis = Math.min(a[i + 1] - a[i], diff);
            diff -= subtractThis;
            a[i] -= subtractThis;
        }
//todo: complete it
        return 0;
    }
}
