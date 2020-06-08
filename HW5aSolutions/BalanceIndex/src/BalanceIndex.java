/*
 * File: BalanceIndex.java
 * ------------------------
 * This program finds the balance index of an array where balanced index i is defined as
 * the first position where left sum is equal to the right sum.
 */

import acm.program.*;
import acm.util.RandomGenerator;

public class BalanceIndex extends ConsoleProgram {
	
	private RandomGenerator rgen = RandomGenerator.getInstance();
	
	private static final int ARRAY_SIZE = 40;
	
	public void run() {
		
		int[] a = new int[ARRAY_SIZE];
		
		fillArrayRandomly(a);
		printArray(a);
		int balanceIndex = findBalanceIndex(a);
		
		if (balanceIndex != -1) 
			print("Balance Index: " + balanceIndex);
		else
			print("No balance index exists");
	}
	
	/* Finds the balance index of the given array */
	private int findBalanceIndex(int[] array) {
		int balanceIndex = -1;
		// Your code starts here
		
		for (int i = 0; i < array.length; i++) {
			int leftSum = 0;
			for (int j = 0; j <= i; j++) {
				leftSum += array[j];
			}
			
			int rightSum = 0;
			for (int j = i + 1; j < array.length; j++) {
				rightSum += array[j];
			}
			
			if (leftSum == rightSum) {
				balanceIndex = i;
				break;
			}
		}
		
		// Your code ends here
		return balanceIndex;
	}
	
	/* Initialize given array with random integers in range [0-2] */
	private void fillArrayRandomly(int[] array) {
		// Your code starts here
		
		for (int i = 0; i < array.length; i++)
			array[i] = rgen.nextInt(0, 2);
			
		// Your code ends here
	}
	
	/* Prints out the data from the array */
	private void printArray(int[] array) {
		for (int i = 0; i < array.length; i++) {
			print(array[i] + " ");
		}
		println();
	}
}
