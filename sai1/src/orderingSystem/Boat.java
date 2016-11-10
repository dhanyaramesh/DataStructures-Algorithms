package orderingSystem;

import java.util.Scanner;

public class Boat extends Vehicle {
	Integer type;
	Integer construction;
	
	private final static String VEHICLE_TYPE = "Boat";
	
	//Scanner a = new Scanner(System.in);
	// hardcoding the values of types of car and towing package option
	private final String typeOfBoat_prompt = "What type of Boat is this? ";
	private final String[] typeOfBoat = {"Pontoon","PWC","Sailboat"};
	
	private final String typeOfBoatConstruction_prompt = "What is the boat's Construction ? ";
	private final String[] boatConstruction = {"Wood","Fibreglass","Steel"};
	
	private final double[] MPG = {3.5,2.2,0.0};
	//mutators
	void setType(int selection)
	{
	/*	Boolean condition=false;
		while(condition ==false)
		{
			System.out.println("What type of Boat is this? ");
			for(int i=0;i<typeOfBoat.length;i++)
			{
				System.out.println(i+1 + "." + typeOfBoat[i]);
			}
			System.out.println("CHOICE : ");
			int typ = a.nextInt();
			if(typ==1 || typ ==2 || typ ==3)
			{
				this.type=typ;
				condition=true;
			}
			else
			{
				System.out.println("Please enter numerical choice");
			}
		}*/
		this.type=selection;
		
	}
	void setConstruction(int selection)
	{	
		/*Boolean condition=false;
		while(condition ==false)
		{
			System.out.println("What is the boat's Construction ? ");
			for(int i=0;i<boatConstruction.length;i++)
			{
				System.out.println(i+1 + "." + boatConstruction[i]);
			}
			System.out.println("CHOICE : ");
			int tp = a.nextInt();
			if(tp==1 || tp ==2)
			{	
				this.construction = tp;
				condition = true;
			}
			else
				System.out.println("Please enter numerical choice");
		}*/
			
		this.construction=selection;
	}
	
	// Accessor
	String getType()
	{
		return typeOfBoat[this.type - 1];
	}
	
	String getConstruction()
	{
		 return boatConstruction[this.construction - 1];
	}
	
	// Constructor
	public Boat()
	{ 			
		//calls base class constructor first
		super(VEHICLE_TYPE);
		setType(showMenu(typeOfBoat_prompt,typeOfBoat));
		setConstruction(showMenu(typeOfBoatConstruction_prompt,boatConstruction));
	}
	
	public String toString()
	{
		String display = (super.toString());
		display = display + "\n Type : " + getType();
		display = display + "\n Made of : " + getConstruction();
		display = display + "\n MPG : " + gasMileage()  + "Miles/Gallon";
		
		return display;
	}
	
	public double gasMileage()
	{	
		return MPG[this.type -1];
	}

}
