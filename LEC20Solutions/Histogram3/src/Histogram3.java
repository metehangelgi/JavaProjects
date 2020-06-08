/*
 * File: Histogram3.java
 * --------------------
 * This program reads a list of exam scores, with one score per line.
 * It then displays a histogram of those scores, divided into the
 * ranges 0-9, 10-19, 20-29, and so forth, up to the range containing
 * only the value 100.  In this version the grades are first read into
 * an ArrayList and then copied into a double[] array.
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class Histogram3 extends ConsoleProgram {	

	/* Name of the data file */
	private static final String DATA_FILE = "Midterm.txt";

	public void run() {
		//double[] scores = readScoresArray(DATA_FILE);
		ArrayList<Double> list =readScoresArray(DATA_FILE);
		int[] histogramArray = createHistogram(list);
		printHistogram(histogramArray);
	}

	/* Reads a data file containing doubles into an array */
	private ArrayList<Double> readScoresArray(String filename) {
		double[] array = null;
		
		ArrayList<Double> list = new ArrayList<Double>();
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			// First read the lines into list, then copy them to array.
			// Your code starts here
			
			while(true) {
				String line =rd.readLine();
				if(line==null) break;
				list.add(Double.parseDouble(line));
			}
			rd.close();
//			while (true) {
//				String line = rd.readLine();
//				if (line == null) break;
//				list.add(Double.parseDouble(line));
//			}
//			array = new double[list.size()];
//			for (int i = 0; i < array.length; i++) {
//				array[i] = list.get(i);
//			}
			// Your code ends here
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		array=new double [list.size()];
		for(int i=0;i<array.length;i++) {
			array[i]=list.get(i);
		}
		return list;
	}

	/* Creates a histogram from the array of scores */
	private int[] createHistogram(ArrayList<Double> scores) {
		int[] histogramArray = new int[11];
		// Your code starts here
		for(int i=0;i<scores.size();i++) {
			double score=scores.get(i);
			if(score<0 || score>100) {
				throw new ErrorException("wtf");
			} else {
				int range=(int) score/10;
				histogramArray[range]++;
			}
			}
		// Your code ends here
		return histogramArray;
	}

	/* Displays the histogram */
	private void printHistogram(int[] histogramArray ) {
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

