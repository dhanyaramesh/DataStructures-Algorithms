package hackerRank;

public class reverseLLAndAddTwoLL {
	
	public static class Node{
		int data;
		Node next;
		Node(int data){
			this.data = data;
			this.next=null;		
		}
		
	   public static Node insert(Node head,int d){
		   Node oldhead = head;
		   if(head==null){
			   head = new Node(d);
			   return head;
		   }
		   while(head.next!=null){
			   head=head.next;
		   }
		   Node newNode = new Node(d);
		   head.next =newNode;
		   return oldhead;
		   
	   }
	   
	   public static Node reverse(Node head){
		   //Node oldhead = head;
		   Node temp = null;
		  // Node current = head;
		   Node nextnode;
		   while(head!=null){
			   nextnode = head.next;
			   head.next= temp;
			   temp = head;
			   head=nextnode;	   
			   
		   }
		   
		   return temp;
	   }
	   
	   public static void add(Node h1, Node h2){
		   Node h = null;
		   Node oh = null;
		   int val,carry=0;
		   while(h1!=null && h2!=null){
			   val = (h1.data + h2.data+carry)%10;
			   carry = (h1.data + h2.data)/10;
			 //  System.out.println("val " + val + "carry " + carry);
			   if(h==null){
				   h=new Node(val);
				   oh=h;
			   }
			   else{
				   h.next = new Node(val);
				   h=h.next;
			   }
			   
			   h1=h1.next;
			   h2=h2.next;
			   
		   }
		   
		   while(h1!=null){
			   
			  // System.out.println("here h1");
			   h.next = new Node(h1.data + carry);
			   h1=h1.next;
			   h=h.next;
			   carry=0;
			   
		   }
		   while(h2!=null){
			 //  System.out.println("here h2");
			   h.next = new Node(h2.data + carry);
			   h2=h2.next;
			   h=h.next;
			   carry=0;
		
		   }
		   while(oh!=null){
		    	  System.out.println(oh.data);
		    	  oh=oh.next;
		      }
		   
		   
	   }
	   
	   public static Node reversePairs(Node head,int k){
		   Node current = head;
	       Node next = null;
	       Node prev = null;
	        
	       int count = 0;
	 
	       /* Reverse first k nodes of linked list */
	       while (count < k && current != null) 
	       {
	           next = current.next;
	           current.next = prev;
	           prev = current;
	           current = next;
	           count++;
	       }
	 
	       /* next is now a pointer to (k+1)th node 
	          Recursively call for the list starting from current.
	          And make rest of the list as next of first node */
	       if (next != null) 
	          head.next = reversePairs(next, k);
	 
	       // prev is now head of input list
	       return prev;
	   }
	   
	   
	}

	public static void main(String[] args) {
      
      Node h = new Node(9);
      h = h.insert(h,2);
      h = h.insert(h,3);
      h = h.insert(h,5);
      h = h.insert(h,3);
      
      Node h2 = new Node(9);
      h2=h2.insert(h2, 3);
      
    //  Node.add(h, h2);
    /*  while(h!=null){
    	  System.out.print(h.data);
    	  h=h.next;
      }*/
      System.out.println("reverse in pairs");
      Node x = Node.reversePairs(h,2);
      
      
      //h=h.reverse(h);
      
      while(x!=null){
    	  System.out.println(x.data);
    	  x=x.next;
      }
      
      
      

	}

}
