/* File: MovingBack.java
 * 
 * move command makes Karel move forward. Now
 * that you have a way to face back (hint:
 * turnAround), write the method moveBack
 * that makes Karel move backwards.
 */ 

import stanford.karel.*;

public class MovingBack extends Karel {

	public void run() {
		move();
		move();
		moveBack();
		moveBack();
		moveBack();
		moveBack();		
	}

	private void moveBack() {
		// Your code starts here
		turnAround();
		move();
		
        // Your code ends here
	}

	private void turnAround() {
		/* Copy and paste your previously
		 * implemented turnAround method 
		 */
		// Your code starts here
		turnLeft();
		turnLeft();
        // Your code ends here
	}
}