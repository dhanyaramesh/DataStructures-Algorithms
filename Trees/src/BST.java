
public class BST {

	Node root;

	BST(Node r){
		root =r;
	}

	public Node insert(Node r,int d){
		root=r;
		Node newNode = new Node(d);
		if(root == null){
			root = newNode;
			//return root;
		}
		else{
			if(d<=root.data){
				if(root.left==null){
					root.left = new Node(d);
					//return;
				}
				else{
					root.left = insert(root.left,d);
				}

			}
			else{
				if(root.right==null){
					root.right = new Node(d);
					//return;
				}
				else{
					root.right = insert(root.right,d);
				}
			}
		}
		return root;
		//System.out.println("inserting "+d);
	}

	public void inorder(Node root){

		if(root!=null){

			inorder(root.left);
			System.out.println(root.data);
			inorder(root.right);
		}

	}


	public void preorder(Node root){

		if(root!=null){
			System.out.println(root.data);
			inorder(root.left);
			inorder(root.right);
		}

	}
	public void postorder(Node root){

		if(root!=null){

			inorder(root.left);
			inorder(root.right);
			System.out.println(root.data);
		}

	}
}
