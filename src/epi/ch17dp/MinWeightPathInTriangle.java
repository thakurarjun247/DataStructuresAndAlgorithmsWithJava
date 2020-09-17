package epi.ch17dp;

import java.util.*;

public class MinWeightPathInTriangle {

    public static void main(String a[]) {
        List<List<Integer>> tri = new ArrayList<>();
        tri.add(Arrays.asList(2));
        tri.add(Arrays.asList(14, 4));
        tri.add(Arrays.asList(81, 91, 6));
        tri.add(Arrays.asList(41, 21, 61, 2));
        tri.add(Arrays.asList(11, 15, 12, 13, 4));
        // System.out.println(minWeightPathInTriangle(tri));
        System.out.println(f(tri));
    }

    static int f(List<List<Integer>> tri) {
        if (tri.isEmpty()) return 0;
        //for each item in every row
        //calculate and save the min distance to get to the bottom most
        //row
        List<List<Integer>> results = new ArrayList<>();
        for (int rowNumber = tri.size() - 1; rowNumber >= 0; rowNumber--) {
            List<Integer> row = new ArrayList<>();
            if (rowNumber == tri.size() - 1)
                row = tri.get(tri.size() - 1);
            else {
                int rowSize = tri.get(rowNumber).size();
                for (int rowIndex = 0; rowIndex < rowSize; rowIndex++) {
                    int current=tri.get(rowNumber).get(rowIndex);
                    int index0=results.get(tri.size()-rowNumber - 2).get(rowIndex);
                    int index1=results.get(tri.size()-rowNumber - 2).get(rowIndex+1);
                    int min= Math.min(index0, index1);
                    row.add(min+current);
                }
            }
            results.add(row);
        }
        return results.get(results.size() - 1).get(0);
    }

    static int minWeightPathInTriangle(List<List<Integer>> tri) {
        if (tri.isEmpty()) return 0;
        int maxLength = tri.get(tri.size() - 1).size();

        return minWeightPathInTriangle(tri, new Integer[tri.size()][maxLength], tri.get(0).get(0), 0, 0);
    }

    static int minWeightPathInTriangle(List<List<Integer>> tri, Integer[][] memo, int sum, int n, int i) {
        if (n >= tri.size())
            return sum;

        return sum + Math.min(minWeightPathInTriangle(tri, memo, sum, n + 1, i),
                minWeightPathInTriangle(tri, memo, sum, n + 1, i + 1));
    }
}
