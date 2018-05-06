package graph;
import java.util.List;
import java.util.Scanner;
public class Graph {
List<Vertex> vertices;
boolean directed;
Scanner scanner=new Scanner(System.in);
public void addEdge(){
	
	 
	System.out.println("enter source vertex data value");
	int source=scanner.nextInt();
	System.out.println("enter destination vertex data value");
	int destination=scanner.nextInt();
	
	Vertex destinationVertex=null;
	//find the source and destination vertices, from the list of vertices 
	//in adjecency list of source just add the destination vertex
	for(Vertex vertex: getVertices())
	{
		if(vertex.data==destination)
		{
			destinationVertex=vertex;
		}
	}
	for(Vertex vertex: getVertices())
	{
		if(vertex.data==source)
		{
			vertex.adjacencyList.add(destinationVertex);
		}
	}
}

public List<Vertex> getVertices() {
	return vertices;
}
public void setVertices(List<Vertex> vertices) {
	this.vertices = vertices;
}
public boolean isDirected() {
	return directed;
}
public void setDirected(boolean directed) {
	this.directed = directed;
}
public Graph() {
	super();
	// TODO Auto-generated constructor stub
}
public Graph(List<Vertex> vertices, boolean directed) {
	super();
	this.vertices = vertices;
	this.directed = directed;
}

}
