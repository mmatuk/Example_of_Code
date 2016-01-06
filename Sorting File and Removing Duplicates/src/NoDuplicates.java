//************************************************************************
//	NoDuplicates.java 						Matt Matuk
// 	CSIT 211								Project 10.7 pg 463
//	1.	This class contains the methods need to remove duplicate strings
//	from a file and save it to a new file
//	2.	All methods are public and void unless otherwise noted
//	3.	All variables are protected unless otherwise noted
//*************************************************************************	
 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class NoDuplicates {
	
	//-------------------------------------------------------------------
	// Constructor Method. Nothing needed.
	//-------------------------------------------------------------------
	public NoDuplicates() {
	}
	
	//-------------------------------------------------------------------
	// This method will accept two files. A starting file that contains 
	// a list of duplicate strings. The Second file will be the location 
	// and file that will contain the list of strings with out duplicates.
	// 
	// Does not sort the list. Only removes the duplicate strings.
	//-------------------------------------------------------------------
	public void readFile(File inFileName, File outFileName) 
			throws IOException {
		
		BufferedReader bufferedReader = null;
		try {
			bufferedReader = new BufferedReader(
					new FileReader(inFileName));
			
			String line = null;
	
			// Loops for each line in the staring file.(Each string)
			while ((line = bufferedReader.readLine()) != null) {
				removeDuplicates(line, outFileName);
			}
		} catch (IOException NoFileFound) {
			System.out.println("Error. No File Found.");
			
		} finally {
			// closes BufferedReader if the reader was open
			if (bufferedReader != null) {
				bufferedReader.close();
			}
		}
	}
	
	//-------------------------------------------------------------------
	// This method will create the ending file that contains no duplicate 
	// strings. The method will accept a string for the string that is 
	// being compared and the method will accept a File for the ending 
	// file without any duplicates. 
	//-------------------------------------------------------------------
	private void removeDuplicates(String bookTitle, File outFileName) 
			throws IOException {

		PrintWriter outPrintWriter = null;
		BufferedReader outBufferedReader = null;
		
		try {		
			// New file writer the will append to the ending file so strings
			// can be added to the end each time.
			outPrintWriter = new PrintWriter(
					new BufferedWriter(new FileWriter(outFileName, true)));
			
			outBufferedReader = new BufferedReader(
					new FileReader(outFileName));
	
				String outLine = null;
			
			// Loops threw the ending file for each item in the file(Line) and 
			// compares the line to the string that was passed. Breaks the loop 
			// if the two strings match. 
			while ((outLine = outBufferedReader.readLine()) != null) {
				if (outLine.equalsIgnoreCase(bookTitle)) {
					break;
				}
			}
		
			// Adds the passed string if there was no identical string in the
			// ending file. 
			if (outLine == null) {
				outPrintWriter.println(bookTitle);
			}
			
		} catch (IOException NoEndingFile) {
			System.out.println("Error. File Not Found."
					+ NoEndingFile.getStackTrace());
			
		} finally {
			if (outPrintWriter != null) {
				outPrintWriter.close();
			}
			
			if (outBufferedReader != null) {
				outBufferedReader.close();
			}

		}
	}
}