package datastructuresandalgorithms.graph.shortestpath;
import util.GraphUtil;

import java.util.*;
public class DijkstraShortestPathAbdulBariSirAndCLRSBookExample {
    // TODO: 01-09-2024 : see the video below for context, or page 659 of CLRS book
    //https://www.youtube.com/watch?v=XB4MIexjvY0
    public static void main(String[] args) {

        //graph 1 abdul bari example
        int numVerticesInGraph1 = 6;
        int startInGraph1 = 1;
        int[][] graph1 = {
                {1, 2, 2},
                {1, 3, 4},
                {2, 3, 1},
                {2, 4, 7},
                {3, 5, 3},
                {5, 4, 2},
                {4, 6, 1},
                {5, 6, 5}
        };

        System.out.println(Arrays.toString(findShortestPathWithDijktraAlgo(graph1, startInGraph1, numVerticesInGraph1)));

        //graph 2 clrs example page 659
        int numVerticesInGraph2 = 5;
        int startInGraph2 = 1;
        int[][] graph2 = {
                {1, 2, 10},
                {1, 3, 5},
                {2, 3, 2},//
                {2, 4, 1},//
                {3, 5, 2},//
                {5, 4, 6},//
                {3,2,3},
                {5, 1,7},
                {4,5,4},
                {3,4,9}
        };

        System.out.println(Arrays.toString(findShortestPathWithDijktraAlgo(graph2,startInGraph2,numVerticesInGraph2)));
    }


    public static int[] findShortestPathWithDijktraAlgo(int[][] edges, int start, int n) {
        int[] distance = new int[n + 1]; //vertex numbering start from 1
        Arrays.fill(distance, Integer.MAX_VALUE); //intially all the vertices are at infinite distance
        distance[start] = 0;//except start vertex which is at 0 distance from itself.
        boolean[] visited = new boolean[n+1]; //keep track of visit status of all vertices
        Map<Integer, List<int[]>> edgeList = GraphUtil.buildAdjacencyListForWeightedDirectedGraph(edges, n); // source -> {{source, destination, edgeWeight}}
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>((x, y) -> distance[x] - distance[y]); //in order of nearest to farthest vertices from the last processed vertex
        priorityQueue.add(start);
        while (!priorityQueue.isEmpty()) {
            int currentlyPolledVertex = priorityQueue.poll();
            if(visited[currentlyPolledVertex])
                continue; //skip
            else
                visited[currentlyPolledVertex]=true;
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
}
