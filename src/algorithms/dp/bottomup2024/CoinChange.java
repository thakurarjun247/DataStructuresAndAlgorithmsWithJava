package algorithms.dp.bottomup2024;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 5, 6, 8}, 12));
    }

    static int coinChange(int[] coins, int change) {
        int R = coins.length + 1;
        int C = change + 1;
        int[][] m = new int[R][C];
        //row 0 should have all infinite, if you have 0 coins with you, you will need infinite to
        //make any change
        for (int[] array : m)
            Arrays.fill(array, Integer.MAX_VALUE);
        //col 0 should have all zero, you need 0 coin to make change 0
        for (int i = 0; i < R; i++) {
            m[i][0] = 0;
        }
        for (int i = 1; i < R; i++)
            for (int j = 1; j < C; j++) {
                int leaveIt = m[i - 1][j];

                if (coins[i - 1] > j)
                    m[i][j] = leaveIt;
                else {

                    int numberOfCurrentCoinsNeededToMakeChange = j / coins[i - 1];
                    int remainder = j % coins[i - 1];
                    int coinsNeededToMakeRemainder = i == 1 ? 0 : m[i - 1][remainder];
                    m[i][j] = Math.min(leaveIt, numberOfCurrentCoinsNeededToMakeChange + coinsNeededToMakeRemainder);
                }

            }

        return m[R - 1][C - 1];
    }
}

/*package algorithms.dp.bottomup2024;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 5, 6, 8}, 12));
    }

    static int coinChange(int[] coins, int change) {
        int R = coins.length + 1;
        int C = change + 1;
        int[][] dp = new int[R][C];

        // Initialize the DP array
        for (int i = 0; i < R; i++) {
            Arrays.fill(dp[i], Integer.MAX_VALUE);
        }

        // No coins are needed to make change for 0
        for (int i = 0; i < R; i++) {
            dp[i][0] = 0;
        }

        // Fill the DP table
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                // Case 1: Don't take the current coin
                int leaveIt = dp[i - 1][j];

                // Case 2: Take the current coin, if possible
                if (coins[i - 1] <= j) {
                    int takeIt = dp[i][j - coins[i - 1]];
                    if (takeIt != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(leaveIt, takeIt + 1);
                    } else {
                        dp[i][j] = leaveIt;
                    }
                } else {
                    dp[i][j] = leaveIt;
                }
            }
        }

        // If dp[R-1][C-1] is still MAX_VALUE, it means we can't make the change
        return dp[R - 1][C - 1] == Integer.MAX_VALUE ? -1 : dp[R - 1][C - 1];
    }
}*/
