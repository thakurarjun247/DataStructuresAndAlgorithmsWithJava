package problemsfrombooks.clrs.dp;

import java.util.HashMap;
import java.util.Map;

//http://techieme.in/solving-01-knapsack-problem-using-recursion/
public class Knapsack {
    public static void main(String[] args) {

        int[] yw={12, 2, 6, 4, 1};
        int[] yp={4, 2, 3, 10, 2};
        int ymax=20;
        System.out.println(f(yw, yp, 0,ymax, 0));
        System.out.println(fMemo(yw, yp, 0,ymax, 0,new HashMap<String, Integer>()));
        System.out.println(fYouTube(yw, yp, 0,ymax, 0,new HashMap<Index, Integer>()));

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

    static int f(int[] w, int[] p, int currentIndex, int maxWeight, int totalPriceSoFar) {
        //System.out.println("f");
        if (currentIndex == w.length || maxWeight == 0)
            return totalPriceSoFar;
        if (w[currentIndex] > maxWeight)
            //leave it
            return f(w, p, currentIndex + 1, maxWeight, totalPriceSoFar);
        else
            return Math.max(
                    //leave it
                    f(w, p, currentIndex + 1, maxWeight, totalPriceSoFar),
                    //take it
                    f(w, p, currentIndex + 1, maxWeight - w[currentIndex], totalPriceSoFar + p[currentIndex])
            );
    }

    static int fMemo(int[] w, int[] p, int currentIndex, int maxWeight, int totalPriceSoFar, Map<String, Integer> memo) {
       // System.out.println("fMemo");
        if (currentIndex == w.length || maxWeight == 0)
            return totalPriceSoFar;
        String key = maxWeight + "," + (currentIndex);

        if (memo.containsKey(key)) {
            System.out.println("Yay! found " + key + " in memo");
        }
        if (!memo.containsKey(key)) {
            int maxPrice = 0;
            if (w[currentIndex] > maxWeight)
                //leave it
                maxPrice = fMemo(w, p, currentIndex + 1, maxWeight, totalPriceSoFar, memo);
            else
                maxPrice = Math.max(
                        //leave it
                        fMemo(w, p, currentIndex + 1, maxWeight, totalPriceSoFar, memo),
                        //take it
                        fMemo(w, p, currentIndex +1, maxWeight - w[currentIndex], totalPriceSoFar + p[currentIndex], memo)

                );
            memo.put(key, maxPrice);

        }
        return memo.get(key);
    }
    static int fYouTube(int[] w, int[] p, int currentIndex, int maxWeight, int totalPriceSoFar, Map<Index, Integer> memo) {
        // System.out.println("fMemo");
        if (currentIndex == w.length || maxWeight == 0)
            return totalPriceSoFar;
        Index key = new Index();
        key.remainingWeight=maxWeight;
        key.remainingItems=currentIndex;



        if (memo.containsKey(key)) {
            System.out.println("Yay! found " + key + " in memo");
        }
        if (!memo.containsKey(key)) {
            int maxPrice = 0;
            if (w[currentIndex] > maxWeight)
                //leave it
                maxPrice = fYouTube(w, p, currentIndex + 1, maxWeight, totalPriceSoFar, memo);
            else
                maxPrice = Math.max(
                        //leave it
                        fYouTube(w, p, currentIndex + 1, maxWeight, totalPriceSoFar, memo),
                        //take it
                        fYouTube(w, p, currentIndex +1, maxWeight - w[currentIndex], totalPriceSoFar + p[currentIndex], memo)

                );
            memo.put(key, maxPrice);

        }
        return memo.get(key);
    }

    static class Index {
        int remainingWeight;
        int remainingItems;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            Index index = (Index) o;

            if (remainingWeight != index.remainingWeight) return false;
            return remainingItems == index.remainingItems;

        }

        @Override
        public int hashCode() {
            int result = remainingWeight;
            result = 31 * result + remainingItems;
            return result;
        }
    }



}




