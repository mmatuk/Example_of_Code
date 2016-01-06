//************************************************************************
//	MedicalDepartment.java 							Matt Matuk
// 	CSIT 210								Project 8.2 pg 407
//	This class extends the HospitalEmployees class and adds 
//	any new methods and variables that only the med dept
//	will have. This class is also a parent and abstract. 
//*************************************************************************	
 
public abstract class MedicalDepartment extends HospitalEmployees
{
	protected int numOfPatents;
	protected boolean erDuty;
	
	//---------------------------------------------------------------
	// Helps to set up the object by calling the parent constructor 
	// and sets the department and deptID.
	//---------------------------------------------------------------
	public MedicalDepartment(String name)
	{
		super(name);
		department = "Medical\t";
		deptID = 333;
	}
	
	//---------------------------------------------------------------
	// Method the sets erDuty to true when called
	//---------------------------------------------------------------
	public void erDuty()
	{
		erDuty = true;
		System.out.println(name + " has ER Duty.");
	}
	
	//---------------------------------------------------------------
	// set erDuty to value
	//---------------------------------------------------------------
	public void setERDuty(boolean value)
	{
		erDuty = value;
	}
	
	//---------------------------------------------------------------
	// set number of patents
	//---------------------------------------------------------------
	public void setNumOfPatents(int num)
	{
		if (num > 0)
		{
			numOfPatents = num;
		}
	}
	
	//---------------------------------------------------------------
	// returns erDuty
	//---------------------------------------------------------------
	public boolean getERDuty()
	{
		return erDuty;
	}
	
	//---------------------------------------------------------------
	// returns number of patents
	//---------------------------------------------------------------
	public int getNumOfPatents()
	{
		return numOfPatents;
	}
	
	//---------------------------------------------------------------
	// returns a nicely formated string that adds onto the bottom
	// of the string from the parent class
	//---------------------------------------------------------------
	public String toString()
	{
		String result = super.toString();
		result = result + "# of Patents: " + numOfPatents +"\n";
		result = result + "ER Duty: "+ ((erDuty) ? "YES" : "NO") 
				+"\t\t\t\t\t\t";
		
		
		return result;
	}

}
