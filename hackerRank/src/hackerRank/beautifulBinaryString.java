package hackerRank;

import java.util.ArrayList;
import java.util.Scanner;

public class beautifulBinaryString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*Alice has a binary string, , of length . She thinks a binary string is beautiful if and only if it doesn't contain the substring .

		In one step, Alice can change a  to a  (or vice-versa). Count and print the minimum number of steps needed to make Alice see the string as beautiful.

		Input Format

		The first line contains an integer,  (the length of binary string ). 
		The second line contains a single binary string, , of length .

		Constraints

		Each character in .
		Output Format

		Print the minimum number of steps needed to make the string beautiful.*/
		
		
		Scanner in  = new Scanner(System.in);
		int n  = in.nextInt();
		String b = in.next();
		int i=0;
		ArrayList<Integer> changes=new ArrayList<Integer>();
		while(i<n){
			if(i+2 < n && b.substring(i, i+3).equals("010")){
				changes.add(i+2);
				i=i+3;
			}
			else
				i=i+1;
		}
		System.out.println(changes.size());

	}

}
