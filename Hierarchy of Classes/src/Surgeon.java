//************************************************************************
//	Surgeon.java 							Matt Matuk
// 	CSIT 210								Project 8.2 pg 407
//	This class extends the MedicalDepartment class and allows 
//	any object create from this class to have all the parent
//	class methods and variables. The class is not abstract and  
//	can have objects create from it. A surgeon can operate 
//	which no other class can do and the surgeon can have ER duty
//	which any MedicalDepartment person can have too. 
//*************************************************************************	
 
public class Surgeon extends MedicalDepartment
{
	protected int numOfSurgeries;
	protected boolean operateToday;
	
	//---------------------------------------------------------------
	// this class creates the object by calling the parent constructor
	// and sets the remaining variables. This constructor also needs
	// to be passed the values for surgeries, patents, name , and 
	// schedule
	//---------------------------------------------------------------
	public Surgeon(int num, int sur, String name, String sch)
	{
		super(name);
		numOfSurgeries = sur;
		position = "Surgeon\t";
		numOfPatents = num;
		erDuty = false;
		if (sur > 0)
		{
			operateToday = true;
		}
		else
		{
			operateToday = false;
		}
		schedule = sch;
		payRate = 40.26;
	}
	
	//---------------------------------------------------------------
	// set operation today to true when called
	//---------------------------------------------------------------
	public void operation()
	{
		operateToday = true;
		System.out.println(name +" has an operation today.");
	}
	
	//---------------------------------------------------------------
	// sets the number to surgeries left to the current number - the
	// passed to the method also changes operation today to false 
	// if the number of surgeries is 0 after.
	//---------------------------------------------------------------
	public void preformSurgery(int num)
	{
		numOfSurgeries = numOfSurgeries - num;
		if (numOfSurgeries == 0)
		{
			operateToday = false;
		}
		System.out.println(name +" has preformed "+ num +" surgeries.");
	}
	
	//---------------------------------------------------------------
	// sets operation today
	//---------------------------------------------------------------
	public void setOperationToday(boolean value)
	{
		operateToday = value;
	}
	//---------------------------------------------------------------
	// sets number of surgeries 
	//---------------------------------------------------------------
	
	public void setNumOfSurgeries(int num)
	{
		if (num > 0)
		{
			numOfSurgeries = num;
		}
	}
	
	//---------------------------------------------------------------
	// returns operation today
	//---------------------------------------------------------------
	public boolean getOperationToday()
	{
		return operateToday;
	}
	
	//---------------------------------------------------------------
	// returns number of surgeries
	//---------------------------------------------------------------
	public int getNumOfSurgeries()
	{
		return numOfSurgeries;
	}
	
	//---------------------------------------------------------------
	// returns a nicely formated string that adds onto the bottom
	// of the string from the parent class
	//---------------------------------------------------------------
	public String toString()
	{
		String result = super.toString();
		result = result + "Operation Today: " 
				+ ((operateToday) ? "YES" : "NO") +"\n";
		result = result + "# of Surgeries: " + numOfSurgeries;
		
		return result;
	}

}
