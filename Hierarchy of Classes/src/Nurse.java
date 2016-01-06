//************************************************************************
//	Nurse.java 							Matt Matuk
// 	CSIT 210								Project 8.2 pg 407
//	This class extends the MedicalDepartment class and allows 
//	any object create from this class to have all the parent
//	class methods and variables. The class is not abstract and  
//	can have objects create from it. A nurse can check on patents 
//	which no other class can do, but a nurse can also have ER duty 
//	which a doctor and surgeon can have. 
//*************************************************************************	
 
public class Nurse extends MedicalDepartment
{

	protected int numOfPatentsToCheck;
	
	//---------------------------------------------------------------
	// this class creates the object by calling the parent constructor
	// and sets the remaining variables. This constructor also needs
	// to be passed the values for patents to check, patents, 
	// name , and schedule
	//---------------------------------------------------------------
	public Nurse(int num, int pat, String name, String sch)
	{
		super(name);
		numOfPatentsToCheck = pat;
		position = "Nurse\t";
		numOfPatents = num;
		erDuty = false;
		schedule = sch;
		payRate = 15.24;
	}
	
	//---------------------------------------------------------------
	// sets number of check patents to the current number - the 
	// number passed 
	//---------------------------------------------------------------
	public void checkPatents(int num)
	{
		numOfPatentsToCheck = numOfPatentsToCheck - num;
		System.out.println(name + " checked "+ num +" patents.");
	}
	
	//---------------------------------------------------------------
	// set the number of patents to check
	//---------------------------------------------------------------
	public void setNumOfPatentsToCheck(int num)
	{
		if (num > 0)
		{
			numOfPatentsToCheck = num;
		}
	}
	
	//---------------------------------------------------------------
	// returns the number of patnets 
	//---------------------------------------------------------------
	public int getNumOfPatentsToCheck()
	{
		return numOfPatentsToCheck;
	}
	
	//---------------------------------------------------------------
	// returns a nicely formated string that adds onto the bottom
	// of the string from the parent class
	//---------------------------------------------------------------
	public String toString()
	{
		String result = super.toString();
		result = result + "Patents to Check: " + numOfPatentsToCheck;
		
		return result;
	}
}
