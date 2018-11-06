public class GraphApp{


	public static void main(String[] args){

		Vertex v0 = new Vertex("0");
		Vertex v1 = new Vertex("1");
		Vertex v2 = new Vertex("2");

		Edge e0 = new Edge(v0, v1, "a");  // 0 -> 1
		Edge e1 = new Edge(v1, v2, "b");  // 1 -> 2
		Edge e2 = new Edge(v2, v0, "c");  // 2 -> 0

		List vertices = {v0, v1, v2};
		List edges = {e0, e1, e2};

		Graph g = new Graph(vertices, edges);


	}



}