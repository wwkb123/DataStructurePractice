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

	public void insertEdge(int i, int j, Edge e){
		edges[i][j] = e;
	}

	public void insertVertex(Vertex v){

		Edge[][] newEdges = new Edge[vertices.size() + 1][vertices.size() + 1];

		//copy old elements to new matrix
		for(int i = 0; i < vertices.size(); i++){
			for(int j = 0; j < vertices.size(); j++){
				newEdges[i][j] = edges[i][j];
			}
		}

		edges = newEdges;
		vertices.add(v);
	}




}