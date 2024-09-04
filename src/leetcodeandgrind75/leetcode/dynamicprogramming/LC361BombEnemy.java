package leetcodeandgrind75.leetcode.dynamicprogramming;

public class LC361BombEnemy {

    public int maxKilledEnemies(char[][] grid) {
        int ans = 0;
        if (grid == null || grid.length == 0)
            return ans;
        int R = grid.length;
        int C = grid[0].length;
        int[][] dp = new int[R + 2][C + 2];
        int[][] dp2 = new int[R + 2][C + 2];
        for (int r = R; r > 0; r--) {
            for (int c = C; c > 0; c--) {
                char value = grid[r - 1][c - 1];
                switch (value) {
                    case 'W':
                        dp[r][c] = 0;
                    case 'E':
                        dp[r][c] = 1 + dp[r + 1][c] + dp[r][c + 1];
                    case '0':
                        dp[r][c] = dp[r + 1][c] + dp[r][c + 1];
                }
            }
        }

        for (int r = 1; r <= R; r++) {
            for (int c = 1; c <= C; c++) {
                char value = grid[r - 1][c - 1];
                switch (value) {
                    case 'W':
                        dp2[r][c] = 0;
                    case 'E':
                        dp2[r][c] = 1 + dp2[r - 1][c] + dp2[r][c - 1];
                    case '0':
                        dp2[r][c] = dp2[r - 1][c] + dp2[r][c - 1];
                }
            }
        }

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == '0')
                    ans = Math.max(dp[r + 1][c + 1] + dp2[r + 1][c + 1], ans);
            }
        }
        return ans;
    }
}