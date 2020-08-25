package clrs.graph;

import java.util.*;
import java.lang.*;
import java.io.*;


public class PrimsAlgo {


    public static void main(String[] args)
    {
		/* Let us create the following graph
		2 3
		(0)--(1)--(2)
		| / \ |
		6| 8/ \5 |7
		| /	 \ |
		(3)-------(4)
			9		 */
        PrimsAlgo t = new PrimsAlgo();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };

        // Print the solution
        t.primMST(graph);
    }






    // Function to construct and print MST for a graph represented
    // using adjacency matrix representation
    void primMST(int graph[][])
    {
        final int V=graph.length;
        // Array to store constructed MST
        int parent[] = new int[V];

        // Key values used to pick minimum weight edge in cut
        int candidateKeysForNextEdge[] = new int[V];

        // To represent set of vertices included in MST
        Boolean verticesAlreadyIncludedInMST[] = new Boolean[V];

        // Initialize all keys as INFINITE
        for (int i = 0; i < V; i++) {
            candidateKeysForNextEdge[i] = Integer.MAX_VALUE;
            verticesAlreadyIncludedInMST[i] = false;
        }

        // Always include first 1st vertex in MST.
        candidateKeysForNextEdge[0] = 0;

        // Make candidateKeysForNextEdge 0 so that this vertex is
        // picked as first vertex
        parent[0] = -1; // First node is always root of MST

        // The MST will have V vertices
        for (int count = 0; count < V - 1; count++) {
            // Pick thd minimum candidateKeysForNextEdge vertex from the set of vertices
            // not yet included in MST
            int u = minKey(candidateKeysForNextEdge, verticesAlreadyIncludedInMST, V);

            // Add the picked vertex to the MST Set
            verticesAlreadyIncludedInMST[u] = true;

            // Update candidateKeysForNextEdge value and parent index of the adjacent
            // vertices of the picked vertex. Consider only those
            // vertices which are not yet included in MST
            for (int v = 0; v < V; v++)

                // graph[u][v] is non zero only for adjacent vertices of m
                // verticesAlreadyIncludedInMST[v] is false for vertices not yet included in MST
                // Update the candidateKeysForNextEdge only if graph[u][v] is smaller than candidateKeysForNextEdge[v]
                if (graph[u][v] != 0 && verticesAlreadyIncludedInMST[v] == false && graph[u][v] < candidateKeysForNextEdge[v]) {
                    parent[v] = u;
                    candidateKeysForNextEdge[v] = graph[u][v];
                }
        }

        // print the constructed MST
        printMST(parent, graph, V);
    }

    // A utility function to find the vertex with minimum key
    // value, from the set of vertices not yet included in MST
    int minKey(int key[], Boolean mstSet[], final int V)
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed MST stored in
    // parent[]
    void printMST(int parent[], int graph[][], final int V)
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

}
// This code is contributed by Aakash Hasija

