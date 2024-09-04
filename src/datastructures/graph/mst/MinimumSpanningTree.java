package datastructures.graph.mst;

import datastructures.graph.disjointset.implementation.DisjointSet;

import java.util.*;

public class MinimumSpanningTree {
    public static void main(String[] args) {

        // Test case 1: Simple graph
        int[][] edges1 = {{1, 2, 5}, {1, 3, 9}, {2, 3, 1}};
        int numberOfVertices1 = 3;
        kruskalAlgorithm(edges1, numberOfVertices1)
                .forEach(item -> System.out.println(item[0] + ", " + item[1] + ", " + item[2]));
        System.out.println("Expected MST: {{2, 3, 1}, {1, 2, 5}}");
        System.out.println();

        // Test case 2: A graph with disconnected components (non-MST)
        int[][] edges2 = {{1, 2, 2}, {2, 3, 3}, {4, 5, 4}, {5, 6, 6}};
        int numberOfVertices2 = 6;
        kruskalAlgorithm(edges2, numberOfVertices2)
                .forEach(item -> System.out.println(item[0] + ", " + item[1] + ", " + item[2]));
        System.out.println("Expected MST: {{1, 2, 2}, {2, 3, 3}, {4, 5, 4}, {5, 6, 6}}");
        System.out.println();

        // Test case 3: Complete graph with multiple MST possibilities
        int[][] edges3 = {{1, 2, 10}, {2, 3, 15}, {1, 3, 5}, {3, 4, 7}, {2, 4, 12}};
        int numberOfVertices3 = 4;
        kruskalAlgorithm(edges3, numberOfVertices3)
                .forEach(item -> System.out.println(item[0] + ", " + item[1] + ", " + item[2]));
        System.out.println("Expected MST: {{1, 3, 5}, {3, 4, 7}, {1, 2, 10}}");
        System.out.println();

        // Test case 4: Graph with negative weights
        int[][] edges4 = {{1, 2, -1}, {2, 3, 2}, {1, 3, 3}, {3, 4, -2}, {4, 5, 1}};
        int numberOfVertices4 = 5;
        kruskalAlgorithm(edges4, numberOfVertices4)
                .forEach(item -> System.out.println(item[0] + ", " + item[1] + ", " + item[2]));
        System.out.println("Expected MST: {{3, 4, -2}, {1, 2, -1}, {4, 5, 1}, {2, 3, 2}}");
        System.out.println();

        // Test case 5: Graph with a single vertex
        int[][] edges5 = {};
        int numberOfVertices5 = 1;
        kruskalAlgorithm(edges5, numberOfVertices5)
                .forEach(item -> System.out.println(item[0] + ", " + item[1] + ", " + item[2]));
        System.out.println("Expected MST: {}");
        System.out.println();
    }


    static List<int[]> kruskalAlgorithm(int[][] edges, int n) {
        //sort edges based on weights
        Arrays.sort(edges, (a, b) -> a[2] - b[2]);
        List<int[]> mstEdges = new ArrayList<>();
        DisjointSet disjointSet = new DisjointSet(n + 1);

        for (int[] edge : edges) {
            //process the edges unless all the vertices are added to our MST
            if (mstEdges.size() == n - 1)
                break;

            //avoid forming a cycle,
            // a cycle is formed if both the source and destinations are part of the same set
            if (disjointSet.areComponentsConnected(edge[0], edge[1]))
                continue;

            disjointSet.union(edge[0], edge[1]);
            mstEdges.add(edge);
        }
        return mstEdges;
    }
}
