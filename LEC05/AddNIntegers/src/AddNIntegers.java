/*
 * File: AddNIntegers.java
 * -----------------------
 * This program adds N integers, where N is specified as a
 * named constant.
 * 
 * Class: AddNIntegers
 * Difficulty: (Easy)
 * Prerequisites: For Loops, Variables and Arithmetic, ConsoleProgram (readInt, println)
 */

import acm.program.*;

public class AddNIntegers extends ConsoleProgram {
	public void run() {
		// Your code starts here
		println("This program adds" +N+ "numbers.");
		
		int total= 0;
		for (int i = 0; i < N; i++) {
	         int userNumber = readInt(" ? ");
	         total += userNumber;
	      }
	      println("The total is " + total + ".");
	   

		// Your code ends here
	}

	private static final int N = 10;
}
