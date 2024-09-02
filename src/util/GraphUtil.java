package util;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class GraphUtil {

    public static void main(String[] args) {

        int[][] a = {{0, 1}, {1, 2}, {3, 4}};
        System.out.println(new GraphUtil().buildAdjacencyListForNonWeightedDirectedGraph(5, a));
    }

    public static Map<Integer, List<Integer>> buildAdjacencyListForNonWeightedDirectedGraph(int n, int[][] edges) {
        Map<Integer, List<Integer>> adjacencyList = new HashMap<>();
        for (int i = 1; i <= n; i++)
            adjacencyList.put(i, new ArrayList<Integer>());
        for (int i = 0; i < edges.length; i++) {
            int source = edges[i][0];
            int destination = edges[i][1];
            adjacencyList.get(source).add(destination);
            //for undirected graph: add the reverse edge as well
            //uncomment below
          //  adjacencyList.get(destination).add(source);
        }
        return adjacencyList;
    }

    public static Map<Integer, List<int[]>> buildAdjacencyListForWeightedDirectedGraph(int[][] edges, int n) {
        Map<Integer, List<int[]>> edgeList = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            edgeList.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            edgeList.get(edge[0]).add(edge);
            //todo: for undirected graph: add the reverse edge as well

        }
        return edgeList;
    }



    //prepare adjList
    public static Map<Integer, List<Integer>> getAdjcencyListLambdaWay(int[][] edges, int numberOfVertices) {
        Map<Integer, List<Integer>> adjList =
                IntStream
                        .rangeClosed(1, numberOfVertices) //loop the value of v from 1 to numberOfVertices
                        .boxed() // Autobox int to Integer:  IntStream to Stream<Integer>
                        .collect(Collectors.toMap(
                                v -> v, // here is the key part of the map we are building, Map vertex to itself
                                //let's build the value now, it will be list of Edges
                                v -> Arrays.stream(edges)
                                        .filter(e -> e[0] == v) //only take the edges where source is the current Vertex
                                        .map(e -> e[1])//map the source destination from datastructures.array to record class Edge representation
                                        .collect(Collectors.toList()) //Collect to a list, it will be value part of the map
                        ));
        return adjList;

    }
}


