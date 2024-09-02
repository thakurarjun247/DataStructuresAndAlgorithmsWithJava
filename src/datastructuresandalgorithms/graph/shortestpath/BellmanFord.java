package datastructuresandalgorithms.graph.shortestpath;

import java.util.Arrays;

public class BellmanFord {
    public static void main(String[] args) {
        BellmanFord bellmanFord = new BellmanFord();

        System.out.println("Test case 1:  graph with negative weights");
        int[][] edges2 = {{0, 1, 6}, {0, 2, 7}, {1, 2, 8}, {2, 3, -3},{2,4,9},{4,3,7},{3,1,-2},{1,3,5},{4,0,2},{1,4,-4}};
        int source2 = 0, n2 = 5;
        int[] distances2 = bellmanFord.bellmanFordAlgo(edges2, source2, n2);
        System.out.println("output: " + Arrays.toString(distances2) + " \n Expected: [0,2,7,4,-2]");


        System.out.println("\nTest case 2: Graph with negative cycle");
        int[][] edges1 = {{0, 1, -1}, {1, 2, -2}, {2, 0, -3}};
        int source1 = 0, n1 = 3;
        int[] distances1 = bellmanFord.bellmanFordAlgo(edges1, source1, n1);
        System.out.println("output " + Arrays.toString(distances1) + " (Expected: Negative cycle detected)");

    }

    int[] bellmanFordAlgo(int[][] edges, int source, int numberOfVertices) {
        //n = vertices numbers 0 to n-1
        int[] distancesFromSource = new int[numberOfVertices];
        //init all the vertices distance to infinite, set source to 0
        for (int i = 0; i < numberOfVertices; i++) {
            if (i != source)
                distancesFromSource[i] = Integer.MAX_VALUE;
        }

        //relax
        for (int v = 0; v < numberOfVertices - 1; v++) {
            for (int[] edge : edges) {
                //distance to the destination vertex
                // = min (current distance to the destination vertex, current distance to the source vertex
                //          + edge weight from the source to the detination)
                distancesFromSource[edge[1]] = Math.min(distancesFromSource[edge[1]],
                        (distancesFromSource[edge[0]] == Integer.MAX_VALUE || edge[2] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : distancesFromSource[edge[0]] + edge[2]);
            }

        }
        //once more for the negative cycle detection
        for (int[] edge : edges) {
            //if there is negative cycle it will reduce the distance from the source to this vertex destination further
            if (distancesFromSource[edge[1]] > Math.min(distancesFromSource[edge[1]],
                    (distancesFromSource[edge[0]] == Integer.MAX_VALUE || edge[2] == Integer.MAX_VALUE) ?
                            Integer.MAX_VALUE : distancesFromSource[edge[0]] + edge[2])) {
                System.out.println("Negative cycle detected!");
                return new int[0];
            }
        }
        return distancesFromSource;
    }
}
