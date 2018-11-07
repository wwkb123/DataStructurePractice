public class Edge{

	String name;
	int weight;
	Vertex from;
	Vertex to;

	public Edge(Vertex from, Vertex to, String name, int weight){
		this.from = from;
		this.to = to;
		this.name = name;
		this.weight = weight;
	}

}