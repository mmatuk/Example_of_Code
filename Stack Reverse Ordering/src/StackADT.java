//************************************************************************
//	StackADT.java 						Matt Matuk
// 	CSIT 211								Project 13.5 pg 546
//	1.	This is a interface for a StackADT
//	2.	All methods are public
//*************************************************************************	
 
public interface StackADT<T>
{
	public void push(T element);
	public T pop();
	public T peek();
	public boolean isEmpty();
	public int size();
	public String toString();
}
