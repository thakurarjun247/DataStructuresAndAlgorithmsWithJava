package clrs.graph;
//https://www.geeksforgeeks.org/dijkstras-shortest-path-algorithm-greedy-algo-7/


/*
Given a graph and a source vertex in the graph, find shortest paths from source to all vertices in the given graph.

        DijkstraGeeksForGeeks’s algorithm is very similar to Prim’s algorithm for minimum spanning tree. Like Prim’s MST, we generate a SPT (shortest path tree) with given source as root. We maintain two sets, one set contains vertices included in shortest path tree, other set includes vertices not yet included in shortest path tree. At every step of the algorithm, we find a vertex which is in the other set (set of not yet included) and has a minimum distance from the source.

        Below are the detailed steps used in DijkstraGeeksForGeeks’s algorithm to find the shortest path from a single source vertex to all other vertices in the given graph.
        Algorithm
        1) Create a set sptSet (shortest path tree set) that keeps track of vertices included in shortest path tree, i.e., whose minimum distance from source is calculated and finalized. Initially, this set is empty.
        2) Assign a distance value to all vertices in the input graph. Initialize all distance values as INFINITE. Assign distance value as 0 for the source vertex so that it is picked first.
        3) While sptSet doesn’t include all vertices
        ….a) Pick a vertex u which is not there in sptSet and has minimum distance value.
        ….b) Include u to sptSet.
        ….c) Update distance value of all adjacent vertices of u. To update the distance values, iterate through all adjacent vertices. For every adjacent vertex v, if sum of distance value of u (from source) and weight of edge u-v, is less than the distance value of v, then update the distance value of v.


 */
// A Java program for DijkstraGeeksForGeeks's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
 // A Java program for DijkstraGeeksForGeeks's single source shortest path algorithm.
// The program is for adjacency matrix representation of the graph
import java.lang.*;

public class DijkstraGeeksForGeeks {
    // A utility function to find the vertex with minimum distance value,
    // from the set of vertices not yet included in shortest path tree
    static final int V = 9;
    int getMinDistanceVertex(int dist[], Boolean sptSet[])
    {
        // Initialize min value
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (sptSet[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }

    // A utility function to print the constructed distance array
    void printSolution(int dist[])
    {
        System.out.println("Vertex \t\t Distance from Source");
        for (int i = 0; i < V; i++)
            System.out.println(i + " \t\t " + dist[i]);
    }

    // Function that implements DijkstraGeeksForGeeks's single source shortest path
    // algorithm for a graph represented using adjacency matrix
    // representation
    void dijkstra(int graph[][], int source)
    {
        int distancesToAllVertices[] = new int[V];
        // The output array. distancesToAllVertices[i] will hold
        // the shortest distance from source to i

        for (int i = 0; i < V; i++) {
            distancesToAllVertices[i] = Integer.MAX_VALUE;

        }

        // Distance of source vertex from itself is always 0
        distancesToAllVertices[source] = 0;



        // isVetexProcessed[i] will true if vertex i is included in shortest
        // path tree or shortest distance from source to i is finalized
        Boolean isVetexProcessed[] = new Boolean[V];

        // Initialize all distances as INFINITE and stpSet[] as false
        for (int i = 0; i < V; i++) {
            isVetexProcessed[i] = false;
        }



        // Find shortest path for all vertices
        for (int i = 0; i < V - 1; i++) {
            // Pick the minimum distance vertex from the set of vertices
            // not yet processed. minDistanceVertex is always equal to source in first
            // iteration.
            int minDistanceVertex = getMinDistanceVertex(distancesToAllVertices, isVetexProcessed);

            // Mark the picked vertex as processed
            isVetexProcessed[minDistanceVertex] = true;

            // Update distancesToAllVertices value of the adjacent vertices of the
            // picked vertex.
            for (int v = 0; v < V; v++)
                //relax
                // Update distancesToAllVertices[v] only if is not in isVetexProcessed, there is an
                // edge from minDistanceVertex to v, and total weight of path from source to
                // v through minDistanceVertex is smaller than current value of distancesToAllVertices[v]
                if (!isVetexProcessed[v] && graph[minDistanceVertex][v] != 0 && distancesToAllVertices[minDistanceVertex] != Integer.MAX_VALUE && distancesToAllVertices[minDistanceVertex] + graph[minDistanceVertex][v] < distancesToAllVertices[v])
                    distancesToAllVertices[v] = distancesToAllVertices[minDistanceVertex] + graph[minDistanceVertex][v];
        }

        // print the constructed distance array
        printSolution(distancesToAllVertices);
    }

    // Driver method
    public static void main(String[] args)
    {
        /* Let us create the example graph discussed above */
        int graph[][] =
new int[][]   { { 0, 4, 0, 0, 0, 0, 0, 8, 0 },
                { 4, 0, 8, 0, 0, 0, 0, 11, 0 },
                { 0, 8, 0, 7, 0, 4, 0, 0, 2 },
                { 0, 0, 7, 0, 9, 14, 0, 0, 0 },
                { 0, 0, 0, 9, 0, 10, 0, 0, 0 },
                { 0, 0, 4, 14, 10, 0, 2, 0, 0 },
                { 0, 0, 0, 0, 0, 2, 0, 1, 6 },
                { 8, 11, 0, 0, 0, 0, 1, 0, 7 },
                { 0, 0, 2, 0, 0, 0, 6, 7, 0 } };
        DijkstraGeeksForGeeks t = new DijkstraGeeksForGeeks();
        t.dijkstra(graph, 0);
    }
}
// This code is contributed by Aakash Hasija



