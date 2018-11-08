package Graph;
import java.util.List;

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

}