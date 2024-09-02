package codeonline.leetcode.dynamicprogramming;

public class CoinChange {
    public static void main(String[] args) {
        int coins[]={0,1,2,5};
        int amount=11;
        int num=coinChange(coins,amount);
        System.out.println(num);
    }
    public static int coinChange(int[] coins, int amount) {
        int max = amount + 1;
        int[][] T = new int[coins.length][amount+1];
        int i,j;
        i=j=0;
        for ( i = 1; i < coins.length; i++) {
            for ( j = 1; j <= amount; j++) {
                if (j >= coins[i]) {
                    T[i][j] = Math.min(T[i - 1][j], T[i][j - coins[i]] + 1);
                } else
                    T[i][j] = T[i - 1][j];
            }
        }
        return T[i][j] > amount ? -1 : T[i][j];
    }

}
