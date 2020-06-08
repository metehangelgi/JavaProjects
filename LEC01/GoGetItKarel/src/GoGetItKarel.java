/* File: GoGetItKarel.java
 * 
 * Milkman delivered the milk (beeper), but only up to
 * your front door. Luckily you have Karel. Make Karel
 * go and pick it up and return back to its initial
 * position, so it can recharge its batteries.
 */

import stanford.karel.*;

public class GoGetItKarel extends Karel {

	public void run() {
		// Your code starts here

		move();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		turnLeft();
		move();
		pickBeeper();
		turnLeft();
		turnLeft();
		move();
		move();
		move();
		turnLeft();
		turnLeft();
		turnLeft();
		move();
		
		// Your code ends here
	}
}