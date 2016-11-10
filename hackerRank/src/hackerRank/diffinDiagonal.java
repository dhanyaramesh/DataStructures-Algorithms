package hackerRank;
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;
public class diffinDiagonal implements Runnable {
	
	public void run(){
		counter();
	}
	synchronized public void counter()
	{
		for(int i=1;i<=10;i++)
		{
			System.out.println(Thread.currentThread().getName() + "is running with value " +i);
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
		}
	}
	
	
	public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        int n = in.nextInt();
//        int a[][] = new int[n][n];
//        int pd=0;
//        int sd=0;
//        for(int a_i=0; a_i < n; a_i++){
//            for(int a_j=0; a_j < n; a_j++){
//                a[a_i][a_j] = in.nextInt();
//                if(a_i==a_j)
//                    pd=pd+a[a_i][a_j];
//            }
//        }
//        int i=0;
//        for(int a_k=n-1;a_k>=0;a_k--)
//        {
//        	sd= sd + a[i][a_k];
//        	i++;
//        }
//        
//        System.out.println(Math.abs(pd-sd));
		diffinDiagonal ts =new diffinDiagonal();
		Thread t1 = new Thread(ts);
		Thread t2 = new Thread(ts);
		Thread t3 = new Thread(ts);
		Thread t4 = new Thread(ts);
		t1.start();
		//t1.run();
		t2.start();
		//t2.run();
		t3.start();
		//t3.run();
		t4.start();
		//t4.run();
		
	
    
    }

}
