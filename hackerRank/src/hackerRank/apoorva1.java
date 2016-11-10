package hackerRank;

public class apoorva1 {
	public static void main(String[] args) {
		int x1,y1,x2,y2;
		x1=1;
		y1=4;
		x2=5;
		y2=14;
		int flag = 0;
//		while(flag==0)
//		{
//			
//			if(x1+y1 <=x2)
//				x1=x1+y1;
//			if(x1+y1 <=y2)
//				y1=x1+y1;
//			
//			if(x1==x2 && y1==y2){
//				flag=1;
//				System.out.println("possible");
//			}
//			else if(x1>x2 || y1 >y2){
//				flag=-1;
//				System.out.println("impossible");
//				//return;
//			}
//			else if((x1+y1 != x2 || x1+y1 != y2) && flag==0)
//			{
//				flag=2;
//				System.out.println("impossible2");
//			}
//			
//			System.out.println(x1 + " "+y1 + " "+x2 + " "+y2 + " ");
//		}
		
		while(x1 <= x2  && y1 <= y2){
			int tempx = x1+y1;
			int tempy = x1+y1;
			
			if(tempx <= x2)
				x1=tempx;
			else if(tempy <= y2)
				y1=tempy;
			else if(tempx == x2 && tempy == y2)
				break;
				//System.out.println(tempx + " "+ tempy);
			
				
		}
		
		if(x1==x2 && y1==y2)
			System.out.println("possible");
		else
			System.out.println("this" + x1 + " " + y1);
		
	}

}
