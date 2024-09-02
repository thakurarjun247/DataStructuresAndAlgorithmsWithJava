package datastructuresandalgorithms.problemsfrombooks.clrs.graph.standard;

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
        g.addEdge(list.get(2),list.get(3));
        g.addEdge(list.get(2),list.get(4));
        g.addEdge(list.get(2),list.get(5));
        g.addEdge(list.get(3),list.get(6));
        g.addEdge(list.get(3),list.get(7));
        g.addEdge(list.get(1),list.get(0));
        g.unvisitAll();
        System.out.println("bfs null");
       // g.bfs(null);
        g.unvisitAll();
        System.out.println("dfs null");
       // g.dfsWithStack(null);

        g.unvisitAll();
        //g.bfs(list.get(1));
        g.unvisitAll();
        g.dfsWithStack(list.get(1));
        g.unvisitAll();
        g.dfs(list.get(1));

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
/*
    @Override
    public int hashCode() {
        Integer x = key;
        return x.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        Vertex o = (Vertex) obj;
        return this.key == o.key;
    }

    @Override
    public String toString(){
        return Integer.toString(key)+list;
    }
    */
}

public class Graph {
    List<Vertex> vertices;

    void addEdge(Vertex sv, Vertex dv) {
        //Vertex sv = new Vertex(s);
       // Vertex dv = new Vertex(d);
        if (!sv.list.contains(dv))
            sv.list.add(dv);
        if (!dv.list.contains(sv))
            dv.list.add(sv);
    }

    void unvisitAll() {
        vertices.forEach(vertex -> vertex.visited = false);
    }

    void dfs(Vertex s) {
        if(s!=null && !s.visited){
            System.out.print(" " + s.key+ " ");
            s.visited=true;
            s.list.forEach(this::dfs);

        }
    }

    void dfsWithStack(Vertex s) {
        Stack<Vertex> stack = new Stack<>();
        stack.add(s);
        while (!stack.isEmpty()) {
            Vertex v = stack.pop();
            if (v!=null && !v.visited) {
                System.out.print(v.key);
                v.visited=true;
                v.list.forEach(item -> stack.push(item));
            }
        }
    }

    void bfs(Vertex s) {

        Queue<Vertex> q = new LinkedList<>();
        q.add(s);
        while (!q.isEmpty()) {
            Vertex v = q.poll();
                if (v!=null && !v.visited) {
                    System.out.print(v.key);
                    v.visited=true;
                    v.list.forEach(item -> q.add(item));
                }
        }
    }

    public Graph() {
    }

    public Graph(List<Vertex> vertices) {
        this.vertices = vertices;
    }

}
