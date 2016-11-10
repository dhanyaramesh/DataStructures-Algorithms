package sorting;

public class insertion_sort {
	//if current card less than the one in had, put it in front (creating holes)
	static void insertionSort(int[] a, int n){
		for(int i=1;i<n;i++){
			int val = a[i];
			int index = i;
			while(index > 0 && a[index-1]>val){
				a[index] = a[index-1];
				index=index-1;
			}
			a[index]=val;
		}
		for(int i=0;i<n;i++){
		System.out.println(a[i] + " ");
		}
	}
	
	static void SelectionSort(int[] a, int n){
		// at each time, bring min element to the front
		for(int i=0;i<n-1;i++){
			int tempi=i;
			for(int j=i+1;j<n;j++){
				if(a[j]<a[tempi]){
					tempi=j;
				}
			}
			
			int temp = a[i];
			a[i]=a[tempi];
			a[tempi]=temp;
		}
		
		
		for(int i=0;i<n;i++){
			System.out.println(a[i] + " ");
			}
	
	}
	
	static void BubbleSort(int[] a, int n){
		// compare current ele with next ele and swap, this pushes largest element to the last
		
		for(int i=1;i<n;i++){
			for(int j=0;j<n-1;j++){
				if(a[j]>a[j+1]){
					int temp=a[j];
					a[j]=a[j+1];
					a[j+1]=temp;
				}
			}
		}
		for(int i=0;i<n;i++){
			System.out.println(a[i] + " ");
			}
	}
	
	
	
	public static void main(String args[]){
		int a[] = {5,4,2,3,6,1};
		BubbleSort(a,a.length);
	}

}
