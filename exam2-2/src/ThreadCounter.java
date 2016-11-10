
public class ThreadCounter extends Thread{
	static int counter = 0;
	int threadnumber;
	ThreadCounter(int num)
	{
		this.threadnumber = num;
		
	}
	public void run()
	{
		try {
			counter++;
			this.display();
			sleep(1);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	}
	
	void display() throws InterruptedException
	{
		System.out.println("Thread " + threadnumber + " counter " + counter);
	
	}
	
	public static void main(String[] args) throws InterruptedException
	{
		for(int i=0;i<10;i++)
		{
			ThreadCounter t1 = new ThreadCounter(1);
			t1.start();
			ThreadCounter t2 = new ThreadCounter(2);
			t2.start();
			ThreadCounter t3 = new ThreadCounter(3);
			t3.start();
			ThreadCounter t4 = new ThreadCounter(4);
			t4.start();
			
			
		}
		sleep(10);
		System.out.println("Final count " + counter);		
	}

}
