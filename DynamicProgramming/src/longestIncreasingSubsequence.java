import java.util.ArrayList;

public class longestIncreasingSubsequence {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] A = {1,12,7,0,23,11,52,31,61,69,70,2};
		int[] ls = new int[A.length];
		
		
		for(int i=0;i<A.length;i++){
			int max=-1;
			for(int j=0;j<i;j++){
				if(A[i]>A[j]){
					if(max==-1 || max < ls[j]+1)
						max = ls[j]+1;
				}
				
			}
			
			if(max==-1){
				max=1;
			}
			ls[i]=max;
		}
		
		for(int k=0;k<ls.length;k++)
			System.out.print(ls[k]);
		
		
		

	}

}
