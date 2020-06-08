/*
 * File: FactorialTable.java
 * -------------------------
 * This file generates a table of factorials.
 */

import acm.program.*;

public class FactorialTable extends ConsoleProgram {

	public void run() {
		// Your code starts here
		println("This program generates a table of factorials.");
		
		for (int n=LOWER_LIMIT; n<=UPPER_LIMIT;n++) {
			
			println("Factorial of "+n+ " is "+factorial(n));
			
		}
		
		// Your code ends here
	}

	/*
	 * Returns the factorial of n, which is defined as the
	 * product of all integers from 1 up to n.
	 */
	private int factorial(int n) {
		int result = 1;
		// Your code starts here
		for (int i = 1; i <= n; i++) {
		      result *= i;
		   }

		// Your code ends here
		return result;
	}

	/* Private constants */
	private static final int LOWER_LIMIT = 0;
	private static final int UPPER_LIMIT = 10;

}
