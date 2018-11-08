package Graph;

import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Collection;

public class Graph{

	List<Vertex> vertices;
	List<Edge> edges;

	public Graph(List<Vertex> vertices, List<Edge> edges){
		this.vertices = vertices;
		this.edges = edges;
	}

	public void printAll(){
		for(Vertex v: vertices){
			System.out.println(v.getName());
		}
	}

	public void insertVertex(Vertex v){

	}

	public void insertEdge(Vertex u, Vertex v, String data){

	}

	public void removeVertex(Vertex v){

	}

	public void removeEdge(Edge e){

	}

	public Collection<Edge> incomingEdges(Vertex v){
		return null;
	}

	public Collection<Edge> outgoingEdges(Vertex v){
		return null;
	}

	public void breadthFirstPrint(){
		Queue<Vertex> q = new LinkedList<Vertex>();


	}

}