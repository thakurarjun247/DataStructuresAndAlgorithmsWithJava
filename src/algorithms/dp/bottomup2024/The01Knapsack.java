package algorithms.dp.bottomup2024;
//reference: https://www.youtube.com/watch?v=8LusJS5-AGo&list=PLrmLmBdmIlpsHaNTPP_jHHDx_os9ItYXr
public class The01Knapsack {
    public static void main(String[] args) {
        // Edge cases
        System.out.println(knapsack(new int[]{}, new int[]{}, 0)); // Empty knapsack
        System.out.println(knapsack(new int[]{10}, new int[]{5}, 5)); // Single item
        System.out.println(knapsack(new int[]{10}, new int[]{10}, 5)); // Item weight exceeds max weight
        System.out.println(knapsack(new int[]{1, 2, 3}, new int[]{2, 3, 4}, 5)); // Multiple items, total weight exceeds max weight

        // Varying item values and weights
        System.out.println(knapsack(new int[]{1, 2, 3}, new int[]{1, 2, 3}, 5)); // Similar values and weights
        System.out.println(knapsack(new int[]{10, 5, 20}, new int[]{1, 2, 3}, 5)); // Different values and weights
        System.out.println(knapsack(new int[]{100, 200, 300}, new int[]{1, 1, 1}, 5)); // Large values and small weights

        // Testing the dynamic programming approach (large input)
        int[] largeValues = new int[1000];
        int[] largeWeights = new int[1000];
        System.out.println(knapsack(new int[]{1,4,5,7},new int[]{1,3,4,5}, 7 ));
    }
    static int knapsack(int[] value, int[] weight, int maxWeight){
        if(value.length==0 || weight.length==0 || weight.length!=value.length || maxWeight<0)
        {
            System.out.println("invalid input ");
            return 0;
        }
        int m[][] = new int[weight.length][maxWeight+1];
        for(int i=1;i<weight.length;i++){
            for(int j=0;j<=maxWeight;j++){
                int leaveIt=m[i-1][j];
                m[i][j]=(j<weight[i])?leaveIt:Math.max(value[i]+m[i-1][j-weight[i]],leaveIt);
            }
        }
        return m[weight.length-1][maxWeight];
    }
}



