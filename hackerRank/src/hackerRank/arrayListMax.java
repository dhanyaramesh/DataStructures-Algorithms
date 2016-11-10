package hackerRank;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class arrayListMax {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String inputLine = scanner.nextLine();
		String[] inputParams = inputLine.split(" ");
		int nSize = Integer.parseInt(inputParams[0]);
		int mLines = Integer.parseInt(inputParams[1]);
		System.out.println(nSize + " "+ mLines);
		ArrayList<Integer> list= new ArrayList<Integer>(Collections.nCopies(5, 0));
		
		while(mLines>0){
			mLines--;
			String[] abVal = scanner.nextLine().split(" ");
			for(int i= Integer.parseInt(abVal[0])-1;i<=Integer.parseInt(abVal[1])-1;i++){
				list.set(i,list.get(i)+Integer.parseInt(abVal[2]));
			}
				
		}
		int max=-1;
		for(int j=0;j<list.size();j++){
			if(list.get(j)>max)
				max=list.get(j);
		}
		
		System.out.println("max" + max);
		System.out.println(list);
		
	}

}
