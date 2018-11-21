package Graph;

import java.util.*;

public class AdjGraph{

	List<Vertex> vertices;
	Edge[][] edges;

	public AdjGraph(List<Vertex> vertices, Edge[][] edges){
		this.vertices = vertices;
		this.edges = edges;
	}

	public void printVertices(){
		for(Vertex v: vertices){
			System.out.println(v.getName());
		}
	}

	public void printEdges(){
		int size = vertices.size();
		for(int i = 0; i < size; i++){
			for(int j = 0; j < size; j++){
				System.out.print((edges[i][j] == null?"null":edges[i][j].getName()) + "\t");
			}
			System.out.println("");
		}
	}

	

}