//************************************************************************
//	EnterStrings.java 						Matt Matuk
// 	CSIT 210								Project 10.2 pg 462
//	1.	This class is the main diver
//	2.	The class will create the StringTooLongException object and 
//	send that object a message to be printed when the exception is throw
//	3.	The class will ask the user to enter strings until “DONE” is 
//	entered
//	4.	Terminate the program when the user enters a string longer 
//	than 20 characters and throw the exception.
//*************************************************************************	
 
import java.util.Scanner;

public class EnterStrings 
{
	public static void main(String[] args) throws StringTooLongException
	{
		String[] str = new String[500]; // hold all strings entered
		int strCount = 0;
		final int MAX = 20; // Max length of string that can be entered
		
		Scanner scan = new Scanner(System.in);
		
		// creates a new exception with a message
		StringTooLongException tooLong = new StringTooLongException("The "
				+"String entered is too long.");
		
		// intro statments
		System.out.println("Welcome to my application. Today I will be "
				+"asking you to enter strings less \nthan 20 characters in "
				+"length. To stop entering strings, enter: \"DONE\"\n");
		
		// loops untill the user entered done
		do
		{
			// asks user for string then adds the string into the array
			System.out.print("Please enter a String: ");
			str[strCount] = scan.nextLine();
			
			// throw exception if string is too long
			if (str[strCount].length() > 20)
			{
				throw tooLong;
			}
			// increase string index count if string is allowed
			//*****************may never reach this point*************
			else
			{
				strCount++;
			}
			
		}while (!(str[strCount-1].equalsIgnoreCase("done")));
		
		// prints the ending statements and all the strings entered. 
		//*********** may never reach this point******************
		System.out.println();
		System.out.println("Here are all the Strings that you entered:\n"
				+"******************************************************");
		for (int count = 0; count < strCount-1; count++)
		{
			System.out.println("String "+ (count+1) + ": \"" + str[count] + "\"");
		}
		
		System.out.println();
		System.out.println("Thank you for using my application today.");
	}
}