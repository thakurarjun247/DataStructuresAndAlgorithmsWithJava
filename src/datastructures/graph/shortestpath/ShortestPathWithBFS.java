package datastructures.graph.shortestpath;

import java.util.*;

/*
* roblem Statement:
Given a directed graph represented as a 2D integer array
* edges where edges[i] = [ai, bi] denotes that there is a directed
*  edge from node ai to node bi. You are also given two integers source and dest.

Find the shortest path from node source to node dest. If there is
* no path, return -1.
* */
public class ShortestPathWithBFS {
    public static void main(String[] args) {
        getPath(new int[][]{{1,2}, {2,4},{1,3} }, 1,4);
    }
    static List<Integer> getPath(int[][] edges, int source, int destination){
        List<Integer> path= new ArrayList<>();
        Map<Integer, List<Integer>> adjList= new HashMap<>();
        //construct the adj list
        List<Integer> destinations= new ArrayList<>();
        for(int[] edge: edges){
            int s= edge[0];
            int d=edge[1];
            if(adjList.containsKey(s))
            {
                destinations= new ArrayList<>(adjList.get(s));
                destinations.add(d);
            }
            else
                destinations= Arrays.asList(d);
            adjList.put(s,destinations);
        }

        Queue<Integer> q= new LinkedList<>();
        if (!adjList.containsKey(source))
            return null;
        else
            path.add(source);
        q.addAll(adjList.get(source));
        while(!q.isEmpty()){
            if(adjList.get(source).contains(destination))
            {
                path.add(destination);
                break;
            }
            //else
        }
        return path;
    }
}
