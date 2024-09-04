package algorithms.dp.knapsack;

import java.util.HashMap;
import java.util.Map;

//http://techieme.in/solving-01-knapsack-problem-using-recursion/
public class Knapsack01 {
    public static void main(String[] args) {
        int[] p1 = {20, 5, 10, 40, 15, 25};
        int[] w1 = {1, 2, 3, 8, 7, 4};
        //17
        int maxWeight1 = 17;
        System.out.println("fMemo map: " + fMemo(w1, p1, 0, maxWeight1, 0, new HashMap<String, Integer>()));

        Map<WeightIndex, Integer> map = new HashMap<WeightIndex, Integer>();
        // int ans=;
        int[][] arr = new int[100][100];
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++)
                arr[i][j] = -1;

        }


        //assert(fMemo(Array(1,3,4,5), Array(1,4,5,7), 7, Map()) == 9)

        //  int[] w1 = {1, 3, 4, 5};
        //  int[] p1 = {1, 4, 5, 7};
        //int maxWeight1 = 7;
        int[] w = /*{1, 3, 4, 5};*/{2, 2, 4, 5};
        int[] p = /*{1, 4, 5, 7};*/{2, 4, 6, 11};
        int maxWeight = 6;
        //wikipedia example
        int[] w3 = /*{1, 3, 4, 5};*/{12, 2, 1, 4, 1};
        int[] p3 = /*{1, 4, 5, 7};*/{4, 2, 1, 10, 2};
        int maxWeight3 = 15;


        System.out.println("f no memo: " + f(w3, p3, 0, maxWeight3, 0));
        // System.out.println("fMemoMatrix: " + fMemoMatrix(w1, p1, 0, maxWeight1, 0, arr));
        System.out.println("fMemo map: " + fMemo(w3, p3, 0, maxWeight3, 0, new HashMap<String, Integer>()));
        // System.out.println("f from  i: " +
        //       knapSack(p3, w3, p1.length - 1, maxWeight3, new HashMap<>()));
        System.out.println();

        //
        // Arrays.fill(arr, -1);
        //  System.out.println(fMemoMatrix(w, p, 0, maxWeight, 0, arr));
        // System.out.println(f(w, p, 0, maxWeight, 0));
        //    System.out.println(fMemo(w,p, 0, maxWeight, 0, map));

        for (int z = -6; z < 8; z++) {

            maxWeight1 += z;
            maxWeight += z;
            System.out.println(maxWeight1 + " " + maxWeight);
            System.out.println("f no memo: " + f(w1, p1, 0, maxWeight1, 0));
            // System.out.println("fMemoMatrix: " + fMemoMatrix(w1, p1, 0, maxWeight1, 0, arr));
            System.out.println("fMemo map: " + fMemo(w1, p1, 0, maxWeight1, 0, new HashMap<String, Integer>()));
            System.out.println("f from  i: " +
                    knapSack(p1, w1, p1.length - 1, maxWeight1, new HashMap<>()));
            System.out.println();
            System.out.println("f no memo: " + f(w, p, 0, maxWeight, 0));
            //System.out.println("fMemoMatrix: " + fMemoMatrix(w, p, 0, maxWeight, 0, arr));
            System.out.println("fMemo map: " + fMemo(w, p, 0, maxWeight, 0, new HashMap<String, Integer>()));
            System.out.println("f from  i: " +
                    knapSack(p, w, p.length - 1, maxWeight, new HashMap<>()));
            System.out.println("================================");
        }


    }

    /*    static int f(int[] w, int[] p, int currentIndex, int maxWeight, int totalPriceSoFar) {
            if (currentIndex == w.length)
                return totalPriceSoFar;
            if (w[currentIndex] > maxWeight) {
                //leave it
              //  System.out.println("left: "+currentIndex);
                return f(w, p, currentIndex + 1, maxWeight, totalPriceSoFar);
            }
            if(f(w, p, currentIndex + 1, maxWeight, totalPriceSoFar)>
                    //take it
                    f(w, p, currentIndex + 1, maxWeight - w[currentIndex], totalPriceSoFar + p[currentIndex]))
            {//System.out.println("left: "+currentIndex);
                //
                }

            return Math.max(
                    //leave it
                    f(w, p, currentIndex + 1, maxWeight, totalPriceSoFar),
                    //take it
                    f(w, p, currentIndex + 1, maxWeight - w[currentIndex], totalPriceSoFar + p[currentIndex])
            );
        }*/
    static int f(int[] w, int[] p, int currentIndex, int maxWeight, int totalPriceSoFar) {
        if (currentIndex == w.length)
            return totalPriceSoFar;
        int leaveIt = f(w, p, currentIndex + 1, maxWeight, totalPriceSoFar);
        int takeIt = f(w, p, currentIndex + 1, maxWeight - w[currentIndex], totalPriceSoFar + p[currentIndex]);
        if (w[currentIndex] > maxWeight)
            return leaveIt;
        else
            return Math.max(leaveIt, takeIt);
    }

    static int fMemo(int[] w, int[] p, int currentIndex, int maxWeight, int totalPriceSoFar, Map<String, Integer> map) {
        if (currentIndex == w.length || maxWeight <= 0)
            return totalPriceSoFar;
        String key = currentIndex + "&" + maxWeight + "JaiShriGanesh";
       /* if (map.containsKey(key)){
            System.out.println("SGN map has the "+key);
        }*/
        if (!map.containsKey(key)) {
            int leaveIt = fMemo(w, p, currentIndex + 1, maxWeight, totalPriceSoFar, map);
            int takeIt = fMemo(w, p, currentIndex + 1, maxWeight - w[currentIndex], totalPriceSoFar + p[currentIndex], map);

            if (w[currentIndex] > maxWeight)

                map.put(key, leaveIt);
            else
                map.put(key, Math.max(leaveIt, takeIt));

        }

        return map.get(key);
    }

    /*static int fMemo(int[] w, int[] p, int currentIndex, int maxWeight, int totalPriceSoFar, Map<WeightIndex, Integer> map) {
        if (currentIndex == w.length || maxWeight == 0)
            return totalPriceSoFar;
        if (!map.containsKey(new WeightIndex(maxWeight, currentIndex))) {
            int maxPrice = 0;
            if (w[currentIndex] > maxWeight)
                //leave it
                maxPrice = fMemo(w, p, currentIndex + 1, maxWeight, totalPriceSoFar, map);
            else
                maxPrice = Math.max(
                        //leave it
                        fMemo(w, p, currentIndex + 1, maxWeight, totalPriceSoFar, map),
                        //take it
                        fMemo(w, p, currentIndex + 1, maxWeight - w[currentIndex], totalPriceSoFar + p[currentIndex], map)

                );
            map.put(new WeightIndex(maxWeight, currentIndex), maxPrice);

        }

        return map.get(new WeightIndex(maxWeight, currentIndex));
    }*/

    static int fMemoMatrix(int[] w, int[] p, int currentIndex, int maxWeight, int totalPriceSoFar, int[][] map) {
        if (currentIndex == w.length || maxWeight == 0)
            return totalPriceSoFar;

        if (map[maxWeight][currentIndex] == -1) {
            int maxPrice = 0;
            if (w[currentIndex] > maxWeight)
            //leave it
            {
                maxPrice = fMemoMatrix(w, p, currentIndex + 1, maxWeight, totalPriceSoFar, map);
                map[maxWeight][currentIndex] = maxPrice;
            } else {
                maxPrice = Math.max(
                        //leave it
                        fMemoMatrix(w, p, currentIndex + 1, maxWeight, totalPriceSoFar, map),
                        //take it
                        fMemoMatrix(w, p, currentIndex + 1, maxWeight - w[currentIndex], totalPriceSoFar + p[currentIndex], map)

                );
                // map.put(new WeightIndex(w[currentIndex], currentIndex), maxPrice);
                map[maxWeight][currentIndex] = maxPrice;
            }

        }
        return map[maxWeight][currentIndex];
    }

    public static int knapSack(int[] v, int[] w, int n, int W,
                               Map<String, Integer> lookup) {


        // base case: no items left or capacity becomes 0
        if (n < 0 || W <= 0) {
            return 0;
        }

        // construct an unique map key from dynamic elements of the input
        String key = n + "|" + W;

        // if sub-problem is seen for the first time, solve it and
        // store its result in a map
        if (!lookup.containsKey(key)) {
            // Case 1. include current item n in knapSack (v[n]) & recur
            // for remaining items (n-1) with decreased capacity (W - w[n])
            int include = v[n] + knapSack(v, w, n - 1, W - w[n], lookup);

            // Case 2. exclude current item n from knapSack and recur for
            // remaining items (n-1)
            int exclude = knapSack(v, w, n - 1, W, lookup);

            int value = 0;
            if (W < w[n])
                value = exclude;
            else value = Integer.max(include, exclude);
            // assign max value we get by including or excluding current item
            lookup.put(key, value);
        }

        // return solution to current sub-problem
        return lookup.get(key);
    }

    static class WeightIndex {
        int maxWeight;
        int index;

        WeightIndex() {
        }

        WeightIndex(int maxWeight, int index) {
            this.maxWeight = (maxWeight);
            this.index = index;
        }

        @Override
        public boolean equals(Object obj) {
            WeightIndex that = (WeightIndex) obj;

            return this.index == that.index && this.maxWeight == that.maxWeight;
        }

        @Override
        public int hashCode() {
            Integer i = this.index * 37 + this.maxWeight * 101;
            return i.hashCode();
        }
    }

}
/*
 def fMemoScala(w: Array[Int], p: Array[Int], wt: Int, memo: Map[(Int, Int), Int]): Int = {
    if (w.isEmpty) 0
    else if (wt == 0) 0
    else {
      if (memo.contains((w.length, wt))) {
        println(s"yay found in Memo ${w.length}, $wt")
      }
      else {
        println(s"calculating ${w.length}, $wt")
        //leave it
        val value = if (wt < w.head) fMemoScala(w.tail, p.tail, wt, memo)
        else p.head + fMemoScala(w.tail, p.tail, wt - w.head, memo) max fMemoScala(w.tail, p.tail, wt, memo)
        memo += (w.length, wt) -> value
      }
      memo((w.length, wt))
    }
  }
 */