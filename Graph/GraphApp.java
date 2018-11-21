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

		/*

		Graph overview:

			A -- B
			| \  |
			|  \ |
			C    D

		*/
	

		//g.insertVertex(new Vertex("E"));

		g.insertEdge(b,d,"BD",1);

		g.printVertices();
		//g.removeVertex(d);
		g.printEdges();

		System.out.println("");

		Edge myEdge = g.getEdge(a,b);
		if(myEdge != null){
			System.out.println("The edge is "+myEdge.getName());
		}

		System.out.println("");

		for(Edge e: g.outgoingEdges(a)){
			System.out.println("The outgoing edge is "+e.getName());
		}

		System.out.println("");

		for(Edge e: g.incomingEdges(d)){
			System.out.println("The incoming edge is "+e.getName());
		}

		System.out.println("");

		System.out.println("Are A B connected? " + g.isConnected(a,b));
		System.out.println("Are C D connected? " + g.isConnected(c,d));

		System.out.println("");

		System.out.println("The indegree of D is "+g.inDegree(d));
		System.out.println("The outdegree of A is "+g.outDegree(a));

		System.out.println("");

		for(Vertex v : g.sameDegreeVertices()){
			System.out.println(v.getName() + " in: "+g.inDegree(v)+" out: "+g.outDegree(v));
		}

		System.out.println("");

		//System.out.println("Is this graph a connected graph? " + g.isConnectedGraph());
		System.out.println("Is D reachable to A? " + g.isReachable(a,d));

		System.out.println("");

		g.depthFirstPrint(a);

		g.breadthFirstPrint(a);

		System.out.println("\n\n=============Adjecency Matrix=============\n\n");

		List<Vertex> adjVertices = new ArrayList<Vertex>();
		adjVertices.add(a);
		adjVertices.add(b);
		adjVertices.add(c);
		adjVertices.add(d);

		Edge[][] adjEdges = new Edge[adjVertices.size()][adjVertices.size()];
		adjEdges[0][1] = new Edge(a, b, "AB", 1);
		adjEdges[0][2] = new Edge(a, c, "AC", 1);  
		adjEdges[0][3] = new Edge(a, d, "AD", 1);  
		

		AdjGraph adjGraph = new AdjGraph(adjVertices,adjEdges);
		adjGraph.insertEdge(adjVertices.indexOf(b),adjVertices.indexOf(d), new Edge(b, d, "BD", 1));

		adjGraph.printEdges();

		adjGraph.insertVertex(new Vertex("E"));

		adjGraph.printVertices();



	}



}