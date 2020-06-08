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
		for(int i=0; i<4 ;i++) {
			repair();
		}
		// Your code ends here
	}

	/** Helper methods. */

	// Your code starts here
	public void repair() {
		move();
		turnRight();
		move();
		putBeeper();
		turnAround();
		move();
		turnRight();
		move();
	}
	// Your code ends here
}