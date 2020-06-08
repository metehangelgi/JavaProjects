/*
 * File: ReverseFile.java
 * ----------------------
 * This program reverses the lines in a file by reading them into a
 * String array, and then printing the lines of the array in reverse order.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;

/** This program reverses the lines in a file */
public class ReverseFile extends ConsoleProgram {

	public void run() {	
		println("This program reverses the lines in a file.");
		BufferedReader rd = openInputFile();
		String[] lines = readLineArray(rd);
		for(int i=lines.length-1;i>-1;i--) {
			println(lines[i]);
		}
	}

	/**
	 * Reads all available lines from the specified reader and returns an array
	 * containing those lines.  This method closes the reader at the end of the file.
	 */
	private String[] readLineArray(BufferedReader rd) {
		String[] result;
		// Your code starts here
		String[] lineTemp=new String[1000];
		int count=0;
		while(true) {
			String line;
		try {
			line=rd.readLine();
			if(line==null) break;
			lineTemp[count]=line;
			count++;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		}
		
		result=new String[count];
		for(int i=0;i<result.length;i++) {
			result[i]=lineTemp[i];
		}
			
		// Your code ends here
		return result;
	}

	/**
	 * Requests the name of an input file from the user and then opens
	 * that file to obtain a BufferedReader.  If the file does not exist,
	 * the user is given a chance to reenter the file name.
	 */
	private BufferedReader openInputFile() {
		BufferedReader rd = null;
		while (rd == null) {
			try {
				String name = readLine("Enter input file: ");
				rd = new BufferedReader(new FileReader(name));
			} catch (IOException ex) {
				println("Can't open that file.");
			}
		}
		return rd;
	}
}










/**
 * String[] lineTemp = new String[1000];
		int count = 0;
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				lineTemp[count] = line;
				count++;
			}
			rd.close();
		} catch (Exception ex) {
			throw new ErrorException(ex);
		}
		result = new String[count];
		for (int i = 0; i < count; i++) {
			result[i] = lineTemp[i];
		}
 */

