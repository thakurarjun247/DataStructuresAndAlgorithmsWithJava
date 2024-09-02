package datastructuresandalgorithms.arraystring.fun;

import java.util.Arrays;

public class MaxArraySubsequence {
    public static void main(String[] args) {
        int a[] = {1, 11, 2, 3, 10, -54, 49, 59, 0, 100};
        System.out.println(Arrays.toString(a));
        System.out.println("recursive " + maxArraySubsequenceRecursive(a));
        System.out.println("iterative " + maxArraySubsequenceIterativeSolution(a));

    }

    public static int maxArraySubsequenceRecursive(int[] a) {
        return fun(a, Integer.MIN_VALUE, 0, Integer.MAX_VALUE, 0);
    }

    public static int fun(int[] a, int prevSum, int currentSum, int prev, int currentIndex) {
        if (currentIndex == a.length) {

            return Math.max(currentSum, prevSum);
        }
        if (a[currentIndex] < prev) {
            prevSum = Math.max(currentSum, prevSum);
            currentSum = a[currentIndex];
            return fun(a, prevSum, currentSum, a[currentIndex], currentIndex + 1);
        } else {
            prev = a[currentIndex];
            currentSum += a[currentIndex];
            return fun(a, prevSum, currentSum, prev, currentIndex + 1);
        }

    }

    public static int maxArraySubsequenceIterativeSolution(int[] a) {
        int prevSum = 0;
        int currentSum = 0;
        int prev = Integer.MIN_VALUE;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < prev) {
                prevSum = Math.max(prevSum, currentSum);
                currentSum = a[i];

            } else {
                currentSum += a[i];
            }
            prev = a[i];
        }
        return Math.max(currentSum, prevSum);
    }

}
