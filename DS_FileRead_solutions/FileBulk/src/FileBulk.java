/*
 * File: FileBulk.java
 * ----------------------
 * This program reads the filebulk.txt file which consist of several filenames.
 * These filenames are stored in a string array. Then these files will be opened one by one
 * and "I am in!" text will be written into each of them.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

/** This program write a line to several files */
public class FileBulk extends ConsoleProgram {

	public void run() {
		println("This program opens the bulk file and reads all file names\n" +
				" and one by one write 'I am in!' into all files.");
		
		BufferedReader rd = null;
		try {
			rd = new BufferedReader(new FileReader("filebulk.txt"));
		} catch (IOException ex) {
			println("Can't open that file.");
		}
		
		String[] files = readFiles(rd);
		BufferedWriter wr = null;
		try {
			for(int i=files.length-1;i>=0;i--) {
				wr=new BufferedWriter( new FileWriter(files[i]));
				wr.write("i am in");
				wr.flush();
				wr.close();
			}
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

/**
 * Reads all available filenames line by line from the specified reader and returns an array
 * containing those filenames.  This method closes the reader at the end of the file.
 *
 * @param rd A BufferedReader for the input file
 * @return A string array containing the filenames read from the reader
 */
	private String[] readFiles(BufferedReader rd) {
		String[] fileList = new String[10000];
		int count = 0;
		try {
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				fileList[count++] = line;
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		String[] result = new String[count];
		for (int i = 0; i < count; i++) {
			result[i] = fileList[i];
		}
		return result;
	}
}
