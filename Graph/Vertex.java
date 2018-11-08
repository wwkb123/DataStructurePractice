package Graph;

public class Vertex{

	String name;
	boolean isVisted;

	public Vertex(String name){
		this.name = name;
		this.isVisted = false;
	}

	public String getName(){
		return name;
	}

	public boolean isVisted(){
		return isVisted;
	}

}