package sorting;

public class selectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {5,4,2,3,6,1};
		int n = A.length;
		int count=0;
		for(int i=0;i<n-1;i++){
			int imin=i;
			for(int j=i+1;j<n;j++){
				count++;
				if(A[j]<A[imin]){
					imin=j;
				}
			}
			int temp = A[i];
			A[i]=A[imin];
			A[imin]=temp;
		}
		
		for(int j=0;j<n;j++){
			System.out.println(A[j]);
		}
		System.out.println("count "+count);
		

	}

}
