package hashMapSample;

import java.util.*;

public class hM {

	HashMap<Integer,Integer> map1 = new HashMap<Integer,Integer> ();
	
	private hM()
	{
		int ele;
		Scanner inp = new Scanner(System.in);
		System.out.println("enter the number of elements: ");
		int num = inp.nextInt();
		for(int i=0;i<num;i++)
		{
		System.out.println("Enter the array elements one by one :");
		ele = inp.nextInt();
		if(map1.containsKey(ele))
		{
			int count = map1.get(ele);
			count++;
			map1.put(ele,count);
		}
		else
		{
			map1.put(ele,1);
		}
		}
}
	
	private void display()
	{
		/*Iterator<Integer> keysetIterator = map1.keySet().iterator();
		while(keysetIterator.hasNext())
		{
			System.out.println(keysetIterator.next() + " " + map1.get(keysetIterator.next()));
		}*/
		
	      Set set = map1.entrySet();
	      // Get an iterator
	      Iterator i = set.iterator();
	      // Display elements
	      int maj_index=0;
	      int maj_element=0;
	      while(i.hasNext()) {
	         Map.Entry me = (Map.Entry)i.next();
	         //System.out.print(me.getKey() + ": ");
	         //System.out.println(me.getValue());
	         if( (Integer)me.getValue() >= maj_index)
	         {
	        	 maj_element= (Integer)me.getKey();
	        	 maj_index = (Integer) me.getValue();
	         }
	      }
	    System.out.println(maj_index +" " + maj_element);
	    System.out.println(map1);
		
	}
	public static void main(String args[])
	{
		hM a = new hM();
		a.display();
	}
	
}
