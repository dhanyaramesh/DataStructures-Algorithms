import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class firstRepeatedElement {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Integer[] A = {1,2,5,7,5,3,10,2};
		//HashMap<Integer,Integer> hm = new HashMap<Integer,Integer>();
		List<Integer> al = new ArrayList<Integer>(Arrays.asList(A));
		System.out.println(al);
		for(int i=0;i<A.length;i++){
			if(al.indexOf(A[i])!=al.lastIndexOf(A[i])){
				System.out.println("index "+ i + " val "+A[i]);
				return;
			}
		}
		
	}

}
