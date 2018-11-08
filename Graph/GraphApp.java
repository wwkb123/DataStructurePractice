package Graph;
import java.util.List;
import java.util.ArrayList;

public class GraphApp{


	public static void main(String[] args){

		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");

		Edge e0 = new Edge(v0, v1, "a", 1);  // 0 -> 1
		Edge e1 = new Edge(v1, v2, "b", 1);  // 1 -> 2
		Edge e2 = new Edge(v2, v0, "c", 1);  // 2 -> 0

		List<Vertex> vertices = new ArrayList<Vertex>();
		vertices.add(v0);
		vertices.add(v1);
		vertices.add(v2);

		List<Edge> edges = new ArrayList<Edge>();
		edges.add(e0);
		edges.add(e1);
		edges.add(e2);

		Graph g = new Graph(vertices, edges);
		g.printAll();


	}



}