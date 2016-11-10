package orderingSystem;

public class UserChoiceException extends Exception {
	int str;
	UserChoiceException(int s2)
	{
		str= s2;
	}
	public String displayException()
	{
		return("Invalid entry " + str + "Please enter a number from the choice");
		//System.out.println("Enter only numeric value");
	}

}
