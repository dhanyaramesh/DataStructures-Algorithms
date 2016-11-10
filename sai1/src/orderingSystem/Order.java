package orderingSystem;
import orderingSystem.Car;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import orderingSystem.Truck;
import java.util.Scanner;
import orderingSystem.Boat;

public class Order {
	Scanner a = new Scanner(System.in);
	Character typeOfOrder;
	
	
	void setTypeOfOrder()    // Mutator : Allows the user to select the type of vehicle. Validation done for improper input.
    {
		 Boolean condition = false;
		 while(condition == false)
		 {
			 System.out.println("Do you want to order a Truck(T/t) or Car(C/c) or Boat(B/b) or WheelChair(W/w) or Jetski (J/j) ot Segway (S/s)?");
			 String tov = a.next();
			 if (tov.equals("T") || tov.equals("t") || tov.equals("C") || tov.equals("c")  || tov.equals("B") || tov.equals("b")|| tov.equals("W") || tov.equals("w")|| tov.equals("J") || tov.equals("j")|| tov.equals("S") || tov.equals("s") )
			 {
				 this.typeOfOrder = tov.charAt(0);
				 condition = true;
			 }
			 else
				 System.out.println("Please enter a valid type !");
		 }
	}
	
	String getTypeOfOrder()  // Accessor
	{
		return this.typeOfOrder.toString();
	}
	
