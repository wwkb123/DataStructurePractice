package Graph;

import java.util.*;

public class Graph{

	List<Vertex> vertices;
	List<Edge> edges;

	public Graph(List<Vertex> vertices, List<Edge> edges){
		this.vertices = vertices;
		this.edges = edges;
	}

	public void printVertices(){
		for(Vertex v: vertices){
			System.out.println(v.getName());
		}
	}

	public void printEdges(){
		for(Edge e: edges){
			System.out.println(e.getName());
		}
	}

	public void insertVertex(Vertex v){
		vertices.add(v);
	}

	public void insertEdge(Vertex u, Vertex v, String data){
		Edge e = new Edge(u,v,data,1);
		edges.add(e);
	}

	public Vertex removeVertex(Vertex v){
		return vertices.remove(v);
	}

	public Edge removeEdge(Edge e){
		return edges.remove();
	}

	public Collection<Edge> incomingEdges(Vertex v){
		return null;
	}

	public Collection<Edge> outgoingEdges(Vertex v){
		Set<Edge> s = new HashSet<Edge>();
		for(Edge e : edges){
			if(e.from == v) s.add(e);
		}
		return s;
	}

	public void breadthFirstPrint(Vertex v){
		
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(v);
		
		while(q.size() > 1){
			Collection<Edge> outgoingEdges = outgoingEdges(v);
			Vertex u = q.remove();
			System.out.println(u.name);
			q.add();
			
		}
		



	}

}