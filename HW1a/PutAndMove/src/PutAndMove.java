/* File: PutAndMove.java 
 * 
 * Implement the method putAndMove that makes
 * Karel put a beeper on the ground and move
 * forward once. Then make a line of 4 beepers
 * using it.
 */

import stanford.karel.*;

public class PutAndMove extends Karel {

	public void run() {
		// Your code starts here
		
		putAndMove();
		// Your code ends here
	}

	private void putAndMove() {
		// Your code starts here
		while(frontIsClear()) {
			putBeeper();
			move();
		}
		
		// Your code ends here
	}
}