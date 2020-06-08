/*
 * File: MultiplicationTable.java
 * --------------------------
 * This file creates NxN multiplication matrix
 */
import acm.program.*;

public class MultiplicationTable extends ConsoleProgram{

	public void run() {
		int tableSize = readInt("Enter the size of multiplication matrix: ");
		int[][] mTable = new int[tableSize][tableSize];
		
		computeTable(mTable);
		printTable(mTable);
	}

	private void computeTable(int[][] mTable) {
		// Your code starts here
		for(int i=0;i<mTable.length;i++) {
			for(int j=0;j<mTable[i].length;j++) {
				mTable[i][j]=i*j;
			}
		}
		// Your code ends here
	}

	private void printTable(int[][] mTable) {
		// Your code starts here
		for(int i=0;i<mTable.length;i++) {
			for(int j=0;j<mTable[i].length;j++) {
			print(mTable[i][j]+"\t");
			
			}
			println();
			}
		// Your code ends here
	}
}

