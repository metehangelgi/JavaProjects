/*
 * File: Question1.java
 * ----------------------
 * This program reads file U.txt and V.txt copy their values to integer array A and B respectively
 * ,compute the outer product of A and B, and print the result
 */

import acm.program.*;
import acm.util.*;
import java.io.*;

/** This program reverses the lines in a file */
public class Question1 extends ConsoleProgram {

	public void run() {
		println("The program reads values of  two vectors from a file and computes their outer product");

		int[] A = readFileToArray("U.txt");// Read each lines of U.txt to array
											// A
		int[] B = readFileToArray("V.txt");// Read each lines of V.txt to to
											// array B
		int[][] Result = outerProduct(A, B);// Result is the outer product of A
											// and B
		printOutput(A, B, Result); // Prints the vectors and their outer product
	}

	/**
	 * Given Array U and Array V returns the outer product of A and B(A outer
	 * product B)
	 * */
	private int[][] outerProduct(int[] U, int[] V) {
		int[][] result = new int[U.length][V.length];
		// Your code starts here
		

		// Your code ends here

		return result;
	}

	private void printOutput(int[] U, int[] V, int[][] Result) {
		// print U and V on a single line
		print("U = [");
		for (int i = 0; i < U.length; i++)
			print(U[i] + "  ");
		print("]  ");
		print("V = [");
		for (int i = 0; i < V.length; i++)
			print(V[i] + "  ");
		println("]");

		// Print the U outer product V
		println("================ U  Outer Product V  ================");
		for (int i = 0; i < U.length; i++) {
			for (int j = 0; j < V.length; j++) {
				print(Result[i][j] + "\t");
			}
			println();
		}
	}

	// Read each line of a text file to an integer Array
	private int[] readFileToArray(String fileName) {
		int[] result = null;
		BufferedReader rd = openInputFile(fileName);
		
		// Your code starts here
		
		// Your code ends here
		return result;
	}

	/**
	 * given the fileName of the text file to be read, OpenInputFile returns a
	 * BufferedReader variable
	 */
	private BufferedReader openInputFile(String fileName) {
		BufferedReader rd = null;
		
		// Your code starts here

		

		// Your code ends here

		return rd;
	}
}
