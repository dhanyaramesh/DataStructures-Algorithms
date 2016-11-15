import java.util.ArrayList;

public class Graphs {
	
	ArrayList<Node> nodes = new ArrayList<Node>();
	Node root;
	
	public void addNode(Node n){
		this.nodes.add(n);
		
	}
	
	public void addNeighbors(Node thisnode, Node neighbor){
		thisnode.addNeighbor(neighbor);
	}
	
	public void printGraph(){
		System.out.println("Printing Graph.... ");
		
		for(int i=0;i<nodes.size();i++){
			Node temp = nodes.get(i);
			System.out.println(temp.name);
			/*if(temp.visited == false){
				System.out.println(temp.name);
				*/
				for(int j=0;j<temp.neighbors.size();j++){
					Node temp1 = temp.neighbors.get(j);
					System.out.print("----" + temp1.name);
					temp1.visited=true;
				}
				temp.visited=true;
				System.out.println();
				
			//}
		}
		
	}

}
