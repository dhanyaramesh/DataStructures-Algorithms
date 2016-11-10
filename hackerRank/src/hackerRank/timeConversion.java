package hackerRank;

import java.awt.datatransfer.StringSelection;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class timeConversion {

    public static void main(String[] args) {/*
    	Scanner in = new Scanner(System.in);
        String time = in.next();
        String newtime=null;
        int flag=0;
        String[] tt = time.split(":");
        if(tt[2].contains("PM"))
        {
        	flag =1;  	
        }
        tt[2]=tt[2].substring(0, 2);
        int hrs= Integer.parseInt(tt[0]);
        int mins=Integer.parseInt(tt[1]);
        int secs=Integer.parseInt(tt[2]);
        
        if(flag==1) //PM
        {
        	if(hrs==12)
        		newtime="12"+":"+(tt[1])+":"+(tt[2]) ;
        	else
        		newtime=Integer.toString(hrs+12)+":"+(tt[1])+":"+(tt[2]) ;
        }
        else //AM
        {
            if(tt[0].equals("12"))
            {
            	newtime="00"+":"+(tt[1])+":"+(tt[2]);
            }
            else   
            	newtime=(tt[0])+":"+(tt[1])+":"+(tt[2]);
        
        }
         System.out.println(newtime); 
    */
    String s = "hello world";
    String sval = String.valueOf(s.charAt(0)-1);
    char val = (char)Integer.parseInt(sval);
    System.out.println(val);    
    }
}

