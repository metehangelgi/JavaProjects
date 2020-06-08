/* File: Messenger.java
 * 
 * Karel should deliver the message (beeper) from one
 * place to another. Pick up the message at the
 * corner of 1st Street and 2nd Avenue and then put it
 * to the corner of 2nd Street and 4th Avenue. Make
 * Karel stand in the 5th Avenue in the end.
 */

import stanford.karel.*;

public class Messenger extends Karel {

	public void run() {
		// Your code starts here
		move();
		pickBeeper();
		move();
		turnLeft();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		putBeeper();
		move();
		// Your code ends here
	}
}