	public Order() // Constructor
	{
		setTypeOfOrder();
	}
	public Order(char vehicletype)
	{
		this.typeOfOrder = vehicletype;
	}
	
	
	public static void main(String args[]) throws IOException
	{
		String create= "y";                   // to check condition for continuing to place orders
		int index=0;                          // for arraylist entry
		System.out.println("SVP's Ordering System");
		Scanner input = new Scanner(System.in);
		ArrayList<Vehicle> myVehicles = new ArrayList<Vehicle>();  // list of vehicles
		ArrayList<Order> myOrders= new ArrayList<Order>();         // list of orders placed
		
		/*FileInputStream fis = new FileInputStream(new File("output.txt"));
		if(fis.available() >=0)
		{
			Integer data = fis.read();
			System.out.println("available" + data.toString());
		}*/
		
/*		try {
		    BufferedReader in = new BufferedReader(new FileReader("output.txt"));
		    String str;
		    String model;
		    String color;
		    Double cost = 0.0;
		    String typ;
		    String towpack;
		   while ((str = in.readLine()) != null)
		    {
		        System.out.println(str);
		        
		        switch(str.charAt(0))
				{
				case 'C' :
					str = in.readLine();
					model = str.substring(9);
					System.out.println(model);
					str = in.readLine();
					color = str.substring(9);;
					System.out.println(color);
					str = in.readLine();
					cost = Double.parseDouble( str.substring(7));
					System.out.println(cost);
					str = in.readLine();
					typ = str.substring(8);
					System.out.println(typ);
					str = in.readLine();
					towpack = str.substring(10);;
					System.out.println(towpack);
					myOrders.add(new Order('C'));
					myVehicles.add(new Car(model ,color,cost,typ,towpack));
					System.out.println("Car111 :");
					break;
				case 'c' :
					str = in.readLine();
					model = str.substring(9);
					System.out.println(model);
					str = in.readLine();
					color = str.substring(9);;
					System.out.println(color);
					str = in.readLine();
					cost = Double.parseDouble( str.substring(7));
					System.out.println(cost);
					str = in.readLine();
					typ = str.substring(8);
					System.out.println(typ);
					str = in.readLine();
					towpack = str.substring(10);;
					System.out.println(towpack);
					myOrders.add(new Order('C'));
					myVehicles.add(new Car(model ,color,cost,typ,towpack));
					System.out.println("Car111 :");
					break;
				case 'T' :
					str = in.readLine();
					model = str.substring(9);
					System.out.println(model);
					str = in.readLine();
					color = str.substring(9);;
					System.out.println(color);
					str = in.readLine();
					cost = Double.parseDouble( str.substring(7));
					System.out.println(cost);
					str = in.readLine();
					typ = str.substring(8);
					System.out.println(typ);
					str = in.readLine();
					towpack = str.substring(10);;
					System.out.println(towpack);
					myOrders.add(new Order('C'));
					myVehicles.add(new Car(model ,color,cost,typ,towpack));
					System.out.println("Car111 :");
					break;
				case 't' :
					myVehicles.add(new Truck());
					break;
				/*case 'B' :
					disp = ((Boat) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					break;
				case 'b' :
					disp = ((Boat) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					break;
				case 'W' :
					disp = ((WheelChair) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					break;
				case 'w' :
					disp = ((WheelChair) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					break;
				case 'S' :
					disp = ((Segway) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					break;
				case 's' :
					disp = ((Segway) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					break;
				case 'J' :
					disp = ((jetski) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					break;
				case 'j' :
					disp = ((jetski) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					break;*/
			/*	default :
					System.out.println("Thank you for using SVP's ordering system");
					break;
				}
		    }
		    in.close();
		} catch (IOException e) {
	}*/
		do
		{
			myOrders.add(new Order());
		
			if((myOrders.get(index)).getTypeOfOrder().equals("C") || (myOrders.get(index)).getTypeOfOrder().equals("c"))
			{
				System.out.println("Entering Car Order :");
				myVehicles.add(new Car());
			}
			else if((myOrders.get(index)).getTypeOfOrder().equals("T") || (myOrders.get(index)).getTypeOfOrder().equals("t"))
			{
				System.out.println("Entering Truck Order :");
				myVehicles.add(new Truck());
			}
			else if ((myOrders.get(index)).getTypeOfOrder().equals("B") || (myOrders.get(index)).getTypeOfOrder().equals("b"))
			{
				System.out.println("Entering Boat Order : ");
				myVehicles.add(new Boat());
			}
			else if ((myOrders.get(index)).getTypeOfOrder().equals("W") || (myOrders.get(index)).getTypeOfOrder().equals("w"))
			{
				System.out.println("Entering WheelChair Order : ");
				myVehicles.add(new WheelChair());
			}
			else if ((myOrders.get(index)).getTypeOfOrder().equals("J") || (myOrders.get(index)).getTypeOfOrder().equals("j"))
			{
				System.out.println("Entering Jetski Order : ");
				myVehicles.add(new jetski());
			}
			else if ((myOrders.get(index)).getTypeOfOrder().equals("S") || (myOrders.get(index)).getTypeOfOrder().equals("s"))
			{
				System.out.println("Entering Segway Order : ");
				myVehicles.add(new Segway());
			}
			
		System.out.println("Do you want to create more vehicles? (y/n)");
		create = input.nextLine();
		index++;
		}while(create.equals("y"));
		
		
		// display of all vehicles ordered
		int size = myVehicles.size();
	
		
		FileOutputStream out = new FileOutputStream("vehicletext.txt");
		FileWriter outFile = new FileWriter("vehicledata.dat");
        BufferedWriter vout = new BufferedWriter(outFile);
        for(int i=0;i<size;i++)
	    {
			 vout.write(myVehicles.get(i).toString());
	    }
				
		String disp="";
		for(int i=0;i<size;i++)
		{
			switch(myOrders.get(i).getTypeOfOrder())
			{
			case "C" :
				disp  = ((Car) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			case "c" :
				 disp = ((Car) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			case "T" :
				disp = ((Truck) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			case "t" :
				disp = ((Truck) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			case "B" :
				disp = ((Boat) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			case "b" :
				disp = ((Boat) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			case "W" :
				disp = ((WheelChair) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			case "w" :
				disp = ((WheelChair) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			case "S" :
				disp = ((Segway) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			case "s" :
				disp = ((Segway) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			case "J" :
				disp = ((jetski) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			case "j" :
				disp = ((jetski) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				break;
			default :
				System.out.println("Thank you for using SVP's ordering system");
				break;
			}
			System.out.println("Thank you for using SVP's ordering system");

		}
		
		
		
		
		/*for(int i = 0;i<size;i++)
		{
			if((myOrders.get(i).getTypeOfOrder()).equals("C") || myOrders.get(i).getTypeOfOrder().equals("c") )
			//if(myVehicles.get(i) instanceof Car);
			{
				System.out.println("Car :");
				String disp = ((Car) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				//System.out.println(disp);
			}
			if((myOrders.get(i).getTypeOfOrder()).equals("T") || myOrders.get(i).getTypeOfOrder().equals("t"))
			//if(myVehicles.get(i) instanceof Truck)
			{
				System.out.println("Truck :");
				String disp = ((Truck) myVehicles.get(i)).toString();
				out.write(disp.getBytes());
				//System.out.println(disp);
			}
			if((myOrders.get(i).getTypeOfOrder()).equals("B") || myOrders.get(i).getTypeOfOrder().equals("b") )
				{
					System.out.println("Boat :");
					String disp = ((Boat) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					//System.out.println(disp);
				}
			if((myOrders.get(i).getTypeOfOrder()).equals("W") || myOrders.get(i).getTypeOfOrder().equals("w"))
				//if(myVehicles.get(i) instanceof Truck)
				{
					System.out.println("WheelChair :");
					String disp = ((WheelChair) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					//System.out.println(disp);
				}
			if((myOrders.get(i).getTypeOfOrder()).equals("J") || myOrders.get(i).getTypeOfOrder().equals("j"))
				//if(myVehicles.get(i) instanceof Truck)
				{
					System.out.println("Jetski :");
					String disp = ((jetski) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					//System.out.println(disp);
				}
			if((myOrders.get(i).getTypeOfOrder()).equals("S") || myOrders.get(i).getTypeOfOrder().equals("s"))
				//if(myVehicles.get(i) instanceof Truck)
				{
					System.out.println("Segway :");
					String disp = ((Segway) myVehicles.get(i)).toString();
					out.write(disp.getBytes());
					//System.out.println(disp);
				}
		}*/
		//System.out.println("Thank you for using SVP's ordering system");
		
	}

}
