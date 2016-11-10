package orderingSystem;
import orderingSystem.Car;
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
			 System.out.println("Do you want to order a Truck(T/t) or Car(C/c) or Boat(B/b)?");
			 String tov = a.next();
			 if (tov.equals("T") || tov.equals("t") || tov.equals("C") || tov.equals("c")  || tov.equals("B") || tov.equals("b") )
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
	
	
	public static void main(String args[])
	{
		String create= "y";                   // to check condition for continuing to place orders
		int index=0;                          // for arraylist entry
		System.out.println("SVP's Ordering System");
		Scanner input = new Scanner(System.in);
		ArrayList<Vehicle> myVehicles = new ArrayList<Vehicle>();  // list of vehicles
		ArrayList<Order> myOrders= new ArrayList<Order>();         // list of orders placed
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
			
		System.out.println("Do you want to create more vehicles? (y/n)");
		create = input.nextLine();
		index++;
		}while(create.equals("y"));
		
		
		// display of all vehicles ordered
		int size = myVehicles.size();
		for(int i = 0;i<size;i++)
		{
			if((myOrders.get(i).getTypeOfOrder()).equals("C") || myOrders.get(i).getTypeOfOrder().equals("c") )
			//if(myVehicles.get(i) instanceof Car);
			{
				System.out.println("Car :");
				((Car) myVehicles.get(i)).display();
				System.out.println();
			}
			if((myOrders.get(i).getTypeOfOrder()).equals("T") || myOrders.get(i).getTypeOfOrder().equals("t"))
			//if(myVehicles.get(i) instanceof Truck)
			{
				System.out.println("Truck :");
				((Truck) myVehicles.get(i)).display();
				System.out.println();
			}
			if((myOrders.get(i).getTypeOfOrder()).equals("B") || myOrders.get(i).getTypeOfOrder().equals("b") )
				{
					System.out.println("Boat :");
					((Boat) myVehicles.get(i)).display();
					System.out.println();
				}
		}
		System.out.println("Thank you for using SVP's ordering system");
		
	}

}
