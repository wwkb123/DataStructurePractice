package Graph;

public class Vertex{

	String name;
	boolean isVisited;

	public Vertex(String name){
		this.name = name;
		this.isVisited = false;
	}

	public String getName(){
		return name;
	}

	public boolean isVisited(){
		return isVisited;
	}

	public void reset(){
		isVisited = false;
	}

}