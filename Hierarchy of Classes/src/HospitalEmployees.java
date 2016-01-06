//************************************************************************
//	HospitalEmployees.java 							Matt Matuk
// 	CSIT 210								Project 8.2 pg 407
//	this class is the top parent class for all the employees in the
//	hospital. The class contains any variable that every employee 
//	needs to have and is an abstract class. This class also 
//	contains some static variables that will contain all the ID
//	and names of the employees that are create from any class under 
//	this one. 
//*************************************************************************	
 
import java.util.Random;
import java.text.DecimalFormat;
import java.text.NumberFormat;

public abstract class HospitalEmployees 
{
	protected String hospitalName = "John Hopkins";
	protected String department;
	protected String name;
	protected String position;
	protected String schedule;
	
	protected int deptID;
	protected int ID;
	protected static int employeeCount = 0;
	
	protected double payRate;
	
	protected static int[] allEmployeeID = new int[50];
	protected static String[] allEmployeeName = new String[50];
	//---------------------------------------------------------------
	// This method is a contractor that sets the employee ID and 
	// name from what is passed. 
	//---------------------------------------------------------------
	public HospitalEmployees(String person)
	{
		if (employeeCount >= allEmployeeID.length)
		{
			increaseSize();
		}
		name = person;
		ID = -1;
		createID();
	}
	
	//---------------------------------------------------------------
	// This method creates a random 7 digit long id and sets the 
	// employee name and id at the same index location for each 
	// array
	//---------------------------------------------------------------
	protected void createID()
	{
		Random generator = new Random();
		
		do
		{
			ID = (generator.nextInt(10000000)+1);
			// --------------Debug-----------------
			//System.out.print(ID);
			//-------------------------------------
		} while(isIDTaken(ID));
		
		allEmployeeID[employeeCount] = ID;
		allEmployeeName[employeeCount] = name;
		employeeCount++;
		
	}
	
	//---------------------------------------------------------------
	// Makes sure the random number is not already taken
	//---------------------------------------------------------------
	private boolean isIDTaken(int num)
	{
		for (int count = 0; count <allEmployeeID.length; count ++)
		{
			if (ID == allEmployeeID[count])
			{
				return true;
			}
		}
		return false;
	}
	
	//---------------------------------------------------------------
	// return all the IDs with the name in a nice string
	//---------------------------------------------------------------
	protected static String getAllID()
	{
		DecimalFormat fmt = new DecimalFormat("0000000");
		
		String result = "*************************************\n";
		result = result + "Employee ID"+ "\t\t" +"Employee Name\n";
		result = result + "_____________________________________\n";
	
		for (int count = 0; count < allEmployeeID.length; count++)
		{
			if (allEmployeeID[count] == 0)
			{
				// does not print if no id 
			}
			else
			{
				result = result + fmt.format(allEmployeeID[count]) +
						"\t\t\t" +allEmployeeName[count] +"\n";
			}
		}
		result = result + "*************************************\n";

		return result;
	}
	
	//---------------------------------------------------------------
	// set the new name of an employee
	//---------------------------------------------------------------
	public void setName(String person)
	{
		boolean nameFound = false;
		for (int count = 0; count < allEmployeeName.length; count ++)
		{
			if (name == allEmployeeName[count])
			{
				allEmployeeName[count] = person;
				name = person;
				nameFound = true;
			}
		}
		
		if (nameFound == false)
		{
			System.out.println("Error. employee does not exsit.");
		}
	}
	
	//---------------------------------------------------------------
	// Sets the position of the employee
	//---------------------------------------------------------------
	public void setPosition(String pos)
	{
		position = pos;
	}
	
	//---------------------------------------------------------------
	//Sets the schedule of the employee
	//---------------------------------------------------------------
	public void setschedule(String sch)
	{
		schedule = sch;
	}
	
	//---------------------------------------------------------------
	// Sets the deptID of the employee
	//---------------------------------------------------------------
	public void setDeptID(int idDepart)
	{
		deptID = idDepart;
	}
	
	//---------------------------------------------------------------
	// set the employee id to a new number and changes the number 
	// in the array 
	//---------------------------------------------------------------
	protected void setID(int newID)
	{
		if (newID <= 0 || newID > 10000000 || isIDTaken(newID))
		{
			System.out.println("Invalid ID");
		}
		else
		{
			for (int count = 0; count < allEmployeeID.length; count ++)
			{
				if (ID == allEmployeeID[count])
				{
					allEmployeeID[count] = newID;
					ID = newID;
				}
			}
		}
	}
	
	//---------------------------------------------------------------
	// Sets the payRate for the employee
	//---------------------------------------------------------------
	protected void setPayRate(double newRate)
	{
		payRate = newRate;
	}
	
	//---------------------------------------------------------------
	// Next couple of methods return variable values
	//---------------------------------------------------------------
	public String getospitalName()
	{
		return hospitalName;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String getPosition()
	{
		return position;
	}
	
	public String getDepartment()
	{
		return department;
	}
	
	public String getSchedule()
	{
		return schedule;
	}
	
	public int getID()
	{
		return ID;
	}
	
	public int getDeptID()
	{
		return deptID;
	}
	
	public double getPayRate()
	{
		return payRate;
	}
	
	public static int getNumOfEmployees()
	{
		return employeeCount;
	}
	
	//---------------------------------------------------------------
	// Increases the size of the arrays if another employee is being
	// created when the array has no more slots
	//---------------------------------------------------------------
	private void increaseSize()
	{
		int[] tempID = new int[allEmployeeID.length *2];
		String[] tempName = new String[allEmployeeName.length * 2];
		
		for (int count = 0; count < allEmployeeID.length; count ++)
		{
			tempID[count] = allEmployeeID[count];
			tempName[count] = allEmployeeName[count];
		}
		
		allEmployeeID = tempID;
		allEmployeeName = tempName;
	}
	
	//---------------------------------------------------------------
	// returns a nicely formated string with every employee variable
	// contained in this class
	//---------------------------------------------------------------
	public String toString()
	{
		DecimalFormat fmtDec = new DecimalFormat("0000000");
		NumberFormat fmt = NumberFormat.getCurrencyInstance();
		String result = "\n\n****************************************";
		result = result + "***************************************\n";
		
		result = result + "**********************************"+hospitalName
				+ "*********************************\n";
		result = result + "\t\tName: "+ name +"\t\tID: "+ fmtDec.format(ID )
				+"\n";
		result = result + "__________________________________________";
		result = result + "_____________________________________\n";

		result = result + "Department: "+ department +"\t\t\t\tPosition: "
					+position +"\n";
		result = result + "Department ID: "+ deptID + "\t\t\t\t\t"
				+"Pay Rate/Hr: " + fmt.format(payRate) +"\n";
		result = result + "Schedule: "+ schedule +"\t\t\t\t";
		
		return result;
	}
}