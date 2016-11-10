/**
 * Name: Segway.java for Homework 5
 * @author Tyler Vick
 * Created: 9/28/15
 * Description: A subclass of the Vehicle class, this creates an object with
 * added attributes for the segway type and the battery capacity.
 *
 */
package orderingSystem;
public class Segway extends Vehicle {

    /**
     * Overloads the vehicle constructor to provide the type of vehicle
     */
    private final static String VEHICLE_IS = "Segway";

    /**
     * The index of the class type for the given segway (Glider, Commuter, Adventurer)
     */
    private int segwayType;

    private final String PROMPT_SEGWAY_TYPE = "What type of Segway is this?";

    private final String [] SEGWAY_TYPE_CHOICES = {"Glider", "Commuter", "Adventurer"};

    /**
     * The index of the battery capacity for the given segway
     */
    private int segwayBatteryCapacity;

    private final String PROMPT_SEGWAY_BATTERY = "What size of battery?";

    private final String [] SEGWAY_BATTERY_CHOICES = {"5.2Ah", "6.4Ah"};
    
    private final Double [] segwayMileages= {23.4,31.2};

    /**
     * Sets the vehicle's custom attributes by prompting the user for input
     */
    public Segway() {

        super(VEHICLE_IS);

        setSegwayType(showMenu(PROMPT_SEGWAY_TYPE, SEGWAY_TYPE_CHOICES));

        setSegwayBatteryCapacity(showMenu(PROMPT_SEGWAY_BATTERY, SEGWAY_BATTERY_CHOICES));

    }

    /**
     * Returns the battery capacity value for the index of the selected battery
     * @return double       The mileage capacity for the selected battery
     */
    public double gasMileage() {

        return segwayMileages[segwayBatteryCapacity-1];

    }

    public String toString() {
        return super.toString() +
                "\n\tMPG/GPH: " + gasMileage() +
                "\n\tType: " + getSegwayType() +
                "\n\tBattery Capacity: " + getSegwayBatteryCapacity();
    }

    public String getSegwayType() {
        return SEGWAY_TYPE_CHOICES[segwayType-1];
    }

    public void setSegwayType(int segwayType) {
        this.segwayType = segwayType;
    }

    public String getSegwayBatteryCapacity() {
        return SEGWAY_BATTERY_CHOICES[segwayBatteryCapacity-1];
    }

    public void setSegwayBatteryCapacity(int segwayBatteryCapacity) {
        this.segwayBatteryCapacity = segwayBatteryCapacity;
    }
}
