package datastructures.arraystring.fun;

/*
 *    Java Program to Implement Kadane Algorithm
 */

import java.util.Scanner;

/* Class kadane */
public class MaxSubArraySum {
    /* Function to largest continuous sum */
    public int maxSequenceSum(int[] arr) {
        int maxSoFar = arr[0], maxEndingHere = arr[0];
        int endIndex = 0;
        int startIndex = 0;
        for (int i = 1; i < arr.length; i++) {
            /* calculate maxEndingHere */
            if (maxEndingHere < 0)
                maxEndingHere = arr[i];
            else
                maxEndingHere += arr[i];
 
            /* calculate maxSoFar */
            if (maxEndingHere >= maxSoFar) {
                maxSoFar = maxEndingHere;
                endIndex++;
            }
        }
        return maxSoFar;
    }

    /* Main function */
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Kadane Algorithm Test\n");
        /* Make an object of Kadane class */
        MaxSubArraySum k = new MaxSubArraySum();

        System.out.println("Enter size of array :");
        int N = scan.nextInt();
        /* Accept two 2d matrices */
        System.out.println("Enter " + N + " elements");
        int[] arr = new int[N];
        for (int i = 0; i < N; i++)
            arr[i] = scan.nextInt();
        int sum = k.maxSequenceSum(arr);
        System.out.println("\nMaximum Sequence sum = " + sum);

    }
}