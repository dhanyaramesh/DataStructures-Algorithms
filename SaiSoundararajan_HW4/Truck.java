package orderingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Truck extends Vehicle{ 	//inherited from vehicle class

	Integer truckSize;
	Integer engineSize;
	// hardcoding the values of load and engine
	static String[] typeOfLoad = {"Half-ton","Full-ton"};
	static String[] typeOfEngine= {"Really big","Not so big"};
	
	Scanner a = new Scanner(System.in);
	// mutators
	void setTruckSize()
	{
		Boolean condition=false;
		while(condition ==false)
		{
			System.out.println("What size truck is this ? ");	
			for(int i=0;i<typeOfLoad.length;i++)
			{
				System.out.println(i+1 + "." + typeOfLoad[i]);
			}
			System.out.println("CHOICE : ");
			
			int ts = a.nextInt();
			if(ts==1 || ts ==2)
			{
				this.truckSize=ts;
				condition =true;
			}
			else
			{
				System.out.println("Please enter numerical choice");
			}
		}
		
	}
	void setEngineSize()
	{	
		Boolean condition=false;
		while(condition ==false)
		{
			System.out.println("What is the engine size of the truck ? ");
			for(int i=0;i<typeOfEngine.length;i++)
			{
				System.out.println(i+1 + "." + typeOfEngine[i]);
			}
			System.out.println("CHOICE : ");
			int es = a.nextInt();
			if(es==1 || es ==2)
			{	
				this.engineSize = es;
				condition = true;
			}
			else
				System.out.println("Please enter numerical choice");
		}
			
		
	}
	
	//Accessors
	String getTruckSize()
	{
		return typeOfLoad[this.truckSize-1];
	}
	
	String getEngineSize()
	{
		return typeOfEngine[this.engineSize-1];
	}
	
	//Constructor
	public Truck()
	{					//calls constructor of vehicle
		setTruckSize();
		setEngineSize();
	}
	
	void display()
	{
		displayVehicle();
		System.out.println("Load : " + getTruckSize());
		System.out.println("Engine : " + getEngineSize());
	}

}