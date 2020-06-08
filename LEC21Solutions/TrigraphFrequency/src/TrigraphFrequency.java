/*
 * File: TrigraphFrequency.java
 * ----------------------------
 * This file computes trigraph frequencies for an input text.
 */

import acm.program.*;
import acm.util.*;

import java.io.*;
import java.util.*;

public class TrigraphFrequency extends ConsoleProgram {

	public void run() {
		BufferedReader rd = openInputFile();
		ArrayList<String> lineArray = readLineArray(rd);
		produceTrigraphReport(lineArray);
	}


	/**
	 * Reads all available lines from the specified reader and returns an array
	 * containing those lines.  This method closes the reader at the end of the
	 * file.
	 */
	private ArrayList<String> readLineArray(BufferedReader rd) {
		ArrayList<String> lineList = new ArrayList<String>();
		// Your code starts here
		while(true) {
			String line;
			try {
				line = rd.readLine();
				if(line==null) break;
				lineList.add(line);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
//		try {
//			while (true) {
//				String line = rd.readLine();
//				if (line == null) break;
//				lineList.add(line);
//			}
//			rd.close();
//		} catch (IOException ex) {
//			throw new ErrorException(ex);
//		}
		// Your code ends here
		return lineList;
	}

	/**
	 * Produces a report showing all of the trigraphs (three character sequences)
	 * and their counts in the file.
	 */
	private void produceTrigraphReport(ArrayList<String> lineArray) {
		HashMap<String,Integer> trigraphMap = new HashMap<String,Integer>();
		for(String line:lineArray) {
			countTrigraphsInLine(line,trigraphMap);
		}
//		for (String line : lineArray) {
//			countTrigraphsInLine(line, trigraphMap);
//		}
		printTrigraphCounts(trigraphMap);
	}

	/**
	 * Tabulates the trigraph count for the specified line, updating
	 * the values in trigraphMap.
	 */
	private void countTrigraphsInLine(String line, HashMap<String,Integer> trigraphMap) {
		line = line.toUpperCase();
		// Your code starts here
		for(int i=0;i<line.length()-2;i++) {
			String trigr=line.substring(i, i+3);
			if(containsOnlyLetters(trigr)) {
				if(trigraphMap.get(trigr)==null) {
					trigraphMap.put(trigr, 1);
				} else {
					trigraphMap.put(trigr, trigraphMap.get(trigr)+1);
				}
				/*
				if(trigraphMap.get(trigr)==null) {
					trigraphMap.put(trigr, 1);
				} else {
					trigraphMap.put(trigr, trigraphMap.get(trigr)+1);
				}
				*/
			}
		}
//		for (int i = 0; i < line.length() - 2; i++) {
//			String trigraph = line.substring(i, i + 3);
//			if (containsOnlyLetters(trigraph)) {
//				if (trigraphMap.containsKey(trigraph)) {
//					trigraphMap.put(trigraph, trigraphMap.get(trigraph) + 1);
//				} else {
//					trigraphMap.put(trigraph, 1);
//				}
//			}
//		}
		// Your code ends here
	}

	/** Checks if a string contains only letters */
	private boolean containsOnlyLetters(String str) {
		// Your code starts here
		for (int i=0;i<str.length();i++) {
			if(!Character.isLetter(str.charAt(i))) return false;
		}
		
		
//		for (int i = 0; i < str.length(); i++) {
//			if (!Character.isLetter(str.charAt(i))) return false;
//		}
		// Your code ends here
		return true;
	}

	/** Displays the table of letter counts */
	private void printTrigraphCounts(HashMap<String,Integer> trigraphMap) {
		// Your code starts here
		for(String key:trigraphMap.keySet()) {
			println(key+": " +trigraphMap.get(key));
		}
		
//		
		// Your code ends here
	}

	/**
	 * Asks the user for the name of an input file and returns a
	 * BufferedReader attached to its contents.  If the file does
	 * not exist, the user is given another chance to try.
	 */ 
	private BufferedReader openInputFile() {
		BufferedReader rd = null;
		while (rd == null) {
			String FileName=readLine("Enter of file name");
			try {
				rd=new BufferedReader(new FileReader(FileName));
			} catch (FileNotFoundException e) {
				throw new ErrorException(e);
			}
		}
		return rd;
	}

}

