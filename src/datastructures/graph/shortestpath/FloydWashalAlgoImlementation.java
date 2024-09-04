package datastructures.graph.shortestpath;
//todo: see https://www.youtube.com/watch?v=oNI0rf2P9gE

public class FloydWashalAlgoImlementation {

    public static void main(String[] args) {
        FloydWashalAlgoImlementation algo = new FloydWashalAlgoImlementation();
        //todo: here in the test cases Integer.MAX_VALUE means no path between the nodes.
        // Test Case 1: Basic Test Case with 3 Nodes
        int[][] edges1 = {
                {0, 3, Integer.MAX_VALUE},
                {2, 0, 5},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        int[][] result1 = algo.calculatePath(edges1);
        int[][] expected1 = {
                {0, 3, 8},
                {2, 0, 5},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        printResult(result1, expected1, "Basic Test Case with 3 Nodes");

        // Test Case 2: Graph with Negative Weights
        int[][] edges2 = {
                {0, -1, Integer.MAX_VALUE},
                {2, 0, 3},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        int[][] result2 = algo.calculatePath(edges2);
        int[][] expected2 = {
                {0, -1, 2},
                {2, 0, 3},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        printResult(result2, expected2, "Graph with Negative Weights");

        // Test Case 3: Graph with Negative Weight Cycle
        int[][] edges3 = {
                {0, 1, Integer.MAX_VALUE},
                {-1, 0, -1},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        int[][] result3 = algo.calculatePath(edges3);
        // Output may vary based on how the algorithm handles negative cycles.
        System.out.println("Graph with Negative Weight Cycle");
        printMatrix(result3);

        // Test Case 4: Graph with No Edges
        int[][] edges4 = {
                {0, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        int[][] result4 = algo.calculatePath(edges4);
        int[][] expected4 = {
                {0, Integer.MAX_VALUE, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, 0, Integer.MAX_VALUE},
                {Integer.MAX_VALUE, Integer.MAX_VALUE, 0}
        };
        printResult(result4, expected4, "Graph with No Edges");

        // Test Case 5: Fully Connected Graph
        int[][] edges5 = {
                {0, 2, 9},
                {1, 0, 6},
                {Integer.MAX_VALUE, 3, 0}
        };
        int[][] result5 = algo.calculatePath(edges5);
        int[][] expected5 = {
                {0, 2, 8},
                {1, 0, 6},
                {4, 3, 0}
        };
        printResult(result5, expected5, "Fully Connected Graph");

        // Test Case 6: Single Node Graph
        int[][] edges6 = {
                {0}
        };
        int[][] result6 = algo.calculatePath(edges6);
        int[][] expected6 = {
                {0}
        };
        printResult(result6, expected6, "Single Node Graph");
    }

    // Utility method to print results
    private static void printResult(int[][] result, int[][] expected, String testCaseName) {
        System.out.println(testCaseName);
        System.out.println("Result:");
        printMatrix(result);
        System.out.println("Expected:");
        printMatrix(expected);
        System.out.println();
    }

    // Utility method to print matrix
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            for (int value : row) {
                if (value == Integer.MAX_VALUE) {
                    System.out.print("∞ ");
                } else {
                    System.out.print(value + " ");
                }
            }
            System.out.println();
        }
    }

    int[][] calculatePath(int[][] edges) {
        int V = edges.length;
        //for every vertex relax
        for (int currentVertex = 0; currentVertex < V; currentVertex++) {
            for (int r = 0; r < edges.length; r++) {
                //relax every row and column
                for (int c = 0; c < edges.length; c++) {
                    edges[r][c] = Math.min(edges[r][c], (edges[r][currentVertex] == Integer.MAX_VALUE || edges[currentVertex][c] == Integer.MAX_VALUE) ? Integer.MAX_VALUE : edges[r][currentVertex] + edges[currentVertex][c]);
                }
            }
        }
        return edges;
    }


}
