package orderingSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class Vehicle {
	
	String model;
	String color;
	Double cost;
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
		System.out.println("Cost : ");
		this.cost = a.nextDouble();
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
	public Vehicle()
	{
		setModel();
		setColor();
		setCost();
		
	}
	
	// displays the attributes of vehicle
	
	void displayVehicle()
	{
		System.out.println("Model : " + getModel());
		System.out.println("Color : " + getColor());
		System.out.println("Cost : " + getCost());
	}

	

	}
