package hackerRank;

import java.util.Iterator;
import java.util.PriorityQueue;

public class PrioQueue {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		PriorityQueue<Integer>  pq = new PriorityQueue<Integer>();
		pq.add(1);
		pq.add(111);
		pq.add(3);
		pq.add(5001);
		pq.add(6);
		pq.add(62);
		pq.add(1);
		
		Iterator it  = pq.iterator();
		while(!pq.isEmpty()){
			System.out.println(pq.poll());
			
		}
		

	}

}
