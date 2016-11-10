package orderingSystem;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import orderingSystem.CostException;
public abstract class Vehicle {
	
	String model;
	String color;
	Double cost;
	String VehicleType;
	Scanner a = new Scanner(System.in);
    
	// mutators
	
	void setModel()
	{
		System.out.println("Model : ");
		this.model = a.next();
	}
	
	void setColor()
	{
		System.out.println("Color : ");
		this.color = a.next();
	}
	
	void setCost()
	{
		String cst="";
		System.out.println("Cost : ");
		try{
			cst=a.next();
			if(cst.contains("$"))
				throw new CostException("$");
			else
				this.cost=Double.parseDouble(cst);
		}
		catch(CostException ce)                 // user defined exception checking for $
		{
			System.out.println("cfe" + ce.displayException());
			this.setCost();
		}

	}
	
	//Accessors
	
	String getModel()
	{
		return this.model;
	}
	
	String getColor()
	{
		return this.color;
	}
	
	Double getCost()
	{
		return this.cost;
	}
	
	
	
	// constructor
	public Vehicle(String vehicle)
	{
		this.VehicleType=vehicle;
		setModel();
		setColor();
		setCost();
	}
	public Vehicle(String vehicletype, String Model,String Color, Double Cost)
	{
		this.VehicleType = vehicletype;
		this.model = Model;
		this.color = Color;
		this.cost = Cost;
	}
	
	public int showMenu(String prompt, String[] choices)
	{
		int selection = -1;
		try{
		System.out.println(prompt);
		for(int i=0;i<choices.length;i++)
		{
			System.out.println(i+1 + "." + choices[i]);
		}
		selection = a.nextInt();
		if(selection <= 0 || selection > choices.length)
		{
			throw new UserChoiceException(selection);
		}
			
	}
	catch(UserChoiceException uime)
	{
		uime.displayException();
		showMenu(prompt, choices);
		
	} 
		return selection;
	}
	
	// displays the attributes of vehicle
	
	public String toString()
	{
		String display = this.VehicleType + ":";
		display = display + "\n Model : " + getModel();
		display = display + "\n Color : " + getColor();
		display = display + "\n Cost : " + getCost();
		
		return display;
	}
	
	void displayVehicle()
	{
		System.out.println("Model : " + getModel());
		System.out.println("Color : " + getColor());
		System.out.println("Cost : " + getCost());
	}

	abstract double gasMileage();
	

	}
