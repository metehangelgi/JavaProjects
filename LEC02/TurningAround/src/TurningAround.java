/* File: TurningAround.java
 * 
 * Now that you can turn both left and right,
 * implement a method called turnAround so that
 * Karel faces back once turnAround called.
 */

import stanford.karel.*;

public class TurningAround extends Karel {

	public void run() {
		move();
		turnAround();
		move();
		turnAround();
	}

	private void turnAround() {
		// Your code starts here
		turnLeft();
		turnLeft();
		
		// Your code ends here
	}
}