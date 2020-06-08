/*
 * File: ReWriteFile.java
 * ----------------------
 * This program reads the copyme.txt file which consist a group of sentences separated by '-'.
 * What you are asked to implement is to create a new file named 'output.txt' and write these '-'
 * separated sentences line by line.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class ReWriteFile extends ConsoleProgram {

	public void run() {
		println("This program opens the 'copyme.txt' file and recognizes each sentence " +
				"and writes them line by line to the 'output.txt' file.");

		BufferedReader rd = null;
		PrintWriter wr = null;
		ArrayList<String> sentences = null;
		// Your code starts here
		try {
			rd = new BufferedReader(new FileReader("copyme.txt"));
		} catch (IOException ex) {
			println("Can't open that file.");
		}
	//ssdsd
		sentences = readFiles(rd);
		try {
			wr = new PrintWriter(new FileWriter("output.txt"));
			for(int i=0;i<sentences.size();i++) {
				wr.println(sentences.get(i));
				println(sentences.get(i));
			}
			
		} catch (IOException ex) {
			println("Can't open that file.");
		}
		// Your code ends here
	}

	/**
	 * rd is a BufferedReader for the input file
	 * return a string ArrayList containing the sentences read from the reader
	 */
	private ArrayList<String>  readFiles(BufferedReader rd) {
		ArrayList<String>  sentences = new ArrayList<String>();
		// Your code starts here
		StringTokenizer st = null;
		try {
			String line = rd.readLine();
			st = new StringTokenizer(line, "-");
			while(st.hasMoreTokens()){
				sentences.add(st.nextToken());
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		
		// Your code ends here
		return sentences;
	}
}
