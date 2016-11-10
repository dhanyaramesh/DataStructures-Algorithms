package hackerRank;

public class htOfbst {
	int data;
	htOfbst left;
	htOfbst right;
	
	htOfbst(int value){
		data = value;
		left = null;
		right = null;
	}
	
	public static void print_inorder(htOfbst head){
		if(head==null)
			return ;
			print_inorder(head.left);
			System.out.println(head.data);
			print_inorder(head.right);
		
	}
	
//	static htOfbst getnode(int value){
//		htOfbst newnode = null;
//        newnode.data = value;
//        newnode.left=null;
//        newnode.right=null;
//    System.out.println("creating" + newnode.data);
//    return newnode;
//}

     static htOfbst Insert(htOfbst root,int value)
    {  
    	 if(root == null)
         {
         	System.out.println("in null");
            root = new htOfbst(value);
           // System.out.println(root.data);
            
             return root;
         }
    	
        //System.out.println(root.data + "  " + value);
       
        else{
            if(value <= root.data){
                System.out.println("less");
                root = root.left;
                root = Insert(root,value);
            }    
            else{
                System.out.println("right");
                root=root.right;
                root = Insert(root,value);
            }
                
        }
       // System.out.println(root.data + "final");
   
        return root;
      
 }

	
	public static void main(String[] args) {
		htOfbst tree = null;
		htOfbst h = null;
		tree = Insert(tree,11);
		print_inorder(h);
		tree = Insert(tree,12);
		print_inorder(h);
		h = Insert(tree,10);
		print_inorder(h);
		//h.Insert(12);
		//print_inorder(h);
//		Insert(h, 10);
//		h.print_inorder(h);
		//h.insert(h, 15);
		
		//h.print_inorder(h);
		
	}
	

}
