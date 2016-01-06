//************************************************************************
//	LinearNode.java 						Matt Matuk
// 	CSIT 211								Project 13.5 pg 546
//	1.	This class creates a generic element and also creates a new 
//	node for the next element 
//	2.	The class uses nodes to point to each other instead of using 
//	the actually elements
//	3.	All variables are private
//	4.	All method are public and void unless otherwise stated
//*************************************************************************	
 

public class LinearNode<T> 
{
	private LinearNode<T> next;
	private T element;
	
	public LinearNode()
	{
		next = null;
		element = null;
	}
	
	public LinearNode(T elem)
	{
		next = null;
		element = elem;
	}
	
	public LinearNode<T> getNext()
	{
		return next;
	}
	
	public void setNext(LinearNode<T> node)
	{
		next = node;
	}
	
	public T getElement()
	{
		return element;
	}
	
	public void setElement(T elem)
	{
		element = elem;
	}
}
