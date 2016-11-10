package hackerRank;

import java.util.Scanner;

public class funnyString {
	/*
	 * Suppose you have a String, , of length  that is indexed from  to . You also have some String, , that is the reverse of String .  is funny if the condition  is true for every character  from  to .

Note: For some String ,  denotes the ASCII value of the  -indexed character in . The absolute value of an integer, , is written as .

Input Format

The first line contains an integer,  (the number of test cases). 
Each line  of the  subsequent lines contain a string, .

Constraints




Output Format

For each String  (where ), print whether it is  or  on a new line.

Sample Input

2
acxz
bcxz
Sample Output

Funny
Not Funny
Explanation

Test Case 0:  
 
 
 
As each comparison is equal, we print .

Test Case 1:  
, but  
At this point, we stop evaluating  (as ) and print .
	 * 
	 */

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner in  =  new Scanner(System.in);
        int  n = in.nextInt();
       // System.out.println(n);
        while(n>0){
            boolean flag=true;
            String s = in.next();
            int[] diff = new int[s.length()];
            //System.out.println(s);
            for(int i=0;i<s.length()-1;i++){
                diff[i+1] = Integer.parseInt((String.valueOf(s.charAt(i+1)-s.charAt(i))));
                int revDiff = Integer.parseInt(String.valueOf(s.charAt(s.length()-1-(i+1))-s.charAt(s.length()-1-i)));
                //System.out.println("diff,revdiff "+ diff[i+1] +","+revDiff);
                if(Math.abs(revDiff)!=Math.abs(diff[i+1])){
                    System.out.println("Not Funny");
                    flag=false;
                    i=s.length();
                }
                
            }
            if(flag==true)
                System.out.println("Funny");
            
            n--;
        }
	}

}
