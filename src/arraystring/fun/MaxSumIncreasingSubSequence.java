package arraystring.fun;

import java.util.Arrays;

public class MaxSumIncreasingSubSequence {

	public static void main(String[] args) {
		int a[] = { 1, 11, 2, 3, 10, -54, 49, 59, 0, 100 };
		System.out.println(Arrays.toString(a));
		System.out.println("recursive " + recursiveSolution(a));
		System.out.println("iterative " + iterativeSolution(a));

	}

	public static int recursiveSolution(int[] a) {
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

	public static int iterativeSolution(int[] a) {
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

	public static class BasicTrickyPrograms {
        // removes a given character c from a given string s, sequentially
        public String remove(String s, char c) {
            char[] array = s.toCharArray();
            StringBuilder builder = new StringBuilder();
            for (int i = 0; i < array.length; i++) {
                if (array[i] != c) {
                    builder.append(array[i]);
                }
            }
            return builder.toString();
        }

        //returns boolean value after checking if a given number n is prime
        // A prime number is a whole number greater than 1, whose only two whole-number
        // factors are 1 and itself. The first few prime numbers are 2, 3, 5, 7, 11, 13,
        // 17, 19, 23, and 29. As we proceed in the set of natural numbers N = {1, 2, 3,
        // ...}, the primes become less and less frequent in general.
        public boolean isPrime(int n) {
            int root = (int) Math.sqrt(n);

            for (int i = 2; i <= root; i++) {
                if (n % i == 0) {
                    System.out.println("divisible by " + i);
                    return false;
                }
            }
            return true;
        }

    }
}
