package orderingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Truck extends Vehicle{ 	//inherited from vehicle class

	Integer truckSize;
	Integer engineSize;
	
	private final static String VEHICLE_TYPE = "Truck";
	private final String type_of_load_prompt = "What size truck is this ? ";
	private final  String[] typeOfLoad = {"Half-ton","Full-ton"};

	private final String type_of_engine_prompt = "What is the engine size of the truck ? ";
	private final  String[] typeOfEngine= {"Really big","Not so big"};
	//Scanner a = new Scanner(System.in);
	// mutators
	void setTruckSize(int selection)
	{
		/*Boolean condition=false;
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
		}*/
		
		/*try
		{
			System.out.println("What size truck is this ? ");	
			for(int i=0;i<typeOfLoad.length;i++)
			{
				System.out.println(i+1 + "." + typeOfLoad[i]);
			}
			System.out.println("CHOICE : ");
			
			this.truckSize = a.nextInt();
			if(truckSize <= 0 || truckSize > typeOfLoad.length)
			{
				throw new UserChoiceException(truckSize.toString());
			}
		
				
		}
		catch(UserChoiceException uime)
		{
			
			uime.displayException();
			this.setTruckSize();
		}*/
		
		this.truckSize= selection;
			
	}
		
	
	void setEngineSize(int selection)
	{	
		/*Boolean condition=false;
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
		}*/
	/*	try
		{
			System.out.println("What is the engine size of the truck ? ");
			for(int i=0;i<typeOfEngine.length;i++)
			{
				System.out.println(i+1 + "." + typeOfEngine[i]);
			}
			System.out.println("CHOICE : ");
			this.engineSize= a.nextInt();
			if(engineSize <= 0 || engineSize > typeOfEngine.length)
			{
				throw new UserChoiceException(engineSize.toString());
			}
		
				
		}
		catch(UserChoiceException uime)
		{
			
			uime.displayException();
			this.setEngineSize();
		}*/
			
		this.engineSize= selection;
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
		
		// hardcoding the values of load and engine
		super(VEHICLE_TYPE);
		setTruckSize(showMenu(type_of_load_prompt,typeOfLoad));
		setEngineSize(showMenu(type_of_engine_prompt,typeOfEngine));
	}
	
	public String toString()
	{
		
		String display = (super.toString());
		display = display + "\n Load : " + getTruckSize();
		display = display + "\n Engine : " + getEngineSize();
		display = display + "\n MPG : " + gasMileage()  + "Miles/Gallon";
		
		return display;
	}
	
	public double gasMileage()
	{
		double mpg = 50.0 - (Math.sqrt(this.getCost()/10.0));
		return mpg;
	}

}