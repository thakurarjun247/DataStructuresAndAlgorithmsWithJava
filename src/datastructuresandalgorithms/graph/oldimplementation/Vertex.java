package datastructuresandalgorithms.graph.oldimplementation;

import java.util.LinkedList;
import java.util.List;

public class Vertex {
    public int data;
    public VisitStatus visitStatus;
    List<Vertex> adjacencyList;

    public int getData() {
        return data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public VisitStatus getVisitStatus() {
        return visitStatus;
    }

    public void setVisitStatus(VisitStatus visitStatus) {
        this.visitStatus = visitStatus;
    }

    public List<Vertex> getAdjacencyList() {
        return adjacencyList;
    }

    public void setAdjacencyList(List<Vertex> adjacencyList) {
        this.adjacencyList = adjacencyList;
    }

    public Vertex() {
        super();
        // TODO Auto-generated constructor stub
    }

    public Vertex(int data) {
        super();
        this.data = data;
        this.adjacencyList = new LinkedList<Vertex>();
        this.visitStatus = VisitStatus.UNVISITED;
    }

    @Override
    public String toString() {
        // TODO Auto-generated method stub
        return "v" + data;
    }
}
