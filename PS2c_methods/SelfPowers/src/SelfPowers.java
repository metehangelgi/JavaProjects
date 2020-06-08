/* File: Quiz2 Question2
 */

import acm.program.*;

public class SelfPowers extends  ConsoleProgram {

	public void run() {
		// Your code starts here
		int sum=0;
		for (int i=LOWER_LIMIT; i<=UPPER_LIMIT;i++) {
			sum +=power(i);
		}
		println(sum);
		// Your code ends here
	}
	
	/** Helper methods */
	// Your code starts here
	private int power(int x) {
		return (int)Math.pow(x, x);
	}
	// Your code ends here
	
	/* Private constants */
	private static final int LOWER_LIMIT = 1;
	private static final int UPPER_LIMIT = 9;
}
