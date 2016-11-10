package sorting;

public class bubbleSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {5,4,2,3,6,1};
		int n= A.length;
		int count=0;
		for(int k=1;k<n;k++){
			for(int i =0;i<n-1;i++){
				count++;
				if(A[i]>A[i+1]){
					int temp = A[i];
					A[i] = A[i+1];
					A[i+1] = temp;
				}
			}
		}
		
		for(int j=0;j<n;j++){
			System.out.println(A[j]);
		}
		System.out.println("count "+count);
		
		//oprimised
		count=0;
		for(int k=1;k<n;k++){
			int flag=0;
			for(int i =0;i<n-k-1;i++){
				count++;
				if(A[i]>A[i+1]){
					int temp = A[i];
					A[i] = A[i+1];
					A[i+1] = temp;
					flag=1;
				}
			}
			if(flag==0)
				break;
		}
		System.out.println("optimized");
		for(int j=0;j<n;j++){
			System.out.println(A[j]);
		}
		System.out.println("count "+count);
		
	}

}
