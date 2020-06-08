/*
 * File: MazeSolving.java
 * ---------------------------
 * This program extends Karel so that it can solve a maze
 * using the right-hand rule.
 */

import stanford.karel.SuperKarel;

public class MazeSolving extends SuperKarel {

	public void run() {
		// Your code starts here
		while(cornerColorIs(GREEN)) {
			turnRight();
			while(frontIsBlocked()) {
				turnLeft();
			}
			if(beepersPresent()) {
				pickBeeper();
			}
			move();
			
		}
		
		// Your code ends here
	}
}
