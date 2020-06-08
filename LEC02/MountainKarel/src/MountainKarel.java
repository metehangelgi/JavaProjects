/*
 * File: MountainKarel.java
 * -------------------------
 *
 * The MountainKarel class gets Karel to climb a simple mountain,
 * plant a flag, and descend to the ground.  We will create 8 versions
 * of increasing generality, each building on the previous version.
 * 
 * Version 1 does not use any helper methods (only uses the run
 * method) but works only for the specific world shown in the handout.
 *
 * Version 2 works only for the specific world shown in the handout,
 * but does define turnRight to simplify the code.
 * 
 * Version 3 works only for the specific world shown in the handout,
 * but extends SuperKarel (which already has turnRight defined) and
 * defines stepUp and stepDown as helper methods.
 * 
 * Version 4 incorporates a for loop in the run method and can easily
 * be tailored for a mountain of any height, but still requires
 * program changes to change the size of the mountain.
 * 
 * Version 5 extends the previous version by having Karel approach the
 * mountain, climb it, and then move away to the east end of the
 * world.  This implementation uses helper methods moveToWall(),
 * climbMountain(), stepUp(), and stepDown() but remains limited to a
 * mountain of a fixed size.
 * 
 * Version 6 attempts to generalize the program to solve a stair-step
 * mountain of any size by generalizing climbMountain() to use while
 * loops instead of for loops.  However this single change is not
 * sufficient.
 * 
 * Version 7 fixes the problem by introducing and using the dropDown()
 * method which drops down from the mid-air position just past a
 * descending step.
 * 
 * Version 8 fixes any remaining problems in the dropDown() method and
 * generalizes the program so that it can climb a stair-step mountain
 * of any size.
 */

import stanford.karel.*;

public class MountainKarel extends SuperKarel {

	/**
	 * Runs the program.
	 */
	
	
	 
	
	public void run() {
		// Your code starts here
		
		
		
		
		moveTocross();
		turnAround();
		while(frontIsClear()) {
			move();
		}
		moveToReverseCross();
		
		
	} 
	
	

	private void moveTocross() {
		paintRandomly();
		while(leftIsClear()) {
			turnLeft();
			move();
			turnRight();
			move();
			turnAround();
			paintRandomly();
		}
		}
	private void moveToReverseCross() {
		paintRandomly();
		while(rightIsClear()){
			turnRight();
			move();
			turnLeft();
			move();
			paintRandomly();
	}
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

	}

/* Please do not write anything below this line */

