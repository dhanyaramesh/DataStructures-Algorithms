package main.java.com.lab0;

/**
 * The Class greetings which implements the greeter interface.
 *
 * @author dhanyaramesh
 */
public class greetings implements greeter {
	private String name;

	/**
	 * @param name the name of the greeter
	 */
	public void setName(String name){
		this.name=name;
	}

	/**
	 * @return Greeting message from the greeter
	 */
	public String getGreeting(){
		return "hello world from "+ name + "!" ;
	}

}