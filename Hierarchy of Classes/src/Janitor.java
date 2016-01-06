//************************************************************************
//	Janitor.java 							Matt Matuk
// 	CSIT 210								Project 8.2 pg 407
//	This class extends the UtilDepartment class and allows 
//	any object create from this class to have all the parent
//	class methods and variables. The class is not abstract and  
//	can have objects create from it. The Janitor class has 
// the cleanBathrooms variable which no other class has. 
//*************************************************************************	
 
public class Janitor extends UtilDepartment
{

	protected boolean cleanBathrooms;
	
	//---------------------------------------------------------------
	// Creates the object by calling the parent class constructor and
	// set the remaining variables. 
	//---------------------------------------------------------------
	public Janitor(String name)
	{
		super(name);
		cleanBathrooms = true;
		position = "Janitor";
		schedule = "M, W, F, Sa";
		payRate = 7.55;
	}
	
	//---------------------------------------------------------------
	// Performs the clean operation which just sets cleanBathrooms 
	// to false when this method is called
	//---------------------------------------------------------------
	public void clean()
	{
		cleanBathrooms = false;
		System.out.println(name +" has cleaned the bathrooms.");
	}
	
	//---------------------------------------------------------------
	// returns cleanBathrooms 
	//---------------------------------------------------------------
	public Boolean getCleanBathrooms()
	{
		return cleanBathrooms;
	}
	
	//---------------------------------------------------------------
	// set cleanBathroom
	//---------------------------------------------------------------
	public void setCleanBathrooms(boolean value)
	{
		cleanBathrooms = value;
	}
	
	//---------------------------------------------------------------
	// returns a nicely formated string that adds onto the bottom
	// of the string from the parent class
	//---------------------------------------------------------------
	public String toString()
	{
		String result = super.toString();
		result = result + "\tRestrooms Cleaned: "
				+ ((cleanBathrooms) ? "NO" : "YES");
		
		return result;
	}
}
