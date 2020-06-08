/*
 * File: RandomPainter.java
 * ---------------------
 * Karel starts at (1, 1) facing East and paints
 * all world in random colors. Colors are blue, 
 * yellow, red and green. Each has 0.25 probability.
 */

import stanford.karel.SuperKarel;

public class RandomPainter extends SuperKarel {

	public void run() {
		paintStreet();
		while (leftIsClear()) {
			repositionForRowToWest();
			paintStreet();
			if (rightIsClear()) {
				repositionForRowToEast();
				paintStreet();
			} else {
				turnAround();
			} 
		}
	}

	private void paintStreet() {
		paintRandomly();
		while (frontIsClear()) {
			move();
			paintRandomly();
		}
	}

	// Only fill this method
	private void paintRandomly(){
		// Your code starts here
		if (random(0.5)) {
			if (random(0.5)) {
				paintCorner(RED);
			} else {
				paintCorner(YELLOW);
			}
		} else {
			if (random(0.5)) {
				paintCorner(BLUE);
			} else {
				paintCorner(GREEN);
			}
		}
		}
				


			
			
	

		// Your code ends here
	

	/* Reposition Karel at far East wall to face West on next row */ 
	private void repositionForRowToWest() {
		turnLeft();
		move();
		turnLeft();
	}
	/* Reposition Karel at far West wall to face East on next row */ 
	private void repositionForRowToEast() {
		turnRight();
		move();
		turnRight();
	} 
}

