/* File: CleanYourRoom.java
 *
 * Your mother told you to clean your room, but you
 * don't want to stop playing with Karel. That's why
 * you will be picking up all the mess (beepers) with
 * Karel.
 */

import stanford.karel.*;

public class CleanYourRoom extends Karel {

	public void run() {
		// Your code starts here
		turnLeft();
		move();
		move();
		pickBeeper();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		move();
		pickBeeper();
		pickBeeper();
		pickBeeper();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		pickBeeper();
		pickBeeper();
		turnLeft();
		move();
		turnLeft();
		move();
		pickBeeper();
		// Your code ends here
	}
}
