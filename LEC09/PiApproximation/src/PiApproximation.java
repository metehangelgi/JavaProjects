/*
 * File: PiApproximation.java
 * --------------------------
 * This progam computes an approximation to pi by simulating
 * a dart board, as described in the handout.  The general
 * technique is called Monte Carlo integration.
 */

import acm.program.*;
import acm.util.*;

public class PiApproximation extends ConsoleProgram {

	public void run() {
		double pi = 0;
		
		// Your code starts here
		int inside=0;
		for(int i=0;i<NDARTS;i++) {
			double xValue= rgen.nextDouble(-1.0, +1.0);
			double yValue= rgen.nextDouble(-1.0, +1.0);
			double checkInside = xValue*xValue +yValue*yValue;
			if (checkInside <= 1.0) {
				inside ++;
			} 
		}
		pi =4.0* inside/NDARTS;
		// Your code ends here
		println("Pi is approximately " + pi);
	}

	/* Private constants */
	private static final int NDARTS = 100000000;  /* Number of darts to throw */

	/* Private instance variables */
	private RandomGenerator rgen = RandomGenerator.getInstance();

}
