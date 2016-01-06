//************************************************************************
//	CalculatePanel.java 							Matt Matuk
// 	CSIT 210								Project 6.9 pg 335
//	This Class will set up the text area and button to display for
//	the user. The text area will contain the intro and exit statements.
//	The button will allow the user to enter two ints and 
//	display the sum and product of the two ints using dialog boxes.
//*************************************************************************	

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


@SuppressWarnings("serial")
public class CalculatePanel extends JPanel
{
	protected JButton btnBegin;
	protected JLabel beginLabel;
	protected JTextArea textArea;
	protected final String FIRST = "Please enter the first number: ";
	protected final String Second = "Please enter the second number: ";
	protected final String MORE = "Would you like to try two new number?";
	protected String sumResult, productResult;
	protected int numOne = 0;
	protected int numTwo = 0;
	protected int again = 300;
	protected JPanel btnPanel;
	
	//------------------------------------------------------------------
	// The method sets up all the panels for the frame. The text area
	// and the button with the label are all set up in this method
	//------------------------------------------------------------------

	public CalculatePanel()
	{
		setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		setBackground(Color.LIGHT_GRAY);
		
		// Create a new button and Button Listener object
		btnBegin = new JButton("Begin");
		ButtonListener listener = new ButtonListener();
		btnBegin.addActionListener(listener);
		
		// Creates the text area that will display all the user input
		textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setSize(500,250);
		textArea.setLineWrap(true);
		textArea.setWrapStyleWord(true);
		textArea.setBorder(BorderFactory.createTitledBorder("Processing"));
		// Sets up a scroll pane for the text area
		JScrollPane scrollPane = new JScrollPane(textArea);
		scrollPane.setVerticalScrollBarPolicy ( 
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );
		
		// Label for the button
		beginLabel = new JLabel("Press Begin to start your calculations");
		
		// Creates teh Begin button that when pressed, The dialog 
		// boxs will pop up that ask the user for input
		btnPanel = new JPanel();
		btnPanel.setLayout(new BoxLayout(btnPanel, BoxLayout.X_AXIS));
		btnPanel.setPreferredSize(new Dimension(500,40));
		btnPanel.setBackground(this.getBackground());
		btnPanel.add(beginLabel);
		btnPanel.add(Box.createRigidArea(new Dimension(20,0)));
		btnPanel.add(btnBegin);
		btnPanel.setAlignmentX(RIGHT_ALIGNMENT);
		
		// Adds the text area to the top and the button Panel to the 
		// bottom
		setPreferredSize(new Dimension(500,250));
		add(scrollPane);
		add(btnPanel);
		
		
		// Displays the intro statements in the intro() method
		intro();
		
		//-----------------------Debug------------------
		//System.out.print("Here End of Constructor");
		//-----------------------Debug------------------

	}
	
	//------------------------------------------------------------------
	// Introduction statements that are displayed when the program first
	// starts
	//------------------------------------------------------------------
	protected void intro()
	{
		textArea.append("Welcome to my application.\n");
		textArea.append("Today I will be asking you for two whole numbers "
				+"and will display the sum and product of the two numbers.\n");
		
	}
	
	//------------------------------------------------------------------
	// Ending statements that are displayed when the user clicks no 
	// after they entered the input
	//------------------------------------------------------------------
	protected void ending()
	{
		textArea.append("\nThank you for using my application.\n\n");
		textArea.append("P.S. Do you think my code is any good??");
	}
	
	//------------------------------------------------------------------
	// This method makes sure the user enters olny whole numbers for 
	// the input
	//------------------------------------------------------------------

	public int verifyInt(String message)
	{
		int num = 0;
		Boolean error = true;
		
		// Loops while the user keeps entering something other than 
		// a whole number
		do
		{
			// displays the input dialog box with the proper message
			// that was passed as the parameter
			String testUserInput = JOptionPane.showInputDialog(textArea,
					message);
			
			// if user does not enter and input but still pushes ok
			// This message will they the user they did not enter any 
			// input
			if (testUserInput.matches(""))
			{
				JOptionPane.showMessageDialog(textArea, 
						"Your entered no input!");
			}
		
			else
			{
				// Will try to set num will the value that the user 
				// entered. If the value is anything other than a whole
				// number, then the exception will be caught and a 
				// message will be displayed. 
				try
				{
					num = Integer.parseInt(testUserInput);
					error = false;
				}
				catch (Exception exception)
				{
					JOptionPane.showMessageDialog(textArea, "Invalid "
							+"Input. Please enter only whole numbers.");
				}
			}
		}while (error == true);
		
		
		return(num);
	}
	
	//------------------------------------------------------------------
	// This class is for the Begin button and will run when the user 
	// pushes Begin. The user will be asked to enter two ints and 
	// then the sum and product will be displayed. The user will then
	// be asked if they want to try again. 
	//------------------------------------------------------------------
	protected class ButtonListener implements ActionListener
	{
		public void actionPerformed (ActionEvent event)
		{
			
			if (event.getSource() == btnBegin)
			{
				// Loops while the user wants to try two more numbers
				do
				{
					// The try statement will end the dialog boxes 
					// if the user clicks the X or cancel buttons. 
					// during the input and messages. 
					try{
						
					// uses the verfiyInt method to make sure the user 
					// only entered whhole numbers, then returns that 
					// value as numOne and numTwo
						
					numOne = verifyInt(FIRST);
					numTwo = verifyInt(Second);
					
					// Calculates the message for sum and product then
					// displays the message with the message dialog
					// box
					sumResult = "The sum of "+ numOne +" plus "+ numTwo 
							+" is equal to "+ (numOne + numTwo);
					productResult = "The product of "+ numOne +" times "
							+ numTwo +" is equal to "+ (numOne * numTwo);
					
					JOptionPane.showMessageDialog(textArea, (sumResult
							+"\n"+ productResult));
					
					// Adds what the user entered to the text area so 
					// they can see what they entered after the process 
					// done 
					textArea.append("\nYour numbers are: "+ numOne +" & "
							+numTwo +"\n");
					textArea.append(sumResult +"\n");
					textArea.append(productResult +"\n");
					
					// asks the user if they want to try two more numbers
					// and loops if they select yes
					again = JOptionPane.showConfirmDialog(textArea, MORE);
					//-----------------------Debug------------------
					//System.out.print(again);
					//-----------------------Debug------------------

					}
					// ends the loop if the user clicks cancel at any time
					catch(Exception exception)
					{
						again = 1;
					}
				}while (again == JOptionPane.YES_OPTION);
				
				// Prints the ending statments
				ending();
			}
		}
	}
}