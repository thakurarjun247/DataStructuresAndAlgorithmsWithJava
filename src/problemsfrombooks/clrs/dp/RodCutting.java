package problemsfrombooks.clrs.dp;

import java.util.Arrays;

public class RodCutting {
    public static void main(String[] a) {
        int price[] = {0, 1, 5, 8, 9, 10, 17, 17, 20, 24, 30};
/*
For testing
here are expected revenues aka r for a given rod size aka s
s r
0 0
1 1
2 5
3 8
4 10
5 13

*/

        int[] memo = new int[price.length + 1];
        Arrays.fill(memo, -1);
        for (int rodSize = 0; rodSize < 6; rodSize++) {
            //System.out.println(rodSize + " " + rodCut(price, rodSize));
            //System.out.println(rodSize + " " + rodCutMemo(price, rodSize, memo));
            System.out.println(rodSize + " " + bottomUpRodCut(price, rodSize, new int[price.length + 1]));
        }
    }

    public static int rodCut(int[] p, int rodSize) {
        if (rodSize == 0) return 0;
        int maxRevenue = Integer.MIN_VALUE;
        for (int i = 1; i <= rodSize; i++) {
            maxRevenue = Math.max(maxRevenue, p[i] + rodCut(p, rodSize - i));
        }
        return maxRevenue;
    }

    public static int rodCutMemo(int[] p, int rodSize, int[] memo) {
        if (rodSize == 0) return 0;
        if (memo[rodSize] != -1) {
            System.out.println("found value of " + rodSize + " in memo as " + memo[rodSize]);
            return memo[rodSize];
        }

        int maxRevenue = Integer.MIN_VALUE;
        for (int i = 1; i <= rodSize; i++) {
            maxRevenue = Math.max(maxRevenue, p[i] + rodCutMemo(p, rodSize - i, memo));
        }
        memo[rodSize] = maxRevenue;
        return maxRevenue;
    }

    static int bottomUpRodCut(int[] p, int rodSize, int[] helper) {
        if (rodSize == 0) return 0;

        for (int rodSizeCounter = 1; rodSizeCounter <= rodSize; rodSizeCounter++) {
            int maxRevenue = Integer.MIN_VALUE;
            for (int i = 1; i <= rodSizeCounter; i++) {
                maxRevenue = Math.max(maxRevenue, p[i] + bottomUpRodCut(p, rodSizeCounter - i, helper));
            }
            helper[rodSize] = maxRevenue;
        }
        return helper[rodSize];
    }
}
