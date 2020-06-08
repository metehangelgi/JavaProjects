/*
 * File: WorldPainter.java
 * ---------------------
 * Karel starts at (1, 1) facing East and paints
 * all world blue.
 */

import stanford.karel.SuperKarel;

public class WorldPainter extends SuperKarel {

	public void run() {
		// Your code starts here
		paintStreet();
		while(leftIsClear()) {
			turnToWest();
			paintStreet();
			if(rightIsClear()) {
				turnToEast();
				paintStreet();
			} else {
				turnAround();
			}
		}
		turnAround();
		while(frontIsClear()) {
			move();
		}
		turnAround();
		// Your code ends here
	}

	/** Helper methods */

	// Your code starts here
	 private void turnToWest() {
		 turnLeft();
		 move();
		 turnLeft();
		 
	 }
	 private void paintRandomly() {
		 if(random(0.5)) {
				if(random(0.5)) {
					paintCorner(BLUE);
				} else {
					paintCorner(RED);
				}
			} else {
				if(random(0.5)) {
					paintCorner(MAGENTA);
				} else {
					paintCorner(YELLOW);
				}
			}
	 }
	 private void paintStreet() {
		 
		 paintRandomly();
		 while(frontIsClear()) {
			 move();
			 paintRandomly();
			 
		 }
	 }
	 private void turnToEast() {
		 turnRight();
		 move();
		 turnRight();
		 
	 }
	// Your code ends here
}

