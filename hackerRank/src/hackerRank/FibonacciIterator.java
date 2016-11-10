package hackerRank;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FibonacciIterator implements Iterator {
	
	 private Integer current = 0;
	 private ArrayList<Integer> index = new ArrayList<Integer>();
	 private ArrayList<Type> items = new ArrayList<Type>();
	 
	 FibonacciIterator(List items){
		 int n=items.size();
		 this.items = (ArrayList<Type>) items;
		 index.add(0);
		 index.add(1);
		 int i=0;
		 while(i<n){
			 index.add(index.get(i)+index.get(i+1));
			 i++;
			 
		 }
		 //System.out.println("iterator constructor " + index );
		 //this.current=index.get(0);
	 }

	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		if(index.get(current)<items.size()){
			if(items.get(index.get(current))!=null){
				return true;
			}
			
		}
		
		
		
		return false;
	}

	@Override
	public Object next() {
		// TODO Auto-generated method stub
		int thisi=index.get(current);
		//System.out.println("this i " + thisi);
		
		if(thisi<items.size()){
			if(items.get(thisi)!=null){
				current++;
				return items.get(thisi);
			}
		}
		
			
		return null;
	}
	

}