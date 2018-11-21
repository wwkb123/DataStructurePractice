package Graph;
import java.util.*;

public class GraphApp{


	public static void main(String[] args){

		Vertex a = new Vertex("a");
		Vertex b = new Vertex("b");
		Vertex c = new Vertex("c");
		Vertex d = new Vertex("d");

		Edge e0 = new Edge(a, b, "AB", 1);  // 0 -> 1
		Edge e1 = new Edge(a, c, "AC", 1);  // 1 -> 2
		Edge e2 = new Edge(a, d, "AD", 1);  // 2 -> 0

		List<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(a);
		vertices.add(b);
		vertices.add(c);
		vertices.add(d);

		List<Edge> edges = new ArrayList<Edge>();
		edges.add(e0);
		edges.add(e1);
		edges.add(e2);

		Graph g = new Graph(vertices, edges);
	

		g.insertVertex(new Vertex("E"));

		g.insertEdge(b,d,"BD",1);

		g.printVertices();
		g.printEdges();

		Edge e = g.getEdge(a,b);
		if(e != null){
			System.out.println("The edge is "+e.getName());
		}

	}



}