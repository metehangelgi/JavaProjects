/*
 * File: MergeArray.java
 * ----------------------
 * This program generates two arrays with N random numbers in range(1-10) and merge the arrays 
 * to create main array
 */

import acm.program.*;
import acm.util.*;

public class MergeArray extends ConsoleProgram {

	public void run(){

		println("This program generates two arrays and merges them.");

		//Initialize Main and sub arrays Array
		int arraySize = readInt("Enter how many random numbers to generate: ");
		int[] firstArray = new int[arraySize];
		int[] secondArray = new int[arraySize];		

		fillArrayRandomly(firstArray);		//Fill first array with random numbers
		fillArrayRandomly(secondArray);	    //Fill second array with random numbers

		int[] bufferArray = mergeArrays(firstArray, secondArray);	//Merge first and seconds arrays

		//Print Results
		println("First Half Contents: ");
		printArray(firstArray);
		println("Second Half Contents: ");
		printArray(secondArray);
		println("Main Array Contents: ");
		printArray(bufferArray);

	}



	private int[] mergeArrays(int[] firstArray, int[] secondArray){
		int[] bufferArray = null;

		// Your code starts here
		//create a main buffer array
		bufferArray = new int[firstArray.length + secondArray.length];

		//Transfer first array to main array
		for(int i=0; i<firstArray.length; i++){
			bufferArray[i] = firstArray[i];	
		}

		//Append second array to main array
		for(int i=0; i<secondArray.length; i++){
			bufferArray[i + firstArray.length] = secondArray[i];	
		}
		// Your code ends here
		return bufferArray;	
	}


	//Initialize given array with random numbers in given random range
	private void fillArrayRandomly(int[] bufferArray){
		// Your code starts here
		for(int i=0; i<bufferArray.length; i++){
			bufferArray[i] = rgen.nextInt(1,NUMBER_RANGE);
		}
		// Your code ends here
	}

	/* Prints out the data from the array */
	private void printArray(int[] array) {
		print("[ ");
		for (int i = 0; i < array.length; i++) {
			print(array[i] + " ");
		}
		println("]");
	}


	private RandomGenerator rgen = RandomGenerator.getInstance();

	private static final int NUMBER_RANGE = 10;


}
