package datastructures.graph;

import java.util.*;

//greedy
//may or may not work with negative edge
//https://leetcode.com/problems/network-delay-time/description/
//algo
/*
 * maintain a distance array for each vertex
 * put source on the queue
 * while q is nonempty{
 *   pop and mark it visited
 *   scan through times
 *   find the vertices with minimum distance from this
 *   update the distance array, if a shorter path found, i.e. relax it.
 *   put these vertices to the queue
 * }
 * choose the max value from the distance array and return it as the answer
 *
 * */
public class DijkstraLeetCodeNetworkDelayProblem1 {
    public static void main(String[] args) {
        DijkstraLeetCodeNetworkDelayProblem1 dij = new DijkstraLeetCodeNetworkDelayProblem1();
        int[][] times = {{1, 2, 1}, {2,1,1}, {2,3,1},{3,1,1}};
        //[[2,1,1],[2,3,1],[]]
        int n = 3;
        int start = 1;
        System.out.println(dij.networkDelayTime(times, n, start));
       // System.out.println(dij.networkDelayTime1(times, n, start));
    }


    public int networkDelayTime(int[][] times, int n, int start) {
        int[] delay = new int[n + 1];
        Arrays.fill(delay, Integer.MAX_VALUE);
        Queue<int[]> q = new LinkedList<>();
        //e.g for times:[[2,1,1],[2,3,1],[3,4,1]]
        // 2->[2,1,1],[2,3,1],
        //3->[3,4,1]
        //init it
        Map<Integer, List<int[]>> connections = new HashMap<>();
        for (int sourceVertex = 1; sourceVertex <= n; sourceVertex++) {
            List<int[]> neighbours = new ArrayList<>();
            for (int row = 0; row < times.length; row++) {
                if (sourceVertex == times[row][0])
                    neighbours.add(times[row]);
            }
            connections.put(sourceVertex, neighbours);
        }

        q.addAll(connections.get(start));


        delay[start] = 0;
        while (!q.isEmpty()) {
            int[] node = q.remove();
            int source = node[0];
            int destination = node[1];
            int newDelayAtDestination = delay[source] + node[2];
            if (newDelayAtDestination < delay[destination]) {
                delay[destination] = newDelayAtDestination;
                //add the items where our destiation is a source
                q.addAll(connections.get(destination));
            }

        }
        int ans = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(delay[i], ans);
        }
        int output = ans == Integer.MAX_VALUE ? -1 : ans;
        return output;

    }


}




