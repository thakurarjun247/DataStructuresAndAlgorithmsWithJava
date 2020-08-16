package clrs.graph;

import java.util.*;
import java.util.stream.Collectors;

public class DijkstraAlgorithms {
    public static void main(String[] args) {
   /*     //  int sourceVertex = 10;
        int numberOfVertices = 10;
        Set<Integer> allVertices = new HashSet<>();
        for (int i = 0; i < numberOfVertices; i++)
            allVertices.add(i);
        Set<Integer> selectedVertices = new HashSet<>();
        selectedVertices.add(1);
        selectedVertices.add(2);
        Set<Integer> unSelectedVertices = allVertices
                .stream()
                .filter(e -> !selectedVertices.contains(e))
                .collect(Collectors.toSet());
        System.out.println(allVertices);
        System.out.println(selectedVertices);
        System.out.println(unSelectedVertices);*/
   int INF=Integer.MAX_VALUE;
        int graph[][] =
        new int[][]  { { 0, 4, INF, INF, INF, INF, INF, 8, INF },
                { 4, 0, 8, INF, INF, INF, INF, 11, INF },
                { INF, 8, 0, 7, INF, 4, INF, INF, 2 },
                { INF, INF, 7, 0, 9, 14, INF, INF, INF },
                { INF, INF, INF, 9, 0, 10, INF, INF, INF },
                { INF, INF, 4, 14, 10, 0, 2, INF, INF },
                { INF, INF, INF, INF, INF, 2, 0, 1, 6 },
                { 8, 11, INF, INF, INF, INF, 1, 0, 7 },
                { INF, INF, 2, INF, INF, INF, 6, 7, 0 } };

        dijkstrasAlgo(graph, 0).forEach((k,v)-> System.out.println(k+"->"+v));
    }

    private static Map<Integer, Integer> dijkstrasAlgo(int[][] adjMatrix, Integer sourceVertex) {
        Map<Integer, Integer> vertexToDistanceFromSource = new HashMap<>();
        //distance of source from itself is zero
        vertexToDistanceFromSource.put(sourceVertex, 0);
        //set all the
        int numberOfVertices = adjMatrix.length;
        Set<Integer> allVertices = new HashSet<>();
        for (int i = 0; i < numberOfVertices; i++)
            allVertices.add(i);
        allVertices.forEach(v->vertexToDistanceFromSource.put(v, Integer.MAX_VALUE));
        vertexToDistanceFromSource.put(sourceVertex, 0);
        Set<Integer> selectedVertices = new HashSet<>();
        selectedVertices.add(sourceVertex);
        int currentVertex = sourceVertex;
        //until all the vertices get selected
        while (selectedVertices.size() < numberOfVertices) {
            //vertexWithMinimumDistanceFromCurrentVertexThatIsntSelectedYet
            int vertexWithMinimumDistance = getVertexWithMinimumDistance(adjMatrix, selectedVertices, allVertices, currentVertex);
           selectedVertices.add(vertexWithMinimumDistance);
            //relax
            int edgeWeightAfterRelaxing =vertexToDistanceFromSource.get(currentVertex)+ adjMatrix[currentVertex][vertexWithMinimumDistance];
            if(vertexToDistanceFromSource.get(vertexWithMinimumDistance)< Integer.MAX_VALUE &&
                    vertexToDistanceFromSource.get(vertexWithMinimumDistance) > edgeWeightAfterRelaxing){
                adjMatrix[currentVertex][vertexWithMinimumDistance]=edgeWeightAfterRelaxing;
                vertexToDistanceFromSource.put(vertexWithMinimumDistance, edgeWeightAfterRelaxing);
            }
            currentVertex=vertexWithMinimumDistance;

        }


        return vertexToDistanceFromSource;
    }

    //find vertex With Minimum Distance From Current Vertex That Isnt Selected Yet
    private static int getVertexWithMinimumDistance(int[][] adjMatrix, Set<Integer> selectedVertices, Set<Integer> allVertices, int currentVertex) {
        int vertexWithMinDistance = Integer.MAX_VALUE;
        int minDistance = Integer.MAX_VALUE;
        Set<Integer> unSelectedVertices = allVertices
                .stream()
                .filter(e -> !selectedVertices.contains(e))
                .collect(Collectors.toSet());
        for (Integer unSelectedDestinationVertex : unSelectedVertices) {
            if (adjMatrix[currentVertex][unSelectedDestinationVertex] < minDistance) {
                vertexWithMinDistance = unSelectedDestinationVertex;
                minDistance = adjMatrix[currentVertex][unSelectedDestinationVertex];
            }
        }
        return vertexWithMinDistance;
    }

}



