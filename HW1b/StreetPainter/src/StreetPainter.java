/*
 * File: StreetPainter.java
 * ---------------------
 * Karel starts at (1, 1) facing East and paints
 * all street blue.
 */

import stanford.karel.SuperKarel;

public class StreetPainter extends SuperKarel {

	public void run() {
		// Your code starts here
		streetPaint();
		// Your code ends here
	}
	private void streetPaint() {
		paintCorner(BLUE);
		while(frontIsClear()) {
			move();
			paintCorner(BLUE);
		}
	}
}

