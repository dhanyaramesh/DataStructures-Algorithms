package hackerRank;

import java.util.Scanner;

public class pangrams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 
        Scanner in = new Scanner(System.in);
        String s = in.nextLine();
        boolean[] alpha = new boolean[26];
        s=s.toUpperCase();
        s = s.replace(" ", "");
        for(int i=0;i<s.length();i++){
            if(alpha[(s.charAt(i))-65]==false)
                alpha[(s.charAt(i))-65]=true;       
        }
        
        for(int j=0;j<alpha.length;j++){
            if(alpha[j]==false){
                System.out.println("not pangram");
                return;
            }                
        }
        System.out.println("pangram");

	}

}
