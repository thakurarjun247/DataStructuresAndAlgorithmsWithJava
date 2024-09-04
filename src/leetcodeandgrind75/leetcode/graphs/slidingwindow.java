package leetcodeandgrind75.leetcode.graphs;


class slidingwindow {
    public int minSubArrayLen(int target, int[] a) {
        int left = 0;
        int windowSize = Integer.MAX_VALUE;
        int right = 0;
        int sum = 0;
        for (right = 0; right < a.length; right++) {
            //move the right edge of window
            sum += a[right];

            //move left edge of window
            while (sum >= target) {
                windowSize = Math.min(windowSize, right - left + 1);
                sum -= a[left];
                left++;
            }

        }
        return windowSize == Integer.MAX_VALUE ? 0 : windowSize;
    }
}