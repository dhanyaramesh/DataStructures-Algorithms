package hackerRank;

public class mergeTwoArrays {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] array1={1,3,5};
		int[] array2={2,4,8};
		int[] mergedArray = new int[array1.length+array2.length];
		
		int i=0;
		int j=0;
		int k=0;
		
		while(i<array1.length && j< array2.length){
			if(array1[i]<array2[j]){
				mergedArray[k]=array1[i];
				i++;
				k++;
			}
			else{
				mergedArray[k]=array2[j];
				j++;
				k++;
			}
		}
		
		while(i<array1.length){
			mergedArray[k]=array1[i];
			i++;
			k++;
		}
		while(j<array2.length){
			mergedArray[k]=array2[j];
			j++;
			k++;
		}
		for(int z=0;z<mergedArray.length;z++)
		System.out.println(mergedArray[z]);

	}

}
