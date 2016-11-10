package orderingSystem;

public class WheelChair extends Vehicle {
	//Double MPG;
	Integer type;
	Integer isFoldable;
	private final String PROMPT_WHEELCHAIR_TYPE = "What type of WHEELCHAIR is this?";
	private final String [] WHEELCHAIR_TYPE_CHOICES = {"Manual", "Semi-Automatic", "Automatic"};

	private final String PROMPT_IS_FOLDABLE = "What type of WHEELCHAIR is this?";
	private final String [] FOLDABLE_CHOICES = {"Yes", "No"};

	private final Double [] MPG_VALUES = {0.0,20.00,10.00};
	private final static String VEHICLE_TYPE = "WheelChair";
	
	public WheelChair()
	{
		super(VEHICLE_TYPE);
		setType(showMenu(PROMPT_WHEELCHAIR_TYPE,WHEELCHAIR_TYPE_CHOICES));
		setFoldableChoice(showMenu(PROMPT_IS_FOLDABLE,FOLDABLE_CHOICES));
	}
	
	public void setType(int selection)
	{
		this.type = selection;
	}
	
	public void setFoldableChoice(int selection)
	{
		this.isFoldable=selection;
	}
	
	public String toString()
	{
		String display = (super.toString());
		display = display + "\n Type : " + getType();
		display = display + "\n Foldable : " + getFoldableChoice();
		display = display + "\n gasMileage : " + gasMileage();
		
		return display;
	}
	
	public String getType()
	{
		return WHEELCHAIR_TYPE_CHOICES[this.type-1];
	}
	
	public String getFoldableChoice()
	{
		return FOLDABLE_CHOICES[this.type-1];
	}
	
	public double gasMileage()
	{
		return MPG_VALUES[this.type-1];
	}

}
