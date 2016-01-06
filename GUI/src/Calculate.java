//************************************************************************
//	Calculate.java 							Matt Matuk
// 	CSIT 210								Project 6.9 pg 335
//	This class is the drivewr class for the Class CalculatePanel.
// 	The class will have a frame that hold a text area and button 
//	that will allow the user to enter two int and calculate the 
//	sum and product of the ints. 
//*************************************************************************	


import javax.swing.JFrame;

public class Calculate
{
	//------------------------------------------------------------------
	// This method sets up the frame and creates the calculatePanel 
	// object. Also sets the frame to the center of the screen. 
	//------------------------------------------------------------------

	public static void main(String[] args)
	{
		JFrame frame = new JFrame ("Calculate");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		frame.getContentPane().add(new CalculatePanel());
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		
	}
}