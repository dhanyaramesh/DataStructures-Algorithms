package helloWorld;

import java.util.Arrays;

public class popele {
	public static int findPopular(int[] a) {

	    if (a == null || a.length == 0)
	        return 0;

	    Arrays.sort(a);

	    int previous = a[0];
	    int popular = a[0];
	    int count = 1;
	    int maxCount = 1;

	    for (int i = 1; i < a.length; i++) {
	        if (a[i] == previous)
	            count++;
	        else {
	            if (count >= maxCount) {
	                popular = a[i];
	                maxCount = count;
	            }
	            previous = a[i];
	            count = 1;
	        }
	    }
	   // return maxCount;
	    System.out.println(count + " " + maxCount);
	    //return count > maxCount ? a[a.length-1] : popular;
	    if(count>maxCount)
	    	return count;
	    else
	    	return maxCount;
	}
	//this is because count has the latest elements count, max count has the maximum count till previous 
	//element. That is y
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A={1,2,2,2,3,3,3,3,3,3,3,3,3,6,6,6,6,6,6,6};
		System.out.println(findPopular(A));

	}

}
