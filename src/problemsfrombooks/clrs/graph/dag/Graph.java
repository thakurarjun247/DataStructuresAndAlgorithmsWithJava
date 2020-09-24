package problemsfrombooks.clrs.graph.dag;

import java.util.*;

class GraphApp {

    public static void main(String[] args) {

        List<Vertex> list = new ArrayList<>();
        for (int i = 0; (i) < 8; i++) {
            list.add(new Vertex(i ));
        }
        //list.forEach(System.out::println);
        Graph g = new Graph(list);
        g.addEdge(list.get(1),list.get(2));
        g.addEdge(list.get(1),list.get(3));
       // g.addEdge(list.get(2),list.get(3));
        g.addEdge(list.get(2),list.get(4));
        g.addEdge(list.get(2),list.get(5));
        g.addEdge(list.get(5),list.get(4));
        g.addEdge(list.get(3),list.get(6));
        g.addEdge(list.get(3),list.get(7));
        g.addEdge(list.get(4),list.get(3));
        //g.addEdge(list.get(1),list.get(0));
        g.unvisitAll();
        Stack<Vertex> result = g.topologicalSort(list);
        while(!result.isEmpty()){
            System.out.println(result.pop().key);
        }
    }
}

class Vertex {
    boolean visited;
    int key;
    List<Vertex> list;

    Vertex() {
    }

    Vertex(int key) {
        this.key = key;
        list=new ArrayList<>();
    }

}

public class Graph {
    List<Vertex> vertices;


    public Graph() {
    }

    public Graph(List<Vertex> vertices) {
        this.vertices = vertices;
    }

    void addEdge(Vertex sv, Vertex dv) {
        //Vertex sv = new Vertex(s);
       // Vertex dv = new Vertex(d);
        if (!sv.list.contains(dv))
            sv.list.add(dv);

    }

    //https://www.youtube.com/watch?v=ddTC4Zovtbc
    public Stack<Vertex> topologicalSort(List<Vertex> vertices) {
        Stack<Vertex> stack = new Stack<>();
        Set<Vertex> visited = new HashSet<>();
        for (Vertex vertex : vertices) {
            //if visited contains the vertex already do nothing else
            if (!visited.contains(vertex))
             topSortUtil(vertex,stack,visited);
        }
        return stack;
    }

    private void topSortUtil(Vertex vertex, Stack<Vertex> stack,
                             Set<Vertex> visited) {
        visited.add(vertex);
        for(Vertex childVertex : vertex.list){
            if(!visited.contains(childVertex))
            topSortUtil(childVertex,stack,visited);
        }
        //a vertex is put on stack only when it is
        //fully explored that is there are no children of it unexplored
        stack.push(vertex);
    }
    void unvisitAll() {
        vertices.forEach(vertex -> vertex.visited = false);
    }



}
