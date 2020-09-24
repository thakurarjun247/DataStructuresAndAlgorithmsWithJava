package other.youtube;

import java.util.*;

public class JSGApp {
    public static void main(String args[]) {
        //this example
        int[] w = {2, 2, 5};
        int[] p = {6, 5, 12};
        int maxWeight = 6;

        //wikipedia example
        int[] p1 = {20, 5, 10, 40, 15, 25};
        int[] w1 = {1, 2, 3, 8, 7, 4};
        int maxWeight1 = 10;

        System.out.println(f(w, p, 0, maxWeight, 0));
        System.out.println(fMemo(w, p, 0, maxWeight, 0, new HashMap<String, Integer>()));
        System.out.println(f(w1, p1, 0, maxWeight1, 0));
        System.out.println(fMemo(w1, p1, 0, maxWeight1, 0, new HashMap<String, Integer>()));

    }

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
        String key = currentIndex + "&" + maxWeight;
        /*if (map.containsKey(key))
            System.out.println("Found value in the memo, for key : "+key);
*/
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

}
