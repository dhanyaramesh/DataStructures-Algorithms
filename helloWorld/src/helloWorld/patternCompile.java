package helloWorld;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class patternCompile {
	
	public static boolean prime(int n) {
		  return !new String(new char[n]).matches(".?|(..+?)\\1+");
		}

	public static void main(String[] args){
//	      Scanner in = new Scanner(System.in);
//	      int testCases = Integer.parseInt(in.nextLine());
//	      while(testCases>0){
//	    	  testCases--;
//	         String pattern = in.nextLine();
//	             //Write your code
//	          try{
//	        	  Pattern p = Pattern.compile(pattern);
//	        	  System.out.println("Valid");
//	              
//	          }catch(PatternSyntaxException pse){
//	              System.out.println("Invalid");
//	          }
//	      }
		
		String s ="dhanya123a";
		Pattern p =Pattern.compile("\\d+");
		Matcher m = p.matcher(s);
		//System.out.println(m.groupCount());
		while(m.find()){
			//System.out.println(m.group());
		}
		//System.out.println(p + " " + m.toString());
		System.out.println(prime(13));
	   }

}
