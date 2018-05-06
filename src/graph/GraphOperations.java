package graph;

import java.util.*;

public class GraphOperations {
    Scanner scanner = new Scanner(System.in);

    public void displayChoice() {
        System.out.println();
        System.out.println("==========choice menu==========");
        System.out.println("-1: show choice menu ");
        System.out.println(" 0: create graph ");
        System.out.println(" 1: add edge ");
        System.out.println(" 2: traverse BFS ");
        System.out.println(" 3: traverse DFS ");
        System.out.println(" 4: add a vertex  ");
        System.out.println(" 5: print all vertices ");

        System.out.println("===============================");
        System.out.println();

    }

    public Graph createGraph() {
        System.out.println("enter the number of vertices in the graph");
        int number = scanner.nextInt();
        List<Vertex> vertices = new ArrayList<>();
        for (int i = 0; i < number; i++) {
            System.out.println("enter data value for vertex number " + i);
            int data = scanner.nextInt();
            vertices.add(new Vertex(data));
        }
        Graph graph = new Graph(vertices, false);
        return graph;
    }

    public void bfs(Vertex start, Graph graph) {
        // mark all as unvisited otherwise when u will rerun it all the nodes
        // will be previsited
        graph.getVertices().forEach(
                vertex -> vertex.setVisitStatus(VisitStatus.UNVISITED));

        LinkedList<Vertex> queue = new LinkedList<>();
        queue.add(start);
        while (!queue.isEmpty()) {
            Vertex current = queue.removeFirst();
            // use poll() becuase it will give us null, removefirst will throw exceptin
            //if q is empty
            if (current.visitStatus.equals(VisitStatus.UNVISITED)) {
                current.visitStatus = VisitStatus.VISITED;
                System.out.print("v" + current.data + "  ");
            }
            queue.addAll(current.getAdjacencyList());
        }

    }


    public void dfs(Vertex start, Graph graph) {

        // dont mark them all unvisited else there will be problem with recursive call staack
        //graph.getVertices().forEach(vertex -> vertex.setVisitStatus(VisitStatus.UNVISITED));
        Stack<Vertex> stack = new Stack<Vertex>();

        //stack.push(start);
        if (start.visitStatus.equals(VisitStatus.UNVISITED)) {
            start.setVisitStatus(VisitStatus.VISITED);
            System.out.print("  v" + start.data);
        }
        if (start.getAdjacencyList().size() != 0) {
            for (int i = 0; i < start.getAdjacencyList().size(); i++) {
                stack.push(start.getAdjacencyList().get(i));
                while (!stack.empty()) {
                    dfs(stack.pop(), graph);
                    //although pop throws exception if stack is empty but
                    //it won't in this caseas did empty check beforehand
                }
            }
        }


    }
}
