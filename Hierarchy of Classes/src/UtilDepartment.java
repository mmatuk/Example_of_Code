//************************************************************************
//	UtilDepartment.java 							Matt Matuk
// 	CSIT 210								Project 8.2 pg 407
//	This class extends the HospitalEmployees class and adds 
//	any new methods and variables that only the util dept
//	will have. This class is also a parent and abstract. 
//*************************************************************************	
 

public abstract class UtilDepartment extends HospitalEmployees
{
	//---------------------------------------------------------------
	// helps to contructs the object and calls the parents class 
	// constructor. also set deparment and deptId variabels. 
	//---------------------------------------------------------------
	public UtilDepartment(String name)
	{
		super(name);
		department = "Utility\t";
		deptID = 222;
		
	}
	
	//---------------------------------------------------------------
	// returns a nicely formated string that adds onto the bottom
	// of the string from the parent class
	//---------------------------------------------------------------
	public String toString()
	{
		String result = super.toString();
		
		return result;
	}

}
