/* File: PlacingPins.java
 * 
 * You are on a bowling alley, but machinery that
 * places the pins is broken and you are just too
 * lazy to place them yourself. Write a code so that
 * Karel collects the four pins and places them
 * according to the given pattern.
 */


import stanford.karel.*;

public class PlacingPins extends Karel {

	public void run() {
		// Your code starts here
		turnLeft();
		while(frontIsClear()) {
			move();
		}
		pickBeeper();
		for (int i=0;i<3;i++) {
			turnLeft();
		}
		while(frontIsClear()) {
			move();
		}
			pickBeeper();
		for (int i=0;i<3;i++) {
				turnLeft();
			}
		move();
		pickBeeper();
		for (int i=0;i<3;i++) {
			turnLeft();
		}
		move();
		pickBeeper();
		move();
		turnLeft();
		move();
		turnLeft();
		putBeeper();
		move();
		putBeeper();
		move();
		putBeeper();
		for (int i=0;i<3;i++) {
			turnLeft();
		}
		move();
		for (int i=0;i<3;i++) {
			turnLeft();
		}
		move();
		putBeeper();
		for (int i=0;i<3;i++) {
			turnLeft();
		}
		move();
		move();
		
		// Your code ends here
	}
}

	

