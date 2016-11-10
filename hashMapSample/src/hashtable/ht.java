package hashtable;

import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class ht {
public static void main(String args[])
{
	Hashtable<String,Integer> samp =  new Hashtable<String,Integer>();
	Scanner imp = new Scanner(System.in);
	String cond="n";
	do{
	System.out.print("Enter key and value");
	String key = imp.nextLine();
	Integer val = imp.nextInt();
	if(!samp.containsKey(key))
	{
		samp.put(key, val);
	}
	else
	{
		samp.put(key,samp.get(key)+val);
	}
	/*samp.put("dhanya", 200);
	samp.put("dhanya", 400);
	samp.put("ramesh", 200);
	samp.put("aishu", 200);
	samp.put("jamuna", 200);*/
	System.out.println("Do u have more entries ? (y/n)");
	cond = imp.next();
	}while(cond.equals("y"));
	
	
	
	Set s = samp.entrySet();
	Iterator it = s.iterator();
	while(it.hasNext())
	{
		Map.Entry<String, Integer> me = (Map.Entry)it.next();
		System.out.println(me.getKey() + ":" + me.getValue());
	}
	
	
	
}
}
