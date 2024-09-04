package algorithms.searching;

public class SearchSorted2DMatrix {
    public static void main(String[] args) {
        int[][] a = {{-1, 2, 4, 4, 6}, {1, 5, 5, 9, 21}, {3, 6, 6, 9, 22}, {3, 6, 8, 10, 24}};
        System.out.println(f(a, 100));
        System.out.println(f(a, -100));
        System.out.println(f(a, 11));
        System.out.println(f(a, 9));
        System.out.println(f(a, 10));
        System.out.println(f(a, 2));

    }

    static boolean f(int[][] a, int key) {
        if (a.length == 0) return false;
        int row = 0;
        int col = a[0].length - 1;
        if (key < a[0][0] && key > a[row][col]) return false;
        return f(a, 0, 0, row, col, key);
    }

    //see explanation in datastructuresandalgorithms.problemsfrombooks.epi, we can also use a[rowHigh][colLow] instead of a[rowLow][colHigh] for comparison
    //the idea is to eliminate one row or column after every comparison.
    private static boolean f(int[][] a, int rowLow, int colLow, int rowHigh, int colHigh, int key) {
        if (colHigh < 0 || rowLow > a.length - 1) //can't find, don't go out of bounds
            return false;
        if (key == a[rowLow][colHigh])
            return true;
        if (key < a[rowLow][colHigh])
            return f(a, rowLow, colLow, rowHigh, colHigh - 1, key);
        else
            return f(a, rowLow + 1, colLow, rowHigh, colHigh, key);

    }
}
