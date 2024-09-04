package leetcodeandgrind75.grind75;

import java.util.Arrays;

public class LC62 {
    public static void main(String[] args) {
        System.out.println(new LC62().uniquePaths(7,3));
    }
    public int uniquePaths(int R, int C) {
        if(R==1 ||C==1) return 1;
        int[][] m=new int[R][C];
        Arrays.fill(m[R-1], 1);
        for(int r=0;r<R;r++)
            m[r][C-1]=1;
        for(int r=R-2;r>=0;r--)
            for(int c=C-2;c>=0;c--)
                m[r][c]= m[r+1][c]+ m[r][c+1];
        return m[0][0];

    }
}
