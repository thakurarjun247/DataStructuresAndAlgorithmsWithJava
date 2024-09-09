package algorithms.dp.bottomupdp2024;

public class BottomUpDP {
    public static void main(String[] args) {
        int[] prices={0,1,5,8,9,10,17,17,20,24,30};
        int length=4;
        System.out.println(rodCut(prices, length));
    }
    static int rodCut(int[] p, int n){
        int[] r= new int[n+1];

        for(int j=1;j<=n;j++){
            for(int i=1;i<j;i++){
                int q=(i>=0 && i<p.length)?p[i]:Integer.MIN_VALUE;
                //int r[j]=Math.max(q, p[]);

            }
        }
        return r[n];
    }
}
