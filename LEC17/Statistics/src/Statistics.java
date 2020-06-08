/*
 * File: Statistics.java
 * ---------------------
 * This file generates a 2D array of random scores and computes two statistics
 * on the distribution: the mean and the standard deviation.
 */

import acm.program.*;
import acm.util.*;

public class Statistics extends ConsoleProgram {

	private RandomGenerator rgen = RandomGenerator.getInstance();

	public void run() {
		rgen.setSeed(1);
		int nstudent = readInt("Enter number of students: ");
		int nexam = readInt("Enter number of exams: ");
		int[][] table = new int[nstudent][nexam];
		generateRandomValues(table);		
		printTable(table);
		println("mean = " + mean(table));
		println("stdev = " + stdev(table));
	
	}


	/* Fills 2D Table with random values between 0 and 100 */
	private void generateRandomValues(int[][] table) {
		// Your code starts here
		for(int i =0; i< table.length;i++) {
			for(int j=0;j<table[i].length;j++) {
				table[i][j]=rgen.nextInt(101);
		}
		}
		// Your code ends here
	}

	/**
	 * Calculates the mean of a double array
	 */
	public double mean(int[][] table) {
		double answer = 0;
		int total=0;
		int examNumber=0;
		// Your code starts here
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				total +=table[i][j];
				examNumber++;
			}
			println("");
		}
		answer=total/examNumber;
		// Your code ends here
		return answer;
	}


	/**
	 * Calculates the standard deviation of a double array
	 */
	public double stdev(int[][] matrix) {
		double answer = 0;
		// Your code starts here
		int elementCount = 0;
		double average = mean(matrix);
		double total = 0.0;

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				double delta = matrix[i][j] - average;
				total += delta * delta;
				elementCount++;
			}
		}

		answer = Math.sqrt(total / elementCount);
		// Your code ends here
		return answer;
	}

	/* Prints scores of the all students */
	private void printTable(int[][] table) {
		try {
		for (int i = 0; i < table.length; i++) {
			int[] row = table[i];
			for (int j = 0; j < row.length; j++) {
				print(row[j] + "\t");
			}
			println("");
		}
		}catch(ArrayIndexOutOfBoundsException e) {
			println("Hata burda");
		}
	}	
}
