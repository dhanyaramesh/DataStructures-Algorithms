package orderingSystem;
import java.util.Scanner;

/** Jetski class stores Jetski Categories and Bodymaterial and inherits attributes of vehicle class.
*
* @author Sangram Pawar
*/


public class jetski extends Vehicle {
	
	Integer category;
	Integer bodymaterial;
	
	private final static String VEHICLE_TYPE = "jetski";
	private final String category_prompt = "Category of the Jetski ?";
	private final String categ[]={"1-manned","2-manned","3-manned"};
	
	private final String bodymaterials_prompt = "What type of bodymaterial ?";
	private final String bodymaterials[]={"Complete Fibre","Sheet Moulded Compound","Plastic Compound"};
	 /** Set Category */
	private final double []  MPG = {2.4,3.5,4.5};
	public void setCategory(int selection) {
	/*	try{
			System.out.println("What Category of jetski is this? ");
			for(int i=0;i<categ.length;i++)
			{
				System.out.println(i+1 + "." + categ[i]);
			}
			System.out.println("CHOICE : ");
			this.category = a.nextInt();
			if(this.category <= 0 || this.category > categ.length)
			{
				throw new UserChoiceException(category.toString());
			}
			//else
				//this.type =typ;
				
		}
		catch(UserChoiceException uime)
		{
			uime.displayException();
			this.setCategory();
		}	*/
		this.category = selection;
}
	
	 /** Get Category */
	
	public String getCategory(){
		return categ[this.category -1] ;
	}
	
	 /** Set Bodymaterial */
	
	public void setBodymaterial(int selection) {
		/*try{
			System.out.println("What is the body material? ");
			for(int i=0;i<bodymaterials.length;i++)
			{
				System.out.println(i+1 + "." + bodymaterials[i]);
			}
			System.out.println("CHOICE : ");
			this.bodymaterial = a.nextInt();
			if(this.bodymaterial <= 0 || this.bodymaterial > bodymaterials.length)
			{
				throw new UserChoiceException(bodymaterial.toString());
			}
			//else
				//this.type =typ;
				
		}
		catch(UserChoiceException uime)
		{
			uime.displayException();
			this.setBodymaterial();
		}	*/
		this.bodymaterial = selection;
		
	}
	
	 /** Get Bodymaterial */
	
	public String getBodymaterial(){
		return bodymaterials[this.bodymaterial -1];
	}
	
/** Set Mileage method */
	
	public double gasmileage(){
		return 0;
	}
	
//public void setGasmileage(double gasmileage){
	//this.gasmileage=gasmileage;
	
//}
 public double gasMileage(){
	 return MPG[this.category -1];
 }
	
	public jetski() {
		super(VEHICLE_TYPE);
		setCategory(showMenu(category_prompt,categ));
		setBodymaterial(showMenu(bodymaterials_prompt,bodymaterials));
		
	}

	public String toString()
	{
		String display = (super.toString());
		display = display + "\n Category : " + getCategory();
		display = display + "\n BodyMaterial : " + getBodymaterial();
		display = display + "\n MPG : " + gasMileage()  + "Miles/Gallon";
		return display;
		
	}
	
	
}
