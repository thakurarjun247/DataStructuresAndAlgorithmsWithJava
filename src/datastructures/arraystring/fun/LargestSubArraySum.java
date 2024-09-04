package datastructures.arraystring.fun;

public class LargestSubArraySum {

    public static void main(String[] args) {
        int a[] = {-2, 6, 1, -1, -2, 1, 5, -3};
        System.out.println(maxSubArraySum(a));

    }

    static int maxSubArraySum(int a[]) {
        int sum = Integer.MIN_VALUE, max_ending_here = 0;

        for (int i = 0; i < a.length; i++) {
            max_ending_here = max_ending_here + a[i];
            if (sum < max_ending_here)
                sum = max_ending_here;

            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return sum;
    }
}
