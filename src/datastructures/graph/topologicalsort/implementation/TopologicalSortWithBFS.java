package datastructures.graph.topologicalsort.implementation;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSortWithBFS {
    public static void main(String[] args) {

        // Test Case 1: Simple directed acyclic graph (DAG)
        int[][] edges1 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}};
        int n1 = 4;
        List<Integer> sortedList1 = topologicalSort(edges1, n1);
        System.out.println("Test Case 1:");
        System.out.println(" Actual output: " + sortedList1);
        System.out.println("Expected output: [0, 1, 2, 3]");

// Test Case 2: DAG with multiple sources and sinks
        int[][] edges2 = {{0, 1}, {0, 2}, {1, 3}, {2, 3}, {4, 5}, {5, 6}};
        int n2 = 7;
        List<Integer> sortedList2 = topologicalSort(edges2, n2);
        System.out.println("Test Case 2:");
        System.out.println(" Actual output: " + sortedList2);
        System.out.println("Expected output: [0, 1, 2, 3, 4, 5, 6]");

// Test Case 3: Cyclic graph (should not produce a topological sort)
        int[][] edges3 = {{0, 1}, {1, 2}, {2, 0}};
        int n3 = 3;
        List<Integer> sortedList3 = topologicalSort(edges3, n3);
        System.out.println("Test Case 3:");
        System.out.println(" Actual output: " + sortedList3);
        System.out.println("Expected output: [] (empty list, indicating a cycle)");

        }

    //given total n vertices, V0 to Vn-1
    static List<Integer> topologicalSort(int[][] edges, int n){
        List<Integer> sortedList= new ArrayList<>();
        int[] indegree= new int[n];
        Queue<Integer> queue =  new LinkedList<>();
        //set indegrees of all
        for(int[] edge: edges){
            indegree[edge[1]] += 1;
        }
        //push 0 indegree vertices to q for processing
       for (int vertex=0;vertex<indegree.length;vertex++){
           if(indegree[vertex]==0)
               queue.add(vertex);
       }
       if(queue.isEmpty())
           System.out.println("cyclic graph detected, none of the vertices have an indegree of 0");

       while(!queue.isEmpty()){
           Integer polledVertex= queue.poll();
           sortedList.add(polledVertex);
           //reduce indegree of the nodes, where the outdegree is from polledVertex
           //e.g. if polledVertex -> nextVertex, is an edge, reduce indegree of the nextVertex by 1
           for(int[] edge: edges){
              if(edge[0]==polledVertex){

                  indegree[edge[1]] -= 1;
                  //push the nextVetex to queue if it's indgree is now 0
                  if(indegree[edge[1]] == 0)
                      queue.add(edge[1]);
              }
           }
       }
        return  sortedList;
    }
}
