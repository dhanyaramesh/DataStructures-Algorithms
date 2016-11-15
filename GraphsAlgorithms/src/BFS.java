import java.util.ArrayList;

public class BFS {
	
	ArrayList<Node> visitedList = new ArrayList<Node>();
	public void bfsTraversal(Node node){
		
		
		System.out.println(node.name);
		node.visited=true;
		visitedList.add(node);
		while(!visitedList.isEmpty()){
			Node temp = visitedList.remove(0);
			
			for(int i=0;i<temp.neighbors.size();i++){
				if(temp.neighbors.get(i).visited==false){
					System.out.print("--" + temp.neighbors.get(i).name);
					temp.neighbors.get(i).visited=true;
					visitedList.add(temp.neighbors.get(i));
				}
				
				
			}
			
		}
		
	}

}
