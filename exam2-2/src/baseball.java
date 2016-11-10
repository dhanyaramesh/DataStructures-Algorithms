import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

public class baseball {
	static int count = 0;  // for keeping track of total number of records
	String firstname;
	String lastname;
	int day;
	int month;
	int year;
	int weight;
	double height;

	baseball()
	{
		
	}
	
	public static void main(String[] args) throws IOException
	{
		try {
			
			DataInputStream dis = new DataInputStream(new FileInputStream("/Users/dhanyaramesh/Desktop/BaseballNames.bin"));
			ArrayList<baseball> namelist = new ArrayList<>();
			int max_weight = 0;
			int max_weight_index = -1;
			double max_height = 0.0;
			int max_height_index = -1;
			
			//read from binary file and putting in the arraylist
			while(dis.available()>0)
			{
				namelist.add(new baseball());
				namelist.get(count).firstname = dis.readUTF();
				namelist.get(count).lastname = dis.readUTF();
				namelist.get(count).day = dis.readInt();
				namelist.get(count).month = dis.readInt();
				namelist.get(count).year = dis.readInt();
				namelist.get(count).weight = dis.readInt();
				namelist.get(count).height = dis.readDouble();

				// max height calculation - keep track of the index of tallest person (non-inclusive comparison ; no >=)
				if(namelist.get(count).height > max_height)
				{
					max_height = namelist.get(count).height;
					max_height_index = count;
				}
				
				// max weight calculation - keep track of the index of heaviest person (non-inclusive comparison ; no >=)
				if(namelist.get(count).weight > max_weight)
				{
					max_weight = namelist.get(count).weight;
					max_weight_index = count;
				}
				// counting the number of records
				count ++;
					
			}
			
			System.out.println("total number of records : " + count);
			System.out.println("Tallest player was: " + namelist.get(max_height_index).firstname + " " + namelist.get(max_height_index).lastname + " at " + namelist.get(max_height_index).height);
			System.out.println("Heaviest player was: " + namelist.get(max_weight_index).firstname + " " + namelist.get(max_weight_index).lastname + " at " + namelist.get(max_weight_index).weight);
			/*System.out.println("max weight + index : " + max_weight + " " + max_weight_index );
			System.out.println("max height + index : " + max_height + " " + max_height_index );*/
			dis.close();
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
}
