import java.awt.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.TreeSet;

public class remDup {
	public static void main(String args[]) throws Exception
	{
		ArrayList<Integer> al = new ArrayList<Integer>();
		al.add(1);
		al.add(2);
		al.add(3);
//		al.add(29);
//		al.add(24);
//		al.add(25);
//		al.add(26);
////		
//		System.out.println("ArrayList : " + al);
//		
//		Boolean x = al.remove((Integer)2);
//		{
//			System.out.println("ArrayList : " + al + x);
//		}
		
//		
//		Set<Integer> s = new LinkedHashSet<Integer>(al);
//		
//		System.out.println("Set : " + s);
//		al.clear();
//		al.addAll(s);
//		al.sort(null);
//		System.out.println(al);
		
//		String s = "sample strings";
//		int ch[] = new int[999999];
//		for(int i=0;i<s.length();i++)
//			ch[i]=0;
//		for(int i=0;i<s.length();i++)
//		{
//			ch[s.charAt(i)]++ ;
//		}
//		int max=-1;
//		char res=' ';
//		
//		for(int i=0;i<s.length();i++)
//		{
//			if(ch[i]>max)
//			{
//				max = ch[i];
//				res=s.charAt(i);
//			}
//		}
//		System.out.println(max + res);
//		Integer a[] = {1,4,100,400,4,3};
//		Set<Integer> s = new TreeSet<Integer>();
//		for(int i=0;i<a.length;i++)
//		{
//			s.add(a[i]);
//		}
//		
//		ArrayList al1 = new ArrayList(s);
//		int count=0;
//		System.out.println(s);
//		for(int i=1;i<al.size();i++)
//		{
//			if(al.get(i)-al.get(i-1) == 1)
//			{
//				count++;
//			}
//		}
//		System.out.println(count);
		
//		char a[]={'a','b','c'};
//		char b[]={'a','b','c'};
//		
//		if(a.toString().equals(b.toString()))
//		{
//			System.out.println("hello");
//		}
//		String str =  String.valueOf(123);
//		System.out.println(str.compareToIgnoreCase("124"));
//		
//		StringBuilder one = new StringBuilder("A");
//		StringBuilder two = new StringBuilder("BB");
//		
//		for(int i=one.length();i< two.length();i++)
//		{
//			if(two.toString().contains(one+"A"))
//			{
//				System.out.println("in A : " + one);
//				one=one.append("A");
//				System.out.println("in A : " + one);
//				
//			}
//			 
//			else //if(two.toString().contains(one.reverse().toString()+"B"))
//			{
//				StringBuilder temp = one.reverse();
//				temp=temp.append("B");
//				
//				
//				one=temp;
//				System.out.println("in B" + one);
//				
//			}
//			
//			
//		}
//		
//		
//		if(one.equals(two))
//			System.out.println(one);
		
		Long x =(long) 223336226;
		long max = (long) 0;
		char num[]=x.toString().toCharArray();
		for(int i=0;i<num.length-1;i++)
		{
				int count=1;
				while(num[i]==num[i+1])
				{
					count ++;
					if(i==num.length-2)
						break;
					i++;
				}
				String m = String.valueOf(num).substring(0, i) + String.valueOf(num).substring(i+1);
				//System.out.println(m);
				long cur_max = (long)Long.parseLong(m);
				if(max < cur_max)
					max = cur_max;
				//System.out.println("count is :" + count + " i is : " + i + " num is : " + num[i] + " val is : " + max);
				
		}
		System.out.println(max);	
	

		String S1="anagramm";
		String S2="marganaa";
		S1 = S1.replaceAll(" ","");
		S2 = S2.replaceAll(" ","");
		char[] ss1 = S1.toCharArray();

		char[] ss2 = S2.toCharArray();
		S1.e
		Arrays.sort(ss1);
		Arrays.sort(ss2);
		Arrays.eq
		System.out.println(Arrays.equals(ss1, ss2));
	}
	
	
	
	
	

}
