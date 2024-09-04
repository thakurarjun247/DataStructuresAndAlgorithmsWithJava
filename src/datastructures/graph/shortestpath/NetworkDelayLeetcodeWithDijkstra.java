package datastructures.graph.shortestpath;

import java.util.*;

//todo: this works accurately, but before going into this
//todo: Navigate to this class in the same package and learn the Dijkstra Alog
//DijkstraShortestPathAbdulBariSirAndCLRSBookExample
public class NetworkDelayLeetcodeWithDijkstra {
    public int networkDelayTime(int[][] times, int n, int k) {
        int start = k;


        int[] distances = findShortestPathWithDijktraAlgo(times, start, n);
        int min = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            if (distances[i] == Integer.MAX_VALUE)
                return -1;
            min = Math.max(min, distances[i]);

        }
        return min;
    }

    public int[] findShortestPathWithDijktraAlgo(int[][] edges, int start, int n) {
        int[] distance = new int[n + 1]; //vertex numbering start from 1
        Arrays.fill(distance, Integer.MAX_VALUE); //intially all the vertices are at infinite distance
        distance[start] = 0;//except start vertex which is at 0 distance from itself.
        boolean[] visited = new boolean[n + 1]; //keep track of visit status of all vertices
        Map<Integer, List<int[]>> edgeList = buildAdjacencyListForWeightedDirectedGraph(edges, n); // source -> {{source, destination, edgeWeight}}
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> distance[x] - distance[y]); //in order of nearest to farthest vertices from the last processed vertex
        priorityQueue.add(start);
        while (!priorityQueue.isEmpty()) {
            int currentlyPolledVertex = priorityQueue.poll();
            if (visited[currentlyPolledVertex])
                continue; //skip
            else
                visited[currentlyPolledVertex] = true;
            List<int[]> neighboursOfCurrentVertex = edgeList.get(currentlyPolledVertex);
            for (int[] edge : neighboursOfCurrentVertex) {
                int destination = edge[1];
                int distanceFromStoDWithThisEdge = edge[2];
                //relax
                distance[destination] = Math.min(distance[destination], distance[currentlyPolledVertex] + distanceFromStoDWithThisEdge);
                priorityQueue.add(destination);
            }
        }
        return distance; //todo:ignore the 0th index, it's a dummy value, we don't care about

    }

    public Map<Integer, List<int[]>> buildAdjacencyListForWeightedDirectedGraph(int[][] edges, int n) {
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


}