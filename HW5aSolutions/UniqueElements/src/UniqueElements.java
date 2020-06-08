/*
 * File: UniqueElements.java
 * ----------------------
 * This program generates an array with random numbers and removes the duplicated values from the array
 */

import acm.program.*;
import acm.util.RandomGenerator;

public class UniqueElements extends ConsoleProgram {
	private final int numberRange = 10;
	RandomGenerator rgen = RandomGenerator.getInstance();

	public void run(){

		println("This program generates an array with random numbers and removes the duplicated values from the array");

		// Take array size and initialize main array
		int arraySize = readInt("Enter how many random numbers to generate: ");
		int [] bufferArray = new int[arraySize];
		fillArrayRandomly(bufferArray, numberRange);			//Fill main array with random numbers

		// Compute its histogram:
		// bufferHistogram[i] should give the number of times i appears in bufferArray
		int[] bufferHistogram = new int[numberRange];
		computeHistogram(bufferHistogram, bufferArray);

		//Print Main Array Elements
		println("Main Array Elements: ");
		printArray(bufferArray);

		//Print Unique elements
		println("Unique Elements: ");
		printNonZero(bufferHistogram);
	}

	// Initialize given array with random integers in range [0 .. numberRange-1]
	void fillArrayRandomly(int[] bufferArray, int randomRange){
		// Your code starts here
		for(int a=0; a<bufferArray.length; a++){
			bufferArray[a] = rgen.nextInt(randomRange);
		}
		// Your code ends here
	}

	// Compute histogram(frequencies) of a given array.
	// arrayHistogram[i] should give the number of times i appears in bufferArray
	void computeHistogram(int[] arrayHistogram, int[] bufferArray){
		// Your code starts here
		for(int a=0; a<bufferArray.length; a++){
			arrayHistogram[bufferArray[a]]++;
		}
		// Your code ends here
	}

	void printArray(int[] array) {
		print("[ ");
		for(int b=0; b<array.length; b++){
			print(array[b] + " ");
		}
		println("]");
	}

	void printNonZero(int[] array) {
		print("[ ");
		for(int b=0; b<array.length; b++){
			if (array[b] > 0)
				print(b + " ");
		}
		println("]");
	}
}
