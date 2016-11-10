import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class ceaserCipher {
	public static String decode(String enc)
	{
		Character[] res = new Character[enc.length()];
		String result="";

		System.out.println("inside");
		for(int i=0;i< enc.length();i++)
		{
			char a = enc.charAt(i);
			if((int)a >=65 && (int) a < 90)
			{

				int sam= (a+1) % 96 ;
				res[i] = (char) (sam);
				System.out.println(res[i]);
			}
			else if ( (int) a >= 97 && (int)a < 122)
			{

				System.out.println("2");
				res[i] = (char) ((a+1) % 122);

				System.out.println(res[i]);
			}
			else if ((int) a == 90)
				res[i] = (char) (65);
			else if ((int) a == 122)
				res[i] = (char) (97);
			else
			{

				System.out.println("3");
				res[i] = a;
			}
			
			System.out.println(res[i]);
			result = result.concat(res[i].toString());
		}

		return result;
	}
	
public static void main(String[] args) throws IOException{

 
	String enc = "HELLO worlz";
	System.out.println("caling");
	System.out.println(decode(enc));
}
}


