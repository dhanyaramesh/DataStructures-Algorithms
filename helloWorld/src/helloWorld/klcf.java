package helloWorld;

import java.util.ArrayList;

public class klcf {
	
	public static float D(float p, float q ){
		float first = p*(31 - Integer.numberOfLeadingZeros((int)(p/q) ));
		float second = q*(31 - Integer.numberOfLeadingZeros( (int)(q/p) ));
		
		return (first+second)/2;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int utility[][] = {{1,2,3,4},{2,3,3,1},{1,4,3,2}}; //3 users, 4 ratings assuming max rating is 5
		ArrayList<Integer> v = new ArrayList<Integer>();
		for(int i=0;i< utility[0].length;i++){
		  // #v			sum of item rating
			int temp=0;
			for(int j=0;j<utility.length;j++){
				 temp = temp +utility[j][i];
			}
			v.add(temp);
			System.out.println(v);
		}
		//#u 			sum of user ratings
		ArrayList<Integer> u = new ArrayList<Integer>();
		ArrayList<Float> upv = new ArrayList<Float>();
		for(int i=0;i<utility.length;i++){
			int temp=0;
			for(int j=0;j<utility[i].length;j++){
				temp=temp+utility[i][j];
			}
			u.add(temp);
			float pv=0;
			for(int k=0;k<v.size();k++){
				pv=pv+v.get(k);
			}
			pv=pv/u.get(i);
			upv.add(pv);
			
			System.out.println(u);
		}
		
		// calculate the similarity between users 3X3
		float sim[][]={{0,0,0},{0,0,0},{0,0,0}};
		
		for(int i=0;i<utility.length;i++){
			for(int j=0;j<utility.length;j++){
				sim[i][j]=0;
				if(i==j){
					sim[i][j]=-1;
				}
				else{
					sim[i][j]=1/1+(D(upv.get(i),upv.get(j)));
					
				}
				System.out.print(sim[i][j] +"      ");
			}
			System.out.println();
			
		}
		

	}

}
