// TestStudent.java
// Test the created Student class

public class TestStudent 
{
	// run test from inside main
	public static void main(String [] args) 
	{
		// create the Student
		Student s1 = new Student("Sam", 46);
		Student s2 = new Student("Pat", 22);
		EnrolledStudent es = new EnrolledStudent("Tim", 19, 12);
		
		// list the student
		System.out.println("Initial Sam's student values:  " + s1.toString());
		System.out.println("Initial Pat's student values:  " + s2.toString());
		System.out.println("Initial Tim's enrolled values: " + es.toString());
		System.out.println();
		
		// change the age to 3
		s1.setAge(3);
		
		// list the student
		System.out.println("After setAge(3):  " + s1.toString());
		
		// change the age to 47
		s1.setAge(47);
		
		// list the student
		System.out.println("After setAge(47): " + s1.toString());
		
		// get the name
		System.out.println("getName returns: " + s1.getName());
		
		// get the age
		System.out.println("getAge returns:  " + s1.getAge());
		
		es.setAge(2);
		es.setCr(23);
		System.out.println("1st test Tim's enrolled values: " + es.toString());
		
		es.setAge(20);
		es.setCr(16);
		System.out.println("2nd test Tim's enrolled values: " + es.toString());

		System.out.println("After set Tim's age to 20: " + es.getAge() );
		System.out.println("After set Tim's cr to 16 : " + es.getCr() );
		System.out.println("After sets Tim's name is : " + es.getName() );
		System.out.println("Final Tim's enrolled values: " + es.toString());
		
		System.out.println();
		System.out.println("Final Sam's student values:  " + s1.toString());
		System.out.println("Final Pat's student values:  " + s2.toString());
	}
}		// end TestStudent