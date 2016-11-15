
public class TreeAlgorithms {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Node root = new Node(10);
		
		Node inoderroot = root;
		Node preoderroot = root;
		Node postoderroot = root;
		Node ancestor = root;
		Node successor = root;
		
		BST bst = new BST(root);
		bst.insert(root,5);
		bst.insert(root,15);
		bst.insert(root,25);
		bst.insert(root,9);
		
		
		System.out.println("INORDER TRAVERSAL");
		bst.inorder(inoderroot);
		System.out.println("PREORDER TRAVERSAL");
		bst.preorder(preoderroot);
		System.out.println("POSTORDER TRAVERSAL");
		bst.postorder(postoderroot);
		System.out.println("ANCESTOR");
		Ancestor_Successor anc = new Ancestor_Successor();
		anc.printAncestor(ancestor, new Node(9));
		
		System.out.println("Successor");
		Ancestor_Successor suc = new Ancestor_Successor();
		suc.printSuccessor(successor, new Node(9));

	}

}
