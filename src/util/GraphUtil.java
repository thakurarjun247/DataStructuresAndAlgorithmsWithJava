package util;

import java.util.*;

public class GraphUtil {

    public static void main(String[] args) {

       int[][] a={{0,1},{1,2},{3,4}};
        System.out.println(new GraphUtil().getAdjListFromLeetCodeRepresentation(5,a ));
    }

    private Map<Integer, List<Integer>> getAdjListFromLeetCodeRepresentation(int n, int[][] edges){
        Map<Integer, List<Integer>> adjacencyList =new HashMap<>();
        for(int i=0;i<n;i++)
            adjacencyList.put(i, new ArrayList<Integer>());
        for( int i=0;i<edges.length;i++){
            int source= edges[i][0];
            int destination= edges[i][1];
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }
        return adjacencyList;
    }
}


