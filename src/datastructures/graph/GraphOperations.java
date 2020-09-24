package datastructures.graph;

import java.util.*;

public class GraphOperations {
    Scanner scanner = new Scanner(System.in);

    public void displayChoice() {
        System.out.println();
        System.out.println("==========choice menu==========");
        System.out.println("-1: show choice menu ");
        System.out.println(" 0: create datastructures.graph ");
        System.out.println(" 1: add edge ");
        System.out.println(" 2: traverse BFS ");
        System.out.println(" 6: dfs recursive ");
        System.out.println(" 3: dfs with stack ");
        System.out.println(" 7: dfsNew with stack ");
        System.out.println(" 4: add a vertex  ");
        System.out.println(" 5: print all vertices ");


        System.out.println("===============================");
        System.out.println();

    }

    public Graph createGraph() {
        System.out.println("enter the number of vertices in the datastructures.graph");
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

    public void dfsRecursive(Vertex v, Graph graph) {
        if (v == null || graph == null) return;
        if (v.visitStatus == VisitStatus.UNVISITED) {
            System.out.println(v);
            v.visitStatus = VisitStatus.VISITED;
        }
        for (Vertex item : v.getAdjacencyList()) {
            dfsRecursive(item, graph);
        }
    }

    public void dfs(Vertex start, Graph graph) {

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

    public void dfsNewWithStack(Vertex start, Graph graph) {
        //TODO: although correct, it traverses right child before left
        //that's because we first push then visit. we should do it
        //the other way around as in dfs() method above
        if (start == null || graph == null) return;
        Stack<Vertex> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Vertex item = stack.pop();
            if (item.visitStatus == VisitStatus.UNVISITED) {
                System.out.println(item);
                item.visitStatus = VisitStatus.VISITED;
                for (Vertex adj : item.adjacencyList) {
                    stack.push(adj);
                }
            }

        }
    }
}
