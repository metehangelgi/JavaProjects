/*
 * File: Histogram2.java
 * --------------------
 * This program reads a list of exam scores, with one score per line.
 * It then displays a histogram of those scores, divided into the
 * ranges 0-9, 10-19, 20-29, and so forth, up to the range containing
 * only the value 100.  In this version the scores are read from a file
 * "Midterm.txt" into an array.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;


public class Histogram2 extends ConsoleProgram {	

	/* Name of the data file */
	private static final String DATA_FILE = "Midterm.txt";

	public void run() {
		double[] scores = readScoresArray(DATA_FILE);
		int[] histogramArray = createHistogram(scores);
		printHistogram(histogramArray);
	}

	/* readScoresArray(): Reads a data file containing doubles into an array 
	 * Hint: if rd is a BufferedReader:
	 * rd.readLine() returns the next line from file as a String
	 * Double.parseDouble(str) converts a String to a Double
	 */
	private double[] readScoresArray(String filename) {	
		double[] array = null;
		// Your code starts here
		// First read into a temporary array with a large size
		double[] listTemp= new double[1000];
		int count=0;
		try {
			BufferedReader rd =new BufferedReader (new FileReader(filename));
			while(true) {
				String line=rd.readLine();
				if(line==null) break;
				listTemp[count]=Double.parseDouble(line);
				count++;
			}
			rd.close();
			
		} catch(IOException ex) {
			throw new ErrorException (ex);
		}
		array= new double[count];
		for (int i=0;i<count;i++) {
			array[i]=listTemp[i];
		}
		
		
		
//		double[] listTemp = new double[1000];
//		int count = 0;
//		try {
//			BufferedReader rd = new BufferedReader(new FileReader(filename));			
//			while (true) {
//				String line = rd.readLine();
//				if (line == null) break;				
//				listTemp[count] = Double.parseDouble(line);
//				count++;
//			}
//
//		} catch (IOException ex) {		
//			throw new ErrorException(ex);
//		}
//		// Once we know the size copy into a smaller array of the right size
//		array = new double[count];
//		for (int i = 0; i < count; i++) {
//			array[i] = listTemp[i];
//		}		
		// Your code ends here
		return array;
	}

	/* Creates a histogram from the array of scores */
	private int[] createHistogram(double[] scores) {
		int[] histogramArray = new int[11];
		// Your code starts here
		for(double score:scores) {
			if(score<0 || score>100) {
				throw new ErrorException("Problem?");
			} else {
				int index =(int)score/10;
				histogramArray[index]++;
			}
		}

		
		
		
//		for (int i = 0; i < scores.length; i++) {
//			double score = scores[i];
//			if (score < 0 || score > 100) {
//				throw new ErrorException("That score is out of range");
//			} else {
//				int range = (int) (score / 10);
//				histogramArray[range]++;
//			}
//		}
		// Your code ends here
		return histogramArray;
	}

	/* Displays the histogram */
	private void printHistogram(int[] histogramArray) {
		for (int range = 0; range <= 10; range++) {
			String stars = createStars(histogramArray[range]);
			println(createLabelForRange(range) + ": " + stars);
		}
	}

	/* Creates the label indicating the range */
	private String createLabelForRange(int range) {
		switch (range) {
		case  0: return "00-09";
		case 10: return "  100";
		default: return (10 * range) + "-" + (10 * range + 9);
		}
	}

	/* Creates a string consisting of n stars */
	private String createStars(int n) {
		String stars = "";
		for (int i = 0; i < n; i++) {
			stars += "*";
		}
		return stars;
	}
}

