//************************************************************************
//	LinkedStack.java 						Matt Matuk
// 	CSIT 211								Project 13.5 pg 546
//	1.	Creates a linked stack  by using the StackADT interface and 
//	the LinkedNode class. A linked stack uses references to other 
//	elements.
//*************************************************************************	
 
import java.util.EmptyStackException;

public class LinkedStack<T> implements StackADT<T>
{
	private int count;
	private LinearNode<T> top;
	
	public LinkedStack()
	{
		count = 0;
		top = null;
	}
	
	public void push(T element) 
	{	
		LinearNode<T> temp = new LinearNode<T>(element);
		
		temp.setNext(top);
		top = temp;
		count++;
	}

	public T pop() throws EmptyStackException
	{
		if (isEmpty())
		{
			throw new EmptyStackException();
		}
		
		T result = top.getElement();
		top = top.getNext();
		count--;
		
		return result;
	}

	public T peek() 
	{
		return top.getElement();
	}

	public boolean isEmpty() 
	{
		return (count == 0 ? true : false);
	}

	public int size() 
	{
		return count;
	}
	
	public String toString()
	{
		String result = "[";
		boolean done = false;
		LinearNode<T> temp = new LinearNode<T>();
		temp = top;
		
		while (done == false)
		{
			if (temp.getNext() != null)
			{
				result = result + temp.getElement() + ", ";
				temp = temp.getNext();
			}
			else 
			{
				done = true;
				result = result + temp.getElement() + "]";
			}
		}
		
		return result;
	}
}
