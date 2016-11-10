// Person Interface
// Java for Programmers - Quiz 2

public interface Person  {
	int MAX_AGE = 75;			// Maximum allowed age
	int MIN_AGE = 5;			// Minimum allowed age
	int MAX_CR  = 20;			// Maximum allowed credit hours, 0 is minimum
	
	// This method sets a persons age. The value is set only
	// if it falls with the allowed age range (5 to 75 inclusive)
	public void setAge(int newAge);
	
	// get the persons age
	public int getAge();
	
	// get the persons name - we are assuming the name does not change
	// so there will be no mutator for name
	public String getName();
	
	// list the persons data in the format Name: name  Age: age
	public String toString();
}