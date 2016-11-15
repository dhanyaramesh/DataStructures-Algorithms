import java.util.ArrayList;

public class Node {
	String name;
	boolean visited;
	ArrayList<Node> neighbors = new ArrayList<Node>();
	
	Node(String name){
		this.name= name;
	}
	
	public void addNeighbor(Node neighbor){
		this.neighbors.add(neighbor);
	}

}
