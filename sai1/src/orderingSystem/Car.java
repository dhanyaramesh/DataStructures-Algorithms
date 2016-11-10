package orderingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Car extends Vehicle{ 	// inherited from vehicle class

	Integer type;
	Integer towPack;
	
	// hardcoding the values of types of car and towing package option
	private final static String VEHICLE_TYPE = "Car";
	
	private final String type_of_car_promt = "What type of Car is this? ";
	private final String[] typeOfCar = {"Sedan","Coupe","Wagon"};
	
	private final String towingPackage_promt = "Does this car have a towing package ? ";
	private final static String[] towingPackage = {"Yes","No"};
	
	private final double[] MPG = {23.7,28.2,19.5};
	
	//mutators
	void setType(int selection)
	{
		/*Boolean condition=false;
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
		}*/
		
		/*try{
			System.out.println("What type of Car is this? ");
			for(int i=0;i<typeOfCar.length;i++)
			{
				System.out.println(i+1 + "." + typeOfCar[i]);
			}
			System.out.println("CHOICE : ");
			type = a.nextInt();
			if(type <= 0 || type > typeOfCar.length)
			{
				throw new UserChoiceException(type.toString());
			}
			//else
				//this.type =typ;
				
		}
		catch(UserChoiceException uime)
		{
			
			System.out.println("hi");
			uime.displayException();
			this.setType();
		} */
		this.type = selection;
	}
	void setTowPack(int selection)
	{	
		/*Boolean condition=false;
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
		}*/
		
		/*try{
			System.out.println("Does this car have a towing package ? ");
			for(int i=0;i<towingPackage.length;i++)
			{
				System.out.println(i+1 + "." + towingPackage[i]);
			}
			System.out.println("CHOICE : ");
			this.towPack = a.nextInt();
			if(towPack <= 0 || towPack > towingPackage.length)
			{
				throw new UserChoiceException(towPack.toString());
			}
		
				
		}
		catch(UserChoiceException uime)
		{
			
			uime.displayException();
			this.setTowPack();
		}*/
		this.towPack = selection;	
		
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
	
	
	public Car(String model, String color,Double cost, String typ,String towpack)
	{
		super(VEHICLE_TYPE,model,color,cost);
		this.type = getIndexOf(typeOfCar,typ);
		this.towPack = getIndexOf(towingPackage,towpack);
		
	}
	public Car()
	{ 					//calls base class constructor first
		super(VEHICLE_TYPE);
		setType(showMenu(type_of_car_promt,typeOfCar));
		setTowPack(showMenu(towingPackage_promt,towingPackage));
	}
	
	public Integer getIndexOf(String[] values, String value)
	{
		Integer index =0;
		for(Integer i=0;i<values.length;i++)
		{
			if(values[i].equals(value))
				index = i;
		}
		return index;
	}
	public String toString()
	{
		String display = (super.toString());
		display = display + "\n Type : " + getType();
		display = display + "\n Towing : " + getTowPacktype();
		display = display + "\n MPG : " + gasMileage()  + "Miles/Gallon";
		
		return display;
	}
	
	
	public double gasMileage()
	{	
		if(this.towPack == 1)
			return(MPG[this.type-1] -3);
		else
			return(MPG[this.type-1]);
	}
	

	
}
