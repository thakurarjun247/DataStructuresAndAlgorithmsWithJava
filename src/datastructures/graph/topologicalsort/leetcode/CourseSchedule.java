package datastructures.graph.topologicalsort.leetcode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedule {
    public boolean canFinish(int n, int[][] edges) {
        List<Integer> list = new ArrayList<>();
        int[] indegree = new int[n];
        Queue<Integer> q = new LinkedList<>();
        for (int[] e : edges) {
            System.out.println(e[0]);
            System.out.println(e[1]);
            indegree[e[0]] += 1;
        }
        for (int v = 0; v < n; v++) {
            if (indegree[v] == 0)
                q.add(v);
        }

        while (!q.isEmpty()) {
            int v = q.poll();
            list.add(v);
            for (int[] e : edges) {
                if (e[1] == v) {
                    indegree[e[0]] -= 1;
                    if (indegree[e[0]] == 0)
                        q.add(e[0]);
                }
            }

        }
        return list.size() == n;
    }
}