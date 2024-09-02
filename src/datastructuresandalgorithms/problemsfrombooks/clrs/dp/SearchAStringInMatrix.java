package datastructuresandalgorithms.problemsfrombooks.clrs.dp;

public class SearchAStringInMatrix {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {3, 4, 5}, {5, 6, 7}};
        int[] pattern1 = {1, 3, 4, 6};
        int[] pattern2 = {1, 2, 3, 4};
        System.out.println(
                f(matrix, pattern1)
        );
        System.out.println(
                f(matrix, pattern2)
        );
    }

    static boolean f(int[][] matrix, int[] pattern) {
        return f(matrix, 0, 0, pattern, 0, new boolean[matrix.length][matrix[0].length]);
    }

    static boolean f(int[][] matrix, int x, int y, int[] pattern, int patternIndex, boolean[][] output) {
        if (pattern.length == 0) return true;
        if (matrix.length == 0) return false;
        int row = matrix.length - 1;
        int col = matrix[0].length - 1;
        if (x < 0 || y < 0 || x > row || y > col) return false;
        int P = pattern.length - 1;
        if (patternIndex < 0 || patternIndex > P) return false;

        while (x <= row && x>=0) {
            while (y <= col && y>=0) {
                if (x < 0 || y < 0 /*|| x > row || y > col*/) output[x][y] =false;

               else  output[x][y] =
                        ((matrix[x][y] == pattern[patternIndex]) && (
                                matrix[x + 1][y] == pattern[patternIndex + 1]
                                        || (x==0? false:matrix[x - 1][y] == pattern[patternIndex + 1])
                                        || (y==0)? false: matrix[x][y - 1] == pattern[patternIndex + 1]
                                        || (y==col? false:matrix[x][y + 1] == pattern[patternIndex + 1])));
                if (output[x][y])
                    return true;

            }
        }


        return false;
    }
}
