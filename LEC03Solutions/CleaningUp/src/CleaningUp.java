/*
 * File: CleaningUp.java
 * -----------------------
 * Karel starts at (1, 1) facing East and cleans up any
 * beepers scattered throughout his world.
 */
import stanford.karel.*;

public class CleaningUp extends SuperKarel {

	/* Cleans up a field of beepers, one row at a time */ 
	public void run() {
		// Your code starts here
		cleanRow();
		while (leftIsClear()) {
			toWest();
			cleanRow();
			if (rightIsClear()) {
				toEast();
				cleanRow();
			} else {
				/*
				 * In rows with an even number of streets, we want
				 * Karel's left to be blocked after he cleans the last
				 * row, so we turn him to the appropriate orientation. */
				turnAround();
			} 
		}
		// Your code ends here
	}

	/** Helper methods. */

	// Your code starts here
	/* Cleans up a row in whichever direction Karel is facing */ 
	private void cleanRow() {
		if (beepersPresent()) {
			pickBeeper();
		}
		while (frontIsClear()) {
			move();
			if (beepersPresent()) {
				pickBeeper();
			} 
		}
	}
	/* Reposition Karel at far East wall to face West on next row */ 
	private void toWest() {
		turnLeft();
		move();
		turnLeft();
	}
	/* Reposition Karel at far West wall to face East on next row */ 
	private void toEast() {
		turnRight();
		move();
		turnRight();
	} 
	// Your code ends here
}