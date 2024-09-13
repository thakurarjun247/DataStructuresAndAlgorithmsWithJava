package algorithms.dp.bottomup2024;

//refer https://www.youtube.com/watch?v=NnD96abizww&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr&index=2
public class LCS {
    public static void main(String[] args) {
        System.out.println(lcs("acbcf", "abcdaf"));
    }
    static int lcs(String x, String y){
        int[][] m=new int[x.length()+1][y.length()+1];
        for(int i=1;i<=x.length();i++)
            for (int j=1;j<=y.length();j++){
                //mind the value of i and j in x and y.
                //we do have enough space in the matrix but not in the input strings.
                if(x.charAt(i-1)==y.charAt(j-1))
                    m[i][j]=1+m[i-1][j-1];
                else
                    m[i][j]=Math.max(m[i-1][j],m[i][j-1] );
            }
        return m[x.length()][y.length()];
    }
}
