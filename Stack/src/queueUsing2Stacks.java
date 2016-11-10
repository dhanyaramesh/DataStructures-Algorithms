
public class queueUsing2Stacks {
	
	stack s1;
	stack s2;
	int queue_size;
	
	queueUsing2Stacks(int cap){
		queue_size = cap;
		s1 = new stack(queue_size);
		s2 = new stack(queue_size);
	}
	
	public void enQ(int val){
		try{
			if(s1.top+s2.top < queue_size)
				s1.push(val);
			else
				throw new Exception("overflow - queue full");
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	public int deQ(){
		int val=-1;
		try{
			if(s1.top==-1 && s2.top==-1)
				throw new Exception("underflow - queue empty");
			else{
				if(s2.top!=-1){
					val = s2.pop();
				}
				else{
					while(s1.top>-1){
						s2.push(s1.pop());
					}
					val = s2.pop();
				}
			}
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return val;
		
	}
	
	public static void main(String args[]){
		
		queueUsing2Stacks q = new queueUsing2Stacks(5);
		q.enQ(1);
		q.enQ(2);
		q.enQ(3);
		q.enQ(4);
		q.enQ(5);
		q.enQ(6);
		System.out.println("removing from q " + q.deQ());
		
		System.out.println("removing from q " + q.deQ());
		System.out.println("removing from q " + q.deQ());
		System.out.println("removing from q " + q.deQ());
		q.s1.print();
		q.s2.print();
		
		
		
		
	}

}