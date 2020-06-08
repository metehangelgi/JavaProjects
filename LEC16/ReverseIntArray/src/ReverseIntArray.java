/*
 * File: ReverseIntArray.java
 * --------------------------
 * This file reads in an array of five integers and then displays
 * those elements in reverse order.
 */

import acm.program.*;

public class ReverseIntArray extends ConsoleProgram {

	/* Private constants */
	private static final int N_VALUES = 5;

	public void run() {
		int[] array = new int[N_VALUES];
		println("Please enter " + N_VALUES + " numbers for the array:");
		readArray(array);
		println("Before reverse:");
		printArray(array);
		reverseArray(array);
		println("After reverse:");
		printArray(array);
	}

	/* Reads the data into the array */
	private void readArray(int[] array) {
		// Your code starts here
		for(int i=0;i<array.length;i++) {
			int arrayNumber=readInt("please enter an integer: ");
			array[i]=arrayNumber;
			
		}
		// Your code ends here
	}

	/* Reverses the data in the array */
	private void reverseArray(int[] array) {
		// Your code starts here
		int temp=0;
		int length=array.length;
		for(int i=0;i<array.length/2;i++) {
			temp=array[i];
			array[i]=array[length-1-i];
			array[length-1-i]=temp;
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

}
