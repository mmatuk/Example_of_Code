//************************************************************************
//	FrameDoubleLinkedList.java 						Matt Matuk
// 	CSIT 211								Project 12.9 pg 516
//	1.	This class creates a new PanelDoubleOderList and frame 
//	for the application
//	2.	This class is the main driver class
//************************************************************************	
 
import java.awt.Dimension;
import javax.swing.JFrame;

public class FrameDoubleLinkedList
{
	public static void main(String[] args)
	{
		JFrame frmStack = new JFrame("Double Linked Ordered Stack");
		frmStack.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmStack.setMinimumSize(new Dimension(450,300));
		frmStack.setBounds(100, 100, 450, 300);
		frmStack.getContentPane().add(new PanelDoubleLinkedList());
		
		frmStack.pack();
		frmStack.setVisible(true);
		
	}
}