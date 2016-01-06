//************************************************************************
//	Administrator.java 							Matt Matuk
// 	CSIT 210								Project 8.2 pg 407
//	This class extends the AdminDepartment class and allows 
//	any object create from this class to have all the parent
//	class methods and variables. The class is not abstract and  
//	can have objects create from it. The admin has the doSchedule
//	Variable that no other class has. 
//*************************************************************************	
 

public class Administrator extends AdminDepartment
{
	protected boolean doSchedule;
	
	//---------------------------------------------------------------
	// Constructs the admin object and calls the parent class 
	// constructor and sets any variables.
	//---------------------------------------------------------------
	public Administrator(String name)
	{
		super(name);
		doSchedule = true;
		payRate = 25.25;
		position = "Administrator";
		schedule = "M, T, W, Tr, F";
	}
	
	//---------------------------------------------------------------
	// Sets doSchedule to false when method is called
	//---------------------------------------------------------------
	public void writeSchedule()
	{
		doSchedule = false;
		System.out.println(name +" has written a schedule.");
	}
	
	//---------------------------------------------------------------
	// sets doSchedule
	//---------------------------------------------------------------
	public void setDoSchedule(boolean value)
	{
		doSchedule = value;
	}
	
	//---------------------------------------------------------------
	// returns doSchedule
	//---------------------------------------------------------------
	public Boolean getDoSchedule()
	{
		return doSchedule;
	}
	
	//---------------------------------------------------------------
	// returns a nicely formated string that adds onto the bottom
	// of the string from the parent class
	//---------------------------------------------------------------
	public String toString()
	{
		String result = super.toString();
		result = result + "Write Schedule: "+ 
				((doSchedule) ? "YES" : "NO") +"\n";
		
		return result;
	}
}