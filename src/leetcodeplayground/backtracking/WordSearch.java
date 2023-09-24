package leetcodeplayground.backtracking;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        String word = "SEE";
        System.out.println(new Solution().exist(board,word));

    }
}

class Solution {
    private char[][] board;
    private int R;
    private int C;

    public boolean exist(char[][] board, String word) {
        this.board = board;
        R = board.length;
        C = board[0].length;

        for (int row = 0; row < R; ++row)
            for (int col = 0; col < C; ++col)
                if (backtrack(row, col, word, 0))
                    return true;
        return false;
    }

    protected boolean backtrack(int row, int col, String word, int index) {
        /* Step 1). check the bottom case. */
        if (index >= word.length())
            return true;

        /* Step 2). Check the boundaries. */
        if (row < 0 || row == R || col < 0 || col == C
                || board[row][col] != word.charAt(index))
            return false;

        /* Step 3). explore the neighbors in DFS */
        // mark the path before the next exploration
        char temp=board[row][col];
        board[row][col] = '#';

        int[] rowOffsets = {0, 1, 0, -1};
        int[] colOffsets = {1, 0, -1, 0};
        for (int d = 0; d < 4; ++d) {
            if (backtrack(row + rowOffsets[d], col + colOffsets[d], word, index + 1))
                // return without cleanup
                return true;
        }

        /* Step 4). clean up and return the result. */
        board[row][col] = temp;
        return false;
    }
}
