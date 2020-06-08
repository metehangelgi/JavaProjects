/*
 * File: ConsecutiveHeads.java
 * ---------------------------
 * This program performs a random experiment consisting of flipping
 * a coin repeatedly until ConsecutiveHeads heads appear in a row.
 */

import acm.program.*;
import acm.util.*;

public class ConsecutiveHeads extends ConsoleProgram {

	public void run() {
		int nFlips = 0;
		// Your code starts here
		int nHeads = 0;
		while (nHeads < NUMBER_REQUIRED) {
			boolean flip = rgen.nextBoolean();
			if (flip) {
				println("Heads");
				nHeads++;
			} else {
				println("Tails");
				nHeads = 0;
			}
			nFlips++;
		}
		// Your code ends here
		println("It took " + nFlips + " flips to get "
				+ NUMBER_REQUIRED + " consecutive heads.");
	}

	/* Private constants */
	private static final int NUMBER_REQUIRED = 2;  /* Number of consecutive heads required */

	/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
