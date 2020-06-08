/*
 * File: SteepleChase.java
 * -----------------------
 * Karel runs a steeple chase that is 9 avenues long.
 * Hurdles are of arbitrary height and placement.
 */

import stanford.karel.*;

public class SteepleChase extends SuperKarel {
	/*
	 * To run a race that is 9 avenues long, we need to move
	 * forward or jump hurdles 8 times.
	 */
	public void run() {
		// Your code starts here
		for(int i=0;i<6;i++) {
			findNextLine();
			climbLine();
			jump();
			goDown();
			
		}
		
		
		// Your code ends here
	}

	/** Helper methods */

	// Your code starts here
	private void climbLine() {
		turnLeft();
		while(rightIsBlocked()) {
			move();
			
		}
	}
	private void findNextLine() {
		while(frontIsClear()) {
			move();
		}
	}
	private void jump() {
		turnRight();
		move();
		turnRight();
		
	}
	private void goDown() {
		while(frontIsClear()) {
			move();
		}
		turnLeft();
	}
	// Your code ends here
}