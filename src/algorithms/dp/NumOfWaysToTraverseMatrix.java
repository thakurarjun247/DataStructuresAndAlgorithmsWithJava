package algorithms.dp;
//https://www.geeksforgeeks.org/count-the-number-of-ways-to-traverse-a-matrix/
//Given a two-dimensional matrix, in how way can someone
// traverse it from top-left to bottom-right?
//Condition- At any particular cell the possible moves are either
// down or right,
// no other steps possible.

public class NumOfWaysToTraverseMatrix {
    public static void main(String[] args) {
        NumOfWaysToTraverseMatrix n = new NumOfWaysToTraverseMatrix();
        System.out.println(n.f(2, 2));
        System.out.println(n.f(3, 3));
        System.out.println(n.f(5, 5));
    }

    int f(int row, int col) {
        if (row == 0 || col == 0) return 0;
        int[][] memo = new int[row][col];
        return f(row - 1, col - 1, memo);
    }

    private int f(int row, int col, int[][] memo) {
        if (row == 0 || col == 0) return 1;
        //defalut value of 2d matrix is always 0
        //if it's not default, i.e. already calculated return it.
        if (memo[row][col] != 0) return memo[row][col];

        //if not calculated, calculate now.
        memo[row][col] = f(row - 1, col, memo) + f(row, col - 1, memo);
        return memo[row][col];
    }
}
