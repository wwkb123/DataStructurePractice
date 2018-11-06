public class Edge{

	String name;
	Vertex from;
	Vertex to;

	public Edge(Vertex from, Vertex to, String name){
		this.from = from;
		this.to = to;
		this.name = name;
	}

}