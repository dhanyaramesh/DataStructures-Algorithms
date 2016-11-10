

public class Student extends ABC implements Person{
	String name;
	int age;
	me[] a1;
	
	 Student(String n, int a)
	{
		setAge(a);
		setName(n);
	}
	 public void setAge(BCD a ,int newAge){
		//try{
		if(newAge >= MIN_AGE && newAge <= MAX_AGE )
		{
			this.age = newAge;
		}
		/*else
		{
			throw new ageException(age);
		}
		}
		catch(ageException ae)
		{
			ae.displayException();
		}*/
	
	}
	
	 public void setName(String newName)
	 {
		 this.name= newName;
	 }
	// get the persons age
	public int getAge(){
		return this.age;
		
	}
	
	// get the persons name - we are assuming the name does not change
	// so there will be no mutator for name
	public String getName(){
		return this.name;
		
	}
	
	// list the persons data in the format Name: name  Age: age
	public String toString(){
		String display = "Name: " + name + " Age:" + age ;
		return display;
		
	}
	

}


