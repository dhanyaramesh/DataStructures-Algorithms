
public class GraphCreation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node n1 = new Node("dhanya");
		Node n2 = new Node ("pratiba");
		Node n3 = new Node ("Ramesh");
		
		Graphs g = new Graphs();
		g.addNode(n1);
		g.addNode(n2);
		g.addNode(n3);
		
		g.addNeighbors(n1, n2);
		g.addNeighbors(n2, n3);
		g.addNeighbors(n3, n1);
		
		Node n4 = new Node("abc");
		Node n5 = new Node("bcd");
		Node n6 = new Node("def");
	
		
		g.addNeighbors(n3, n4);
		g.addNeighbors(n3, n5);
		g.addNeighbors(n3, n6);
		
		//g.printGraph();
		
		System.out.println("BFS traversal");
		
		/*DFS dfs = new DFS();
		dfs.dfsTraversal(n3);*/
		
		BFS bfs = new BFS();
		bfs.bfsTraversal(n3);
		
		

	}

}
