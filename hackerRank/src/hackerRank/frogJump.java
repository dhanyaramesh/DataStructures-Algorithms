package hackerRank;

import java.util.Set;
import java.util.TreeSet;

public class frogJump {
	
	public static int func(int[] A, int D){
		/* boolean[] jumpable = new boolean[A.length];
	        int total = D;
	        for(int i=0;i<A.length;i++){ 
	        	System.out.println("i and A[i]" + i + "  "+ A[i]);
	        	if(A[i]<0)
	        		total--;
	            if(A[i]>=0 && jumpable[A[i]] == false){
	            	System.out.println("jumpable[A[i]]" +jumpable[A[i]]);
	                jumpable[A[i]] = true;
	                System.out.println("changed jumpable[A[i]]" +jumpable[A[i]]);
	                total-=1;
	                System.out.println("total" + total);
	                if(total==0) 
	                    return i;
	            }
	        }
	         
	         return -1;  */
		
	    int steps=-1;
	    Set<Integer> values = new TreeSet<Integer>();
	    for(int i=0; i<A.length;i++){
	        if(A[i]<=D){
	            values.add(A[i]);
	        }
	        if(values.size()==D){
	            steps=i;
	            break;
	        }
	    }
	        return steps;
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,-1,0,2,3,5};
		//int[] A = {1,3,1,4,2,3,5,4};
		int D = 3;
		System.out.println(func(A,D));
		

	}

}
