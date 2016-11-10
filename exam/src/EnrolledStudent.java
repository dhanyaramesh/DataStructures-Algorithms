

public class EnrolledStudent extends Student{
	int credit;
	
	EnrolledStudent(String n, int a, int c)
	{
		super(n,a);
		setCr(c);
	}
	public void setCr(int newCredit)
	{
		if(newCredit <= MAX_CR)
		this.credit = newCredit;
	}
	public int getCr()
	{
		return this.credit;
	}
	
	public String toString()
	{
		return super.toString() + " Credit:" + credit;
		
	}
	

}
