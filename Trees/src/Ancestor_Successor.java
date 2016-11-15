
public class Ancestor_Successor {
	
	public boolean printAncestor(Node root, Node node){
		
		if(root == null){
			return false;
		}
		
		if(root.data == node.data){
		//	System.out.println(root.data );
			return true;
		}
		if(printAncestor(root.left,node) || printAncestor(root.right,node)){
			System.out.println(root.data);
			return true;
		}
			
		return false;
	}
	
	public boolean printSuccessor(Node root, Node node){
		
		if(root ==null)
			return false;
		
		if(root.left.data == node.data){
			System.out.println(root.data);
			return true;
		}	
		//if(root.data == node.data){
		else{
			if(root.right==null){
				root = root.right;
				while(root.left!=null){
					root=root.left;
				}
				System.out.println(root.data);
				return true;
			}
			else{
				System.out.println(root.right.data);
				return true;
			}
		}
		
		//return false;
	}
	

}
