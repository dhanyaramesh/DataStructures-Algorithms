package hackerRank;

public class spiralAnd90matrix {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int x=0,y=0,val=1,step=0,n=4;
		int[][] m = new int[n][n];
		//for(val=1;val < n*n;){
		while(val <= n*n){
			while(y+step < n){
				m[x][y]=val++;
				System.out.println("here " + x + " " + y +" "+ m[x][y]);
				
				y++;
			}
			//y--;
			x++;
			//System.out.print("after 1st while");
			y--;
			while(x+step<n){
				m[x][y]=val++;
				System.out.println("here2 " + x + " " + y +" "+ m[x][y]);
				
				x++;
			}
			x--;
			y--;
			System.out.println("y" + y);
			while(y >= 0+step){
				m[x][y]=val++;
				System.out.println("here3 " + x + " " + y +" "+ m[x][y]);
				
				y--;
			}
			y++;
			x--;
			
			step++;
			
			while(x>=0+step){
				m[x][y]=val++;
				System.out.println("here4 " + x + " " + y +" "+ m[x][y]);
				x--;
			}
			x++;
			y++;
			
		}
		
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		
		// 90degree
		
		int[][] newM = m;//new int[n][n];
		
		for(int i=0;i<n/2;i++){
			for(int j=0;j< Math.ceil(n/2);j++){
				int temp = m[i][j];
				m[i][j]= m[n-1-j][i];
				m[n-1-j][i]=m[n-1-i][n-1-j];
				m[n-1-i][n-1-j]=m[n-1-n+1+j][n-1-i];
				m[j][n-1-i]=temp;
				
			}
		}
		
		for(int i=0;i<n;i++){
			for(int j=0;j<n;j++){
				System.out.print(m[i][j] + " ");
			}
			System.out.println();
		}
		

	}

}
