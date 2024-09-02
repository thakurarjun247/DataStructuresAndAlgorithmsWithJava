package datastructuresandalgorithms.problemsfrombooks.clrs.dp;

 class Playground {
    public static void main(String[] args) {
        //, {3, 4, 5}, {0, 3, 0}, {9, 0, 20}
        int[][] grid = {{1, 0, 7}, {2, 0, 6}};

        //TODO: correct
        Solution2 s2 = new Solution2();
        System.out.println(s2.getMaximumGold(grid));
        //TODO: incorrect
        Solution s = new Solution();
        System.out.println(s.getMaximumGold(grid));

    }
}
class Solution2 {
    public int getMaximumGold(int[][] grid) {
        int max = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                max = Math.max(max, get(grid, i, j, new boolean[grid.length][grid[0].length]));
            }
        }
        return max;
    }

    private int get(int[][] grid, int i, int j, boolean[][] visited) {
        if (i < 0 || j < 0 || i == grid.length || j == grid[0].length || grid[i][j] == 0 || visited[i][j]) return 0;
        visited[i][j] = true;
        int max = 0;
        max = Math.max(max, get(grid, i + 1, j, visited));
        max = Math.max(max, get(grid, i - 1, j, visited));
        max = Math.max(max, get(grid, i, j - 1, visited));
        max = Math.max(max, get(grid, i, j + 1, visited));
        visited[i][j] = false;
        return grid[i][j] + max;
    }
}
class Solution {
    public int getMaximumGold(int[][] grid) {
        int[][] ans = new int[grid.length][grid[0].length];
        if (grid.length == 0) return 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                boolean[][] v = unvisit(grid);
                ans[i][j] = f(i, j, v, grid);
            }
        int max = 0;
        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] > max)
                    max = grid[i][j];
            }
        return max;
    }

    public int f(int i, int j, boolean[][] v, int[][] grid) {
        if (visitable(i, j, v, grid)) {
            v[i][j] = true;
            int value = grid[i][j];
            int up = f(i - 1, j, v, grid);
            int down = f(i + 1, j, v, grid);
            int left = f(i, j - 1, v, grid);
            int right = f(i, j + 1, v, grid);
            int max = Math.max(Math.max(left, right), Math.max(up, down));
            return value + max;
        } else return 0;

    }

    public boolean visitable(int i, int j, boolean[][] v, int[][] grid) {
         if(i < 0 || i > grid.length - 1 || j < 0 || j > grid[0].length - 1 || v[i][j] == true || grid[i][j] == 0 )
             return false;
         return true;


    }

    public boolean[][] unvisit(int[][] grid) {
        boolean[][] v = new boolean[grid.length][grid[0].length];
        return v;
    }

}

