package graph;

import java.util.Scanner;

public class GraphApp {

    public static void main(String[] args) {
        Graph graph = new Graph();
        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        GraphOperations graphOperations = new GraphOperations();
        for (int i = 0; i < 100; i++) {
            if (i == 0) {
                graphOperations.displayChoice();
            } else {
                System.out.println();
                System.out.println("----------------------------");
            }
            //graphOperations.displayChoice();
            choice = scanner.nextInt();
            switch (choice) {
                case -1:
                    graphOperations.displayChoice();
                    break;
                case 0:
                    graph = graphOperations.createGraph();
                    break;
                case 1:
                    System.out.println("adding edge... ");
                    graph.addEdge();

                    break;
                case 2:
                    System.out.println("bfs...");
                    graphOperations.bfs(graph.getVertices().get(0), graph);
                    break;
                case 3:
                    System.out.println("dfs...");
                    graph.getVertices().forEach(vertex -> vertex.setVisitStatus(VisitStatus.UNVISITED));
                    graphOperations.dfs(graph.getVertices().get(0), graph);
                    break;
                case 5:
                    graph.getVertices().forEach(
                            vertex -> System.out.println(vertex.data + " "));
                default:
                    break;
            }
            // sample graph
            /*                     0
			 *
			 * 				1				2
			 * 			3		4	  	5		6
			 * 
			 * 							7
			 * 						
			 * dfs = 0 1 3 4 2 5 7 6 
			 * bfs=  0 1 2 3 4 5 6 7
			 * 
			 * 
			 * 
			 * 
			 */

        }

    }

}
