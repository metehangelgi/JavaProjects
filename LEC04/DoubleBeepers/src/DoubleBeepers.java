/*
 * File: DoubleBeepers.java
 * ------------------------
 * Karel doubles the number of beepers on the corner directly
 * in front of him in the world.  He then returns to his
 * original position/orientation.
 */

import stanford.karel.SuperKarel;

public class DoubleBeepers extends SuperKarel {

	public void run() {
		// Your code starts here
		move();
		doubleBeepersInPile();
		moveBackwards();
		
		// Your code ends here
	}

	/** Helper methods */

	// Your code starts here
	private void doubleBeepersInPile() {
		while(beepersPresent()) {
			pickBeeper();
			putTwoBeepersNextDoor();
			
		}
		movePileNextDoorBack();
	}
	private void movePileNextDoorBack() {
		move();
		while(beepersPresent()) {
			moveOneBeeperBack();
			
		}
	}
	private void putTwoBeepersNextDoor() {
		move();
		putBeeper();
		putBeeper();
		moveBackwards();
	}
	private void moveBackwards() {
		turnAround();
		move();
		turnAround();
	}
	private void moveOneBeeperBack() {
		pickBeeper();
		moveBackwards();
		putBeeper();
		move();
	}
	// Your code ends here
}