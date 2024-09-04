package datastructures.graph.disjointset.leetcode;

import java.util.HashSet;
import java.util.Set;

public class NumberOfConnectedComponents {


    int[] parent;
    int[] size;

    public static void main(String[] args) {
        NumberOfConnectedComponents solution = new NumberOfConnectedComponents();

        // Test case 1
        int[][] edges1 = {{0, 1}, {1, 2}, {2, 3}, {3, 4}};
        int expected1 = 1;
        int result1 = solution.countConnectedComponents(5, edges1);
        System.out.println("Test case 1: Expected " + expected1 + ", Got " + result1);

        // Test case 2
        int[][] edges2 = {{0, 1}, {1, 2}, {3, 4}};
        int expected2 = 2;
        int result2 = solution.countConnectedComponents(5, edges2);
        System.out.println("Test case 2: Expected " + expected2 + ", Got " + result2);

        // Test case 3: Empty graph
        int[][] edges3 = {};
        int expected3 = 0;
        int result3 = solution.countConnectedComponents(0, edges3);
        System.out.println("Test case 3: Expected " + expected3 + ", Got " + result3);

        // Test case 4: Single node
        int[][] edges4 = {{0, 0}}; // Invalid, but handle it gracefully
        int expected4 = 1;
        int result4 = solution.countConnectedComponents(1, edges4);
        System.out.println("Test case 4: Expected " + expected4 + ", Got " + result4);


        // Test case 6: Large graph with many components
        int[][] edges6 = {{0, 1}, {2, 3}, {4, 5}, {6, 7}, {8, 9}, {10, 11}, {12, 13}, {14, 15}};
        int expected6 = 8;
        int result6 = solution.countConnectedComponents(16, edges6);
        System.out.println("Test case 6: Expected " + expected6 + ", Got " + result6);

        // Test case 7: Graph with self-loops and multiple edges (should be handled gracefully)
        int[][] edges7 = {{0, 1}, {0, 1}, {1, 1}, {2, 3}};
        int expected7 = 2; // Assuming self-loops and multiple edges are ignored
        int result7 = solution.countConnectedComponents(4, edges7);
        System.out.println("Test case 7: Expected " + expected7 + ", Got " + result7);
    }

    void init(int n, int[][] edges) {
        if (n < 1 || edges.length < 1)
            System.out.print("Vertexless/Edgeless graph: is a tree? ");
        parent = new int[n];
        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
            parent[i] = i;
        }
    }

    int countConnectedComponents(int n, int[][] edges) {
        init(n, edges);
        for (int[] e : edges) {
            union(e[0], e[1]);
        }
        Set<Integer> distinctParent = new HashSet<>();
        for (int i = 0; i < n; i++)
            distinctParent.add(find(i));
        return distinctParent.size();
    }

    boolean areTwoVerticesAlreadyConnected(int a, int b) {
        return find(a) == find(b);
    }

    int find(int v) {
        if (v == parent[v])
            return v;
        else
            return find(parent[v]);
    }

    boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        int newSize = size[a] + size[b];
        if (size[a] > size[b]) {
            parent[b] = a;
            size[a] = newSize;
        } else {
            parent[a] = b;
            size[b] = newSize;
        }
        return true;
    }
}
