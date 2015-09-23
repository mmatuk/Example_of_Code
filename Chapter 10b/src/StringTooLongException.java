//************************************************************************
//	StringTooLongException.java 			Matt Matuk
// 	CSIT 210								Project 10.2 pg 462
//	1.	This class will contain a new exception
//	2.	The class is used when a string has too many character and 
//	that class throws this exception.
//*************************************************************************	
 
public class StringTooLongException extends Exception
{
	public StringTooLongException(String message)
	{
		super(message);
	}
}