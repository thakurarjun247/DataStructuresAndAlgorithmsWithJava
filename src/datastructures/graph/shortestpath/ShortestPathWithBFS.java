package datastructures.graph.shortestpath;

import util.GraphUtil;

import java.util.*;


/*
* Problem Statement:
Given a directed graph represented as a 2D integer array
* edges where edges[i] = [ai, bi] denotes that there is a directed
*  edge from node ai to node bi. You are also given two integers source and dest.

Find the shortest path from node source to node dest. If there is
* no path, return -1.
* */
public class ShortestPathWithBFS {
    public static void main(String[] args) {

        System.out.println(
                getPath(new int[][]{{5, 4}, {1, 2}, {2, 4}, {1, 3}, {3, 5}}, 5, 3, 4));
    }

    static List<Integer> getPath(int[][] edges, int numberOfVertices, int source, int destination) {
        boolean[] visited = new boolean[numberOfVertices + 1];
        Map<Integer, Integer> childToParent = new HashMap<>();
        for (int i = 1; i <= numberOfVertices; i++)
            childToParent.put(i, null);
        Map<Integer, List<Integer>> adjList = (GraphUtil.getAdjcencyListLambdaWay(edges, numberOfVertices));
        Queue<Integer> q = new
                LinkedList<>();
        q.add(source);
        while (!q.isEmpty()) {
            int polledVertex = q.poll();
            if (visited[polledVertex])
                continue;
            else
                visited[polledVertex] = true;

            if (polledVertex == destination) {

                return constructPath(source, polledVertex, childToParent);
            } else {
                adjList.get(polledVertex).forEach(child -> childToParent.put(child, polledVertex));
                if(adjList.get(polledVertex)!=null)
                    q.addAll(adjList.get(polledVertex));
            }

        }
        return null;
    }

    public static List<Integer> constructPath(int source, int destination, Map<Integer, Integer> childToParent) {
        List<Integer> path = new ArrayList<>();

        while (destination != source) {
            path.add(destination);
            destination = childToParent.get(destination);
        }

        path.add(source);
       // Collections.reverse(path);
       // or
        return path.reversed();
    }

}

