//************************************************************************
//	Receptionist.java 							Matt Matuk
// 	CSIT 210								Project 8.2 pg 407
//	This class extends the AdminDepartment class and allows 
//	any object create from this class to have all the parent
//	class methods and variables. The class is not abstract and  
//	can have objects create from it. 
//*************************************************************************	
 

public class Receptionist extends AdminDepartment
{
	protected boolean callClients;
	
	//---------------------------------------------------------------
	// create the object with the contructor class and sets the 
	// variables. also calls the parent class contructor and passes 
	// the name. 
	//---------------------------------------------------------------
	public Receptionist(String name)
	{
		super(name);
		payRate = 10.00;
		position = "Receptionist";
		schedule = "M, T, W, Tr, F, Sa";
		callClients = true;
	}
	
	//---------------------------------------------------------------
	// Set CallClients to true when this method is called
	//---------------------------------------------------------------
	public void call()
	{
		callClients = false;
		System.out.println(name + " has called all the clients.");
	}
	
	//---------------------------------------------------------------
	// sets callClients
	//---------------------------------------------------------------
	public void setCallClients(boolean value)
	{
		callClients = value;
	}
	
	//---------------------------------------------------------------
	// returns call clients
	//---------------------------------------------------------------
	public boolean getCallClients()
	{
		return callClients;
	}
	
	//---------------------------------------------------------------
	// returns a nicely formated string that adds onto the bottom
	// of the string from the parent class
	//---------------------------------------------------------------
	public String toString()
	{
		String result = super.toString();
		result = result +" Call Clients: " 
				+ ((callClients) ? "YES" : "NO");
		return result;
	}
}