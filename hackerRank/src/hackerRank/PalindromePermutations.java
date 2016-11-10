package hackerRank;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class PalindromePermutations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s="cattacoe";
		HashMap<Character, Integer> charCnt = new HashMap<Character,Integer>();
		for(int i=0;i<s.length();i++){
			if(charCnt.containsKey(s.charAt(i))){
				charCnt.put(s.charAt(i), charCnt.get(s.charAt(i))+1);
			}
			else
				charCnt.put(s.charAt(i),1);
		}
		int flag=0;
		Set<Entry<Character,Integer>> es = charCnt.entrySet();
		Iterator i = es.iterator();
		while(i.hasNext()){
			Entry<Character,Integer> thises = (Entry<Character, Integer>) i.next();
			if(thises.getValue()%2==0){
				
			}
			else{
				if(flag==1){
					System.out.println("not possible");
					return;
				}
				else
					flag=1;
			}

	}
	System.out.println("possible");	
		
	}

}
