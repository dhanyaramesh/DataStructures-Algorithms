import java.util.ArrayList;

public class DFS {
	
	/*class GraphStack{
		ArrayList<String> stack = new ArrayList<String>();
		int top=-1;
		
		public void push(String name){
			stack.add(name);
			top++;
		}
		public String pop(){
			return(stack.get(top--));
		}
		
	}

	GraphStack gs = new DFS.GraphStack();*/
	
	ArrayList<Node> visitedList = new ArrayList<Node>();
	
	public  void dfsTraversal(Node node){
		
			if(!visitedList.contains(node))
				visitedList.add(node);
			node.visited=true;
			System.out.println(node.name);

			for(int j=0;j<node.neighbors.size();j++){
				Node temp = node.neighbors.get(j);
				//System.out.print("neighbors" + temp.name + "status" + temp.visited);
				if(temp.visited==false){
					dfsTraversal(node.neighbors.get(j));
				}
				
			}
		/*	
			for(int i=0;i<visitedList.size();i++){
				System.out.println(visitedList.get(i).name);
			}
			*/
			
			
			
		
	}

}
