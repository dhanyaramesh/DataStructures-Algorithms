package orderingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Car extends Vehicle{ 	// inherited from vehicle class

	Integer type;
	Integer towPack;
	
	
	Scanner a = new Scanner(System.in);
	// hardcoding the values of types of car and towing package option
	static String[] typeOfCar = {"Sedan","Coupe","Wagon"};
	static String[] towingPackage = {"Yes","No"};
	
	//mutators
	void setType()
	{
		Boolean condition=false;
		while(condition ==false)
		{
			System.out.println("What type of Car is this? ");
			for(int i=0;i<typeOfCar.length;i++)
			{
				System.out.println(i+1 + "." + typeOfCar[i]);
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
	void setTowPack()
	{	
		Boolean condition=false;
		while(condition ==false)
		{
			System.out.println("Does this car have a towing package ? ");
			for(int i=0;i<towingPackage.length;i++)
			{
				System.out.println(i+1 + "." + towingPackage[i]);
			}
			System.out.println("CHOICE : ");
			int tp = a.nextInt();
			if(tp==1 || tp ==2)
			{	
				this.towPack = tp;
				condition = true;
			}
			else
				System.out.println("Please enter numerical choice");
		}
			
		
	}
	
	// Accessor
	String getType()
	{
		return typeOfCar[this.type-1];
	}
	
	String getTowPacktype()
	{
		if(this.towPack ==1)
		{
			return "Included" ;
		}
		else
		{
			return "Not Included" ;
		}
		
		// return towingPackage[this.towPack-1];
	}
	
	// Constructor
	public Car()
	{ 						//calls base class constructor first
		setType();
		setTowPack();
	}
	
	void display()
	{
		displayVehicle();
		System.out.println("Type : " + getType());
		System.out.println("Towing : " + getTowPacktype());
	}
	
	
	
	

	
}
