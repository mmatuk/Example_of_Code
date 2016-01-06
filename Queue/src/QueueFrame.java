//************************************************************************
//	QueueFrame.java 						Matt Matuk
// 	CSIT 211								Project 14.8 pg 578
//	1.	This class contains the main driver of the program.
//	2.	This class will create a frame which will contain a panel 
//	from the QueuePanel class.
//	3.	The application create will use a queue to store user 
//	input and display the contents after each operation.
//************************************************************************	

import java.awt.Dimension;

import javax.swing.JFrame;

public class QueueFrame
{
	public static void main(String[] args)
	{
		JFrame frmQueue = new JFrame("Queue");
		frmQueue.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmQueue.setMinimumSize(new Dimension(700,225));
		frmQueue.getContentPane().add(new QueuePanel());
		frmQueue.pack();
		frmQueue.setLocationRelativeTo(null);
		frmQueue.setVisible(true);
	}

}
