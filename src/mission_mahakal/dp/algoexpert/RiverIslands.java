package mission_mahakal.dp.algoexpert;
import java.util.*;
public class RiverIslands{

    public static void main(String[] a){
        int[][] matrix={
                {0}
        };
        System.out.print(riverSizes(matrix));
    }
    public static List<Integer> riverSizes(int[][] matrix) {
        // Write your code here.
        int R=matrix.length;
        int C=matrix[0].length;

        List<Integer> list =new ArrayList<Integer>();
        boolean[][] v= new boolean[R][C];
        for(int r=0; r<R;r++)
            for(int c=0;c<C;c++){
                int len=visit(matrix, v, r, c, R, C);
                if(len!=0)
                    list.add(len);

            }

        return list;
    }

    public static int visit(int[][] matrix,boolean[][] v,int r,int c, int R, int C){
        if(c<0 || c==C || r<0 || r==R || matrix[r][c]==0 || v[r][c]==true)
            return 0;
        else{
            v[r][c]=true;
            return 1+ visit(matrix, v, r+1, c, R, C)+visit(matrix, v, r-1, c, R, C)+visit(matrix, v, r, c+1, R, C)+visit(matrix, v, r, c-1, R, C);
        }

    }


}


