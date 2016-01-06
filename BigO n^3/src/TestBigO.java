//************************************************************************
//	TestBigO.java 						Matt Matuk
// 	CSIT 211							Project Trend 1 Big O
//	This program will test and show how efficient O(n^3) is.
//	The program will by multiplying two arrays together to 
//	show the difference.
//************************************************************************	
 
import java.util.Random;

public class TestBigO 
{
	static long startTime;
	static long endTime;
	static int[][] array1Size100 = new int[100][100];
	static int[][] array2Size100 = new int[100][100];
	static int[][] array1Size200 = new int[200][200];
	static int[][] array2Size200 = new int[200][200];
	static int[][] array1Size1000 = new int[1000][1000];
	static int[][] array2Size1000 = new int[1000][1000];
	static int[][] arrayMul;
	static int sum = 0;

	//--------------------------------------------------------------------
	// Creates the siz arrays of diffent sizes and calls the method to add
	// values in each array and calls teh method to multiply the arrays
	//--------------------------------------------------------------------
	public static void main(String[] args)
	{
		System.out.println("Array 100 size:");
		populateArray(array1Size100);
		populateArray(array2Size100);
		multiplyArrays(array1Size100, array2Size100);
		
		System.out.println("Array 200 size:");
		populateArray(array1Size200);
		populateArray(array2Size200);
		multiplyArrays(array1Size200, array2Size200);
		
		System.out.println("Array 1000 size:");
		populateArray(array1Size1000);
		populateArray(array2Size1000);
		multiplyArrays(array1Size1000, array2Size1000);
	}
	
	//--------------------------------------------------------------------
	// Hows how the Cubic Big O works by using three for loop nested inside
	// each other. The program will increase by eightfold for each double 
	// of N. 
	//--------------------------------------------------------------------
	public static void multiplyArrays(int[][] array1, int[][] array2)
	{
		startTime = System.currentTimeMillis();
		arrayMul = new int[array1.length][array1.length];
		
		for (int loop1 = 0; loop1 < array1.length; loop1++)
		{
			for (int loop2 = 0; loop2 < array2.length; loop2++)
			{
				for (int loop3 = 0; loop3 < array2.length; loop3++)
				{
					sum = sum + array1[loop1][loop3] * array2[loop3][loop2];
				}
				arrayMul[loop1][loop2] = sum;
				sum = 0;
			}
		}
		endTime = System.currentTimeMillis();
		//prints the product of the multiplying
		//System.out.println(arrayToString(arrayMul));
		System.out.println("The process took: " + (endTime-startTime)*.001
				+ " Seconds.");
		System.out.println();
	}
	
	//--------------------------------------------------------------------
	// Adds random numbers to the array the is passed
	//--------------------------------------------------------------------
	public static void populateArray(int[][] array)
	{
		Random gen = new Random(); 
		for (int row = 0; row < array.length; row++)
		{
			for (int col = 0; col < array.length; col++)
			{
				array[row][col] = gen.nextInt(100);
			}
		}
	}
	
	//--------------------------------------------------------------------
	// returns a string with the contents of the passed array.
	//--------------------------------------------------------------------
	public static String arrayToString(int[][] array)
	{
		String result = "";
		
		for (int row = 0; row < array.length; row++)
		{
			for (int col = 0; col < array.length; col++)
			{
				result = result + array[row][col] + ", "; 
			}
			result = result + "\n";
		}
		return result;
	}
}
