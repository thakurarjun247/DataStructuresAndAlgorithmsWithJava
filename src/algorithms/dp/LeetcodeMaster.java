package algorithms.dp;

import java.util.HashMap;
import java.util.Map;

public class LeetcodeMaster {
    public static void main(String[] args) {
        Solution1 s1 = new Solution1();
        int[] a1 = {3, 2, 4};
        int target = 6;
        int[] ans1 = s1.twoSum(a1, target);
        System.out.println("ans1");
        Solution322 s322 = new Solution322();
        int[] a = {2};
        int ans = s322.coinChange(a, 3);
        System.out.println(ans);
    }
}

class Solution322 {
    boolean minusOne = true;

    public int coinChange(int[] coins, int amount) {
        int[] a = new int[amount + 1];
        //global = amount;
        int val = f(coins, amount, 0, 0, a);
        if (minusOne)
            return -1;
        else
            return val;
    }

    //i is the index, n is the ans.
    public int f(int[] c, int amount, int i, int n, int[] a) {
        if (c.length == 0 || amount == 0 || i == c.length) {
            if (amount == 0)
                minusOne = false;
            return n;
        }
        //leave
        //if(amount>c[i])
        int min = Integer.MAX_VALUE;
        if (a[amount] == 0) {
            for (int count = 0; count < c.length; count++) {
                min = Math.min(min, f(c, amount - c[i], i + 1, n + 1, a));
                a[amount] = min;

            }
        }
        return a[amount];

    }
}

class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++)
            map.put(target - nums[i], i);
        for (int i = 0; i < nums.length; i++)
            if (map.containsKey(nums[i])) {
                ans[0] = i;
                ans[1] = map.get(nums[i]);
            }
        return ans;
    }
}