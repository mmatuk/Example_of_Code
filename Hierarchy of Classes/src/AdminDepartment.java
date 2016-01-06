//************************************************************************
//	AdminDepartment.java 							Matt Matuk
// 	CSIT 210								Project 8.2 pg 407
//	This class extends the HospitalEmployees class and adds 
//	any new methods and variables that only the admin dept
//	will have. This class is also a parent and abstract. 
//*************************************************************************	
 

public class AdminDepartment extends HospitalEmployees
{
	
	//---------------------------------------------------------------
	// Contructs the object and sets the department and deptID
	//---------------------------------------------------------------
	public AdminDepartment(String name)
	{
		super(name);
		department = "Administration";
		deptID = 111;
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