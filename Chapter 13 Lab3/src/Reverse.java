//************************************************************************
//	Reverse.java 						Matt Matuk
// 	CSIT 211								Project 13.5 pg 546
//	1.	This class contains the main method of the application.
//	2.	This class will create a ReverseOrder object and call 
//	the reverseSentance() method to reverse the order of each 
//	word in a sentence.
//	3.	Make sure anything that is printed looks nicely formatted.
//*************************************************************************	
 
import java.util.Scanner;

public class Reverse
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		ReverseOrder reverOrder = new ReverseOrder();
		String reverse;
		String in;
		
		System.out.println("Welcome to my application. \n"
				+ "Today you will enter a sentance and then I "
				+ "will print that sentance with each word "
				+ "backwords.");
		System.out.println();
		
		System.out.println("Please enter a sentance to reverse "
				+ "the order of each word.");
			in = scan.nextLine();

		reverse = reverOrder.reverseSentance(in);
		System.out.println();

		System.out.println("Here is the sentance with each word "
				+ "backwords.");
		System.out.println(reverse);
		
		System.out.println();
		System.out.println("Thank you for using my application "
				+ "today.");
	}
}
