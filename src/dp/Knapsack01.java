package dp;


import java.util.*;

public class Knapsack01 {
    public static void main(String[] args) {
        int[] w3 = /*{1, 3, 4, 5};*/{12, 2,1,4,1};
        int[] p3 = /*{1, 4, 5, 7};*/{4, 2, 1,10,2};
        int W3 = 15;
        System.out.println(f(w3, p3, W3));

        int[] yw = {12, 2, 6, 4, 1};
        int[] yp = {4, 2, 3, 10, 2};
        int ymax = 20;

       /* int[] w = {2, 2, 4, 5};
        int[] p = {2, 4, 6, 11};
        int maxWeight = 6;*/
        int[] w = {2, 2, 5};
        int[] p = {6, 5, 12};

        int maxWeight = 6;


        int[] p1 = {20, 5, 10, 40, 15, 25};
        int[] w1 = {1, 2, 3, 8, 7, 4};
        int maxWeight1 = 10;

        int[] w2 = {1, 3, 4, 5};
        int[] p2 = {1, 4, 5, 7};
        int maxWeight2 = 7;


        // System.out.println("f: " + f(w, p, 0, maxWeight, 0));

        //  System.out.println("fMemo: " + fMemo(w, p, 0, maxWeight, 0, new HashMap<String, Integer>()));
        // }
        //System.out.println(fMemo(w1, p1, 0, maxWeight1, 0, new HashMap<String, Integer>()));
        //  System.out.println(fMemo(w2, p2, 0, maxWeight2, 0, new HashMap<String, Integer>()));
        //   System.out.println(f(w2, p2, 0, maxWeight2, 0));

    }

    public static  int f(int[] w, int[] p, int W) {
        return f(w, p, W, 0, 0, new HashMap<String, Integer>());
    }

    private static int f(int[] w, int[] p, int W, int index, int price, Map<String, Integer> memo) {
        String key=index+"SGN"+W;
        if (memo.containsKey(key)) return memo.get(key);
        if (W == 0) return 0;
        if (index == w.length) return price;
        if (p.length == 0 || w.length == 0) return 0;
        int value = 0;
        if (W < w[index])
            value = f(w, p, W, index+1, price, memo);
        else
            value = Math.max(f(w, p, W - w[index], index+1, price + p[index], memo), f(w, p, W, index+1, price, memo));
        memo.put(index+"SGN"+W, value);
        return value;
    }

}
