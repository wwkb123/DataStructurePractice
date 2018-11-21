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

	public Edge getEdge(Vertex u, Vertex v){
		for(Edge e: edges){
			if(e.from == u && e.to == v){
				return e;
			}
		}
		return null;  //not found
	}

	public void insertVertex(Vertex v){
		vertices.add(v);
	}

	public void insertEdge(Vertex u, Vertex v, String data, int weight){
		Edge e = new Edge(u,v,data,weight);
		edges.add(e);
	}

	public void removeVertex(Vertex v){
		vertices.remove(v);
		ListIterator<Edge> iterator = edges.listIterator();  // to prevent ConcurrentModificationException
		while(iterator.hasNext()){
			Edge e = iterator.next();
			if(e.from == v || e.to == v){
				iterator.remove();
			}
		}
	}

	public void removeEdge(Edge e){
		edges.remove(e);
	}

	public Collection<Edge> incomingEdges(Vertex v){
		Set<Edge> s = new HashSet<Edge>();
		for(Edge e : edges){
			if(e.to == v) s.add(e);
		}
		return s;
	}

	public Collection<Edge> outgoingEdges(Vertex v){
		Set<Edge> s = new HashSet<Edge>();
		for(Edge e : edges){
			if(e.from == v) s.add(e);
		}
		return s;
	}

	public int outDegree(Vertex v){
		int count = 0;
		for(Edge e : edges){
			if(e.from == v){
				count++;
			}
		}
		return count;
	}

	public int inDegree(Vertex v){
		int count = 0;
		for(Edge e : edges){
			if(e.to == v){
				count++;
			}
		}
		return count;
	}

	public boolean isReachable(Vertex u, Vertex v){
		return false;
	}

	public void printAllPaths(Vertex u, Vertex v){

	}

	//check whether two vertices are conntect
	public boolean isConnected(Vertex u, Vertex v){
		for(Edge e : edges){
			if((e.from == u && e.to == v) || (e.from == v && e.to == u)){
				return true;
			}
		}
		return false; //not found
	}

	//check whether this graph is a connected graph
	public boolean isConnectedGraph(){
		for(Vertex u : vertices){
			System.out.print(u.getName()+" ");
			for(Vertex v : vertices){
				
				if(u != v){ //for simple graph
					System.out.print(v.getName()+" ");
					if(!isConnected(u,v)){
						return false;
					}
				}
			}
		}
		return true;
	}

	public void breadthFirstPrint(Vertex v){
		/*
		Queue<Vertex> q = new LinkedList<Vertex>();
		q.add(v);
		
		while(q.size() > 1){
			Collection<Edge> outgoingEdges = outgoingEdges(v);
			Vertex u = q.remove();
			System.out.println(u.name);
			q.add();
			
		}
		

*/

	}

	public void depthFirstPrint(Vertex v){
		depthFirstPrintRecursive(v);
		for(Vertex vertex : vertices){
			vertex.reset();
		}
		System.out.println("");
	}
	public void depthFirstPrintRecursive(Vertex v){
		System.out.print(v.getName() + " ");
		v.isVisited = true;
		for(Edge e : outgoingEdges(v)){
			Vertex u = e.to;
			if(!u.isVisited){
				depthFirstPrintRecursive(u);
			}
		}
	}

	//return a collection of vertices in the graph that has the same in-Degree as its own out-Degree
	public Collection<Vertex> sameDegreeVertices(){
		Set<Vertex> s = new HashSet<Vertex>();
		for(Vertex v : vertices){
			if(inDegree(v) == outDegree(v)) s.add(v);
		}
		return s;
	}

}