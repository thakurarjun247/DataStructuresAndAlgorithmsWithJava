package leetcodeandgrind75.leetcode.slidingwindow;

public class MaxAbsoluteDiff {
    public static void main(String[] args) {
        System.out.println(new MaxAbsoluteDiff().longestSubarray(new int[]{8, 2, 4, 7}, 4));
    }

    public int longestSubarray(int[] a, int limit) {
        if (a.length == 1)
            return 1;
        int right = 0;
        int length = 1;
        int min = a[0];
        int max = a[0];
        int diff = Math.abs(max - min);

        for (int left = 0; left < a.length; left++) {
            right = Math.max(left, right);
            while (right < a.length) {
                if (canPick(min, max, left, right + 1, a, limit)) {
                    right++;
                    int item = a[right];
                    min = Math.min(item, min);
                    max = Math.max(item, max);
                    diff = Math.abs(max - min);
                    length = Math.max(right - left + 1, length);
                } else
                    break;
            }

        }


        return length;
    }

    boolean canPick(int min, int max, int left, int next, int[] a, int limit) {
        if (next >= a.length)
            return false;
        min = Math.min(min, a[next]);
        max = Math.max(max, a[next]);
        return Math.abs(min - max) <= limit;
    }
}