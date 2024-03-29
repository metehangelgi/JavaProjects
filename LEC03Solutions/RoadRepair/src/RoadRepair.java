/* /*
 * File: RoadRepair.java
 * --------------------------
 * This version of the RoadRepair class fills an
 * arbitrary sequence of potholes in a roadway.
 */

import stanford.karel.*;

public class RoadRepair extends SuperKarel {

	public void run() {
		// Your code starts here
		while (frontIsClear()) {
			checkForPothole();
			move();
		}
		checkForPothole();
		// Your code ends here
	}

	/** Helper methods. */

	// Your code starts here
	/**
	 * Checks for a pothole immediately beneath Karel's current
	 * looking for a wall to the right.  If a pothole exists,
	 * Karel calls fillPothole to repair it.
	 */
	private void checkForPothole() {
		if (rightIsClear()) {
			fillPothole();
		}
	}

	/**
	 * Fills the pothole beneath Karel's current position by
	 * placing a beeper on that corner.  For this method to
	 * work correctly, Karel must be facing east immediately
	 * above the pothole.  When execution is complete, Karel
	 * will have returned to the same square and will again
	 * be facing east.  This version of fillPothole checks to
	 * see if there is already a beeper present before putting
	 * a new one down.
	 */
	private void fillPothole() {
		turnRight();
		move();
		if (noBeepersPresent()) {
			putBeeper();
		}
		turnAround();
		move();
		turnRight();
	} 
	// Your code ends here
}