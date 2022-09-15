package mission_mahakal.graphs;

import java.util.*;

public class _1971 {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //[[0,1],[1,2],[2,0]]

        int[][] a = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(solution.countComponents(5, a));

    }
}

class Solution {
    int count = 0;

    public int countComponents(int n, int[][] a) {
        List<Integer> list = new ArrayList<>();
        List<Boolean> visited = Arrays.asList(new Boolean[n]);

        Map<Integer, List<Integer>> adjList = getAdjList(n, a);


        while (visited.contains(null)) {

            count++;
            dfs(visited.indexOf(null), adjList, visited);
        }
        return count;
    }

    private void dfs(Integer i, Map<Integer, List<Integer>> adjList, List<Boolean> visited) {

        if (visited.get(i) == null) {

            visited.set(i, true);
            for (Integer item : adjList.get(i)) {
                dfs(item, adjList, visited);
            }
        }


    }

    private Map<Integer, List<Integer>> getAdjList(int n, int[][] edges) {


        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 0; i < n; i++)
            adjacencyList.put(i, new ArrayList<Integer>());
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int destination = edges[i][1];
            adjacencyList.get(source).add(destination);
            adjacencyList.get(destination).add(source);
        }
        return adjacencyList;
    }

}
