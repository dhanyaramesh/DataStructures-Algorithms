
public class maximumContiguousSubarray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A={-2, -3, 4, -1, -2, 1, 5, -3};
		int max_so_far = 0;
		int max_till_here=0;
		for(int a:A){
			max_till_here = max_till_here+a;
			if(max_till_here<0){
				max_till_here =0;
			}
			if(max_so_far<max_till_here && max_till_here >0){
				max_so_far = max_till_here;
			}
		}
	
		System.out.println(max_so_far);
	}

}
