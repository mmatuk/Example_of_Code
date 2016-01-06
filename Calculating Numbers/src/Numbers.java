//************************************************************************
//	Numbers.java 								Matt Matuk
// 	CSIT 210								Project 10.1 pg 462
//	1.	This class will contain ten in numbers in an array
//	2.	The class will have a method for collecting 10 ints from a user
//	3.	The class will have a method to display the ten numbers and the 
//	average of the numbers 
//	4.	All methods are public and void unless otherwise noted
//	5.	All variables are protected unless otherwise noted
//*************************************************************************	
 
import java.util.Scanner;

public class Numbers
{
	protected int[] num;
	protected double avg = 0;
	
	// Constructor that sets up the int array to a size of ten
	public Numbers()
	{
		num = new int[10];
	}
	
	// This method asks the user for ten ints and adds each number to 
	// the num array
	public void collectTenNumbers()
	{
		int count = num.length;
		Scanner scan = new Scanner(System.in);
		
		// loop until all values are entered into the number array
		do
		{
			// asks user for int 
			System.out.print("Please enter number "+ (count+1) +": ");
			// trys to add value entered for user to the index location 
			// in the num array. If the value is not an int, then the 
			// exception will catch it and ask the user to re-enter the 
			// value
			try
			{
				num[count] = Integer.parseInt(scan.next());
				count++;
			}
			catch (NumberFormatException exception)
			{
				System.out.println("Error. Invalid Input. Please enter "
						+"only whole numbers.");
			}
		}while (count < 10);
		
		scan.close();
	}
	
	// Calculate the average of the num array and prints the result
	public void average()
	{
		int sum = 0;
		
		// adds all teh values in the array
		for (int count = 0; count < num.length; count ++)
		{
			sum = sum + num[count];
		}
		
		// finds the average of all values in the array
		avg = sum / num.length;
		
		// print the sum, average and all values in the array 
		String temp = "\nHere is a list of all the numbers entered and \nthe "
				+"average of the numbers:\n"
				+"Sum: " + sum + "\t\t\tAverage: " + avg +"\n";
		temp = temp + "************************************************\n";
		
		for (int count = 0; count < num.length; count++)
		{
			temp = temp + (count+1) +": "+ num[count] + "\t\t\t\t";
			if ((count + 1) % 2 == 0)
			{
				temp = temp +"\n";
			}
		}
		
		System.out.print(temp);
	}
	
	// These methods are setters and getters and a toString
	public void setNum(int index, int value)
	{
		num[index] = value;
		
	}
	
	public int getNum(int index)
	{
		return num[index];
	}
	
	public void setAvg(double value)
	{
		avg = value;
	}
	
	public double getAvg()
	{
		return avg;
	}
	
	// returns the avg and all values in num array
	public String toString()
	{
		String temp = "Average: " + avg +"\n";
		
		for (int count = 0; count < num.length; count++)
		{
			temp = temp + (count+1) + ": " + num[count] + "\n";
		}
		
		return temp;
	}
}