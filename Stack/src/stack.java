
public class stack {
	
	int capacity;
	int top;
	int[] s;
	
	stack(int cap){
		this.capacity = cap;
		s = new int[this.capacity];
		top=-1;
	}
	
	public int getTop(){
		return this.top;
	}
	
	public int pop(){
		int val=-1;
		try{
			if(top>-1){
				val = s[top];
				top--;
				
			}
			else
				throw new Exception("underflow - stack empty");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
		return val;
	}
	
	public void push(int val){
		
		try{
			if(top<capacity-1){
				top++;
				s[top] = val;
				//top++;
			}
			else
				throw new Exception("overflow - stack full");
			
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		
	}
	
	
	public void print(){
		System.out.println("Stack Top ");
		for(int i=capacity;i > top+1;i--){
			System.out.println("___");
		}
		for(int i=top;i>=0;i--)
			System.out.println(s[i]);
		
	}
	
	public static void main(String args[]){
		
		stack SK = new stack(5);
		SK.push(1);
		SK.push(2);
		SK.push(3);
		SK.push(4);
		SK.push(5);
		System.out.println("popping " + SK.pop());

		System.out.println("popping " + SK.pop());

		System.out.println("popping " + SK.pop());
		SK.print();
	}
	

}
