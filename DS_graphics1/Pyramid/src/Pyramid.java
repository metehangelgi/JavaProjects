/*
 * File: Pyramid.java
 * ------------------
 * This program draws a brick pyramid.
 */

import acm.graphics.*;
import acm.program.*;

/**
 * This program draws a pyramid consisting of staggered
 * rows of bricks, each of which has the dimensions
 * BRICK_WIDTH x BRICK_HEIGHT.  The base of the pyramid
 * consists of BRICKS_IN_BASE bricks, with each successive
 * layer one step shorter.  The pyramid should be centered
 * in the window.
 */

public class Pyramid extends GraphicsProgram {

	public void run() {
		//Your code starts here
		
		
		//Your code ends here
		
		double y = (getHeight() + BRICKS_IN_BASE * BRICK_HEIGHT) / 2;
		for (int nBricks = BRICKS_IN_BASE; nBricks > 0; nBricks--) {
			y -= BRICK_HEIGHT;
			double x = (getWidth() - nBricks * BRICK_WIDTH) / 2;
			for (int i = 0; i < nBricks; i++) {
				add(new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT));
				x += BRICK_WIDTH;
			}
		}
	}

/* Private constants */
	private static final int BRICK_WIDTH = 30;     /* Width of each brick in pixels */
	private static final int BRICK_HEIGHT = 12;    /* Width of each brick in pixels */
	private static final int BRICKS_IN_BASE = 15;  /* Number of bricks in the base  */

}























/*
 * double y = (getHeight() + BRICKS_IN_BASE * BRICK_HEIGHT) / 2;
		for (int nBricks = BRICKS_IN_BASE; nBricks > 0; nBricks--) {
			y -= BRICK_HEIGHT;
			double x = (getWidth() - nBricks * BRICK_WIDTH) / 2;
			for (int i = 0; i < nBricks; i++) {
				add(new GRect(x, y, BRICK_WIDTH, BRICK_HEIGHT));
				x += BRICK_WIDTH;
			}
		}
 */
