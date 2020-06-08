import acm.program.*;
import acm.util.*;

import java.util.*;
import java.io.*;

/*
 * File: DescendingOrder.java
 * -----------------------------------------------------
 * Reads grades from two separate files and stores numbers into two ArrayList.
 * Then, calculate the weighted average of the grades and store them in one ArrayList.
 * Finally, print weighted grades in descending order.
 */

public class DescendingOrder extends ConsoleProgram {

	public void run() {
		BufferedReader rd1 = openInputFile("midtermGrades.txt");
		BufferedReader rd2 = openInputFile("finalGrades.txt");
		ArrayList<Double> midtermExam = readLineArray(rd1);
		println("Midterm exam grades: " + midtermExam);
		ArrayList<Double> finalExam = readLineArray(rd2);
		println("Final exam grades: " + finalExam);
		ArrayList<Double> averageList = average(midtermExam, finalExam);
		printDescending(averageList);
	}	
	
	/*
	 * Method opens the files according to fileName
	 * Returns a BufferedReader variable that holds the opened file. 
	 */
	private BufferedReader openInputFile(String fileName) {
		BufferedReader rd = null;
		// Your code starts here
		try {
			rd = new BufferedReader(new FileReader(fileName));
		} catch (IOException ex) {
			println("Can't open that file.");
		}
		// Your code ends here
		return rd;
	}
	
	/*
	 * Takes a BufferedReader parameter.
	 * Reads parameter line by line and writes the numbers into arrayList.
	 * Returns an arrayList that holds numbers as DOUBLE.
	 */
	private ArrayList<Double> readLineArray(BufferedReader rd) {
		ArrayList<Double> list = new ArrayList<Double>();
		// Your code starts here
		try {
			while (true) {
				String line = rd.readLine();
				if(line == null) break;
				list.add(Double.parseDouble(line));
			}
			rd.close();
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		// Your code ends here
		return list;
	}
	
	/*
	 * Takes two Double ArrayLists as parameters.
	 * Calculate average of the grades and put them into one arraylist.
	 * Returns combined arrayList.
	 */
	private ArrayList<Double> average(ArrayList<Double> midtermExam, ArrayList<Double> finalExam) {
		ArrayList<Double> averageList = new ArrayList<Double>();
		double midtermWeight = 0.4;
		double finalWeight = 0.6;
		// Your code starts here
		for(int i = 0; i < midtermExam.size(); i++)
			averageList.add(midtermExam.get(i)*midtermWeight + finalExam.get(i)*finalWeight);
		// Your code ends here
		return averageList;
	}	

	/*
	 * Prints calculated grades in descending order. 
	 */
	private void printDescending(ArrayList<Double> averageList){
		// Your code starts here
		Collections.sort(averageList);
		Collections.reverse(averageList);
		println("Average grades of students in descending order: " + averageList);
		// Your code ends here
	}
}