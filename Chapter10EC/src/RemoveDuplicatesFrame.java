//************************************************************************
//	RemoveDuplicatesFrame.java 						Matt Matuk
// 	CSIT 211								Project 10.7 pg 463
//	1.	This class contains all the panels for the No duplicates program.
//	2.	The class has listeners for buttons and allow the user to 
//	select two file locations and press the remove duplicates button to 
//	remove any duplicate strings the file. 
//	3.	All colors and sizes of the panel can be change to make to look 
//	better. Use best judgment. 
//	4.	All method are public and void unless otherwise noted
//	5.	All variables are protected unless otherwise noted
//*************************************************************************	
 
import java.awt.*;
import javax.swing.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.io.File;
import java.io.IOException;

public class RemoveDuplicatesFrame {

	private JFrame frame;
	private JTextField textFieldStartFile;
	private JTextField textFieldEndFile;
	
	protected File fileStart; // location of the starting file
	protected File fileEnd; // location of the ending file
	protected JButton btnRemove, btnStartFile, btnEndFile;
	protected JLabel lblIntro, lblStartFile, lblEndFile;
	protected final String startFileName = "bookTitles.inp"; //name for the starting file . User must enter this as the file name
	protected final String endFileName = "noDuplicates.out"; //name for the ending file. user must enter this as the file name

	//-------------------------------------------------------------------
	// Main method. Creates the main frame for the GUI
	//-------------------------------------------------------------------
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					RemoveDuplicatesFrame window = new RemoveDuplicatesFrame();
					window.frame.setVisible(true);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	//-------------------------------------------------------------------
	// Constructor Method. Nothing needed.
	//-------------------------------------------------------------------
	public RemoveDuplicatesFrame() {
		initialize();
	}

	//-------------------------------------------------------------------
	// This method creates all the GUI elements and the listeners for 
	// the buttons
	//-------------------------------------------------------------------
	private void initialize() {
		frame = new JFrame("Remove Duplicate Book Titles");
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 700, 200);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setMinimumSize(new Dimension(700,200));
		frame.setLocationRelativeTo(null);;
		
		btnRemove = new JButton("Remove Duplicates");
		btnRemove.setBounds(275, 120, 150, 25);
		frame.getContentPane().add(btnRemove);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel.setBounds(12, 26, 658, 90);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		// label for the starting location file
		lblStartFile = new JLabel("Please select the starting file "
				+ "location. The file must be called  \u201CbookTitles.inp\u201D");
		lblStartFile.setBounds(5, 5, 540, 15);
		panel.add(lblStartFile);
		
		// text feild where the location of the file will  be displayed
		textFieldStartFile = new JTextField();
		textFieldStartFile.setEditable(false);
		textFieldStartFile.setBounds(5, 20, 540, 15);
		panel.add(textFieldStartFile);
		textFieldStartFile.setColumns(10);
		
		// label for the ending file
		lblEndFile = new JLabel("Please select the ending file "
				+ "location. The file will be named "
				+ "\u201CnoDuplicates.out\u201D");
		lblEndFile.setBounds(5, 45, 540, 15);
		panel.add(lblEndFile);
		
		// text field where the ending file location will be displayed
		textFieldEndFile = new JTextField();
		textFieldEndFile.setEditable(false);
		textFieldEndFile.setColumns(10);
		textFieldEndFile.setBounds(5, 65, 540, 15);
		panel.add(textFieldEndFile);
		
		// button to select the starting file location
		btnStartFile = new JButton("File");
		btnStartFile.setBounds(550, 21, 100, 15);
		panel.add(btnStartFile);
		
		// button to select the ending file save location
		btnEndFile = new JButton("File");
		btnEndFile.setBounds(550, 66, 100, 15);
		panel.add(btnEndFile);
		
		// Intro statments
		lblIntro = new JLabel("Welcome to the application. "
				+ "This application will take a list of book titles "
				+ "and remove any duplicates");
		lblIntro.setBounds(12, 0, 658, 27);
		frame.getContentPane().add(lblIntro);
		
		// creates the listeners for each button
		ButtonListener listener = new ButtonListener();
		btnEndFile.addActionListener(listener);
		btnRemove.addActionListener(listener);
		btnStartFile.addActionListener(listener);
		

	}		
	
	//-------------------------------------------------------------------
	// This class contains all the actions for each buttton
	//-------------------------------------------------------------------
	private class ButtonListener implements ActionListener {

		public void actionPerformed(ActionEvent buttonPressed) {

			// When the Remove Duplicates button is pressed. if the 
			// user entered a open and save file, then the method 
			// readFile() is called to remove any duplicate titles
			if (buttonPressed.getSource() == btnRemove) {
				if (fileStart != null && fileEnd != null) {
					JOptionPane.showMessageDialog(null, "Please wait "
							+ "while the duplicate book titles are "
							+ "removed.");
					NoDuplicates remove = new NoDuplicates();
					
					try {
						remove.readFile(fileStart, fileEnd);
					} catch (IOException e) {
						e.printStackTrace();
					}
					
					JOptionPane.showMessageDialog(null, "DONE");
				}
				else {
					JOptionPane.showMessageDialog(null, "Please "
							+ "Select both a starting and an ending file "
							+ "location.");
				}
			}
			else {					
				
				JFileChooser chooser = new JFileChooser();
				
				// When the user pushes the file button for the starting 
				// file location, a file chooser is displayed for the 
				// user to pick a file to open. File must be named
				// "bookTitles.inp or an error message will be displayed
				if (buttonPressed.getSource() == btnStartFile) {
					int status = chooser.showOpenDialog(null);
					
					if (status != JFileChooser.APPROVE_OPTION) {
						textFieldStartFile.setText(
								"No File Chosen!");
					}
					else {
						if(startFileName.equals(chooser.getName(
								chooser.getSelectedFile()))) {
							fileStart = chooser.getSelectedFile();
							textFieldStartFile.setText(
									fileStart.getAbsolutePath());
						}
						else {
							JOptionPane.showMessageDialog(null, "Error " 
									+ "Invalid File Name!");
						}
					}
				}
				
				// When the user pushes the file button to select a 
				// location to save the new file without any duplicates.
				// File must be saved as "noDuplicates.out" or an error
				// message is displayed
				else {
					int status = chooser.showSaveDialog(null);
					
					if (status != JFileChooser.APPROVE_OPTION) {
						textFieldEndFile.setText(
								"No File Chosen!");
					}
					else {
						if (endFileName.equals(chooser.getName(
								chooser.getSelectedFile()))) {
							fileEnd = chooser.getSelectedFile();
							textFieldEndFile.setText(
									fileEnd.getAbsolutePath());
						}
						else {
							JOptionPane.showMessageDialog(null, "Error " 
									+ "Invalid File Name! Please Name "
									+ "the file \"noDuplicates.out\"");
						}
					}
				}
			}
		}
	}
}
