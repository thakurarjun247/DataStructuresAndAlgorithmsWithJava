package algorithms.dp;


import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

class WeightIndex {
    int w;
    int i;

    WeightIndex() {
    }

    public WeightIndex(int w, int i) {
        this.w = w;
        this.i = i;
    }

    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getI() {
        return i;
    }

    public void setI(int i) {
        this.i = i;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WeightIndex that = (WeightIndex) o;
        return w == that.w &&
                i == that.i;
    }

    @Override
    public int hashCode() {
        return Objects.hash(w, i);
    }
}

public class Knapsack01 {
    public static void main(String[] args) {
        //wikipedia data set example
        int[] w3 = /*{1, 3, 4, 5};*/{12, 2, 1, 4, 1};
        int[] p3 = /*{1, 4, 5, 7};*/{4, 2, 1, 10, 2};
        int W3 = 10;
        System.out.println(knap01(w3, p3, W3));
        System.out.println(knap01Memo(w3, p3, W3));
        int[] wWiki = /*{1, 3, 4, 5};*/{3, 2, 1};
        int[] ppWiki = /*{1, 4, 5, 7};*/{4, 3, 1};
        int maxWeight = 4;

        //abdul bari dataset
        int[] w2 = /*{1, 3, 4, 5};*/{2, 3, 4, 5};
        int[] p2 = /*{1, 4, 5, 7};*/{1, 2, 5, 6};
        int W2 = 2;
        /*   System.out.println(knap01(w2, p2, W2));*/
        System.out.println(knap01Memo(w2, p2, W2));
        System.out.println("done bari");

        //System.out.println(f(w3, p3, W3));

        int[] yw = {12, 2, 6, 4, 1};
        int[] yp = {4, 2, 3, 10, 2};
        int ymax = 20;

       /* int[] w = {2, 2, 4, 5};
        int[] p = {2, 4, 6, 11};
        int maxWeight = 6;
        int[] w = {2, 2, 5};
        int[] p = {6, 5, 12};

        int maxWeight = 6;


        int[] p1 = {20, 5, 10, 40, 15, 25};
        int[] w1 = {1, 2, 3, 8, 7, 4};
        int maxWeight1 = 10;

        int[] w2 = {1, 3, 4, 5};
        int[] p2 = {1, 4, 5, 7};
        int maxWeight2 = 7;
*/

        // System.out.println("f: " + f(w, p, 0, maxWeight, 0));

        //  System.out.println("fMemo: " + fMemo(w, p, 0, maxWeight, 0, new HashMap<String, Integer>()));
        // }
        //System.out.println(fMemo(w1, p1, 0, maxWeight1, 0, new HashMap<String, Integer>()));
        //  System.out.println(fMemo(w2, p2, 0, maxWeight2, 0, new HashMap<String, Integer>()));
        //   System.out.println(f(w2, p2, 0, maxWeight2, 0));

    }

    static int knap01(int[] w, int[] p, int maxWeight) {
        if (w.length == 0 || p.length == 0 || maxWeight <= 0)
            return 0;
        return knap01(w, p, 0, maxWeight, 0);
    }

    static int knap01Memo(int[] w, int[] p, int maxWeight) {
        if (w.length == 0 || p.length == 0 || maxWeight <= 0)
            return 0;
        Map<WeightIndex, Integer> map = new HashMap<>();
        return knap01Memo(w, p, 0, maxWeight, 0, map);
    }

    private static int knap01(int[] w, int[] p, int i, int remainingWeight, int priceSoFar) {
        //terminate if we reached the end of the datastructures.array

        if (i == w.length)
            return priceSoFar;
        // skip
        if (w[i] > remainingWeight)
            return knap01(w, p, i + 1, remainingWeight, priceSoFar);
        return Math.max(
                knap01(w, p, i + 1, remainingWeight - w[i], priceSoFar + p[i]),
                knap01(w, p, i + 1, remainingWeight, priceSoFar)
        );

    }

    private static int knap01Memo(int[] w, int[] p, int i, int remainingWeight, int priceSoFar, Map<WeightIndex, Integer> map) {
        //terminate if we reached the end of the datastructures.array

        if (i == w.length)
            return priceSoFar;
        WeightIndex key = new WeightIndex(remainingWeight, i);
        if (map.containsKey(key))
            return map.get(key);
        // skip
        if (w[i] > remainingWeight) {
            int value = knap01Memo(w, p, i + 1, remainingWeight, priceSoFar, map);
            map.put(key, value);
            return value;
        }
        int value = Math.max(
                knap01Memo(w, p, i + 1, remainingWeight - w[i], priceSoFar + p[i], map),
                knap01Memo(w, p, i + 1, remainingWeight, priceSoFar, map)
        );
        map.put(key, value);
        return value;

    }


    public static int f(int[] w, int[] p, int W) {
        return f(w, p, W, 0, 0, new HashMap<String, Integer>());
    }

    private static int f(int[] w, int[] p, int W, int index, int price, Map<String, Integer> memo) {
        String key = index + "SGN" + W;
        if (memo.containsKey(key)) return memo.get(key);
        if (W == 0) return 0;
        if (index == w.length) return price;
        if (p.length == 0 || w.length == 0) return 0;
        int value = 0;
        if (W < w[index])
            value = f(w, p, W, index + 1, price, memo);
        else
            value = Math.max(f(w, p, W - w[index], index + 1, price + p[index], memo), f(w, p, W, index + 1, price, memo));
        memo.put(index + "SGN" + W, value);
        return value;
    }

}
