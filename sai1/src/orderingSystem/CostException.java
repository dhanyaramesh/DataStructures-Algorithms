package orderingSystem;

public class CostException extends Exception{
	String str;
	CostException(String s2)
	{
		str=s2;
	}
	public String displayException()
	{
		return("Invalid cost" + str + "Enter the value without $");
		//System.out.println("Enter only numeric value");
	}
}
