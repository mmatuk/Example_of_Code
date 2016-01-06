//************************************************************************
//	Doctor.java 							Matt Matuk
// 	CSIT 210								Project 8.2 pg 407
//	This class extends the MedicalDepartment class and allows 
//	any object create from this class to have all the parent
//	class methods and variables. The class is not abstract and  
//	can have objects create from it. The Doctor class has the
//	Num of Prescriptions variable the no other class has. A 
//	Doctor can write prescriptions. 
//*************************************************************************	
 
public class Doctor extends MedicalDepartment
{
	protected int numOfPrescriptions;
	
	//---------------------------------------------------------------
	// this class creates the object by calling the parent constructor
	// and sets the remaining variables. This constructor also needs
	// to be passed the values for prescriptions, patents, name , and 
	// schedule
	//---------------------------------------------------------------
	public Doctor(int num, int pre, String name, String sch)
	{
		super(name);
		numOfPrescriptions = pre;
		position = "Doctor\t";
		numOfPatents = num;
		erDuty = false;
		schedule = sch;
		payRate = 30.63;
	}
	
	//---------------------------------------------------------------
	// sets the number of prescriptions to write to the number 
	// before - the number passed to the method
	//---------------------------------------------------------------
	public void writePrescriptions(int num)
	{
		numOfPrescriptions = numOfPrescriptions - num;
		System.out.println(name +" wrote "+ num +" prescriptions.");
	}
	
	//---------------------------------------------------------------
	// sets the number of prescriptions
	//---------------------------------------------------------------
	public void setNumOfPrescriptions(int num)
	{
		numOfPrescriptions = num;
	}
	
	//---------------------------------------------------------------
	// returns the number of prescription 
	//---------------------------------------------------------------
	public int getNumOfPrescriptions()
	{
		return numOfPrescriptions;
	}
	
	//---------------------------------------------------------------
	// returns a nicely formated string that adds onto the bottom
	// of the string from the parent class
	//---------------------------------------------------------------
	public String toString()
	{
		String result = super.toString();
		result = result + "# of Prescriptions: " + numOfPrescriptions;
		
		return result;
	}

}
