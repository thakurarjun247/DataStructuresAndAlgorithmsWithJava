package mission_mahakal.dp.clrs.chapter15;

public class Knapsack01BottomUp{

    // Returns the maximum value that can
    // be put in a knapsack of capacity W
    static int knapSack(int W, int wt[],
                        int val[], int n)
    {
        int i, w;
        int K[][] = new int[n + 1][W + 1];

        // Build table K[][] in bottom up manner
        for (i = 1; i <= n; i++)
        {
            for (w = 1; w <= W; w++)
            {

                 if (wt[i-1] <= w)
                    K[i][w]
                            = Math.max(val[i - 1]
                                    + K[i - 1][w - wt[i - 1]],
                            K[i - 1][w]);
                else
                    K[i][w] = K[i - 1][w];
            }
        }
        for(int x=0;i<n;i++)
            System.out.println("hi");
         //   util.GenericUtil.printArray(K[x]);
        return K[n][W];
    }

    // Driver code
    public static void main(String args[])
    {
        int val[] = new int[] { 60, 100, 120 };
        int wt[] = new int[] { 10, 20, 30 };
        int W = 100;
        int n = val.length;
        System.out.println(knapSack(W, wt, val, n));
    }
}
/*This code is contributed by Rajat Mishra */
