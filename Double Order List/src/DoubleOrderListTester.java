//************************************************************************
//	DoubleOrderListTester.java 						Matt Matuk
// 	CSIT 211								Project 15.14 pg 578
//	1.	This class will test the implementation of the double linked 
//	ordered list class
// 	2.	This class will create a couple of items for the list and then
//	make some changes on those items to show that the implementation of 
//	the double linked ordered list works
//************************************************************************	

public class DoubleOrderListTester 
{
	public static void main(String[] args) throws Exception
	{
		DoubleOrderList<String> test = new DoubleOrderList<String>();
		System.out.println("Welcome to my application.\n"
		 		+ "I will be showing you a implemented Double Linked Ordered"
		 		+ "List.");
		 System.out.println();
		 
		test.add("Zoo");
		test.add("Abc");
		test.add("Ball");
		test.add("#123");
		test.add("I want a cookie.");
		test.add("Something else.");
		test.add("I do not know");
		test.add("Testing");
		
		System.out.println("**Before Changes**\n"
				+ "---------------------------------\n"
				+ "Here is the contents of the list:\n"
				+ test
				+ "\n---------------------------------");
		
		test.remove("I want a cookie.");
		test.removeFirst();
		
		System.out.println();
		System.out.println("**Removed \"I want a cookie.\" and removed first item.**\n"
				+ "---------------------------------\n"
				+ "Here is the contents of the list:\n"
				+ test
				+ "\n---------------------------------");
		
		test.add("Something else");
		test.add("This is an element in the list");
		
		System.out.println();
		System.out.println("**Added two new Strings**\n"
				+ "---------------------------------\n"
				+ "Here is the contents of the list:\n"
				+ test
				+ "\n---------------------------------");
	}

}
