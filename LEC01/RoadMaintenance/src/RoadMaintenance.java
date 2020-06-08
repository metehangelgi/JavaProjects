/* File: RoadMaintenance
 * 
 * There is a pothole in the middle of the road. Use
 * Karel to fill it with a beeper. Karel then should
 * go to where it started.
 */

import stanford.karel.*;

public class RoadMaintenance extends Karel {

	public void run() {
		// Your code starts here
		move();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		putBeeper();
		turnLeft();
		turnLeft();
		move();
		turnLeft();
		move();
		move();
		
        // Your code ends here
	}
}