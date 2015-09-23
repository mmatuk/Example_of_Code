//************************************************************************
//	PanelStack.java 						Matt Matuk
// 	CSIT 211								Project 12.9 pg 516
//	1.	This class will contain the method that will create all 
//	the components of the panel for the frame
//	2.	Make sure when creating the window, that it looks similar 
//	to the GUI storyboard. Color and exact size can change.
//	3.	Multiple methods will be used to add and remove strings 
//	from the stack
//	4.	All methods are public and void unless otherwise stated
//************************************************************************	
 
import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.text.BadLocationException;
import javax.swing.text.Utilities;
import java.awt.*;
import java.awt.event.*;
import java.util.Stack;

public class PanelStack extends JPanel {
	private JTextField txtFieldUserInput;
	protected JButton btnPop, btnPush;
	protected Stack<String> userStack = new Stack<String>();
	protected JTextArea txtAreaStack;

	//-------------------------------------------------------------------
	// This method create all the panels and layouts for the application.
	// This method also sets any listeners and creates the view.
	//-------------------------------------------------------------------
	public PanelStack() {
		setBorder(new TitledBorder(null, "Stack", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		JPanel panel = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel, 0, SpringLayout.NORTH, this);
		springLayout.putConstraint(SpringLayout.WEST, panel, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel, -30, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel, 0, SpringLayout.EAST, this);
		add(panel);
		
		JPanel panel_1 = new JPanel();
		springLayout.putConstraint(SpringLayout.NORTH, panel_1, 0, SpringLayout.SOUTH, panel);
		SpringLayout sl_panel = new SpringLayout();
		panel.setLayout(sl_panel);
		
		JPanel panel_2 = new JPanel();
		sl_panel.putConstraint(SpringLayout.NORTH, panel_2, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.WEST, panel_2, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, panel_2, -22, SpringLayout.SOUTH, panel);
		panel.add(panel_2);
		
		JLabel lblUserString = new JLabel("Please enter your string here.");
		sl_panel.putConstraint(SpringLayout.NORTH, lblUserString, 6, SpringLayout.SOUTH, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, lblUserString, 106, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.EAST, lblUserString, -95, SpringLayout.EAST, panel);
		panel.add(lblUserString);
		
		JTextArea txtAreaIntro = new JTextArea();
		sl_panel.putConstraint(SpringLayout.NORTH, txtAreaIntro, 10, SpringLayout.NORTH, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtAreaIntro, -6, SpringLayout.NORTH, lblUserString);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -6, SpringLayout.WEST, txtAreaIntro);
		sl_panel.putConstraint(SpringLayout.WEST, txtAreaIntro, 227, SpringLayout.WEST, panel);
		txtAreaIntro.setLineWrap(true);
		txtAreaIntro.setBackground(SystemColor.menu);
		sl_panel.putConstraint(SpringLayout.EAST, txtAreaIntro, -10, SpringLayout.EAST, panel);
		txtAreaIntro.setWrapStyleWord(true);
		txtAreaIntro.setEditable(false);
		txtAreaIntro.setText("Welcome to my application. Today you will be "
				+ "entering a string at that bottom of the page and then "
				+ "press PUSH or POP to either add or remove the string from "
				+ "your stack. The contents of your stack will be displayed to the left.");
		panel.add(txtAreaIntro);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JLabel lblStack = new JLabel("Here is the contents of your stack:");
		lblStack.setAlignmentX(Component.CENTER_ALIGNMENT);
		lblStack.setAlignmentY(Component.TOP_ALIGNMENT);
		panel_2.add(lblStack);
		sl_panel.putConstraint(SpringLayout.NORTH, lblStack, 0, SpringLayout.NORTH, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, lblStack, 30, SpringLayout.EAST, panel_2);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		panel_2.add(verticalStrut);
		
		txtAreaStack = new JTextArea();		
		JScrollPane scrollPane = new JScrollPane(txtAreaStack);
		panel_2.add(scrollPane);
		sl_panel.putConstraint(SpringLayout.WEST, txtAreaStack, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtAreaStack, -6, SpringLayout.NORTH, lblUserString);
		txtAreaStack.setWrapStyleWord(true);
		txtAreaStack.setEditable(false);
		sl_panel.putConstraint(SpringLayout.EAST, txtAreaStack, -6, SpringLayout.WEST, txtAreaIntro);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, this);
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut);
		
		btnPush = new JButton("PUSH");
		panel_1.add(btnPush);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1);
		
		txtFieldUserInput = new JTextField();
		panel_1.add(txtFieldUserInput);
		txtFieldUserInput.setColumns(10);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2);
		
		btnPop = new JButton("POP");
		panel_1.add(btnPop);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3);

		ButtonListener listener = new ButtonListener();
		btnPop.addActionListener(listener);
		btnPush.addActionListener(listener);
	}
	
	private class ButtonListener implements ActionListener
	{
		//-------------------------------------------------------------------
		// This method handles the button clickes
		//-------------------------------------------------------------------
		public void actionPerformed(ActionEvent event) 
		{
			if (event.getSource() == btnPop)
			{
				btnPop();
			}
			else
			{
				btnPush();
			}
			
			// returns teh text area back to the top after each action
			txtAreaStack.setCaretPosition(0);
		}
		
		//-------------------------------------------------------------------
		// When the user pushes the PUSH button, the text entered in the 
		// text field is placed at the top of the text area txtAreaStack
		// using the top string in the stack.
		//-------------------------------------------------------------------
		private void btnPush()
		{
			if (!txtFieldUserInput.getText().equalsIgnoreCase(""))
			{		
				if (txtAreaStack.getText().equalsIgnoreCase("empty:"))
				{
					txtAreaStack.setText("");
				}
				userStack.push(txtFieldUserInput.getText());
				txtFieldUserInput.setText("");
				
				try
				{
					// inserts the string entered at the top of all the text in 
					// txtAreaStack
					txtAreaStack.getDocument().insertString(0, userStack.peek()+"\n", null);
				}
				catch (BadLocationException e)
				{
					e.printStackTrace();
				}
			}
		}
		
		//-------------------------------------------------------------------
		// When the user presses the POP button, the the top string in the 
		// stack is removed and then the top line in the txtAreaStack is removed
		//-------------------------------------------------------------------
		private void btnPop()
		{
			if (userStack.empty() != true)
			{
				userStack.pop();

				try
				{	
					txtAreaStack.getDocument().remove(0, 
							Utilities.getRowEnd(txtAreaStack, 0)+1);
				}
				catch (BadLocationException e)
				{
					e.printStackTrace();
				}
			}	
			// sets Text area to empty if stack is emtpy
			if (userStack.empty()) 
			{
				txtAreaStack.setText("EMPTY:");
			}
		}
	}
}
