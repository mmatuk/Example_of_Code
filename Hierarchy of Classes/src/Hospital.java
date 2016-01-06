//************************************************************************
//	Receptionist.java 							Matt Matuk
// 	CSIT 210								Project 8.2 pg 407
//	This class is the driver and create an object from each class
// six objects total and calls some class spefic methods. 
//*************************************************************************	
 

public class Hospital
{
	//---------------------------------------------------------------
	// The main method that creates the objects and calls some of the 
	// different methods that each object has. 
	//---------------------------------------------------------------
	public static void main(String[] args)
	{
		Receptionist recpt = new Receptionist("John Smith");
		Administrator admin = new Administrator("Maggie Simpson");
		Janitor jan = new Janitor("Marge Simpson");
		Doctor doc = new Doctor(25, 15, "Lisa Simpson", "S, M, T, "
				+"W, Tr, F, Sa");
		Nurse nurse = new Nurse(100, 63, "Homer Simpson", "S, M, T, "
				+"W, Tr, F, Sa");
		Surgeon surgeon = new Surgeon(10, 5, "Bart Simpson", "S, M, T, "
				+"W, Tr, F, Sa");
		
		// shows all the employees after they are first created 
		System.out.println(recpt);
		System.out.println(admin);
		System.out.println(jan);
		System.out.println(doc);
		System.out.println(nurse);
		System.out.println(surgeon);

		System.out.println("\n");
		// calls deferment methods for each object
		admin.writeSchedule();
		recpt.call();
		jan.clean();
		doc.writePrescriptions(10);
		nurse.checkPatents(5);
		surgeon.preformSurgery(5);
		surgeon.erDuty();
		doc.setPayRate(50.29);
		nurse.erDuty();

		// shows how the variables changed after the methods 
		// were called
		System.out.println(recpt);
		System.out.println(admin);
		System.out.println(jan);
		System.out.println(doc);
		System.out.println(nurse);
		System.out.println(surgeon);

		// shows all the employee names and ids 
		System.out.println("\n");
		System.out.print(HospitalEmployees.getAllID());

	}
}