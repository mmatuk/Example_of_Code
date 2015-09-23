//************************************************************************
//	Average.java 								Matt Matuk
// 	CSIT 210								Project 10.1 pg 462
//	1.	This class contains the main method of the program
//	2.	This class will supply the intro and ending statements 
//	3.	This class will call the collectTenNumbers() and the average() 
//	methods
//*************************************************************************	

public class Average
{
	public static void main(String[] args)
	{
		System.out.println("Welcome to my application today. I am going "
				+"to ask you to enter ten whole \nnumbers and then I will "
				+"display the average of those numbers.");
		System.out.println();
		
		// creates the object an calls the to methods to collect and display
		// the ten ints
		Numbers avg = new Numbers();
		avg.collectTenNumbers();
		avg.average();
		
		System.out.println("Thank you for using my application today.");
	}
}