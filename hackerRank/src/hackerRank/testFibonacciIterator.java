package hackerRank;

import java.util.ArrayList;
import java.util.List;

public class testFibonacciIterator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> items = new ArrayList<String>();
		int i=0;
		items.add("a");
		items.add("b");
		items.add("c");
		items.add("d");
		items.add("e");
		items.add("f");
		items.add("g");
		items.add("h");
		items.add("i");
		
		
		System.out.println(items);
	    FibonacciIterator fi = new FibonacciIterator(items);
	    while(fi.hasNext()){
	    	System.out.println(fi.next());
	    }

	}

}