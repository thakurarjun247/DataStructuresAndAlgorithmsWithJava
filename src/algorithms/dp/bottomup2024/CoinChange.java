package algorithms.dp.bottomup2024;

import java.util.Arrays;

public class CoinChange {
    public static void main(String[] args) {
        System.out.println(coinChange(new int[]{1, 5, 6, 8}, 11));
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


