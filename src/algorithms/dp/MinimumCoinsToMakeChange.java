package algorithms.dp;

/*
https://leetcode.com/problems/coin-change/
* You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:

Input: coins = [1, 2, 5], amount = 11
Output: 3
Explanation: 11 = 5 + 5 + 1
Example 2:

Input: coins = [2], amount = 3
Output: -1
Note:
You may assume that you have an infinite number of each kind of coin.
*
*
*
* */

//TODO: remember:
//TODO: don't pass anything other than a map to the params e.g.
/*
* package datastructuresandalgorithms.problemsfrombooks.clrs.algorithms.dp;

public class RodCutting
*/

import java.util.Map;

public class MinimumCoinsToMakeChange {
    public static void main(String[] args) {

    }

  /*  private static int f(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (coins.length == 0) return -1;
        return f(coins, amount);

    }*/

    private static int f(int[] coins, int amount, Map<Integer, Integer> memo) {
        if (memo.containsKey(amount)) return memo.get(amount);
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < coins.length; i++) {
            if (amount >= coins[i]) {
                int val = f(coins, amount - coins[i], memo);
                if (val < min)
                    min = val;
            }
        }
        memo.put(amount, min);
        return min;
    }
}
