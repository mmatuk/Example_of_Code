//************************************************************************
//	PanelDoubleLinkedList.java 						Matt Matuk
// 	CSIT 211								Project 15.15 pg 516
//	1.	This class will contain the method that will create all 
//	the components of the panel for the frame
//	2.	Make sure when creating the window, that it looks similar 
//	to the GUI storyboard. Color and exact size can change.
//	3.	Multiple methods will be used to add and remove strings 
//	from the double linked ordered list
//	4.	All methods are public and void unless otherwise stated
//************************************************************************	
 
import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.NoSuchElementException;

@SuppressWarnings("serial")
public class PanelDoubleLinkedList extends JPanel 
{
	private JTextField txtFieldUserInput;
	protected JButton btnRemove, btnAdd;
	protected DoubleOrderList<String> list = new DoubleOrderList<String>();
	protected JTextArea txtAreaList;
	protected JPanel panel;

	//-------------------------------------------------------------------
	// This method create all the panels and layouts for the application.
	// This method also sets any listeners and creates the view.
	//-------------------------------------------------------------------
	public PanelDoubleLinkedList() 
	{
		setBorder(new TitledBorder(null, "List", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		
		panel = new JPanel();
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
		sl_panel.putConstraint(SpringLayout.WEST, txtAreaIntro, 225, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtAreaIntro, -6, SpringLayout.NORTH, lblUserString);
		sl_panel.putConstraint(SpringLayout.EAST, panel_2, -6, SpringLayout.WEST, txtAreaIntro);
		txtAreaIntro.setLineWrap(true);
		txtAreaIntro.setBackground(SystemColor.menu);
		sl_panel.putConstraint(SpringLayout.EAST, txtAreaIntro, -10, SpringLayout.EAST, panel);
		txtAreaIntro.setWrapStyleWord(true);
		txtAreaIntro.setEditable(false);
		txtAreaIntro.setText("Welcome to my application. Today you will be "
				+ "entering a string at that bottom of the page and then "
				+ "press ADD or REMOVE to either add or remove the string from "
				+ "your ordered list. The contents of your ordered list will be "
				+ "displayed to the left.");
		panel.add(txtAreaIntro);
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		
		JLabel lblList = new JLabel("Here is the contents of your list:      ");
		lblList.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblList.setAlignmentX(Component.CENTER_ALIGNMENT);
		panel_2.add(lblList);
		sl_panel.putConstraint(SpringLayout.NORTH, lblList, 0, SpringLayout.NORTH, panel_2);
		sl_panel.putConstraint(SpringLayout.WEST, lblList, 30, SpringLayout.EAST, panel_2);
		
		Component verticalStrut = Box.createVerticalStrut(5);
		panel_2.add(verticalStrut);
		
		txtAreaList = new JTextArea();		
		JScrollPane scrollPane = new JScrollPane(txtAreaList);
		panel_2.add(scrollPane);
		sl_panel.putConstraint(SpringLayout.WEST, txtAreaList, 10, SpringLayout.WEST, panel);
		sl_panel.putConstraint(SpringLayout.SOUTH, txtAreaList, -6, SpringLayout.NORTH, lblUserString);
		txtAreaList.setWrapStyleWord(true);
		txtAreaList.setEditable(false);
		sl_panel.putConstraint(SpringLayout.EAST, txtAreaList, -6, SpringLayout.WEST, txtAreaIntro);
		springLayout.putConstraint(SpringLayout.WEST, panel_1, 0, SpringLayout.WEST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, panel_1, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, panel_1, 0, SpringLayout.EAST, this);
		add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));
		
		Component horizontalStrut = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut);
		
		btnAdd = new JButton("ADD");
		panel_1.add(btnAdd);
		
		Component horizontalStrut_1 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_1);
		
		txtFieldUserInput = new JTextField();
		panel_1.add(txtFieldUserInput);
		txtFieldUserInput.setColumns(10);
		
		Component horizontalStrut_2 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_2);
		
		btnRemove = new JButton("REMOVE");
		panel_1.add(btnRemove);
		
		Component horizontalStrut_3 = Box.createHorizontalStrut(20);
		panel_1.add(horizontalStrut_3);

		ButtonListener listener = new ButtonListener();
		btnRemove.addActionListener(listener);
		btnAdd.addActionListener(listener);
	}
	
	private class ButtonListener implements ActionListener
	{
		//-------------------------------------------------------------------
		// This method handles the button clicks
		//-------------------------------------------------------------------
		public void actionPerformed(ActionEvent event) 
		{
			if (event.getSource() == btnRemove)
			{
				btnRemove();
			}
			else
			{
				btnAdd();
			}
		}
		
		//-------------------------------------------------------------------
		// When the user pushes the PUSH button, the text entered in the 
		// text field is placed in the list
		//-------------------------------------------------------------------
		private void btnAdd()
		{
			if (!txtFieldUserInput.getText().equalsIgnoreCase(""))
			{		
				try 
				{
					list.add(txtFieldUserInput.getText());
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
				
				txtFieldUserInput.setText("");	
				txtAreaList.setText(list.toString());
			}
		}
		
		//-------------------------------------------------------------------
		// When the user presses the POP button, the the top string in the 
		// stack is removed and then the top line in the txtAreaStack is removed
		//-------------------------------------------------------------------
		private void btnRemove()
		{
			if (list.isEmpty() != true)
			{
				try
				{
					list.remove(txtFieldUserInput.getText());
					txtAreaList.setText(list.toString());
				}
				catch (NoSuchElementException e)
				{
					JOptionPane.showMessageDialog(panel, "The string entered is not in the list. "
							+ "Please enter only strings that are in the list to remove.");
				}
			}
			// sets Text area to empty if stack is emtpy
			if (list.isEmpty()) 
			{
				txtAreaList.setText("EMPTY:");
			}
			txtFieldUserInput.setText("");
		}
	}
}
