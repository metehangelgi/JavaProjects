/*
 * File: CelsiusToFahrenheit.java
 * ------------------------------
 * This program creates a table of Celsius to Fahrenheit
 * equivalents using a function to perform the conversion.
 */

import acm.program.*;

public class CelsiusToFahrenheit extends ConsoleProgram {

	public void run() {
		println("Celsius to Fahrenheit table.");
		for (int c = LOWER_LIMIT; c <= UPPER_LIMIT; c += STEP_SIZE) {
			// Your code starts here
			println(c+"C = "+celsiusToFahrenheit(c)+ " F ");
			
			// Your code ends here
		}
	}

	/* Returns the Fahrenheit equivalent of the Celsius temperature c. */
	private double celsiusToFahrenheit(double c) {
		double answer = 0.0;
		// Your code starts here
		answer = c*1.8 +32;
		// Your code ends here
		return answer;
	}

	/* Private constants */
	private static final int LOWER_LIMIT = 0;
	private static final int UPPER_LIMIT = 100;
	private static final int STEP_SIZE = 5;

}