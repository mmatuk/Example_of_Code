//************************************************************************
//	Task.java 								Matt Matuk
// 	CSIT 210								Project 9.6 pg 438
//	1.	This class contains the info for a task to be completed
//	2.	The class will have two methods for setting and getting priority 
//	3.	All methods are public and void unless otherwise noted
//	4.	This class will have a number priority from 1-3 with 3 being 
//	the highest
//*************************************************************************	
 
public class Task implements Priority
{
	protected int time;
	private int priority; // set to 1, 2, 3 (3 is the highest)
	protected String name;
	
	// creates the task and sets the name and description and calles the 
	// set priority and sets the priority by the time
	public Task(String tName, int timeMin)
	{
		name = tName;
		time = timeMin;
		setPriority(0);
	}
	
	// set the priority of the object. 1-3 with 3 being the highest 
	// priority. the priority can be set by time when passing 0
	public void setPriority(int num)
	{
		if (num == 1 || num == 2 || num ==3)
		{
			priority = num;
		}
		else 
		{
			if (num == 0)
			{
				if (time <= 30)
				{
					priority = 3;
				}
				else 
				{
					if (time > 30 && time <= 60)
					{
						priority = 2;
					}
					else
					{
						priority = 1;
					}
				}
			}
		}
	}
	
	public int getPriority()
	{
		return priority;
	}
	
	// returns a Task[] that is shorted by priority with 3 being first
	public static Task[] sortAllTasks(Task[] all)
	{
		Task[] temp = new Task[all.length];
		
		// this is for the first index only
		temp[0] = all[0];
		
		// this is for the other index locations
		for (int count = 1; count < all.length; count++)
		{
			if (all[count] != null)
			{
				// loops threw the temp array and compares the all array count index priority
				for (int tempCount = 0; tempCount < temp.length; tempCount++)
				{
					try
					{
						if (all[count].getPriority() > temp[tempCount].getPriority())
						{
							// moves all the objects down one spot than puts the current
							// object being checked into the top spot
							for (int num = temp.length; num > tempCount+1; num--)
							{
								temp[num-1] = temp[num-2];
							}
							temp[tempCount] = all[count];
							break;
						}
					} catch (NullPointerException exception)
					{
						// this is for when the index is empty 
						temp[tempCount] = all[count];
						break;
					}
				}
			}
		}
		
		return temp;
	}
	
	// returns a string that prints each item in the passed array
	public static String printAllTask(Task[] all)
	{
		String result = "Here is the list of all of your tasks:\n";
		result = result + "Name\t\tT/Min\t\tPriority\n";
		result = result + "********************************************\n";
		
		for (int count = 0; count < all.length; count++)
		{
			if (all[count] != null)
			{
				result = result + all[count].toString() + "\n";
			}
			/*//---------------debug---------
			else 
			{
				result = result + "null";
			}
			//--------------------------------*/
		}
		
		return result;
	}
	
	public void setTime(int num)
	{
		time = num;
	}
	
	public int getTime()
	{
		return time;
	}
	
	public void setName(String str)
	{
		name = str;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name + "\t" + time + "\t\t" + priority;
	}
}