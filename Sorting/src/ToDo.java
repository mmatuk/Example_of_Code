//************************************************************************
//	ToDo.java 								Matt Matuk
// 	CSIT 210								Project 9.6 pg 438
//	1.	This class is the driver class
//	2.	The class will create an array of tasks and ad each newly 
//	created task tot the array
//	3.	The shortAllTask method from Task class will be called and the 
//	toDo array will be passed. 
//	4.	Use the set priority on some object to change the priority of 
//	the object
//*************************************************************************	
 
public class ToDo
{
	public static void main(String[] args)
	{
		Task[] toDo = new Task[4];
		
		// intro statements
		System.out.println("Welcome to my application today. \n"
				+"I will be setting up some tasks for you to do with a time "
				+"and a priority");
		System.out.println("\nHere are some tasks:\n"
				+ "Task\t\tTime\t\tPriority\n"
				+ "********************************************");
		
		// Creates the four tasks and adds each one into the toDo array
		Task cleanDishes = new Task("Clean Dishes", 70);
		toDo[0] = cleanDishes;
		System.out.println(cleanDishes);
		
		Task cutGrass = new Task("Cut Grass", 30);
		toDo[1] = cutGrass;
		System.out.println(cutGrass);
		
		Task walkDog = new Task("Walk Dog", 45);
		toDo[2] = walkDog;
		System.out.println(walkDog);
		
		Task makeBed = new Task("Make Bed", 10);
		toDo[3] = makeBed;
		System.out.println(makeBed);
		
		System.out.println();
		
		// prints all tasks 
		System.out.println(Task.printAllTask(toDo));

		// uses the method to short all tasks by priority 3 being the highest
		// the priority is based on the time it task to complete
		toDo = Task.sortAllTasks(toDo);
		
		// prints all tasks
		System.out.println(Task.printAllTask(toDo));
		
		// manually changes the priority
		makeBed.setPriority(1);
		cleanDishes.setPriority(3);
		toDo = Task.sortAllTasks(toDo);
		
		// prints all tasks after changing the priority
		System.out.println(Task.printAllTask(toDo));
		
		System.out.println("Thank you for using my application today.");
	}
}