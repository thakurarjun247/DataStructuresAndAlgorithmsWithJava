package datastructuresandalgorithms.arraystring.fun;

public class TwoD {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] a = new int[3][2];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 2; j++) {
                a[i][j] = i + j;
            }
        }

        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }
}
