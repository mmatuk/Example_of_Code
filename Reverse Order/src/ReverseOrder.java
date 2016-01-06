//************************************************************************
//	ReverseOrder.java 						Matt Matuk
// 	CSIT 211								Project 10.7 pg 463
//	1.	This class will accept a string and return that string with 
//	the words backwards.
//	2.	The class will use a stack to reverse the order of the 
//	words.
//	3.	All variables are protected unless otherwise noted
//	4.	All methods are public and void unless otherwise noted
//*************************************************************************	
 
import java.util.Stack;

public class ReverseOrder
{
	protected String sen;
	protected Stack<String> reverse;
	
	public ReverseOrder()
	{
	}
	
	//-------------------------------------------------------------------
	// This method is where the passed string is reverse word by word.
	//-------------------------------------------------------------------
	public String reverseSentance(String sentance)
	{
		sen = sentance;
		reverse = new Stack<String>();
		String result = "";
		//****************Debug**************
		//System.out.println(sen);
		//***********************************
		
		// loops thru each character in the string
		for (int count = 0; count<sen.length(); count++)
		{
			// if the character equals a space, then the stack is poped
			// until its empty. 
			if (sen.substring(count,count+1).equalsIgnoreCase(" "))
			{
				result = result + pop(reverse.size(), true);
			}
			// each character is added to the stack until a space is 
			// reached, then the stack is poped to the result string.
			else
			{
				reverse.push(sen.substring(count,count+1));
			}
		}
		
		// this is for the end of the sentance to clear the last word.
		result = result + pop(reverse.size(),false);
		
		return result;
	}
	
	//-------------------------------------------------------------------
	// This method pops the stack clear by looping the size of teh stack
	//-------------------------------------------------------------------
	private String pop(int times, boolean space)
	{
		String result = "";
		for (int num = 0; num<times; num++)
		{
			result = result + reverse.pop();
		}
		if (space)
		{
			result = result + " ";
		}
		
		return result;
	}
	

	
}