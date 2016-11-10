package orderingSystem;

import java.util.Scanner;

public class Boat extends Vehicle {
	Integer type;
	Integer construction;
	
	
	Scanner a = new Scanner(System.in);
	// hardcoding the values of types of car and towing package option
	final String[] typeOfBoat = {"Pontoon","PWC","Sailboat"};
	final String[] boatConstruction = {"Wood","Fibreglass","Steel"};
	
	//mutators
	void setType()
	{
		Boolean condition=false;
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
		}
		
	}
	void setConstruction()
	{	
		Boolean condition=false;
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
		}
			
		
	}
	
	// Accessor
	String getType()
	{
		return typeOfBoat[this.type-1];
	}
	
	String getConstruction()
	{
		 return boatConstruction[this.construction-1];
	}
	
	// Constructor
	public Boat()
	{ 						//calls base class constructor first
		setType();
		setConstruction();
	}
	
	void display()
	{
		displayVehicle();
		System.out.println("Type : " + getType());
		System.out.println("Made of : " + getConstruction());
	}
	

}
